### Toxtree via web services

This document describes how to:
* Retrieve Toxtree modules via OpenTox [algorithm](algorithm.md) and [model](model.md) API
* [Run predictions](#finally-get-some-predictions-eg-apply-the-model-to-compound-or-dataset-uri-)
* The examples assume the chemical compound URIs are known. At the [query](query.md) page there is a guide how to search and retrieve chemical compounds. 
More info on OpenTox compound API [here](http://opentox.org/dev/apis/api-1.2/structure)


#### Algorithms

#####Retrieve all Toxtree modules, available as OpenTox [algorithms](algorithm.md)
````
    curl "http://apps.ideaconsult.net:8080/ambit2/algorithm?search=ToxTree&media=application/json"
````

````json
{
    "algorithm": [
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer",
            "id": "toxtreecramer",
            "name": "ToxTree: Cramer rules",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#HumanHealthEffects",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecramer",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreemic",
            "id": "toxtreemic",
            "name": "ToxTree: Structure Alerts for the in vivo micronucleus assay in rodents",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Endpoints",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreemic",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecarc",
            "id": "toxtreecarc",
            "name": "ToxTree: Benigni/Bossa rules for carcinogenicity and mutagenicity",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Carcinogenicity",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecarc",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        
...........        
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeames",
            "id": "toxtreeames",
            "name": "ToxTree: In vitro mutagenicity (Ames test) alerts by ISS",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Mutagenicity",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeames",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        }
    ]
}
````

#### Models 

[What is an OpenTox Model](model.md)

#####Retrieve a model, created by a given algorithm

````
    curl -H "Accept:application/json" http://host:port/ambit2/model?algorithm=ALGORITHM_URI
````

######Example: Retrieve the model, which will apply the Cramer rules algorithm

````
    curl -H "Accept:application/json" \
     http://apps.ideaconsult.net:8080/ambit2/model?algorithm=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fambit2%2Falgorithm%2Ftoxtreecramer
````

````json
{
    "model": [
        {
            "URI": "http://apps.ideaconsult.net:8080/ambit2/model/2",
            "id": 2,
            "title": "ToxTree: Cramer rules",
            "stars": 9,
            "algorithm": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer"
            },
            "trainingDataset": "http://apps.ideaconsult.net:8080/ambit2/dataset/27764",
            "independent": "http://apps.ideaconsult.net:8080/ambit2/model/2/independent",
            "dependent": "http://apps.ideaconsult.net:8080/ambit2/model/2/dependent",
            "predicted": "http://apps.ideaconsult.net:8080/ambit2/model/2/predicted",
            "ambitprop": {
                "legend": "http://apps.ideaconsult.net:8080/ambit2/model/2?media=image/png"
            }
        }
    ]
} 
````


#####Create a model 
````
    curl -X POST http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer -H "Accept:application/json"
````
#####A task is returned. More about the [OpenTox Task API](http://opentox.org/dev/apis/api-1.2/AsyncTask) 
````json
{"task": [
{
        "uri":"http://apps.ideaconsult.net:8080/ambit2/task/7aadd2a5-06de-4ae2-851e-3e13ca6811d9",
        "id": "7aadd2a5-06de-4ae2-851e-3e13ca6811d9",
        "name": "Apply ToxTree: Cramer rules  ",
        "status": "Running",
        "started": 1371742727965,
        "result": "http://apps.ideaconsult.net:8080/ambit2/task/7aadd2a5-06de-4ae2-851e-3e13ca6811d9",
}
]
````

###### Poll the task 
````
    curl -H "Accept:application/json" "http://apps.ideaconsult.net:8080/ambit2/task/7aadd2a5-06de-4ae2-851e-3e13ca6811d9"
````
  
######the task is now completed and themodel URI is http://apps.ideaconsult.net:8080/ambit2/model/2
````json
{"task": [
{
        "uri":"http://apps.ideaconsult.net:8080/ambit2/model/2",
        "id": "7aadd2a5-06de-4ae2-851e-3e13ca6811d9",
        "name": "Apply ToxTree: Cramer rules  ",
        "status": "Completed",
        "started": 1371742727965,
        "completed": 1371742727974,
        "result": "http://apps.ideaconsult.net:8080/ambit2/model/2",
}
]
}
````

#### Retrieve the model representation by URI 


````
    curl -H "Accept:application/json" "http://apps.ideaconsult.net:8080/ambit2/model2"
````
  
 
````json
{
    "model": [
        {
            "URI": "http://apps.ideaconsult.net:8080/ambit2/model/2",
            "id": 2,
            "title": "ToxTree: Cramer rules",
            "stars": 9,
            "algorithm": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer"
            },
            "trainingDataset": "http://apps.ideaconsult.net:8080/ambit2/dataset/27764",
            "independent": "http://apps.ideaconsult.net:8080/ambit2/model/2/independent",
            "dependent": "http://apps.ideaconsult.net:8080/ambit2/model/2/dependent",
            "predicted": "http://apps.ideaconsult.net:8080/ambit2/model/2/predicted",
            "ambitprop": {
                "legend": "http://apps.ideaconsult.net:8080/ambit2/model/2?media=image/png"
            }
        }
    ]
}
````

