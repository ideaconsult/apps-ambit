##AMBIT REST API: Bundle resource

> bundle: a collection of things, or a quantity of material, tied or wrapped up together. 

A Bundle resource provides means to define collections of [Substance](substance.md), [Compounds](dataset.md) and Endpoints. [API documentation](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle)

### Bundle

1. Bundle summary [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleSummary)]
2. List compounds in a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleCompounds)]
3. List substances in a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleSubstances)]
4. List endpoints in a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleProperties)]
5. List studies defined by a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleStudySummary)]
6. Compound role (*bundle_uri* parameter added to compound queries) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/compound_0/searchBySimilarity)] [[example](http://apps.ideaconsult.net:8080/data/query/similarity?search=C%3DO&type=smiles&bundle_uri=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
7. Substance role (*bundle_uri* parameter added to substance queries) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance_1/getSubstances)] [[example](http://apps.ideaconsult.net:8080/data/substance?search=formaldehyde&type=name&bundle_uri=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
8. Endpoint role (*bundle_uri* parameter added to endpoint queries) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/query/getEndpointSummary)] [[example](http://apps.ideaconsult.net:8080/data/query/study?topcategory=P-CHEM&category=PC_MELTING&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
9. Filter endpoints by endpoints, defined in a bundle (*filterbybundle* parameter ) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/query/getEndpointSummary)] [[examples](http://apps.ideaconsult.net:8080/data/query/study?selected=endpoints&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1&media=application/json)]
10. Filter endpoints by substances, defined in a bundle (*filterbybundle* parameter ) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/query/getEndpointSummary)] [[examples](http://apps.ideaconsult.net:8080/data/query/study?selected=substances&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1&media=application/json)]
11. Filter substances by a bundle (*filterbybundle* parameter ) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance/searchByRelatedCompound)] [[examples](http://apps.ideaconsult.net:8080/data/query/substance/related?compound_uri=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fcompound%2F21219&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
12. Create an empty bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/createBundle)]
13. Update a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateBundle)]
14. Get all bundles [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundles)]
  The result is a [Dataset](dataset.md) metadata.
15. Delete a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/deleteBundle)]
16. Dataset of substances, defined by the bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleDataset)]
  The format is the same as for [Substance dataset](substance_dataset.md). The substances and the endpoints can be added and removed to / from the bundle.
