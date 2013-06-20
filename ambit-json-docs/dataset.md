##OpenTox REST API: Dataset

Provides access to chemical compounds and their features (e.g. structural, physical-chemical, biological, toxicological properties).

The concept of a Dataset of chemical compounds is central to OpenTox web services functionality. 

* Algorithm services accept dataset URI in order to build a model, or to generate descriptor values. 
* Model services accept dataset URI in order to apply a model and obtain predictions. 
* Predictions are again returned as dataset URI, which could be subsequently retrieved. 
* Search results (exact chemical structure, similarity or substructure) are also available as datasets.
* Documentation http://opentox.org/dev/apis/api-1.2/dataset 

### JSON

OpenTox mandatory representation of REST resources is [RDF](http://www.w3.org/RDF/) (W3C Resource Description Framework). 
Examples: [1](http://opentox.org/dev/apis/api-1.2/dataset),[2](http://ambit.sourceforge.net/api_dataset.html).

The JSON representation is a new development, implemented in AMBIT web services [1](http://ambit.sf.net),[2](http://www.jcheminf.com/content/3/1/18).

* The dataset JSON representation closely follows the RDF data model;
* The dataset consists of data entries (or data rows);
* Each row is associated with exactly one chemical compound, identified by its URL and available via OpenTox Compound service API;
* One and the same compound URL can be associated with multiple dataset rows;
* Every column is associated with a Feature URL, representation should be available via OpenTox [Feature](feature.md) API. A feature is identified by its URL and has name and source,along with other properties. Any OpenTox [Dataset](dataset.md), [Algorithm](algorithm.md) or [Model](model.md) can serve as feature source. 

* The JSON or JSONP representation could be retrieved via HTTP Accept headers **"application/json"** or **"application/x-javascript"** respectively.
* As a workaround for web browsers restriction, the URI parameter **?media=application/json** or **?media=application/x-javascript** could be used.



````json
{
    "query": {
        "summary": "Query description"
    },
    "dataEntry": [
        {
            "compound": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/compound/{id}/conformer/{id}"
            },
            "values": {
                "key1": "value1",
                "key2": 3.14
            }
        },
        {
            "compound": {
                "URI": "http://host:port/ambit2/compound/{id}/conformer/{id}"
            },
            "values": {
                "key1": "value3",
                "key3": "value4"
            }
        }
    ],
    "feature": {
        "key1": {
            "type": "Feature",
            "title": "Title1",
            "units": "",
            "isNominal": false,
            "isNumeric": false,
            "sameAs": "ONTOLOGY_ENTRY",
            "isModelPredictionFeature": false,
            "creator": "URI",
            "order": 1,
            "source": {
                "URI": "URI of a dataset, algorithm, or a model",
                "type": "Dataset"
            }
        },
        "key2": {
            "type": "Feature",
            "title": "Title2",
            "units": "",
            "isNominal": false,
            "isNumeric": true,
            "sameAs": "ONTOLOGY_ENTRY",
            "isModelPredictionFeature": false,
            "creator": "URI",
            "order": 3,
            "source": {
                "URI": "URI of a dataset, algorithm, or a model",
                "type": "Algorithm"
            }
        },
        "key3": {
            "type": "Feature",
            "title": "Title 3",
            "units": "",
            "isNominal": false,
            "isNumeric": false,
            "sameAs": "ONTOLOGY_ENTRY",
            "isModelPredictionFeature": true,
            "creator": "URI",
            "order": 2,
            "source": {
                "URI": "URI of a dataset, algorithm, or a model",
                "type": "Model"
            }
        }
    }
}
````

#### [cURL](http://curl.haxx.se/) examples:

[Search](http://apps.ideaconsult.net:8080/ambit2/query/compound/search/all?search=caffeine&media=application/json&page=0&pagesize=1) for compound with name *caffeine*
````
    curl http://apps.ideaconsult.net:8080/ambit2/query/compound/search/all?search=caffeine&media=application/json&page=0&pagesize=1 
````

Retrieve the first 10 record of [dataset/1](http://apps.ideaconsult.net:8080/ambit2/dataset/12?page=0&pagesize=10)
````
    http://apps.ideaconsult.net:8080/ambit2/dataset/12?media=application/json&page=0&pagesize=10
```` 


### <a id="ONTOLOGY_ENTRY">The ontology entries</a>

In RDF the feature type is denoted by a mandatory link to an ontology via owl:sameAs or directly subclassing a class from an ontology.
The JSON representation uses the key **"sameAs"** and the same ontology URIs.

The following ontology entries are used to denote: 

#### Chemical identifiers [opentox.owl](http://www.opentox.org/api/1.1/opentox.owl):

* [CAS Registry](http://en.wikipedia.org/wiki/CAS_registry_number) number : "http://www.opentox.org/api/1.1#CASRN"
* [EC Registry](http://en.wikipedia.org/wiki/European_Commission_number) number : "http://www.opentox.org/api/1.1#EINECS"
* [IUPAC](http://www.iupac.org/) name : "http://www.opentox.org/api/1.1#IUPACName"
* Chemical name : "http:////www.opentox.org/api/1.1#ChemicalName"
* [SMILES](http://en.wikipedia.org/wiki/Simplified_molecular-input_line-entry_system) : "http://www.opentox.org/api/1.1#SMILES"
* [InChI](http://en.wikipedia.org/wiki/Inchi) : "http://www.opentox.org/api/1.1#InChI_std"
* [InChIKey]((http://en.wikipedia.org/wiki/Inchi)"http://www.opentox.org/api/1.1#InChIKey_std"
 
#### Toxicological endpoints [echaEndpoints.owl](http://www.opentox.org/echaEndpoints.owl), [SPARQL endpoint](http://apps.ideaconsult.net:8080/ontology/query/Endpoints) 

Examples:

* Fish toxicity http://www.opentox.org/echaEndpoints.owl#Acute_toxicity_to_fish_lethality 
* Carcinogenicity http://www.opentox.org/echaEndpoints.owl#Carcinogenicity	



