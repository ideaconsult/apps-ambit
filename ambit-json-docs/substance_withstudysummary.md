#### Query to retrieve all substances related to a compound , including study summaries:

   https://apps.ideaconsult.net/toxcast/substance?type=related&compound_uri=https%3A%2F%2Fapps.ideaconsult.net%2Ftoxcast%2Fcompound%2F3&media=application%2Fjson&studysummary=true

* Note there are 5 different entries (the `substance` array), related to the Acetaminophen. In the context of the example (ToxCast Phase II) these are 5 different samples. The `composition` array defines what the substance is composed of.
 
Result:

````
{
    "substance": [
        {
            "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e",
            "ownerUUID": "TX14-0c6f168c-06d1-f580-f664-a82bcb89a745",
            "ownerName": "ToxCast2014",
            "i5uuid": "TX14-17cc8819-2429-10e9-67d1-44b553f4df8e",
            "name": "TX002867",
            "publicname": "Acetaminophen",
            "format": "20006",
            "substanceType": "Existing Chemical",
            "referenceSubstance": {
                "i5uuid": "TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f",
                "uri": "https://apps.ideaconsult.net/toxcast/query/compound/search/all?search=TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f"
            },
            "composition": [
                {
                    "substance": {
                        "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e"
                    },
                    "component": {
                        "compound": {
                            "URI": "https://apps.ideaconsult.net/toxcast/compound/3"
                        }
                    },
                    "compositionUUID": "SMPL-17cc8819-2429-10e9-67d1-44b553f4df8e",
                    "compositionName": "SAMPLE TX002867 SID=20006",
                    "relation": "HAS_CONSTITUENT",
                    "proportion": {
                        "typical": {
                            "precision": null,
                            "value": 100,
                            "unit": "%"
                        },
                        "real": {
                            "lowerPrecision": null,
                            "lowerValue": 100,
                            "upperPrecision": null,
                            "upperValue": 100,
                            "unit": "%"
                        },
                        "function_as_additive": null
                    }
                }
            ],
            "externalIdentifiers": [],
            "bundles": {},
            "studysummary": [
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_CYCLE",
                        "description": "CELL CYCLE",
                        "order": 1001,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=CELL_CYCLE"
                    },
                    "interpretation_result": "Inactive",
                    "count": 16
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_DEATH",
                        "description": "CELL DEATH",
                        "order": 1002,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=CELL_DEATH"
                    },
                    "interpretation_result": "Inactive",
                    "count": 27
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_MORPHOLOGY",
                        "description": "CELL MORPHOLOGY",
                        "order": 1003,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=CELL_MORPHOLOGY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 2
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_PROLIFERATION",
                        "description": "CELL PROLIFERATION",
                        "order": 1004,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=CELL_PROLIFERATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 10
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "MITOCHONDRIAL_DEPOLARIZATION",
                        "description": "MITOCHONDRIAL DEPOLARIZATION",
                        "order": 1005,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=MITOCHONDRIAL_DEPOLARIZATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 4
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "OXIDATIVE_PHOSPHORYLATION",
                        "description": "OXIDATIVE PHOSPHORYLATION",
                        "order": 1006,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=OXIDATIVE_PHOSPHORYLATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 8
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "PROTEIN_STABILIZATION",
                        "description": "PROTEIN STABILIZATION",
                        "order": 1007,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=PROTEIN_STABILIZATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 18
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "RECEPTOR_BINDING",
                        "description": "RECEPTOR BINDING",
                        "order": 1008,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=RECEPTOR_BINDING"
                    },
                    "interpretation_result": "Active",
                    "count": 1
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_CATALYTIC_ACTIVITY",
                        "description": "REGULATION OF CATALYTIC ACTIVITY",
                        "order": 1009,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=REGULATION_OF_CATALYTIC_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 6
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_GENE_EXPRESSION",
                        "description": "REGULATION OF GENE EXPRESSION",
                        "order": 1010,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=REGULATION_OF_GENE_EXPRESSION"
                    },
                    "interpretation_result": "Active",
                    "count": 5
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_GENE_EXPRESSION",
                        "description": "REGULATION OF GENE EXPRESSION",
                        "order": 1010,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=REGULATION_OF_GENE_EXPRESSION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 144
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY",
                        "description": "REGULATION OF TRANSCRIPTION FACTOR ACTIVITY",
                        "order": 1011,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-17cc8819-2429-10e9-67d1-44b553f4df8e/study?top=TOX&category=REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 81
                }
            ]
        },
        {
            "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d",
            "ownerUUID": "TX14-0c6f168c-06d1-f580-f664-a82bcb89a745",
            "ownerName": "ToxCast2014",
            "i5uuid": "TX14-31102d50-124f-a51d-5775-60ea81ed4d3d",
            "name": "Tox21_300100",
            "publicname": "Acetaminophen",
            "format": "20006",
            "substanceType": "Existing Chemical",
            "referenceSubstance": {
                "i5uuid": "TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f",
                "uri": "https://apps.ideaconsult.net/toxcast/query/compound/search/all?search=TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f"
            },
            "composition": [
                {
                    "substance": {
                        "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d"
                    },
                    "component": {
                        "compound": {
                            "URI": "https://apps.ideaconsult.net/toxcast/compound/3"
                        }
                    },
                    "compositionUUID": "SMPL-31102d50-124f-a51d-5775-60ea81ed4d3d",
                    "compositionName": "SAMPLE Tox21_300100 SID=20006",
                    "relation": "HAS_CONSTITUENT",
                    "proportion": {
                        "typical": {
                            "precision": null,
                            "value": 100,
                            "unit": "%"
                        },
                        "real": {
                            "lowerPrecision": null,
                            "lowerValue": 100,
                            "upperPrecision": null,
                            "upperValue": 100,
                            "unit": "%"
                        },
                        "function_as_additive": null
                    }
                }
            ],
            "externalIdentifiers": [],
            "bundles": {},
            "studysummary": [
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX"
                    },
                    "category": {
                        "title": "AUTOFLUORESCENCE",
                        "description": "AUTOFLUORESCENCE",
                        "order": 1012,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX&category=AUTOFLUORESCENCE"
                    },
                    "interpretation_result": "Inactive",
                    "count": 12
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_PROLIFERATION",
                        "description": "CELL PROLIFERATION",
                        "order": 1004,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX&category=CELL_PROLIFERATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 7
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX"
                    },
                    "category": {
                        "title": "MITOCHONDRIAL_DEPOLARIZATION",
                        "description": "MITOCHONDRIAL DEPOLARIZATION",
                        "order": 1005,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX&category=MITOCHONDRIAL_DEPOLARIZATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 1
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_CATALYTIC_ACTIVITY",
                        "description": "REGULATION OF CATALYTIC ACTIVITY",
                        "order": 1009,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX&category=REGULATION_OF_CATALYTIC_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 14
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_GENE_EXPRESSION",
                        "description": "REGULATION OF GENE EXPRESSION",
                        "order": 1010,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX&category=REGULATION_OF_GENE_EXPRESSION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 25
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY",
                        "description": "REGULATION OF TRANSCRIPTION FACTOR ACTIVITY",
                        "order": 1011,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-31102d50-124f-a51d-5775-60ea81ed4d3d/study?top=TOX&category=REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 6
                }
            ]
        },
        {
            "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d",
            "ownerUUID": "TX14-0c6f168c-06d1-f580-f664-a82bcb89a745",
            "ownerName": "ToxCast2014",
            "i5uuid": "TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d",
            "name": "Tox21_110397",
            "publicname": "Acetaminophen",
            "format": "20006",
            "substanceType": "Existing Chemical",
            "referenceSubstance": {
                "i5uuid": "TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f",
                "uri": "https://apps.ideaconsult.net/toxcast/query/compound/search/all?search=TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f"
            },
            "composition": [
                {
                    "substance": {
                        "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d"
                    },
                    "component": {
                        "compound": {
                            "URI": "https://apps.ideaconsult.net/toxcast/compound/3"
                        }
                    },
                    "compositionUUID": "SMPL-44b260e4-294a-6285-b4a0-39ea6bbfa10d",
                    "compositionName": "SAMPLE Tox21_110397 SID=20006",
                    "relation": "HAS_CONSTITUENT",
                    "proportion": {
                        "typical": {
                            "precision": null,
                            "value": 100,
                            "unit": "%"
                        },
                        "real": {
                            "lowerPrecision": null,
                            "lowerValue": 100,
                            "upperPrecision": null,
                            "upperValue": 100,
                            "unit": "%"
                        },
                        "function_as_additive": null
                    }
                }
            ],
            "externalIdentifiers": [],
            "bundles": {},
            "studysummary": [
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX"
                    },
                    "category": {
                        "title": "AUTOFLUORESCENCE",
                        "description": "AUTOFLUORESCENCE",
                        "order": 1012,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX&category=AUTOFLUORESCENCE"
                    },
                    "interpretation_result": "Inactive",
                    "count": 12
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_PROLIFERATION",
                        "description": "CELL PROLIFERATION",
                        "order": 1004,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX&category=CELL_PROLIFERATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 4
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_CATALYTIC_ACTIVITY",
                        "description": "REGULATION OF CATALYTIC ACTIVITY",
                        "order": 1009,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX&category=REGULATION_OF_CATALYTIC_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 4
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_GENE_EXPRESSION",
                        "description": "REGULATION OF GENE EXPRESSION",
                        "order": 1010,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX&category=REGULATION_OF_GENE_EXPRESSION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 16
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY",
                        "description": "REGULATION OF TRANSCRIPTION FACTOR ACTIVITY",
                        "order": 1011,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-44b260e4-294a-6285-b4a0-39ea6bbfa10d/study?top=TOX&category=REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 4
                }
            ]
        },
        {
            "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51",
            "ownerUUID": "TX14-0c6f168c-06d1-f580-f664-a82bcb89a745",
            "ownerName": "ToxCast2014",
            "i5uuid": "TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51",
            "name": "Tox21_201930",
            "publicname": "Acetaminophen",
            "format": "20006",
            "substanceType": "Existing Chemical",
            "referenceSubstance": {
                "i5uuid": "TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f",
                "uri": "https://apps.ideaconsult.net/toxcast/query/compound/search/all?search=TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f"
            },
            "composition": [
                {
                    "substance": {
                        "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51"
                    },
                    "component": {
                        "compound": {
                            "URI": "https://apps.ideaconsult.net/toxcast/compound/3"
                        }
                    },
                    "compositionUUID": "SMPL-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51",
                    "compositionName": "SAMPLE Tox21_201930 SID=20006",
                    "relation": "HAS_CONSTITUENT",
                    "proportion": {
                        "typical": {
                            "precision": null,
                            "value": 100,
                            "unit": "%"
                        },
                        "real": {
                            "lowerPrecision": null,
                            "lowerValue": 100,
                            "upperPrecision": null,
                            "upperValue": 100,
                            "unit": "%"
                        },
                        "function_as_additive": null
                    }
                }
            ],
            "externalIdentifiers": [],
            "bundles": {},
            "studysummary": [
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "AUTOFLUORESCENCE",
                        "description": "AUTOFLUORESCENCE",
                        "order": 1012,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=AUTOFLUORESCENCE"
                    },
                    "interpretation_result": "Inactive",
                    "count": 12
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_PROLIFERATION",
                        "description": "CELL PROLIFERATION",
                        "order": 1004,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=CELL_PROLIFERATION"
                    },
                    "interpretation_result": "Active",
                    "count": 1
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_PROLIFERATION",
                        "description": "CELL PROLIFERATION",
                        "order": 1004,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=CELL_PROLIFERATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 6
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "MITOCHONDRIAL_DEPOLARIZATION",
                        "description": "MITOCHONDRIAL DEPOLARIZATION",
                        "order": 1005,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=MITOCHONDRIAL_DEPOLARIZATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 1
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_CATALYTIC_ACTIVITY",
                        "description": "REGULATION OF CATALYTIC ACTIVITY",
                        "order": 1009,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=REGULATION_OF_CATALYTIC_ACTIVITY"
                    },
                    "interpretation_result": "Active",
                    "count": 1
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_CATALYTIC_ACTIVITY",
                        "description": "REGULATION OF CATALYTIC ACTIVITY",
                        "order": 1009,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=REGULATION_OF_CATALYTIC_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 13
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_GENE_EXPRESSION",
                        "description": "REGULATION OF GENE EXPRESSION",
                        "order": 1010,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=REGULATION_OF_GENE_EXPRESSION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 25
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY",
                        "description": "REGULATION OF TRANSCRIPTION FACTOR ACTIVITY",
                        "order": 1011,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-6d7d1769-5fb8-23ff-1e76-ef9bd46f1f51/study?top=TOX&category=REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 6
                }
            ]
        },
        {
            "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2",
            "ownerUUID": "TX14-0c6f168c-06d1-f580-f664-a82bcb89a745",
            "ownerName": "ToxCast2014",
            "i5uuid": "TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2",
            "name": "Tox21_110397_1",
            "publicname": "Acetaminophen",
            "format": "20006",
            "substanceType": "Existing Chemical",
            "referenceSubstance": {
                "i5uuid": "TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f",
                "uri": "https://apps.ideaconsult.net/toxcast/query/compound/search/all?search=TX14-59df6576-9c29-b94d-8bcc-e0d3f4999b9f"
            },
            "composition": [
                {
                    "substance": {
                        "URI": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2"
                    },
                    "component": {
                        "compound": {
                            "URI": "https://apps.ideaconsult.net/toxcast/compound/3"
                        }
                    },
                    "compositionUUID": "SMPL-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2",
                    "compositionName": "SAMPLE Tox21_110397_1 SID=20006",
                    "relation": "HAS_CONSTITUENT",
                    "proportion": {
                        "typical": {
                            "precision": null,
                            "value": 100,
                            "unit": "%"
                        },
                        "real": {
                            "lowerPrecision": null,
                            "lowerValue": 100,
                            "upperPrecision": null,
                            "upperValue": 100,
                            "unit": "%"
                        },
                        "function_as_additive": null
                    }
                }
            ],
            "externalIdentifiers": [],
            "bundles": {},
            "studysummary": [
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX"
                    },
                    "category": {
                        "title": "CELL_PROLIFERATION",
                        "description": "CELL PROLIFERATION",
                        "order": 1004,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX&category=CELL_PROLIFERATION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 3
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_CATALYTIC_ACTIVITY",
                        "description": "REGULATION OF CATALYTIC ACTIVITY",
                        "order": 1009,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX&category=REGULATION_OF_CATALYTIC_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 9
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_GENE_EXPRESSION",
                        "description": "REGULATION OF GENE EXPRESSION",
                        "order": 1010,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX&category=REGULATION_OF_GENE_EXPRESSION"
                    },
                    "interpretation_result": "Inactive",
                    "count": 8
                },
                {
                    "topcategory": {
                        "title": "TOX",
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX"
                    },
                    "category": {
                        "title": "REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY",
                        "description": "REGULATION OF TRANSCRIPTION FACTOR ACTIVITY",
                        "order": 1011,
                        "uri": "https://apps.ideaconsult.net/toxcast/substance/TX14-f613bd9d-2136-f95a-9c24-a3fda2ee9bb2/study?top=TOX&category=REGULATION_OF_TRANSCRIPTION_FACTOR_ACTIVITY"
                    },
                    "interpretation_result": "Inactive",
                    "count": 2
                }
            ]
        }
    ],
    "records": 5
}
````