17. Add or delete substance to / from a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateSubstanceInBundle)]
18. Add or delete compound to / from a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateCompoundInBundle)]
19. Add or delete endpoint categories to / from a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updatePropertyInBundle)]
20. Copy selected study entries (determined by selected substances and endpoint) into local copy in a bundle /bundle/{idbundle}/matrix [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/createMatrixFromBundle)]
21. Delete local study copy in a bundle  /bundle/{idbundle}/matrix [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/deleteMatrixFromBundle)]
22. Read the local copy of studies (same format as /bundle/{idbundle}/dataset ) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleMatrix)]
23. Mark values in the local copy of studues as deleted PUT /bundle/{idbundle}/matrix/deleted. [JSON format expected](https://svn.code.sf.net/p/ambit/code/trunk/ambit2-all/ambit2-core/src/test/resources/ambit2/core/data/json/effects_delete.json)
24. Update local copy of studies  /bundle/{idbundle}/matrix . Does not add substances! Content-type should be either application/json or multipart/form-data with *.json file attached [json schema](https://github.com/ideaconsult/api/blob/master/apidocs/study-schema.json). The study.owner.substance.uuid should be an existing Substance UUID.  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/uploadBundleStudy)]. 
study JSON example :

Example 1
````json
{
    "study": [
        {
            "owner": {
                "substance": {
                    "uuid": "IUC4-efdb21bb-e79f-3286-a988-b6f6944d3734"
                }
            },
            "protocol": {
                "topcategory": "TOX",
                "category": {
                    "code": "TO_ACUTE_ORAL_SECTION"
                },
                "endpoint": "Acute toxicity: oral.001",
                "guideline": [
                    "OECD Guideline 401 (Acute Oral Toxicity)"
                ]
            },
            "citation": {
                "title": "Study reference",
                "year": "2015",
                "owner": "My company"
            },
            "parameters": {
                "Species": "rat",
                "Sex": "male/female"
            },
            "interpretation": {
                "result": "not classified",
                "criteria": "EU"
            },
            "reliability": {
                "r_isRobustStudy": "false",
                "r_isUsedforClassification": "false",
                "r_isUsedforMSDS": "false",
                "r_purposeFlag": "",
                "r_studyResultType": "",
                "r_value": "3 (not reliable)"
            },
            "effects": [
                {
                    "endpoint": "LD50",
                    "conditions": {
                        "Sex": "male"
                    },
                    "result": {
                        "unit": "mg/kg bw",
                        "loQualifier": ">",
                        "loValue": 5000
                    }
                },
                {
                    "endpoint": "LD50",
                    "conditions": {
                        "Sex": "female"
                    },
                    "result": {
                        "unit": "mg/kg bw",
                        "loQualifier": ">",
                        "loValue": 2000,
                        "upQualifier": "<",
                        "upValue": 5000
                    }
                }
            ]
        },
        {
            "uuid": null,
            "owner": {
                "substance": {
                    "uuid": "IUC4-efdb21bb-e79f-3286-a988-b6f6944d3734"
                },
                "company": {
                    "uuid": "TEST-e535bebb-e59f-3906-f988-554478ad3734",
                    "name": "Morgoth"
                }
            },
            "citation": {
                "title": "Study reference 123",
                "year": "2014",
                "owner": "Your company"
            },
            "protocol": {
                "topcategory": "ENV FATE",
                "category": {
                    "code": "TO_BIODEG_WATER_SCREEN_SECTION"
                },
                "endpoint": "Biodegradation in water: screening tests.001",
                "guideline": [
                    "OECD Guideline 301 D (Ready Biodegradability: Closed Bottle Test)"
                ]
            },
            "parameters": {
                "TEST TYPE": "aerobic"
            },
            "reliability": {
                "r_isRobustStudy": "false",
                "r_isUsedforClassification": "false",
                "r_isUsedforMSDS": "false",
                "r_purposeFlag": "",
                "r_studyResultType": "",
                "r_value": "3 (not reliable)"
            },
            "interpretation": {
                "result": "readily biodegradable",
                "criteria": ""
            },
            "effects": [
                {
                    "endpoint": "% Degradation",
                    "conditions": {
                        "Time point": "3 h"
                    },
                    "result": {
                        "unit": "%",
                        "loQualifier": "",
                        "loValue": 0
                    }
                },
                {
                    "endpoint": "% Degradation",
                    "conditions": {
                        "Time point": "7 d"
                    },
                    "result": {
                        "unit": "%",
                        "loQualifier": "",
                        "loValue": 20
                    }
                },
                {
                    "endpoint": "% Degradation",
                    "conditions": {
                        "Time point": "14 d"
                    },
                    "result": {
                        "unit": "%",
                        "loQualifier": "",
                        "loValue": 50
                    }
                },
                {
                    "endpoint": "% Degradation",
                    "conditions": {
                        "Time point": "28 d"
                    },
                    "result": {
                        "unit": "%",
                        "loQualifier": "",
                        "loValue": 85
                    }
                }
            ]
        }
    ]
}
````

Example 2
````JSON
{
    "study": [
        {
            "uuid": "IUC5-69f39568-46e4-45ba-94f6-f00765525422",
            "owner": {
                "substance": {
                    "uuid": "IUC4-efdb21bb-e79f-3286-a988-b6f6944d3734"
                },
                "company": {
                    "uuid": "TEST-e535bebb-e59f-3906-f988-554478ad3734",
                    "name": "Morgoth"
                }
            },
            "protocol": {
                "topcategory": "TOX",
                "category": {
                    "code": "TO_ACUTE_ORAL_SECTION"
                },
                "endpoint": "Acute toxicity: oral.001",
                "guidance": [
                    "OECD Guideline 401 (Acute Oral Toxicity)"
                ]
            },
            "parameters": {
                "Year": "1999",
                "Reference": "ano",
                "Species": "rat",
                "Sex": "male/female"
            },
            "reliability": {
                "r_isRobustStudy": "false",
                "r_isUsedforClassification": "false",
                "r_isUsedforMSDS": "false",
                "r_purposeFlag": "",
                "r_studyResultType": "",
                "r_value": "3 (not reliable)"
            },
            "interpretation": {
                "result": "not classified",
                "criteria": "EU"
            },
            "effects": [
                {
                    "endpoint": "LD50",
                    "conditions": {
                        "Sex": "male"
                    },
                    "result": {
                        "unit": "mg/kg bw",
                        "loQualifier": ">",
                        "loValue": 5000
                    }
                },
                {
                    "endpoint": "LD50",
                    "conditions": {
                        "Sex": "female"
                    },
                    "result": {
                        "unit": "mg/kg bw",
                        "loQualifier": ">",
                        "loValue": 2000,
                        "upQualifier": "<",
                        "upValue": 5000
                    }
                }
            ]
        }
    ]
}
````
