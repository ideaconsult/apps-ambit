##OpenTox REST API: Feature

A Feature is a resource, representing any kind of a property or identifier, assigned to a Compound. 

* The feature types are determined via their links to ontologies, e.g. [BlueObelisk ontology](http://apps.ideaconsult.net:8080/ontology/query/BODO) and [ECHA endpoints ontology](http://www.opentox.org/echaEndpoints.owl).
* Documentation http://opentox.org/dev/apis/api-1.2/Feature 

### JSON

OpenTox mandatory representation of REST resources is [RDF](http://www.w3.org/RDF/) (W3C Resource Description Framework). 
Examples: [1](http://opentox.org/dev/apis/api-1.2/Feature),[2](http://ambit.sourceforge.net/api_feature.html).

The JSON representation is a new development, implemented in AMBIT web services [1](http://ambit.sf.net),[2](http://www.jcheminf.com/content/3/1/18).

* The dataset JSON representation closely follows the RDF data model;
* A feature is identified by its URL and has a title, source,along with other properties
* Title *title:*
* Units *units:*
* The origin of the Feature *source:*. Any OpenTox [Dataset](dataset.md), [Algorithm](algorithm.md) or [Model](model.md) can serve as feature source. 
* Relations to other resources, which represent the same entity, could be established via *sameAs:* property. 
* This approach is be used for example to link the [feature](feature.md) resource to a resource form another [ontology](#ONTOLOGY_ENTRY).
*  *isNumeric* denotes if a feature holds numeric  or string values.
*  *isNominal* denote if a feature holds nominal values (a predefined list of string values).

* The JSON or JSONP representation could be retrieved via HTTP Accept headers **"application/json"** or **"application/x-javascript"** respectively.
* As a workaround for web browsers restriction, the URI parameter **?media=application/json** or **?media=application/x-javascript** could be used.



````json
{
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

##### [Retrieve dataset features](http://apps.ideaconsult.net:8080/ambit2/dataset/1/feature). More about [dataset](dataset.md).
````
    curl -H "Accept:application/json" \
        "http://apps.ideaconsult.net:8080/ambit2/dataset/1/feature" 
````
 Result
````json
{
    "feature": {
        "http://apps.ideaconsult.net:8080/ambit2/feature/2": {
            "type": "Feature",
            "title": "CasRN",
            "isNominal": false,
            "isNumeric": false,
            "sameAs": "http://www.opentox.org/api/1.1#CASRN",
            "isModelPredictionFeature": "false",
            "creator": "http://apps.echa.europa.eu/preregistered/prsDownload.aspx",
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/dataset/ECHA",
                "type": "Dataset"
            }
        },
        "http://apps.ideaconsult.net:8080/ambit2/feature/3": {
            "type": "Feature",
            "title": "EC",
            "isNominal": false,
            "isNumeric": false,
            "sameAs": "http://www.opentox.org/api/1.1#EINECS",
            "isModelPredictionFeature": "false",
            "creator": "http://apps.echa.europa.eu/preregistered/prsDownload.aspx",
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/dataset/ECHA",
                "type": "Dataset"
            }
        },
        "http://apps.ideaconsult.net:8080/ambit2/feature/4": {
            "type": "Feature",
            "title": "Names",
            "units": "",
            "isNominal": false,
            "isNumeric": true,
            "sameAs": "http://www.opentox.org/api/1.1#ChemicalName",
            "isModelPredictionFeature": "false",
            "creator": "http://apps.echa.europa.eu/preregistered/prsDownload.aspx",
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/dataset/ECHA",
                "type": "Dataset"
            }
        }
    }
}
````

###### [Retrieve model output variables](http://apps.ideaconsult.net:8080/ambit2/model/2/predicted) 
````
    curl "http://apps.ideaconsult.net:8080/ambit2/model/2/predicted?media=application/json&page=0&pagesize=10"
```` 

 Result
````json
{
    "feature": {
        "http://apps.ideaconsult.net:8080/ambit2/feature/9042927": {
            "type": "Feature",
            "title": "Cramer rules",
            "isNominal": "false",
            "isNumeric": "false",
            "sameAs": "Cramer rules",
            "isModelPredictionFeature": "false",
            "creator": "http://toxtree.sourceforge.net/cramer.html",
            "order": 9042927,
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/algorithm/Cramer+rules",
                "type": "Algorithm"
            }
        },
        "http://apps.ideaconsult.net:8080/ambit2/feature/9042928": {
            "type": "Feature",
            "title": "Cramer rules#explanation",
            "isNominal": "false",
            "isNumeric": "false",
            "sameAs": "Cramer rules#explanation",
            "isModelPredictionFeature": "false",
            "creator": "http://toxtree.sourceforge.net/cramer.html",
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/algorithm/Cramer+rules",
                "type": "Algorithm"
            }
        }
    }
}
````

### <a id="ONTOLOGY_ENTRY">The ontology entries</a>

In RDF the feature type is denoted by a mandatory link to an ontology via owl:sameAs or directly subclassing a class from an ontology.
The JSON representation uses the key **"sameAs"** and the same ontology URIs.

The following ontology entries are used to denote: 

#### Chemical identifiers [opentox.owl](http://www.opentox.org/api/1.1/opentox.owl):

* [CAS Registry](http://en.wikipedia.org/wiki/CAS_registry_number) number : "http://www.opentox.org/api/1.1#CASRN"
* [EC Registry](http://en.wikipedia.org/wiki/European_Commission_number) number : "http://www.opentox.org/api/1.1#EINECS"
* [IUPAC](http://www.iupac.org/) name : "http://www.opentox.org/api/1.1#IUPACName"
* Chemical name : "http://www.opentox.org/api/1.1#ChemicalName"
* [SMILES](http://en.wikipedia.org/wiki/Simplified_molecular-input_line-entry_system) : "http://www.opentox.org/api/1.1#SMILES"
* [InChI](http://en.wikipedia.org/wiki/Inchi) : "http://www.opentox.org/api/1.1#InChI_std"
* [InChIKey]((http://en.wikipedia.org/wiki/Inchi)"http://www.opentox.org/api/1.1#InChIKey_std"
 
#### Toxicological endpoints [echaEndpoints.owl](http://www.opentox.org/echaEndpoints.owl), [SPARQL](http://apps.ideaconsult.net:8080/ontology/query/Endpoints) 

Examples:

* Fish toxicity http://www.opentox.org/echaEndpoints.owl#Acute_toxicity_to_fish_lethality 
* Carcinogenicity http://www.opentox.org/echaEndpoints.owl#Carcinogenicity	