##### Finally, get some predictions 

* The compound URI is usually result of a [chemical compound search](query.md). 
* Parse the [dataset](dataset.md) to retrieve the compound URIs.
* The 2D structure diagram of a chemical compound can be retrieved by requesting **image/png* by [http://host:port/ambit2/compound/328&media=image/png&w=200&h=200](http://apps.ideaconsult.net:8080/ambit2/compound/328&media=image/png&w=200&h=200).


###### Retrieve existing predictions 

The variables, assigned upon prediction are represented as [OpenTox features](http://ambit.sourceforge.net/api_feature.html) and could be accessed via http://host:port/model/{mid}/predicted.

````
    curl -H "Accept:application/json" "http://apps.ideaconsult.net:8080/ambit2/compound/328?feature_uris[]=http://apps.ideaconsult.net:8080/ambit2/model2/predicted"
````

The resutls are in the same format, as when retrieving a [dataset](dataset.md)

````json

````

###### Apply the model to compound or dataset URI


````
    curl -X POST -H "Accept:application/json" \
           -d "dataset_uri=http://apps.ideaconsult.net:8080/ambit2/compound/328" \
           "http://apps.ideaconsult.net:8080/ambit2/model/2"
````
  
######Here is the task
````json
{
    "task": [
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/task/80552714-de54-4319-9a88-ec9d39f64539",
            "id": "80552714-de54-4319-9a88-ec9d39f64539",
            "name": "Apply Model ToxTree: Cramer rules to http://apps.ideaconsult.net:8080/ambit2/compound/328",
            "status": "Running",
            "started": 1371743438742,
            "result": "http://apps.ideaconsult.net:8080/ambit2/task/80552714-de54-4319-9a88-ec9d39f64539"
        }
    ]
}
````
    
######poll the task
````
    curl -H "Accept:application/json" http://apps.ideaconsult.net:8080/ambit2/task/80552714-de54-4319-9a88-ec9d39f64539
````

#####and now the task is completed. The **result** field contains the URI of the dataset with the predictions. 
````json
{
    "task": [
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/compound/328?feature_uris[]=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fambit2%2Fmodel%2F2%2Fpredicted",
            "id": "80552714-de54-4319-9a88-ec9d39f64539",
            "name": "Apply Model ToxTree: Cramer rules to http://apps.ideaconsult.net:8080/ambit2/compound/328",
            "status": "Completed",
            "started": 1371743438742,
            "completed": 1371743439633,
            "result": "http://apps.ideaconsult.net:8080/ambit2/compound/328?feature_uris[]=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fambit2%2Fmodel%2F2%2Fpredicted"
        }
    ]
}
````
   
#####Retrieve the predictions
````
    curl -H "Accept:application/json" "http://apps.ideaconsult.net:8080/ambit2/compound/328?feature_uris[]=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fambit2%2Fmodel%2F2%2Fpredicted"
````
 
#####The resutls are in the same format, as when retrieving a [dataset](dataset.md)
````json
{
    "query": {
        "summary": "idcompound=328"
    },
    "dataEntry": [
        {
            "compound": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/compound/328/conformer/144160"
            },
            "values": {
                "http://apps.ideaconsult.net:8080/ambit2/feature/9042927": "High (Class III)",
                "http://apps.ideaconsult.net:8080/ambit2/feature/9042928": "Q1.Normal constituent of the body No <br>Q2.Contains functional groups associated with enhanced toxicity No <br>Q3.Contains elements other than C,H,O,N,divalent S No <br>Q5.Simply branched aliphatic hydrocarbon or a common carbohydrate No <br>Q6.Benzene derivative with certain substituents No <br>7.Heterocyclic Yes <br>Q8.Lactone or cyclic diester No <br>Q10.3-membered heterocycle No <br>11.Has a heterocyclic ring with complex substituents. Yes <br>Q33.Has sufficient number of sulphonate or sulphamate groups No Class High (Class III)<br>"
            }
        }
    ],
    "model_uri": null,
    "feature": {
        "http://apps.ideaconsult.net:8080/ambit2/feature/9042927": {
            "type": "Feature",
            "title": "Cramer rules",
            "creator": "http://toxtree.sourceforge.net/cramer.html",
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/algorithm/Cramer+rules",
                "type": "Algorithm"
            }
        },
        "http://apps.ideaconsult.net:8080/ambit2/feature/9042928": {
            "type": "Feature",
            "title": "Cramer rules#explanation",
            "creator": "http://toxtree.sourceforge.net/cramer.html",
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/algorithm/Cramer+rules",
                "type": "Algorithm"
            }
        }
    }
}
````
