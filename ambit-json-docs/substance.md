##Substance

###Existing chemical [Composition](http://apps.ideaconsult.net:8080/biodeg/substance/IUC4-bd8b36ce-3d42-357d-b968-09144269488a/composition), [Study](http://apps.ideaconsult.net:8080/biodeg/substance/IUC4-bd8b36ce-3d42-357d-b968-09144269488a/study) 

###Nanomaterial [Composition](#composition), [Study](#study), [Summary](#summary), [Substance dataset](substance_dataset.md)


####<a name="upload"></a>Substance and study upload 

 [example web form ](http://apps.ideaconsult.net:8080/enanomapper/ui/uploadsubstance1)

````
  curl -H "subjectid:OPENSSO_TOKEN" --form files[]=@predicted.csv --form clearMeasurements=yes --form clearComposition=no --form qaenabled=no http://apps.ideaconsult.net:8080/enanomapper/substance -iv     
             

````

or to keep previous info 

````
  curl -H "subjectid:OPENSSO_TOKEN" --form files[]=@predicted.csv --form http://apps.ideaconsult.net:8080/enanomapper/substance -iv
````

####<a name="study"></a>Study  

[Demo link](http://apps.ideaconsult.net:8080/enanomapper/substance/PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819/study)

````json
{
    "study": [
        {
            "uuid": "IUC5-89019c4a-acc8-4457-8a5a-4db66cd16ff3",
            "owner": {
                "substance": {
                    "uuid": "IUC4-d0966414-0e9b-3610-ab7d-7d27848027e2"
                },
                "company": {
                    "uuid": "IUC4-44bf02d8-47c5-385d-b203-9a8f315911cb",
                    "name": "OECD / Paris / France"
                }
            },
            "citation": {
                "title": "eNMtest",
                "year": "2014",
                "owner": "Owner company"
            },
            "protocol": {
                "topcategory": "P-CHEM",
                "category": {
                    "code": "ZETA_POTENTIAL_SECTION",
                    "title": "4.29 Nanomaterial zeta potential"
                },
                "endpoint": "Zeta potential.001",
                "guideline": [
                    "some guideline"
                ]
            },
            "parameters": {
                "DATA_GATHERING_INSTRUMENTS": null,
                "Method details": "Details",
                "SAMPLING": null,
                "TESTMAT_FORM": "aerosol",
                "Type of method": "Laser-Doppler"
            },
            "reliability": {
                "r_isRobustStudy": "true",
                "r_isUsedforClassification": "true",
                "r_isUsedforMSDS": "true",
                "r_purposeFlag": "key study",
                "r_studyResultType": "experimental result",
                "r_value": "1 (reliable without restriction)"
            },
            "interpretation": {
                "result": "Conclusions"
            },
            "effects": [
                {
                    "endpoint": "ZETA POTENTIAL",
                    "conditions": {
                        "MEDIUM": "in medium",
                        "Remark": "Remarks",
                        "STD_DEV": {
                            "loValue": 1,
                            "unit": "mV"
                        },
                        "pH": {
                            "loValue": "1"
                        }
                    },
                    "result": {
                        "unit": "mV",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "ISOELECTRIC POINT",
                    "conditions": {
                        "MEDIUM": "in medium",
                        "Remark": "Remarks",
                        "STD_DEV": {
                            "loValue": 1
                        },
                        "pH": null
                    },
                    "result": {
                        "unit": null,
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                }
            ]
        },
        {
            "uuid": "IUC5-f1fb9fe7-3ed0-4650-a7f8-d56ba17e5d07",
            "owner": {
                "substance": {
                    "uuid": "IUC4-d0966414-0e9b-3610-ab7d-7d27848027e2"
                },
                "company": {
                    "uuid": "IUC4-44bf02d8-47c5-385d-b203-9a8f315911cb",
                    "name": "OECD / Paris / France"
                }
            },
            "citation": {
                "title": "eNMtest",
                "year": "2014",
                "owner": "Owner company"
            },
            "protocol": {
                "topcategory": "P-CHEM",
                "category": {
                    "code": "PC_GRANULOMETRY_SECTION",
                    "title": "4.5 Particle size distribution (Granulometry)"
                },
                "endpoint": "Particle size distribution (Granulometry).001",
                "guideline": [
                    "OECD Guideline 110 (Particle Size Distribution / Fibre Length and Diameter Distributions)"
                ]
            },
            "parameters": {
                "DISTRIBUTION_TYPE": "volumetric distribution",
                "TESTMAT_FORM": "aerosol"
            },
            "reliability": {
                "r_isRobustStudy": "true",
                "r_isUsedforClassification": "true",
                "r_isUsedforMSDS": "true",
                "r_purposeFlag": "key study",
                "r_studyResultType": "experimental result",
                "r_value": "1 (reliable without restriction)"
            },
            "interpretation": {
                "result": "Conclusions"
            },
            "effects": [
                {
                    "endpoint": "MASS MEDIAN DIAMETER",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": {
                            "loValue": null
                        },
                        "SEQ_NUM": {
                            "loValue": null
                        },
                        "STD_DEV": {
                            "loValue": null
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "MASS MEDIAN AERODYNAMIC DIAMETER",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": {
                            "loValue": null
                        },
                        "SEQ_NUM": {
                            "loValue": null
                        },
                        "STD_DEV": {
                            "Class": "GEOMETRIC STANDARD DEVIATION",
                            "isResult": "true",
                            "loQualifier": ">",
                            "loValue": 1,
                            "upQualifier": "<",
                            "upValue": 2
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "PARTICLE SIZE.D10",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": {
                            "loQualifier": "  ",
                            "loValue": "D10"
                        },
                        "Remark": {
                            "loQualifier": "  ",
                            "loValue": "Remarks"
                        },
                        "SEQ_NUM": {
                            "loValue": null
                        },
                        "STD_DEV": {
                            "loValue": 1
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "PARTICLE SIZE.D50",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": {
                            "loQualifier": "  ",
                            "loValue": "D50"
                        },
                        "Remark": {
                            "loQualifier": "  ",
                            "loValue": "Remarks"
                        },
                        "SEQ_NUM": {
                            "loValue": null
                        },
                        "STD_DEV": {
                            "loValue": 1
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "PARTICLE SIZE.D90",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": {
                            "loQualifier": "  ",
                            "loValue": "D90"
                        },
                        "Remark": {
                            "loQualifier": "  ",
                            "loValue": "Remarks"
                        },
                        "SEQ_NUM": {
                            "loValue": null
                        },
                        "STD_DEV": {
                            "loValue": 1
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "PARTICLE SIZE.DT95",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": {
                            "loQualifier": "  ",
                            "loValue": "DT95"
                        },
                        "Remark": {
                            "loQualifier": "  ",
                            "loValue": "Remarks"
                        },
                        "SEQ_NUM": {
                            "loValue": null
                        },
                        "STD_DEV": {
                            "loValue": 1
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "PARTICLE SIZE.DT99",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": {
                            "loQualifier": "  ",
                            "loValue": "DT99"
                        },
                        "Remark": {
                            "loQualifier": "  ",
                            "loValue": "Remarks"
                        },
                        "SEQ_NUM": {
                            "loValue": null
                        },
                        "STD_DEV": {
                            "loValue": 1
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                },
                {
                    "endpoint": "PARTICLE SIZE",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": {
                            "loValue": "Remarks"
                        },
                        "SEQ_NUM": {
                            "loQualifier": "  ",
                            "loValue": "#1"
                        },
                        "STD_DEV": {
                            "Class": "Distribution",
                            "isResult": "true",
                            "loQualifier": ">",
                            "loValue": 1,
                            "upQualifier": "<",
                            "upValue": 2
                        }
                    },
                    "result": {
                        "unit": "µm",
                        "loQualifier": ">",
                        "loValue": 1,
                        "upQualifier": "<",
                        "upValue": 2
                    }
                }
            ]
        }
    ]
}
````

####<a name='composition'></a>Composition
````json
{
    "composition": [
        {
            "substance": {
                "URI": "http://apps.ideaconsult.net:8080/enanomapper/substance/1"
            },
            "component": {
                "compound": {
                    "URI": "http://apps.ideaconsult.net:8080/enanomapper/compound/1/conformer/1",
                    "structype": "NA",
                    "metric": null,
                    "name": "",
                    "cas": "",
                    "einecs": ""
                },
                "values": {
                    "http://apps.ideaconsult.net:8080/enanomapper/feature/http%3A%2F%2Fwww.opentox.org%2Fapi%2F1.1%23ChemicalNameDefault": "[Au]"
                },
                "facets": []
            },
            "compositionUUID": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819",
            "relation": "HAS_CORE",
            "proportion": {
                "typical": {
                    "precision": null,
                    "value": 0,
                    "unit": null
                },
                "real": {
                    "lowerPrecision": null,
                    "lowerValue": 0,
                    "upperPrecision": null,
                    "upperValue": 0,
                    "unit": null
                },
                "function_as_additive": null
            }
        },
        {
            "substance": {
                "URI": "http://apps.ideaconsult.net:8080/enanomapper/substance/1"
            },
            "component": {
                "compound": {
                    "URI": "http://apps.ideaconsult.net:8080/enanomapper/compound/2/conformer/2",
                    "structype": "NA",
                    "metric": null,
                    "name": "",
                    "cas": "",
                    "einecs": ""
                },
                "values": {
                    "http://apps.ideaconsult.net:8080/enanomapper/feature/http%3A%2F%2Fwww.opentox.org%2Fapi%2F1.1%23ChemicalNameDefault": "AC"
                },
                "facets": []
            },
            "compositionUUID": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819",
            "relation": "HAS_COATING",
            "proportion": {
                "typical": {
                    "precision": null,
                    "value": 0,
                    "unit": null
                },
                "real": {
                    "lowerPrecision": null,
                    "lowerValue": 0,
                    "upperPrecision": null,
                    "upperValue": 0,
                    "unit": null
                },
                "function_as_additive": null
            }
        }
    ],
    "feature": {
        "http://apps.ideaconsult.net:8080/enanomapper/feature/http%3A%2F%2Fwww.opentox.org%2Fapi%2F1.1%23IUPACNameDefault": {
            "type": "Feature",
            "title": "IUPAC name",
            "units": "",
            "isNominal": "false",
            "isNumeric": "false",
            "sameAs": "http://www.opentox.org/api/1.1#IUPACName",
            "isModelPredictionFeature": false,
            "creator": "http://ambit.sourceforge.net",
            "order": 1,
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/enanomapper/dataset/Default",
                "type": "Dataset"
            },
            "annotation": []
        },
        "http://apps.ideaconsult.net:8080/enanomapper/feature/http%3A%2F%2Fwww.opentox.org%2Fapi%2F1.1%23ChemicalNameDefault": {
            "type": "Feature",
            "title": "Names",
            "units": "",
            "isNominal": "false",
            "isNumeric": "false",
            "sameAs": "http://www.opentox.org/api/1.1#ChemicalName",
            "isModelPredictionFeature": false,
            "creator": "http://ambit.sourceforge.net",
            "order": 2,
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/enanomapper/dataset/Default",
                "type": "Dataset"
            },
            "annotation": []
        },
        "http://apps.ideaconsult.net:8080/enanomapper/feature/http%3A%2F%2Fwww.opentox.org%2Fapi%2F1.1%23CASRNDefault": {
            "type": "Feature",
            "title": "CasRN",
            "units": "",
            "isNominal": "false",
            "isNumeric": "false",
            "sameAs": "http://www.opentox.org/api/1.1#CASRN",
            "isModelPredictionFeature": false,
            "creator": "http://ambit.sourceforge.net",
            "order": 3,
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/enanomapper/dataset/Default",
                "type": "Dataset"
            },
            "annotation": []
        },
        "http://apps.ideaconsult.net:8080/enanomapper/feature/http%3A%2F%2Fwww.opentox.org%2Fapi%2F1.1%23EINECSDefault": {
            "type": "Feature",
            "title": "EC number",
            "units": "",
            "isNominal": "false",
            "isNumeric": "false",
            "sameAs": "http://www.opentox.org/api/1.1#EINECS",
            "isModelPredictionFeature": false,
            "creator": "http://ambit.sourceforge.net",
            "order": 4,
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/enanomapper/dataset/Default",
                "type": "Dataset"
            },
            "annotation": []
        },
        "http://apps.ideaconsult.net:8080/enanomapper/feature/http%3A%2F%2Fwww.opentox.org%2Fapi%2F1.1%23TradeNameDefault": {
            "type": "Feature",
            "title": "Trade Name",
            "units": "",
            "isNominal": "false",
            "isNumeric": "false",
            "sameAs": "http://www.opentox.org/api/1.1#TradeName",
            "isModelPredictionFeature": false,
            "creator": "http://ambit.sourceforge.net",
            "order": 5,
            "source": {
                "URI": "http://apps.ideaconsult.net:8080/enanomapper/dataset/Default",
                "type": "Dataset"
            },
            "annotation": []
        }
    }
}
````


  
