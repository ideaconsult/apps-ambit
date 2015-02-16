
Supporting information for [createProperty API](http://ideaconsult.github.io/examples-ambit/apidocs/#!/property/createProperty)

Substance properties are "virtual" entities, generated from the data and NOT stored in database tables. 
The substance properties are generated from the study records by using the following entries: 

* Protocol category :  Feature.sameAs  (http://www.opentox.org/echaEndpoints.owl#CATEGORY) 
* Protocol guidance : Feature.source.URI (if URI it is taken as it is, if string is converted to URI using the {base_uri}/dataset/+URLENCODED(String) . 
* Effect endpoint : Feature.title 
* Effect units : Feature.units
* Effect conditions : part of the SHA2 hash 

The Feature.URI is generated as follows:
Example URI: https://apps.ideaconsult.net/enanomapper/property/P-CHEM/ZETA_POTENTIAL_SECTION/ZETA+POTENTIAL/7F8B3FB82019B1CCF8A8C3FD2B5A2DACBDDDB832/3ed642f9-1b42-387a-9966-dea5b91e5f8a
* https://apps.ideaconsult.net/enanomapper/property  : base URI of the server + "/property" resource
* /P-CHEM  - protocol top category (derived from protocol category)
* /ZETA_POTENTIAL_SECTION - protocol endpoint category
* /ZETA+POTENTIAL - effect endpoint
* /7F8B3FB82019B1CCF8A8C3FD2B5A2DACBDDDB832 : SHA2 hash generated from Feature.title, Feature.units, Effect conditions 
* /3ed642f9-1b42-387a-9966-dea5b91e5f8a : UUID generated from Feature.source.URI 

The API supports two modes of creating properties - via web form and Feature RDF  (JSON will follow shortly).
The Feature RDF must contain owl:sameAs , ot:hasSource, dc:title, ot:units  . 

  ([Example RDF](https://svn.code.sf.net/p/ambit/code/trunk/ambit2-all/ambit2-apps/ambit2-www/src/test/resources/feature.rdf)

````RDF
 <ot:hasSource rdf:resource="http://localhost:8080/ambit2/dataset/Method%3A+other%3A+Am.+Soc.+Test.+Mater.+%281980%29+and+U.S.+EPA+%281975%29"/>
 <owl:sameAs>http://www.opentox.org/echaEndpoints.owl#EC_DAPHNIATOX</owl:sameAs>
 <ot:units>mg/L</ot:units>
 <dc:title>EC10</dc:title>
````

To create a feature for e.g. modelling algorithm, ot:hasSource should point to the model URI; dc:title should be the title of the endpoint being predicted; owl:sameAs should reflect the endpoint category (see the [endpoint category drop down box](http://ideaconsult.github.io/examples-ambit/apidocs/#!/property/createProperty) for supported categories). The units should be rep[resented by ot:units (if relevant). These should match the data file, othwerwise the gereated property URI may differ.


###Examples:
#### Study record
````json
{
    "uuid": "FCSV-b42b9514-9693-3b87-b40e-6920a55ffb8e",
    "owner": {
        "substance": {
            "uuid": "FCSV-bc77c03d-4e75-3fab-bb3d-17b983663819"
        },
        "company": {
            "uuid": "FCSV-319611c6-e7da-3977-a5ac-eb74d49a4319",
            "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles.csv"
        }
    },
    "citation": {
        "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles.csv",
        "year": "2014",
        "owner": null
    },
    "protocol": {
        "topcategory": "P-CHEM",
        "category": {
            "code": "ZETA_POTENTIAL_SECTION",
            "title": "4.29 Nanomaterial zeta potential"
        },
        "endpoint": "DLS",
        "guideline": [
            "doi: 10.1021/nn406018q"
        ]
    },
    "parameters": {
        "DATA_GATHERING_INSTRUMENTS": "ZetaSizer Nano ZS (Malvern Instruments)",
        "Type of method": "DLS",
        "testmat_form": null
    },
    "reliability": {
        "r_isRobustStudy": "false",
        "r_isUsedforClassification": "false",
        "r_isUsedforMSDS": "false",
        "r_purposeFlag": null,
        "r_studyResultType": "experimental result",
        "r_value": null
    },
    "interpretation": {
        "result": null
    },
    "effects": [
        {
            "endpoint": "ZETA POTENTIAL",
            "conditions": {
                "MEDIUM": " ",
                "Remark": null,
                "pH": null
            },
            "result": {
                "unit": "mV",
                "loQualifier": "mean",
                "loValue": -21.78,
                "errQualifier": "sd",
                "errorValue": 6.81
            }
        },
        {
            "endpoint": "ZETA POTENTIAL",
            "conditions": {
                "MEDIUM": "Human serum (Sigma #H4522)",
                "Remark": null,
                "pH": null
            },
            "result": {
                "unit": "mV",
                "loQualifier": "mean",
                "loValue": -9.11,
                "errQualifier": "sd",
                "errorValue": 1.11
            }
        }
    ]
}
````

####Study records serialized as [datasets](https://apps.ideaconsult.net/enanomapper/substanceowner/FCSV-319611C6-E7DA-3977-A5AC-EB74D49A4319/dataset?max=1&media=application/json) :

````json
{
    "dataEntry": [
        {
            "compound": {
                "URI": "https://apps.ideaconsult.net/enanomapper/substance/FCSV-bc77c03d-4e75-3fab-bb3d-17b983663819"
            },
            "values": {
                "https://apps.ideaconsult.net/enanomapper/identifier/name": "G15.AC",
                "https://apps.ideaconsult.net/enanomapper/property/P-CHEM/ZETA_POTENTIAL_SECTION/ZETA+POTENTIAL/7F8B3FB82019B1CCF8A8C3FD2B5A2DACBDDDB832/3ed642f9-1b42-387a-9966-dea5b91e5f8a": [
                    {
                        "loQualifier": "mean",
                        "loValue": -21.78
                    }
                ],
                "https://apps.ideaconsult.net/enanomapper/property/P-CHEM/ZETA_POTENTIAL_SECTION/ZETA+POTENTIAL/AD2880DCCB16852FB869B7E10223708801EB1B02/3ed642f9-1b42-387a-9966-dea5b91e5f8a": [
                    {
                        "loQualifier": "mean",
                        "loValue": -9.11
                    }
                ]
            }
        }
    ],
    "model_uri": null,
    "feature": {
        "https://apps.ideaconsult.net/enanomapper/identifier/name": {
            "type": "Feature",
            "title": "Names",
            "units": "",
            "isNominal": false,
            "isNumeric": false,
            "isMultiValue": false,
            "sameAs": "http://www.opentox.org/api/1.1#ChemicalName",
            "isModelPredictionFeature": false,
            "creator": "",
            "order": 2,
            "source": {
                "URI": "https://apps.ideaconsult.net/enanomapper/dataset/Substance",
                "type": "Dataset"
            },
            "annotation": []
        },
        "https://apps.ideaconsult.net/enanomapper/property/P-CHEM/ZETA_POTENTIAL_SECTION/ZETA+POTENTIAL/7F8B3FB82019B1CCF8A8C3FD2B5A2DACBDDDB832/3ed642f9-1b42-387a-9966-dea5b91e5f8a": {
            "type": "Feature",
            "title": "ZETA POTENTIAL",
            "units": "mV",
            "isNominal": false,
            "isNumeric": false,
            "isMultiValue": true,
            "sameAs": "http://www.opentox.org/echaEndpoints.owl#ZETA_POTENTIAL",
            "isModelPredictionFeature": false,
            "creator": "doi: 10.1021/nn406018q",
            "order": 1803,
            "source": {
                "URI": "https://apps.ideaconsult.net/enanomapper/dataset/doi%3A+10.1021%2Fnn406018q",
                "type": "Dataset"
            },
            "annotation": [
                {
                    "p": "MEDIUM",
                    "o": " "
                }
            ]
        },
        "https://apps.ideaconsult.net/enanomapper/property/P-CHEM/ZETA_POTENTIAL_SECTION/ZETA+POTENTIAL/AD2880DCCB16852FB869B7E10223708801EB1B02/3ed642f9-1b42-387a-9966-dea5b91e5f8a": {
            "type": "Feature",
            "title": "ZETA POTENTIAL",
            "units": "mV",
            "isNominal": false,
            "isNumeric": false,
            "isMultiValue": true,
            "sameAs": "http://www.opentox.org/echaEndpoints.owl#ZETA_POTENTIAL",
            "isModelPredictionFeature": false,
            "creator": "doi: 10.1021/nn406018q",
            "order": 1804,
            "source": {
                "URI": "https://apps.ideaconsult.net/enanomapper/dataset/doi%3A+10.1021%2Fnn406018q",
                "type": "Dataset"
            },
            "annotation": [
                {
                    "p": "MEDIUM",
                    "o": "Human serum (Sigma #H4522)"
                }
            ]
        }
    }
}
````
