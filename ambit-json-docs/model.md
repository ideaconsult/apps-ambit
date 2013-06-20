##OpenTox REST API: Models

Provides different representations for QSAR/toxicology models. 

* Models are the output/result of (learning) [algorithms](algorithm.md) and cannot be modified. 
* To apply a model, it is necessary to provide as input a [dataset](dataset.md) with compatible descriptors/features. 
* Documentation http://opentox.org/dev/apis/api-1.2/Model


### JSON

OpenTox mandatory representation of REST resources is [RDF](http://www.w3.org/RDF/) (W3C Resource Description Framework). 
Examples: [1](http://opentox.org/dev/apis/api-1.2/algorithm),[2](http://ambit.sourceforge.net/api_algorithm.html).

The JSON representation is a new development, implemented in AMBIT web services [1](http://ambit.sf.net),[2](http://www.jcheminf.com/content/3/1/18).

* The model JSON representation closely follows the RDF representation;

* The JSON or JSONP representation could be retrieved via HTTP Accept headers **"application/json"** or **"application/x-javascript"** respectively.
* As a workaround for web browsers restriction, the URI parameter **?media=application/json** or **?media=application/x-javascript** could be used.

#### Models
#####Retrieve first 10 models
````
    curl -H "Accept:application/json" "http://host:port/ambit2/model?page=0&pagesize=10"
````

Example: 
````
    curl -H "Accept:application/json" "http://apps.ideaconsult.net:8080/ambit2/model?page=0&pagesize=10"
````

````json
ТОДО

````

#####Retrieve a model, created by a given algorithm

````
    curl -H "Accept:application/json" http://host:port/ambit2/model?algorithm=ALGORITHM_URI
````

Example: Retrieve the model, which will apply the Cramer rules algorithm

See [Toxtree examples](toxtree.md)


######Create a model 
````
    curl -X POST http://host:port/ambit2/algorithm/{id} -H "Accept:application/json"
````
   a task is returned
   
````json
{"task": [
{
        "uri":"http://host:port/ambit2/task/{id}",
        "id": "7aadd2a5-06de-4ae2-851e-3e13ca6811d9",
        "name": "The model name",
        "status": "Running",
        "started": 1371742727965,
        "result": "http://host:port/ambit2/task/7aadd2a5-06de-4ae2-851e-3e13ca6811d9",
}
]
````

  poll the task 
````
    curl -H "Accept:application/json" "http://host:port/ambit2/task/7aadd2a5-06de-4ae2-851e-3e13ca6811d9"
````
  
  the task is now completed and the model URI is http://host:port/ambit2/model/{md}
````json
{"task": [
{
        "uri":"http://host:port/ambit2/model/{mid}",
        "id": "7aadd2a5-06de-4ae2-851e-3e13ca6811d9",
        "name": "Apply algorithm {aid}  ",
        "status": "Completed",
        "started": 1371742727965,
        "completed": 1371742727974,
        "result": "http://host:port/ambit2/model/{mid}",
}
]
}
````

#### Retrieve model representation by URI 


````
    curl -H "Accept:application/json" "http://host:port/ambit2/model/{mid}"
````
  
````json
{
    "model": [
        {
            "URI": "http://host:port/ambit2/model/{mid}",
            "id": 2,
            "title": "ToxTree: Cramer rules",
            "stars": 9,
            "algorithm": {
                "URI": "http://host:port/ambit2/algorithm/{aid}"
            },
            "trainingDataset": "http://host:port/ambit2/dataset/{did}",
            "independent": "http://host:port/ambit2/model/2/independent",
            "dependent": "http://host:port/ambit2/model/{mid}/dependent",
            "predicted": "http://host:port/ambit2/model/{mid}/predicted",
            "ambitprop": {
                "legend": "http://host:port/ambit2/model/{mid}?media=image/png"
            }
        }
    ]
}
````

#### Finally, get some prediction (e.g. apply the model to compound or dataset URI )

````
    curl -X POST -H "Accept:application/json" \
           -d "dataset_uri=http://host:port/ambit2/compound/{cid}" \
           "http://host:port/ambit2/model/{mid}"
````
  
######here is the task
    
````json
{
    "task": [
        {
            "uri": "http://host:port/ambit2/task/80552714-de54-4319-9a88-ec9d39f64539",
            "id": "80552714-de54-4319-9a88-ec9d39f64539",
            "name": "Apply Model {mid} to http://host:port/ambit2/compound/{cid}",
            "status": "Running",
            "started": 1371743438742,
            "result": "http://host:port/ambit2/task/80552714-de54-4319-9a88-ec9d39f64539"
        }
    ]
}
````
    
######poll the task
````
    curl -H "Accept:application/json" http://host:port/ambit2/task/80552714-de54-4319-9a88-ec9d39f64539
````

######and now the task is completed. The **result** field contains the URI of the dataset with the predictions. 
````json
{
    "task": [
        {
            "uri": "http://host:port/ambit2/compound/{cid}?feature_uris[]=http%3A%2F%2Fhost%3Aport%2Fambit2%2Fmodel%2Fmid%2Fpredicted",
            "id": "80552714-de54-4319-9a88-ec9d39f64539",
            "name": "Apply Model {mid} to http://host:port/ambit2/compound/{cid}",
            "status": "Completed",
            "started": 1371743438742,
            "completed": 1371743439633,
            "result": "http://host:port/ambit2/compound/{cid}?feature_uris[]=http%3A%2F%2Fhost%3Aport%2Fambit2%2Fmodel%2Fmid%2Fpredicted"
        }
    ]
}
````
   
######Retrieve the predictions
````
    curl -H "Accept:application/json" "http://host:port/ambit2/compound/{cid?feature_uris[]=http%3A%2F%2Fhost%3Aport%2Fambit2%2Fmodel%2Fmid%2Fpredicted"
````
 
  The resutls are in the same format, as if retrieving a [dataset](dataset.md). 

* For specific examples see the [Toxtree](toxtree.md) page.
