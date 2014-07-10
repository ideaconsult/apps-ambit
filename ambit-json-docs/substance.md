##Substance

###Existing chemical [Composition](http://apps.ideaconsult.net:8080/biodeg/substance/IUC4-bd8b36ce-3d42-357d-b968-09144269488a/composition), [Study](http://apps.ideaconsult.net:8080/biodeg/substance/IUC4-bd8b36ce-3d42-357d-b968-09144269488a/study) 

###Nanomaterial [Composition](#composition), [Study](#study), [Summary](#summary), [Substance dataset](substance_dataset.md)

####<a name="study"></a>Study  

[Demo link](http://apps.ideaconsult.net:8080/enanomapper/substance/PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819/study)

````json
{
    "study": [
        {
            "uuid": "PRCR-24769d6c-4e07-3dd0-a699-5f768d6db825",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "P-CHEM",
                "category": {
                    "code": "PC_GRANULOMETRY_SECTION",
                    "title": "4.5 Particle size distribution (Granulometry)"
                },
                "endpoint": "TEM",
                "guideline": [
                    "doi: 10.1021/nn406018q"
                ]
            },
            "parameters": {
                "DATA_GATHERING_INSTRUMENTS": "Tecnai 20 (FEI) microscope;Tecnai 20 (FEI) microscope;AMT 16000 camera",
                "Type of method": "TEM",
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
                    "endpoint": "Core size",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loQualifier": "mean",
                        "loValue": 14.9,
                        "errQualifier": "sd",
                        "errorValue": 1.2
                    }
                },
                {
                    "endpoint": "Density",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "g/cm^3",
                        "loQualifier": "",
                        "loValue": 19.1
                    }
                },
                {
                    "endpoint": "MW",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "g/mol",
                        "loQualifier": "",
                        "loValue": 197
                    }
                },
                {
                    "endpoint": "Mol/NP",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "",
                        "loQualifier": "",
                        "loValue": 0
                    }
                },
                {
                    "endpoint": "SA/NP",
                    "conditions": {
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "cm^2/NP",
                        "loQualifier": "",
                        "loValue": 0
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-2722b894-4eac-3a23-9939-dbfc7c086b31",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "P-CHEM",
                "category": {
                    "code": "SURFACE_CHEMISTRY_SECTION",
                    "title": "4.30 Nanomaterial surface chemistry"
                },
                "endpoint": "",
                "guideline": [
                    ""
                ]
            },
            "parameters": {
                "Type of method": null,
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
                    "endpoint": "FUNCTIONAL GROUP",
                    "conditions": {
                        "COATING_DESCRIPTION": null,
                        "DESCRIPTION": null,
                        "ELEMENT_OR_GROUP": null,
                        "Remark": null,
                        "TYPE": {
                            "loQualifier": "  ",
                            "loValue": "FUNCTIONALIZATION"
                        }
                    },
                    "result": {
                        "unit": null,
                        "textValue": "AC"
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-360c16f6-ecfb-35b2-834c-3d08a668f491",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "P-CHEM",
                "category": {
                    "code": "SURFACE_CHEMISTRY_SECTION",
                    "title": "4.30 Nanomaterial surface chemistry"
                },
                "endpoint": "Description",
                "guideline": [
                    "Description"
                ]
            },
            "parameters": {
                "Type of method": null,
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
                    "endpoint": "ATOMIC COMPOSITION",
                    "conditions": {
                        "COATING_DESCRIPTION": null,
                        "DESCRIPTION": null,
                        "ELEMENT_OR_GROUP": null,
                        "Remark": null,
                        "TYPE": {
                            "loQualifier": "  ",
                            "loValue": "CORE"
                        }
                    },
                    "result": {
                        "unit": null,
                        "textValue": "[Au]"
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-41409144-654c-3aa6-acbd-42b10b0ae738",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "TOX",
                "category": {
                    "code": "UNKNOWN_TOXICITY_SECTION",
                    "title": "7.99 Unclassified toxicity"
                },
                "endpoint": "ICP-AES",
                "guideline": [
                    "doi: 10.1021/nn406018q"
                ]
            },
            "parameters": {
                "DATA_GATHERING_INSTRUMENTS": "Perkin-Elmer",
                "Type of method": "ICP-AES",
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
                    "endpoint": "Net cell association",
                    "conditions": {
                        "Cell": "A549"
                    },
                    "result": {
                        "unit": "mL/ug(Mg)",
                        "loQualifier": "mean",
                        "loValue": 0.02751,
                        "errQualifier": "sd",
                        "errorValue": 0.01654
                    }
                },
                {
                    "endpoint": "Log2 transformed",
                    "conditions": {
                        "Cell": "A549"
                    },
                    "result": {
                        "unit": "",
                        "loQualifier": "mean",
                        "loValue": -5.184,
                        "errQualifier": "std",
                        "errorValue": 0.867
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-5eb139d8-5ea3-3951-afc1-a01c4fc9d6e7",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "TOX",
                "category": {
                    "code": "UNKNOWN_TOXICITY_SECTION",
                    "title": "7.99 Unclassified toxicity"
                },
                "endpoint": "Bicinchoninic Acid (BCA) Assay",
                "guideline": [
                    "doi: 10.1021/nn406018q"
                ]
            },
            "parameters": {
                "Type of method": "Serum.density",
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
                    "endpoint": "Total protein (BCA assay)",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)"
                    },
                    "result": {
                        "unit": "ug",
                        "loQualifier": "mean",
                        "loValue": 2.927,
                        "errQualifier": "sd",
                        "errorValue": 0.465
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-657fef01-5d29-37f8-a4cb-48bfb3ebe449",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "TOX",
                "category": {
                    "code": "PROTEOMICS_SECTION",
                    "title": "7.100 Proteomics"
                },
                "endpoint": "Solution-based digestion protocol for serum protein isolates",
                "guideline": [
                    "doi: 10.1021/nn406018q"
                ]
            },
            "parameters": {
                "DATA_GATHERING_INSTRUMENTS": "Orbitrap-Velos mass spectrometer (Thermo)",
                "Type of method": "LC MS/MS",
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
                    "endpoint": "Spectral counts",
                    "conditions": {},
                    "result": {
                        "unit": null,
                        "textValue": "{\"A2VDJ0\":{\n\t\"loValue\":0\n}\n,\"A6NE01\":{\n\t\"loValue\":0\n}\n,\"A6NL26\":{\n\t\"loValue\":0\n}\n,\"A7E2F4\":{\n\t\"loValue\":0\n}\n,\"A8MTI9\":{\n\t\"loValue\":0\n}\n,\"A8MVM7\":{\n\t\"loValue\":0\n}\n,\"A9YTQ3\":{\n\t\"loValue\":0\n}\n,\"B1ANY3\":{\n\t\"loValue\":0\n}\n,\"B1NKR3\":{\n\t\"loValue\":0\n}\n,\"B2RXH2\":{\n\t\"loValue\":0\n}\n,\"B9A064\":{\n\t\"loValue\":7\n}\n,\"O00148\":{\n\t\"loValue\":0\n}\n,\"O00167\":{\n\t\"loValue\":0\n}\n,\"O00187\":{\n\t\"loValue\":0\n}\n,\"O00391\":{\n\t\"loValue\":0\n}\n,\"O00507\":{\n\t\"loValue\":0\n}\n,\"O00512\":{\n\t\"loValue\":0\n}\n,\"O00555\":{\n\t\"loValue\":0\n}\n,\"O00602\":{\n\t\"loValue\":0\n}\n,\"O14497\":{\n\t\"loValue\":0\n}\n,\"O14523\":{\n\t\"loValue\":0\n}\n,\"O14734\":{\n\t\"loValue\":0\n}\n,\"O14786\":{\n\t\"loValue\":0\n}\n,\"O14791\":{\n\t\"loValue\":3\n}\n,\"O14983\":{\n\t\"loValue\":0\n}\n,\"O15117\":{\n\t\"loValue\":0\n}\n,\"O15213\":{\n\t\"loValue\":0\n}\n,\"O15355\":{\n\t\"loValue\":0\n}\n,\"O15446\":{\n\t\"loValue\":0\n}\n,\"O15503\":{\n\t\"loValue\":0\n}\n,\"O40626\":{\n\t\"loValue\":0\n}\n,\"O43155\":{\n\t\"loValue\":0\n}\n,\"O43194\":{\n\t\"loValue\":0\n}\n,\"O43426\":{\n\t\"loValue\":0\n}\n,\"O43681\":{\n\t\"loValue\":0\n}\n,\"O43866\":{\n\t\"loValue\":0\n}\n,\"O43889\":{\n\t\"loValue\":0\n}\n,\"O60462\":{\n\t\"loValue\":0\n}\n,\"O60518\":{\n\t\"loValue\":0\n}\n,\"O75051\":{\n\t\"loValue\":0\n}\n,\"O75052\":{\n\t\"loValue\":0\n}\n,\"O75309\":{\n\t\"loValue\":0\n}\n,\"O75356\":{\n\t\"loValue\":0\n}\n,\"O75367\":{\n\t\"loValue\":0\n}\n,\"O75427\":{\n\t\"loValue\":0\n}\n,\"O75636\":{\n\t\"loValue\":0\n}\n,\"O75915\":{\n\t\"loValue\":0\n}\n,\"O75943\":{\n\t\"loValue\":0\n}\n,\"O75970\":{\n\t\"loValue\":0\n}\n,\"O75976\":{\n\t\"loValue\":1\n}\n,\"O76036\":{\n\t\"loValue\":0\n}\n,\"O91087\":{\n\t\"loValue\":0\n}\n,\"O91734\":{\n\t\"loValue\":0\n}\n,\"O94812\":{\n\t\"loValue\":0\n}\n,\"O94813\":{\n\t\"loValue\":0\n}\n,\"O94900\":{\n\t\"loValue\":0\n}\n,\"O94985\":{\n\t\"loValue\":0\n}\n,\"O95221\":{\n\t\"loValue\":0\n}\n,\"O95342\":{\n\t\"loValue\":0\n}\n,\"O95445\":{\n\t\"loValue\":0\n}\n,\"O95466\":{\n\t\"loValue\":0\n}\n,\"O95486\":{\n\t\"loValue\":0\n}\n,\"O95810\":{\n\t\"loValue\":0\n}\n,\"O95847\":{\n\t\"loValue\":0\n}\n,\"P00450\":{\n\t\"loValue\":0\n}\n,\"P00451\":{\n\t\"loValue\":0\n}\n,\"P00558\":{\n\t\"loValue\":0\n}\n,\"P00734\":{\n\t\"loValue\":122\n}\n,\"P00736\":{\n\t\"loValue\":23\n}\n,\"P00738\":{\n\t\"loValue\":0\n}\n,\"P00739\":{\n\t\"loValue\":4\n}\n,\"P00740\":{\n\t\"loValue\":0\n}\n,\"P00742\":{\n\t\"loValue\":0\n}\n,\"P00746\":{\n\t\"loValue\":0\n}\n,\"P00747\":{\n\t\"loValue\":1\n}\n,\"P00748\":{\n\t\"loValue\":9\n}\n,\"P00751\":{\n\t\"loValue\":0\n}\n,\"P01008\":{\n\t\"loValue\":221\n}\n,\"P01009\":{\n\t\"loValue\":13\n}\n,\"P01011\":{\n\t\"loValue\":1\n}\n,\"P01019\":{\n\t\"loValue\":0\n}\n,\"P01023\":{\n\t\"loValue\":23\n}\n,\"P01024\":{\n\t\"loValue\":145\n}\n,\"P01031\":{\n\t\"loValue\":0\n}\n,\"P01034\":{\n\t\"loValue\":0\n}\n,\"P01042\":{\n\t\"loValue\":40\n}\n,\"P01266\":{\n\t\"loValue\":0\n}\n,\"P01344\":{\n\t\"loValue\":0\n}\n,\"P01591\":{\n\t\"loValue\":0\n}\n,\"P01593\":{\n\t\"loValue\":0\n}\n,\"P01594\":{\n\t\"loValue\":0\n}\n,\"P01596\":{\n\t\"loValue\":0\n}\n,\"P01597\":{\n\t\"loValue\":0\n}\n,\"P01599\":{\n\t\"loValue\":0\n}\n,\"P01605\":{\n\t\"loValue\":0\n}\n,\"P01610\":{\n\t\"loValue\":0\n}\n,\"P01611\":{\n\t\"loValue\":0\n}\n,\"P01613\":{\n\t\"loValue\":0\n}\n,\"P01614\":{\n\t\"loValue\":0\n}\n,\"P01617\":{\n\t\"loValue\":0\n}\n,\"P01619\":{\n\t\"loValue\":0\n}\n,\"P01620\":{\n\t\"loValue\":3\n}\n,\"P01621\":{\n\t\"loValue\":0\n}\n,\"P01625\":{\n\t\"loValue\":0\n}\n,\"P01700\":{\n\t\"loValue\":0\n}\n,\"P01714\":{\n\t\"loValue\":1\n}\n,\"P01717\":{\n\t\"loValue\":1\n}\n,\"P01743\":{\n\t\"loValue\":0\n}\n,\"P01763\":{\n\t\"loValue\":0\n}\n,\"P01764\":{\n\t\"loValue\":2\n}\n,\"P01765\":{\n\t\"loValue\":1\n}\n,\"P01766\":{\n\t\"loValue\":1\n}\n,\"P01771\":{\n\t\"loValue\":0\n}\n,\"P01780\":{\n\t\"loValue\":0\n}\n,\"P01781\":{\n\t\"loValue\":0\n}\n,\"P01825\":{\n\t\"loValue\":0\n}\n,\"P01833\":{\n\t\"loValue\":0\n}\n,\"P01834\":{\n\t\"loValue\":23\n}\n,\"P01857\":{\n\t\"loValue\":29\n}\n,\"P01859\":{\n\t\"loValue\":7\n}\n,\"P01860\":{\n\t\"loValue\":10\n}\n,\"P01861\":{\n\t\"loValue\":1\n}\n,\"P01871\":{\n\t\"loValue\":33\n}\n,\"P01876\":{\n\t\"loValue\":16\n}\n,\"P01877\":{\n\t\"loValue\":2\n}\n,\"P01880\":{\n\t\"loValue\":0\n}\n,\"P02042\":{\n\t\"loValue\":0\n}\n,\"P02452\":{\n\t\"loValue\":0\n}\n,\"P02647\":{\n\t\"loValue\":9\n}\n,\"P02649\":{\n\t\"loValue\":169\n}\n,\"P02652\":{\n\t\"loValue\":6\n}\n,\"P02654\":{\n\t\"loValue\":0\n}\n,\"P02655\":{\n\t\"loValue\":0\n}\n,\"P02656\":{\n\t\"loValue\":0\n}\n,\"P02671\":{\n\t\"loValue\":0\n}\n,\"P02708\":{\n\t\"loValue\":0\n}\n,\"P02735\":{\n\t\"loValue\":0\n}\n,\"P02741\":{\n\t\"loValue\":0\n}\n,\"P02743\":{\n\t\"loValue\":62\n}\n,\"P02745\":{\n\t\"loValue\":6\n}\n,\"P02746\":{\n\t\"loValue\":16\n}\n,\"P02747\":{\n\t\"loValue\":16\n}\n,\"P02748\":{\n\t\"loValue\":11\n}\n,\"P02749\":{\n\t\"loValue\":0\n}\n,\"P02750\":{\n\t\"loValue\":0\n}\n,\"P02751\":{\n\t\"loValue\":44\n}\n,\"P02760\":{\n\t\"loValue\":0\n}\n,\"P02763\":{\n\t\"loValue\":0\n}\n,\"P02765\":{\n\t\"loValue\":0\n}\n,\"P02766\":{\n\t\"loValue\":4\n}\n,\"P02774\":{\n\t\"loValue\":0\n}\n,\"P02775\":{\n\t\"loValue\":0\n}\n,\"P02776\":{\n\t\"loValue\":0\n}\n,\"P02786\":{\n\t\"loValue\":0\n}\n,\"P02787\":{\n\t\"loValue\":0\n}\n,\"P02788\":{\n\t\"loValue\":21\n}\n,\"P02790\":{\n\t\"loValue\":0\n}\n,\"P03303\":{\n\t\"loValue\":0\n}\n,\"P03362\":{\n\t\"loValue\":0\n}\n,\"P03950\":{\n\t\"loValue\":5\n}\n,\"P03951\":{\n\t\"loValue\":27\n}\n,\"P03952\":{\n\t\"loValue\":0\n}\n,\"P04003\":{\n\t\"loValue\":63\n}\n,\"P04004\":{\n\t\"loValue\":66\n}\n,\"P04070\":{\n\t\"loValue\":0\n}\n,\"P04075\":{\n\t\"loValue\":0\n}\n,\"P04083\":{\n\t\"loValue\":0\n}\n,\"P04114\":{\n\t\"loValue\":157\n}\n,\"P04180\":{\n\t\"loValue\":0\n}\n,\"P04196\":{\n\t\"loValue\":87\n}\n,\"P04206\":{\n\t\"loValue\":0\n}\n,\"P04217\":{\n\t\"loValue\":0\n}\n,\"P04220\":{\n\t\"loValue\":1\n}\n,\"P04275\":{\n\t\"loValue\":0\n}\n,\"P04279\":{\n\t\"loValue\":0\n}\n,\"P04406\":{\n\t\"loValue\":3\n}\n,\"P04433\":{\n\t\"loValue\":0\n}\n,\"P04434\":{\n\t\"loValue\":0\n}\n,\"P04632\":{\n\t\"loValue\":0\n}\n,\"P04792\":{\n\t\"loValue\":0\n}\n,\"P04899\":{\n\t\"loValue\":0\n}\n,\"P04908\":{\n\t\"loValue\":0\n}\n,\"P05019\":{\n\t\"loValue\":0\n}\n,\"P05062\":{\n\t\"loValue\":0\n}\n,\"P05067\":{\n\t\"loValue\":0\n}\n,\"P05090\":{\n\t\"loValue\":1\n}\n,\"P05106\":{\n\t\"loValue\":0\n}\n,\"P05109\":{\n\t\"loValue\":0\n}\n,\"P05154\":{\n\t\"loValue\":21\n}\n,\"P05155\":{\n\t\"loValue\":8\n}\n,\"P05156\":{\n\t\"loValue\":0\n}\n,\"P05452\":{\n\t\"loValue\":0\n}\n,\"P05546\":{\n\t\"loValue\":15\n}\n,\"P05667\":{\n\t\"loValue\":0\n}\n,\"P06239\":{\n\t\"loValue\":0\n}\n,\"P06276\":{\n\t\"loValue\":0\n}\n,\"P06280\":{\n\t\"loValue\":0\n}\n,\"P06311\":{\n\t\"loValue\":0\n}\n,\"P06396\":{\n\t\"loValue\":13\n}\n,\"P06421\":{\n\t\"loValue\":0\n}\n,\"P06435\":{\n\t\"loValue\":0\n}\n,\"P06681\":{\n\t\"loValue\":0\n}\n,\"P06702\":{\n\t\"loValue\":0\n}\n,\"P06727\":{\n\t\"loValue\":0\n}\n,\"P06732\":{\n\t\"loValue\":0\n}\n,\"P06733\":{\n\t\"loValue\":0\n}\n,\"P06744\":{\n\t\"loValue\":0\n}\n,\"P07195\":{\n\t\"loValue\":0\n}\n,\"P07225\":{\n\t\"loValue\":6\n}\n,\"P07332\":{\n\t\"loValue\":0\n}\n,\"P07355\":{\n\t\"loValue\":0\n}\n,\"P07357\":{\n\t\"loValue\":0\n}\n,\"P07358\":{\n\t\"loValue\":0\n}\n,\"P07360\":{\n\t\"loValue\":0\n}\n,\"P07384\":{\n\t\"loValue\":0\n}\n,\"P07737\":{\n\t\"loValue\":0\n}\n,\"P07900\":{\n\t\"loValue\":0\n}\n,\"P07996\":{\n\t\"loValue\":76\n}\n,\"P08123\":{\n\t\"loValue\":0\n}\n,\"P08185\":{\n\t\"loValue\":0\n}\n,\"P08238\":{\n\t\"loValue\":0\n}\n,\"P08294\":{\n\t\"loValue\":0\n}\n,\"P08393\":{\n\t\"loValue\":0\n}\n,\"P08514\":{\n\t\"loValue\":0\n}\n,\"P08519\":{\n\t\"loValue\":0\n}\n,\"P08567\":{\n\t\"loValue\":0\n}\n,\"P08575\":{\n\t\"loValue\":0\n}\n,\"P08603\":{\n\t\"loValue\":43\n}\n,\"P08697\":{\n\t\"loValue\":2\n}\n,\"P08709\":{\n\t\"loValue\":0\n}\n,\"P08922\":{\n\t\"loValue\":0\n}\n,\"P09211\":{\n\t\"loValue\":0\n}\n,\"P09493\":{\n\t\"loValue\":0\n}\n,\"P09603\":{\n\t\"loValue\":0\n}\n,\"P09871\":{\n\t\"loValue\":20\n}\n,\"P0C0L4\":{\n\t\"loValue\":54\n}\n,\"P0C0L5\":{\n\t\"loValue\":3\n}\n,\"P0C6X2\":{\n\t\"loValue\":0\n}\n,\"P0C6X3\":{\n\t\"loValue\":0\n}\n,\"P0C6X5\":{\n\t\"loValue\":0\n}\n,\"P0C6X6\":{\n\t\"loValue\":0\n}\n,\"P0C7N1\":{\n\t\"loValue\":0\n}\n,\"P0C7U2\":{\n\t\"loValue\":0\n}\n,\"P0C7U3\":{\n\t\"loValue\":0\n}\n,\"P0C881\":{\n\t\"loValue\":0\n}\n,\"P0CG05\":{\n\t\"loValue\":14\n}\n,\"P10071\":{\n\t\"loValue\":0\n}\n,\"P10211\":{\n\t\"loValue\":0\n}\n,\"P10242\":{\n\t\"loValue\":0\n}\n,\"P10451\":{\n\t\"loValue\":0\n}\n,\"P10599\":{\n\t\"loValue\":0\n}\n,\"P10643\":{\n\t\"loValue\":0\n}\n,\"P10646\":{\n\t\"loValue\":4\n}\n,\"P10720\":{\n\t\"loValue\":3\n}\n,\"P10745\":{\n\t\"loValue\":0\n}\n,\"P10909\":{\n\t\"loValue\":25\n}\n,\"P11274\":{\n\t\"loValue\":0\n}\n,\"P11532\":{\n\t\"loValue\":0\n}\n,\"P11597\":{\n\t\"loValue\":0\n}\n,\"P12259\":{\n\t\"loValue\":8\n}\n,\"P12273\":{\n\t\"loValue\":0\n}\n,\"P12314\":{\n\t\"loValue\":0\n}\n,\"P12814\":{\n\t\"loValue\":0\n}\n,\"P12830\":{\n\t\"loValue\":0\n}\n,\"P13533\":{\n\t\"loValue\":0\n}\n,\"P13591\":{\n\t\"loValue\":0\n}\n,\"P13667\":{\n\t\"loValue\":0\n}\n,\"P13671\":{\n\t\"loValue\":0\n}\n,\"P13929\":{\n\t\"loValue\":0\n}\n,\"P14136\":{\n\t\"loValue\":0\n}\n,\"P14314\":{\n\t\"loValue\":0\n}\n,\"P14543\":{\n\t\"loValue\":0\n}\n,\"P14618\":{\n\t\"loValue\":6\n}\n,\"P14625\":{\n\t\"loValue\":0\n}\n,\"P14923\":{\n\t\"loValue\":0\n}\n,\"P15169\":{\n\t\"loValue\":1\n}\n,\"P15311\":{\n\t\"loValue\":0\n}\n,\"P15884\":{\n\t\"loValue\":0\n}\n,\"P15924\":{\n\t\"loValue\":0\n}\n,\"P16070\":{\n\t\"loValue\":0\n}\n,\"P16112\":{\n\t\"loValue\":0\n}\n,\"P16827\":{\n\t\"loValue\":0\n}\n,\"P17275\":{\n\t\"loValue\":0\n}\n,\"P17927\":{\n\t\"loValue\":0\n}\n,\"P17936\":{\n\t\"loValue\":0\n}\n,\"P18065\":{\n\t\"loValue\":0\n}\n,\"P18206\":{\n\t\"loValue\":0\n}\n,\"P18428\":{\n\t\"loValue\":0\n}\n,\"P18827\":{\n\t\"loValue\":0\n}\n,\"P19652\":{\n\t\"loValue\":0\n}\n,\"P19823\":{\n\t\"loValue\":18\n}\n,\"P19827\":{\n\t\"loValue\":7\n}\n,\"P20160\":{\n\t\"loValue\":0\n}\n,\"P20591\":{\n\t\"loValue\":0\n}\n,\"P20851\":{\n\t\"loValue\":3\n}\n,\"P21333\":{\n\t\"loValue\":12\n}\n,\"P21810\":{\n\t\"loValue\":0\n}\n,\"P22102\":{\n\t\"loValue\":0\n}\n,\"P22105\":{\n\t\"loValue\":1\n}\n,\"P22303\":{\n\t\"loValue\":0\n}\n,\"P22352\":{\n\t\"loValue\":0\n}\n,\"P22607\":{\n\t\"loValue\":0\n}\n,\"P22614\":{\n\t\"loValue\":0\n}\n,\"P22692\":{\n\t\"loValue\":0\n}\n,\"P22891\":{\n\t\"loValue\":0\n}\n,\"P23528\":{\n\t\"loValue\":0\n}\n,\"P24437\":{\n\t\"loValue\":0\n}\n,\"P24592\":{\n\t\"loValue\":0\n}\n,\"P24593\":{\n\t\"loValue\":0\n}\n,\"P24855\":{\n\t\"loValue\":0\n}\n,\"P24928\":{\n\t\"loValue\":0\n}\n,\"P25311\":{\n\t\"loValue\":0\n}\n,\"P25685\":{\n\t\"loValue\":0\n}\n,\"P26038\":{\n\t\"loValue\":0\n}\n,\"P26927\":{\n\t\"loValue\":0\n}\n,\"P27105\":{\n\t\"loValue\":0\n}\n,\"P27169\":{\n\t\"loValue\":0\n}\n,\"P27482\":{\n\t\"loValue\":0\n}\n,\"P27708\":{\n\t\"loValue\":0\n}\n,\"P27797\":{\n\t\"loValue\":0\n}\n,\"P27816\":{\n\t\"loValue\":0\n}\n,\"P27918\":{\n\t\"loValue\":4\n}\n,\"P28325\":{\n\t\"loValue\":0\n}\n,\"P28566\":{\n\t\"loValue\":0\n}\n,\"P29083\":{\n\t\"loValue\":0\n}\n,\"P29317\":{\n\t\"loValue\":0\n}\n,\"P29401\":{\n\t\"loValue\":0\n}\n,\"P29508\":{\n\t\"loValue\":0\n}\n,\"P29622\":{\n\t\"loValue\":0\n}\n,\"P30101\":{\n\t\"loValue\":0\n}\n,\"P30304\":{\n\t\"loValue\":0\n}\n,\"P30519\":{\n\t\"loValue\":0\n}\n,\"P30530\":{\n\t\"loValue\":0\n}\n,\"P31025\":{\n\t\"loValue\":0\n}\n,\"P31151\":{\n\t\"loValue\":0\n}\n,\"P31942\":{\n\t\"loValue\":0\n}\n,\"P33764\":{\n\t\"loValue\":0\n}\n,\"P33778\":{\n\t\"loValue\":0\n}\n,\"P33811\":{\n\t\"loValue\":0\n}\n,\"P33818\":{\n\t\"loValue\":0\n}\n,\"P34096\":{\n\t\"loValue\":0\n}\n,\"P35247\":{\n\t\"loValue\":0\n}\n,\"P35443\":{\n\t\"loValue\":0\n}\n,\"P35475\":{\n\t\"loValue\":0\n}\n,\"P35542\":{\n\t\"loValue\":0\n}\n,\"P35555\":{\n\t\"loValue\":0\n}\n,\"P35579\":{\n\t\"loValue\":10\n}\n,\"P35580\":{\n\t\"loValue\":0\n}\n,\"P35749\":{\n\t\"loValue\":0\n}\n,\"P35858\":{\n\t\"loValue\":0\n}\n,\"P35959\":{\n\t\"loValue\":0\n}\n,\"P36896\":{\n\t\"loValue\":0\n}\n,\"P36955\":{\n\t\"loValue\":0\n}\n,\"P36980\":{\n\t\"loValue\":0\n}\n,\"P39060\":{\n\t\"loValue\":0\n}\n,\"P40763\":{\n\t\"loValue\":0\n}\n,\"P41002\":{\n\t\"loValue\":0\n}\n,\"P41968\":{\n\t\"loValue\":0\n}\n,\"P42694\":{\n\t\"loValue\":0\n}\n,\"P43652\":{\n\t\"loValue\":0\n}\n,\"P46939\":{\n\t\"loValue\":0\n}\n,\"P47929\":{\n\t\"loValue\":0\n}\n,\"P48059\":{\n\t\"loValue\":0\n}\n,\"P48200\":{\n\t\"loValue\":0\n}\n,\"P48380\":{\n\t\"loValue\":0\n}\n,\"P48426\":{\n\t\"loValue\":2\n}\n,\"P48594\":{\n\t\"loValue\":0\n}\n,\"P48740\":{\n\t\"loValue\":0\n}\n,\"P49146\":{\n\t\"loValue\":0\n}\n,\"P49746\":{\n\t\"loValue\":0\n}\n,\"P49747\":{\n\t\"loValue\":1\n}\n,\"P49750\":{\n\t\"loValue\":0\n}\n,\"P49789\":{\n\t\"loValue\":0\n}\n,\"P49908\":{\n\t\"loValue\":6\n}\n,\"P49913\":{\n\t\"loValue\":0\n}\n,\"P51795\":{\n\t\"loValue\":0\n}\n,\"P51884\":{\n\t\"loValue\":0\n}\n,\"P52452\":{\n\t\"loValue\":0\n}\n,\"P52468\":{\n\t\"loValue\":0\n}\n,\"P53609\":{\n\t\"loValue\":0\n}\n,\"P53677\":{\n\t\"loValue\":0\n}\n,\"P55056\":{\n\t\"loValue\":0\n}\n,\"P55058\":{\n\t\"loValue\":0\n}\n,\"P55081\":{\n\t\"loValue\":0\n}\n,\"P55103\":{\n\t\"loValue\":0\n}\n,\"P55209\":{\n\t\"loValue\":0\n}\n,\"P55774\":{\n\t\"loValue\":0\n}\n,\"P56597\":{\n\t\"loValue\":0\n}\n,\"P56856\":{\n\t\"loValue\":0\n}\n,\"P59533\":{\n\t\"loValue\":0\n}\n,\"P59665\":{\n\t\"loValue\":0\n}\n,\"P61221\":{\n\t\"loValue\":0\n}\n,\"P61224\":{\n\t\"loValue\":0\n}\n,\"P61570\":{\n\t\"loValue\":0\n}\n,\"P61586\":{\n\t\"loValue\":0\n}\n,\"P61626\":{\n\t\"loValue\":0\n}\n,\"P61769\":{\n\t\"loValue\":0\n}\n,\"P62158\":{\n\t\"loValue\":0\n}\n,\"P62805\":{\n\t\"loValue\":0\n}\n,\"P62834\":{\n\t\"loValue\":0\n}\n,\"P62937\":{\n\t\"loValue\":0\n}\n,\"P62987\":{\n\t\"loValue\":0\n}\n,\"P63104\":{\n\t\"loValue\":0\n}\n,\"P63241\":{\n\t\"loValue\":0\n}\n,\"P67809\":{\n\t\"loValue\":0\n}\n,\"P67936\":{\n\t\"loValue\":0\n}\n,\"P68104\":{\n\t\"loValue\":0\n}\n,\"P68363\":{\n\t\"loValue\":0\n}\n,\"P68366\":{\n\t\"loValue\":0\n}\n,\"P68871\":{\n\t\"loValue\":0\n}\n,\"P69905\":{\n\t\"loValue\":0\n}\n,\"P78344\":{\n\t\"loValue\":0\n}\n,\"P80748\":{\n\t\"loValue\":0\n}\n,\"P81605\":{\n\t\"loValue\":0\n}\n,\"P84077\":{\n\t\"loValue\":0\n}\n,\"P98088\":{\n\t\"loValue\":0\n}\n,\"P98160\":{\n\t\"loValue\":0\n}\n,\"Q00169\":{\n\t\"loValue\":0\n}\n,\"Q02413\":{\n\t\"loValue\":0\n}\n,\"Q02817\":{\n\t\"loValue\":0\n}\n,\"Q02846\":{\n\t\"loValue\":0\n}\n,\"Q03591\":{\n\t\"loValue\":4\n}\n,\"Q04637\":{\n\t\"loValue\":0\n}\n,\"Q04724\":{\n\t\"loValue\":0\n}\n,\"Q04756\":{\n\t\"loValue\":0\n}\n,\"Q06033\":{\n\t\"loValue\":0\n}\n,\"Q07507\":{\n\t\"loValue\":0\n}\n,\"Q07954\":{\n\t\"loValue\":0\n}\n,\"Q08380\":{\n\t\"loValue\":0\n}\n,\"Q09472\":{\n\t\"loValue\":0\n}\n,\"Q0IIM8\":{\n\t\"loValue\":0\n}\n,\"Q0P6H9\":{\n\t\"loValue\":0\n}\n,\"Q12778\":{\n\t\"loValue\":0\n}\n,\"Q12794\":{\n\t\"loValue\":0\n}\n,\"Q12816\":{\n\t\"loValue\":0\n}\n,\"Q12852\":{\n\t\"loValue\":0\n}\n,\"Q12864\":{\n\t\"loValue\":0\n}\n,\"Q12955\":{\n\t\"loValue\":0\n}\n,\"Q13093\":{\n\t\"loValue\":0\n}\n,\"Q13103\":{\n\t\"loValue\":5\n}\n,\"Q13217\":{\n\t\"loValue\":0\n}\n,\"Q13277\":{\n\t\"loValue\":0\n}\n,\"Q13310\":{\n\t\"loValue\":0\n}\n,\"Q13418\":{\n\t\"loValue\":0\n}\n,\"Q13426\":{\n\t\"loValue\":0\n}\n,\"Q13546\":{\n\t\"loValue\":0\n}\n,\"Q13576\":{\n\t\"loValue\":0\n}\n,\"Q13642\":{\n\t\"loValue\":0\n}\n,\"Q13790\":{\n\t\"loValue\":0\n}\n,\"Q13797\":{\n\t\"loValue\":0\n}\n,\"Q13868\":{\n\t\"loValue\":0\n}\n,\"Q13885\":{\n\t\"loValue\":0\n}\n,\"Q13952\":{\n\t\"loValue\":0\n}\n,\"Q13972\":{\n\t\"loValue\":0\n}\n,\"Q14003\":{\n\t\"loValue\":0\n}\n,\"Q14050\":{\n\t\"loValue\":0\n}\n,\"Q14151\":{\n\t\"loValue\":0\n}\n,\"Q14157\":{\n\t\"loValue\":0\n}\n,\"Q14168\":{\n\t\"loValue\":0\n}\n,\"Q14185\":{\n\t\"loValue\":0\n}\n,\"Q14247\":{\n\t\"loValue\":0\n}\n,\"Q14393\":{\n\t\"loValue\":0\n}\n,\"Q14515\":{\n\t\"loValue\":0\n}\n,\"Q14520\":{\n\t\"loValue\":0\n}\n,\"Q14624\":{\n\t\"loValue\":5\n}\n,\"Q14656\":{\n\t\"loValue\":0\n}\n,\"Q14689\":{\n\t\"loValue\":0\n}\n,\"Q14766\":{\n\t\"loValue\":0\n}\n,\"Q147U4\":{\n\t\"loValue\":0\n}\n,\"Q14973\":{\n\t\"loValue\":0\n}\n,\"Q14CM0\":{\n\t\"loValue\":0\n}\n,\"Q14D04\":{\n\t\"loValue\":0\n}\n,\"Q14EA6\":{\n\t\"loValue\":0\n}\n,\"Q15113\":{\n\t\"loValue\":0\n}\n,\"Q15166\":{\n\t\"loValue\":0\n}\n,\"Q15303\":{\n\t\"loValue\":0\n}\n,\"Q15468\":{\n\t\"loValue\":0\n}\n,\"Q15485\":{\n\t\"loValue\":0\n}\n,\"Q15555\":{\n\t\"loValue\":0\n}\n,\"Q15617\":{\n\t\"loValue\":0\n}\n,\"Q15751\":{\n\t\"loValue\":0\n}\n,\"Q15758\":{\n\t\"loValue\":0\n}\n,\"Q15777\":{\n\t\"loValue\":0\n}\n,\"Q15836\":{\n\t\"loValue\":0\n}\n,\"Q16348\":{\n\t\"loValue\":0\n}\n,\"Q16520\":{\n\t\"loValue\":0\n}\n,\"Q16665\":{\n\t\"loValue\":0\n}\n,\"Q16696\":{\n\t\"loValue\":0\n}\n,\"Q16849\":{\n\t\"loValue\":0\n}\n,\"Q1HVB8\":{\n\t\"loValue\":0\n}\n,\"Q1HVF2\":{\n\t\"loValue\":0\n}\n,\"Q29RF7\":{\n\t\"loValue\":0\n}\n,\"Q2KHT3\":{\n\t\"loValue\":0\n}\n,\"Q2LD37\":{\n\t\"loValue\":0\n}\n,\"Q2TAK8\":{\n\t\"loValue\":0\n}\n,\"Q2VWP7\":{\n\t\"loValue\":0\n}\n,\"Q2WGJ6\":{\n\t\"loValue\":0\n}\n,\"Q2Y0W8\":{\n\t\"loValue\":0\n}\n,\"Q30201\":{\n\t\"loValue\":0\n}\n,\"Q32P41\":{\n\t\"loValue\":0\n}\n,\"Q3LXA3\":{\n\t\"loValue\":0\n}\n,\"Q49A17\":{\n\t\"loValue\":0\n}\n,\"Q49A26\":{\n\t\"loValue\":0\n}\n,\"Q4G0Z9\":{\n\t\"loValue\":0\n}\n,\"Q4JDL3\":{\n\t\"loValue\":0\n}\n,\"Q4W5G0\":{\n\t\"loValue\":0\n}\n,\"Q58FF7\":{\n\t\"loValue\":0\n}\n,\"Q58FG0\":{\n\t\"loValue\":0\n}\n,\"Q58FG1\":{\n\t\"loValue\":0\n}\n,\"Q5BVD1\":{\n\t\"loValue\":0\n}\n,\"Q5D862\":{\n\t\"loValue\":0\n}\n,\"Q5HYC2\":{\n\t\"loValue\":0\n}\n,\"Q5JY77\":{\n\t\"loValue\":0\n}\n,\"Q5JZY3\":{\n\t\"loValue\":0\n}\n,\"Q5SY16\":{\n\t\"loValue\":0\n}\n,\"Q5T4S7\":{\n\t\"loValue\":0\n}\n,\"Q5TB80\":{\n\t\"loValue\":0\n}\n,\"Q5TH69\":{\n\t\"loValue\":0\n}\n,\"Q5VST9\":{\n\t\"loValue\":0\n}\n,\"Q5VTR2\":{\n\t\"loValue\":0\n}\n,\"Q5VWG9\":{\n\t\"loValue\":0\n}\n,\"Q5XUX0\":{\n\t\"loValue\":0\n}\n,\"Q676U5\":{\n\t\"loValue\":0\n}\n,\"Q68CQ1\":{\n\t\"loValue\":0\n}\n,\"Q6F5E8\":{\n\t\"loValue\":0\n}\n,\"Q6FI13\":{\n\t\"loValue\":0\n}\n,\"Q6IEV9\":{\n\t\"loValue\":0\n}\n,\"Q6IQ26\":{\n\t\"loValue\":0\n}\n,\"Q6KC79\":{\n\t\"loValue\":0\n}\n,\"Q6P1K1\":{\n\t\"loValue\":0\n}\n,\"Q6P656\":{\n\t\"loValue\":0\n}\n,\"Q6PJT7\":{\n\t\"loValue\":0\n}\n,\"Q6PKG0\":{\n\t\"loValue\":0\n}\n,\"Q6Q0C0\":{\n\t\"loValue\":0\n}\n,\"Q6Q788\":{\n\t\"loValue\":0\n}\n,\"Q6SPF0\":{\n\t\"loValue\":0\n}\n,\"Q6UW60\":{\n\t\"loValue\":0\n}\n,\"Q6UWB1\":{\n\t\"loValue\":0\n}\n,\"Q6UWD8\":{\n\t\"loValue\":0\n}\n,\"Q6UX06\":{\n\t\"loValue\":0\n}\n,\"Q6UXG2\":{\n\t\"loValue\":0\n}\n,\"Q6ZMV8\":{\n\t\"loValue\":0\n}\n,\"Q6ZN28\":{\n\t\"loValue\":0\n}\n,\"Q6ZWH5\":{\n\t\"loValue\":0\n}\n,\"Q709F0\":{\n\t\"loValue\":0\n}\n,\"Q71F56\":{\n\t\"loValue\":0\n}\n,\"Q71SY5\":{\n\t\"loValue\":1\n}\n,\"Q71U36\":{\n\t\"loValue\":0\n}\n,\"Q76632\":{\n\t\"loValue\":0\n}\n,\"Q76633\":{\n\t\"loValue\":0\n}\n,\"Q7KYR7\":{\n\t\"loValue\":0\n}\n,\"Q7Z2D5\":{\n\t\"loValue\":0\n}\n,\"Q7Z3B3\":{\n\t\"loValue\":0\n}\n,\"Q7Z407\":{\n\t\"loValue\":0\n}\n,\"Q7Z478\":{\n\t\"loValue\":0\n}\n,\"Q7Z601\":{\n\t\"loValue\":0\n}\n,\"Q7Z7G0\":{\n\t\"loValue\":0\n}\n,\"Q86T90\":{\n\t\"loValue\":0\n}\n,\"Q86TB9\":{\n\t\"loValue\":0\n}\n,\"Q86UC2\":{\n\t\"loValue\":0\n}\n,\"Q86UK0\":{\n\t\"loValue\":0\n}\n,\"Q86UX6\":{\n\t\"loValue\":0\n}\n,\"Q86UX7\":{\n\t\"loValue\":3\n}\n,\"Q86VI4\":{\n\t\"loValue\":0\n}\n,\"Q86WS5\":{\n\t\"loValue\":1\n}\n,\"Q86YC2\":{\n\t\"loValue\":0\n}\n,\"Q86YT5\":{\n\t\"loValue\":0\n}\n,\"Q8IU80\":{\n\t\"loValue\":0\n}\n,\"Q8IV31\":{\n\t\"loValue\":0\n}\n,\"Q8IV77\":{\n\t\"loValue\":0\n}\n,\"Q8IWV2\":{\n\t\"loValue\":0\n}\n,\"Q8IZF2\":{\n\t\"loValue\":0\n}\n,\"Q8IZP9\":{\n\t\"loValue\":0\n}\n,\"Q8IZS8\":{\n\t\"loValue\":0\n}\n,\"Q8N130\":{\n\t\"loValue\":0\n}\n,\"Q8N149\":{\n\t\"loValue\":0\n}\n,\"Q8N2G6\":{\n\t\"loValue\":0\n}\n,\"Q8N3C7\":{\n\t\"loValue\":0\n}\n,\"Q8N5Q1\":{\n\t\"loValue\":0\n}\n,\"Q8N5V2\":{\n\t\"loValue\":0\n}\n,\"Q8N693\":{\n\t\"loValue\":0\n}\n,\"Q8N697\":{\n\t\"loValue\":0\n}\n,\"Q8N8R5\":{\n\t\"loValue\":0\n}\n,\"Q8N961\":{\n\t\"loValue\":0\n}\n,\"Q8NB12\":{\n\t\"loValue\":0\n}\n,\"Q8NBC4\":{\n\t\"loValue\":0\n}\n,\"Q8NBP7\":{\n\t\"loValue\":0\n}\n,\"Q8NBU5\":{\n\t\"loValue\":0\n}\n,\"Q8NCW6\":{\n\t\"loValue\":0\n}\n,\"Q8ND61\":{\n\t\"loValue\":0\n}\n,\"Q8NET4\":{\n\t\"loValue\":0\n}\n,\"Q8NEZ4\":{\n\t\"loValue\":0\n}\n,\"Q8NFD5\":{\n\t\"loValue\":0\n}\n,\"Q8NFQ6\":{\n\t\"loValue\":0\n}\n,\"Q8NG66\":{\n\t\"loValue\":0\n}\n,\"Q8NGJ4\":{\n\t\"loValue\":0\n}\n,\"Q8NGL0\":{\n\t\"loValue\":0\n}\n,\"Q8NGY3\":{\n\t\"loValue\":0\n}\n,\"Q8NHA8\":{\n\t\"loValue\":0\n}\n,\"Q8TAQ9\":{\n\t\"loValue\":0\n}\n,\"Q8TB68\":{\n\t\"loValue\":0\n}\n,\"Q8TBZ2\":{\n\t\"loValue\":0\n}\n,\"Q8TCV5\":{\n\t\"loValue\":0\n}\n,\"Q8TD33\":{\n\t\"loValue\":0\n}\n,\"Q8TD86\":{\n\t\"loValue\":1\n}\n,\"Q8TDQ7\":{\n\t\"loValue\":0\n}\n,\"Q8TE04\":{\n\t\"loValue\":0\n}\n,\"Q8TE76\":{\n\t\"loValue\":0\n}\n,\"Q8TEA8\":{\n\t\"loValue\":1\n}\n,\"Q8TEW8\":{\n\t\"loValue\":0\n}\n,\"Q8TF62\":{\n\t\"loValue\":0\n}\n,\"Q8TF66\":{\n\t\"loValue\":0\n}\n,\"Q8WVP7\":{\n\t\"loValue\":0\n}\n,\"Q8WW52\":{\n\t\"loValue\":0\n}\n,\"Q8WXG9\":{\n\t\"loValue\":0\n}\n,\"Q8WXH0\":{\n\t\"loValue\":0\n}\n,\"Q8WXI7\":{\n\t\"loValue\":0\n}\n,\"Q8WXK4\":{\n\t\"loValue\":0\n}\n,\"Q8WZ42\":{\n\t\"loValue\":0\n}\n,\"Q90038\":{\n\t\"loValue\":0\n}\n,\"Q914N2\":{\n\t\"loValue\":0\n}\n,\"Q92545\":{\n\t\"loValue\":0\n}\n,\"Q92630\":{\n\t\"loValue\":0\n}\n,\"Q92643\":{\n\t\"loValue\":0\n}\n,\"Q92673\":{\n\t\"loValue\":0\n}\n,\"Q92698\":{\n\t\"loValue\":0\n}\n,\"Q92736\":{\n\t\"loValue\":0\n}\n,\"Q92747\":{\n\t\"loValue\":0\n}\n,\"Q92793\":{\n\t\"loValue\":0\n}\n,\"Q92797\":{\n\t\"loValue\":0\n}\n,\"Q92925\":{\n\t\"loValue\":0\n}\n,\"Q92954\":{\n\t\"loValue\":46\n}\n,\"Q96AQ1\":{\n\t\"loValue\":0\n}\n,\"Q96AY4\":{\n\t\"loValue\":0\n}\n,\"Q96B21\":{\n\t\"loValue\":0\n}\n,\"Q96C24\":{\n\t\"loValue\":0\n}\n,\"Q96C45\":{\n\t\"loValue\":0\n}\n,\"Q96DA0\":{\n\t\"loValue\":0\n}\n,\"Q96DD0\":{\n\t\"loValue\":0\n}\n,\"Q96DN6\":{\n\t\"loValue\":0\n}\n,\"Q96EN8\":{\n\t\"loValue\":0\n}\n,\"Q96FV0\":{\n\t\"loValue\":0\n}\n,\"Q96IY4\":{\n\t\"loValue\":5\n}\n,\"Q96JK2\":{\n\t\"loValue\":0\n}\n,\"Q96JQ0\":{\n\t\"loValue\":0\n}\n,\"Q96KG9\":{\n\t\"loValue\":0\n}\n,\"Q96KN2\":{\n\t\"loValue\":0\n}\n,\"Q96LR5\":{\n\t\"loValue\":0\n}\n,\"Q96NH3\":{\n\t\"loValue\":0\n}\n,\"Q96NZ9\":{\n\t\"loValue\":0\n}\n,\"Q96P11\":{\n\t\"loValue\":0\n}\n,\"Q96PD5\":{\n\t\"loValue\":0\n}\n,\"Q96PJ5\":{\n\t\"loValue\":0\n}\n,\"Q96R28\":{\n\t\"loValue\":0\n}\n,\"Q96RG2\":{\n\t\"loValue\":0\n}\n,\"Q96RL6\":{\n\t\"loValue\":0\n}\n,\"Q96RL7\":{\n\t\"loValue\":0\n}\n,\"Q96RT8\":{\n\t\"loValue\":0\n}\n,\"Q96RV3\":{\n\t\"loValue\":0\n}\n,\"Q96SN8\":{\n\t\"loValue\":0\n}\n,\"Q99467\":{\n\t\"loValue\":0\n}\n,\"Q99592\":{\n\t\"loValue\":0\n}\n,\"Q99661\":{\n\t\"loValue\":0\n}\n,\"Q99676\":{\n\t\"loValue\":0\n}\n,\"Q99698\":{\n\t\"loValue\":0\n}\n,\"Q99715\":{\n\t\"loValue\":0\n}\n,\"Q99733\":{\n\t\"loValue\":0\n}\n,\"Q99758\":{\n\t\"loValue\":0\n}\n,\"Q99819\":{\n\t\"loValue\":0\n}\n,\"Q99965\":{\n\t\"loValue\":0\n}\n,\"Q99969\":{\n\t\"loValue\":0\n}\n,\"Q9BQS7\":{\n\t\"loValue\":0\n}\n,\"Q9BTP7\":{\n\t\"loValue\":0\n}\n,\"Q9BVV6\":{\n\t\"loValue\":0\n}\n,\"Q9BXJ4\":{\n\t\"loValue\":0\n}\n,\"Q9BXN1\":{\n\t\"loValue\":3\n}\n,\"Q9BXR6\":{\n\t\"loValue\":26\n}\n,\"Q9BYT3\":{\n\t\"loValue\":0\n}\n,\"Q9BYV9\":{\n\t\"loValue\":0\n}\n,\"Q9BZA7\":{\n\t\"loValue\":0\n}\n,\"Q9BZW5\":{\n\t\"loValue\":0\n}\n,\"Q9C093\":{\n\t\"loValue\":0\n}\n,\"Q9C0E4\":{\n\t\"loValue\":0\n}\n,\"Q9C0F3\":{\n\t\"loValue\":0\n}\n,\"Q9H0K4\":{\n\t\"loValue\":0\n}\n,\"Q9H1D0\":{\n\t\"loValue\":0\n}\n,\"Q9H1D9\":{\n\t\"loValue\":0\n}\n,\"Q9H211\":{\n\t\"loValue\":0\n}\n,\"Q9H334\":{\n\t\"loValue\":0\n}\n,\"Q9H346\":{\n\t\"loValue\":0\n}\n,\"Q9H5J4\":{\n\t\"loValue\":0\n}\n,\"Q9H773\":{\n\t\"loValue\":0\n}\n,\"Q9H944\":{\n\t\"loValue\":0\n}\n,\"Q9H9A5\":{\n\t\"loValue\":0\n}\n,\"Q9H9A7\":{\n\t\"loValue\":0\n}\n,\"Q9HAU8\":{\n\t\"loValue\":0\n}\n,\"Q9HBH5\":{\n\t\"loValue\":2\n}\n,\"Q9HBZ2\":{\n\t\"loValue\":0\n}\n,\"Q9HCE0\":{\n\t\"loValue\":0\n}\n,\"Q9HCF6\":{\n\t\"loValue\":0\n}\n,\"Q9HCG1\":{\n\t\"loValue\":0\n}\n,\"Q9HD89\":{\n\t\"loValue\":0\n}\n,\"Q9IVZ8\":{\n\t\"loValue\":0\n}\n,\"Q9NNW5\":{\n\t\"loValue\":0\n}\n,\"Q9NP55\":{\n\t\"loValue\":0\n}\n,\"Q9NQ79\":{\n\t\"loValue\":0\n}\n,\"Q9NQG5\":{\n\t\"loValue\":0\n}\n,\"Q9NQV8\":{\n\t\"loValue\":0\n}\n,\"Q9NQZ2\":{\n\t\"loValue\":0\n}\n,\"Q9NR82\":{\n\t\"loValue\":0\n}\n,\"Q9NRN5\":{\n\t\"loValue\":0\n}\n,\"Q9NSC2\":{\n\t\"loValue\":0\n}\n,\"Q9NSI6\":{\n\t\"loValue\":0\n}\n,\"Q9NTI7\":{\n\t\"loValue\":0\n}\n,\"Q9NUB4\":{\n\t\"loValue\":0\n}\n,\"Q9NUN5\":{\n\t\"loValue\":0\n}\n,\"Q9NUP1\":{\n\t\"loValue\":0\n}\n,\"Q9NUQ2\":{\n\t\"loValue\":1\n}\n,\"Q9NV72\":{\n\t\"loValue\":0\n}\n,\"Q9NWB7\":{\n\t\"loValue\":0\n}\n,\"Q9NYF3\":{\n\t\"loValue\":0\n}\n,\"Q9NZ20\":{\n\t\"loValue\":0\n}\n,\"Q9NZB2\":{\n\t\"loValue\":0\n}\n,\"Q9NZP8\":{\n\t\"loValue\":0\n}\n,\"Q9NZT1\":{\n\t\"loValue\":0\n}\n,\"Q9P1Z9\":{\n\t\"loValue\":0\n}\n,\"Q9P203\":{\n\t\"loValue\":0\n}\n,\"Q9P265\":{\n\t\"loValue\":0\n}\n,\"Q9P2E2\":{\n\t\"loValue\":0\n}\n,\"Q9P2P6\":{\n\t\"loValue\":0\n}\n,\"Q9P2S2\":{\n\t\"loValue\":0\n}\n,\"Q9QJ49\":{\n\t\"loValue\":0\n}\n,\"Q9UBN7\":{\n\t\"loValue\":0\n}\n,\"Q9UBW5\":{\n\t\"loValue\":0\n}\n,\"Q9UEW3\":{\n\t\"loValue\":2\n}\n,\"Q9UGM3\":{\n\t\"loValue\":0\n}\n,\"Q9UGM5\":{\n\t\"loValue\":0\n}\n,\"Q9UHC6\":{\n\t\"loValue\":0\n}\n,\"Q9UHD2\":{\n\t\"loValue\":0\n}\n,\"Q9UHG3\":{\n\t\"loValue\":0\n}\n,\"Q9UIF9\":{\n\t\"loValue\":0\n}\n,\"Q9UIM3\":{\n\t\"loValue\":0\n}\n,\"Q9UIV8\":{\n\t\"loValue\":0\n}\n,\"Q9UJJ9\":{\n\t\"loValue\":0\n}\n,\"Q9UK55\":{\n\t\"loValue\":0\n}\n,\"Q9UK59\":{\n\t\"loValue\":0\n}\n,\"Q9UKZ4\":{\n\t\"loValue\":0\n}\n,\"Q9UKZ9\":{\n\t\"loValue\":3\n}\n,\"Q9UL01\":{\n\t\"loValue\":0\n}\n,\"Q9ULK4\":{\n\t\"loValue\":0\n}\n,\"Q9ULL4\":{\n\t\"loValue\":0\n}\n,\"Q9ULL5\":{\n\t\"loValue\":0\n}\n,\"Q9ULT8\":{\n\t\"loValue\":0\n}\n,\"Q9ULU8\":{\n\t\"loValue\":0\n}\n,\"Q9ULV4\":{\n\t\"loValue\":0\n}\n,\"Q9ULW8\":{\n\t\"loValue\":0\n}\n,\"Q9UMN6\":{\n\t\"loValue\":0\n}\n,\"Q9UNZ2\":{\n\t\"loValue\":0\n}\n,\"Q9UPR0\":{\n\t\"loValue\":0\n}\n,\"Q9UPS6\":{\n\t\"loValue\":0\n}\n,\"Q9UPU5\":{\n\t\"loValue\":0\n}\n,\"Q9WT38\":{\n\t\"loValue\":0\n}\n,\"Q9Y240\":{\n\t\"loValue\":0\n}\n,\"Q9Y2B5\":{\n\t\"loValue\":0\n}\n,\"Q9Y2H6\":{\n\t\"loValue\":0\n}\n,\"Q9Y312\":{\n\t\"loValue\":0\n}\n,\"Q9Y3D7\":{\n\t\"loValue\":0\n}\n,\"Q9Y3Q4\":{\n\t\"loValue\":0\n}\n,\"Q9Y483\":{\n\t\"loValue\":0\n}\n,\"Q9Y485\":{\n\t\"loValue\":0\n}\n,\"Q9Y490\":{\n\t\"loValue\":15\n}\n,\"Q9Y577\":{\n\t\"loValue\":0\n}\n,\"Q9Y5C1\":{\n\t\"loValue\":1\n}\n,\"Q9Y5G2\":{\n\t\"loValue\":0\n}\n,\"Q9Y5G4\":{\n\t\"loValue\":0\n}\n,\"Q9Y5H2\":{\n\t\"loValue\":0\n}\n,\"Q9Y5I3\":{\n\t\"loValue\":0\n}\n,\"Q9Y5S9\":{\n\t\"loValue\":0\n}\n,\"Q9Y5W7\":{\n\t\"loValue\":0\n}\n,\"Q9Y5X5\":{\n\t\"loValue\":0\n}\n,\"Q9Y6C5\":{\n\t\"loValue\":0\n}\n,\"Q9Y6I3\":{\n\t\"loValue\":0\n}\n,\"Q9Y6K0\":{\n\t\"loValue\":0\n}\n,\"Q9Y6M4\":{\n\t\"loValue\":0\n}\n,\"Q9Y6Y1\":{\n\t\"loValue\":0\n}\n}"
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-70a8dad7-6a9f-319f-bc09-4232cdf1676b",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "P-CHEM",
                "category": {
                    "code": "PC_GRANULOMETRY_SECTION",
                    "title": "4.5 Particle size distribution (Granulometry)"
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
                    "endpoint": "Z-Average Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": " ",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loQualifier": "mean",
                        "loValue": 22.36,
                        "errQualifier": "sd",
                        "errorValue": 0.94
                    }
                },
                {
                    "endpoint": "Z-Average Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loQualifier": "mean",
                        "loValue": 57.53,
                        "errQualifier": "sd",
                        "errorValue": 2.05
                    }
                },
                {
                    "endpoint": "Volume Mean Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": " ",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loValue": 21.94,
                        "errQualifier": "sd",
                        "errorValue": 0.08
                    }
                },
                {
                    "endpoint": "Volume Mean Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loValue": 21.75,
                        "errQualifier": "sd",
                        "errorValue": 17.23
                    }
                },
                {
                    "endpoint": "Number Mean Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": " ",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loValue": 23.49,
                        "errQualifier": "sd",
                        "errorValue": 0.48
                    }
                },
                {
                    "endpoint": "Number Mean Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loValue": 18.38,
                        "errQualifier": "sd",
                        "errorValue": 14.53
                    }
                },
                {
                    "endpoint": "Intensity Mean Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": " ",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loValue": 23.49,
                        "errQualifier": "sd",
                        "errorValue": 0.75
                    }
                },
                {
                    "endpoint": "Intensity Mean Hydrodynamic Diameter",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)",
                        "PHRASEOTHER_PERCENTILE": null,
                        "Remark": null,
                        "SEQ_NUM": null
                    },
                    "result": {
                        "unit": "nm",
                        "loValue": 70.97,
                        "errQualifier": "sd",
                        "errorValue": 7.26
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-73e4b1f4-c2f0-3096-a7a1-8b224e1bc150",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
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
        },
        {
            "uuid": "PRCR-9cb05f3b-b21c-35e7-a21b-47b1767fa1f1",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "TOX",
                "category": {
                    "code": "UNKNOWN_TOXICITY_SECTION",
                    "title": "7.99 Unclassified toxicity"
                },
                "endpoint": "Ellman depletion assay",
                "guideline": [
                    "doi: 10.1021/nn406018q"
                ]
            },
            "parameters": {
                "Type of method": "Serum.density",
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
                    "endpoint": "Autot (ICP-AES)",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)"
                    },
                    "result": {
                        "unit": "nmol",
                        "loQualifier": "mean",
                        "loValue": 255.4430266,
                        "errQualifier": "sd",
                        "errorValue": 10.23948422
                    }
                },
                {
                    "endpoint": "Total surface area (SAtot)",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)"
                    },
                    "result": {
                        "unit": "cm^2",
                        "loQualifier": "mean",
                        "loValue": 11,
                        "errQualifier": "sd",
                        "errorValue": 0
                    }
                },
                {
                    "endpoint": "Protein density",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)"
                    },
                    "result": {
                        "unit": "ug/cm^2",
                        "loQualifier": "mean",
                        "loValue": 0,
                        "errQualifier": "sem",
                        "errorValue": 0.026465833
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-b48a96cc-59ba-35ec-8d91-8bcb1d0e7abc",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "TOX",
                "category": {
                    "code": "UNKNOWN_TOXICITY_SECTION",
                    "title": "7.99 Unclassified toxicity"
                },
                "endpoint": "Absorbance.spectrophotometry.AS.",
                "guideline": [
                    "doi: 10.1021/nn406018q"
                ]
            },
            "parameters": {
                "DATA_GATHERING_INSTRUMENTS": "UV-1601PC absorbance spectrophotometer (Shimadzu)",
                "Type of method": "Absorbance.spectrophotometry.AS.",
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
                    "endpoint": "Localized Surface Plasmon Resonance (LSPR) index",
                    "conditions": {
                        "MEDIUM": " "
                    },
                    "result": {
                        "unit": "",
                        "loQualifier": "mean",
                        "loValue": 0.182530253,
                        "errQualifier": "sd",
                        "errorValue": 0.076033968
                    }
                },
                {
                    "endpoint": "Localized Surface Plasmon Resonance (LSPR) index",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)"
                    },
                    "result": {
                        "unit": "",
                        "loQualifier": "mean",
                        "loValue": 0.454404195,
                        "errQualifier": "sd",
                        "errorValue": 0.030191237
                    }
                },
                {
                    "endpoint": "LSPR peak position (nm)",
                    "conditions": {
                        "MEDIUM": " "
                    },
                    "result": {
                        "unit": "nm",
                        "loQualifier": "mean",
                        "loValue": 518.77,
                        "errQualifier": "sd",
                        "errorValue": 0.51
                    }
                }
            ]
        },
        {
            "uuid": "PRCR-edf4a344-2b88-33f8-accc-04ead1d68e49",
            "owner": {
                "substance": {
                    "uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819"
                },
                "company": {
                    "uuid": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
                    "name": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles"
                }
            },
            "citation": {
                "title": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
                "year": "2014",
                "owner": null
            },
            "protocol": {
                "topcategory": "P-CHEM",
                "category": {
                    "code": "CRYSTALLITE_AND_GRAIN_SIZE_SECTION",
                    "title": "4.26 Nanomaterial crystallite and grain size"
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
                    "endpoint": "Polydispersity index",
                    "conditions": {
                        "MEDIUM": " "
                    },
                    "result": {
                        "unit": "nm",
                        "loQualifier": "mean",
                        "loValue": 0.084,
                        "errQualifier": "sd",
                        "errorValue": 0.035
                    }
                },
                {
                    "endpoint": "Polydispersity index",
                    "conditions": {
                        "MEDIUM": "Human serum (Sigma #H4522)"
                    },
                    "result": {
                        "unit": "nm",
                        "loQualifier": "mean",
                        "loValue": 0.27,
                        "errQualifier": "sd",
                        "errorValue": 0.027
                    }
                }
            ]
        }
    ]
}
````

####<a name="summary"></a>Summary
````json
{
    "substance": [
        {
            "URI": "http://apps.ideaconsult.net:8080/enanomapper/substance/PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819",
            "ownerUUID": "PRCR-a6103acb-f2c6-3190-98d2-ff3404f1e36c",
            "ownerName": "Protein Corona Fingerprinting Predicts the Cellular Interaction of Gold and Silver Nanoparticles",
            "i5uuid": "PRCR-bc77c03d-4e75-3fab-bb3d-17b983663819",
            "name": "G15.AC",
            "publicname": "G15.AC",
            "format": "SDF",
            "substanceType": "nanoparticle",
            "referenceSubstance": {
                "i5uuid": "PRCR-50cca421-d821-396d-b4a5-e2702f0859c6",
                "uri": "http://apps.ideaconsult.net:8080/enanomapper/query/compound/search/all?search=PRCR-50cca421-d821-396d-b4a5-e2702f0859c6"
            },
            "externalIdentifiers": [
                {
                    "type": "Classification",
                    "id": "Anionic"
                }
            ]
        }
    ]
}
````


####<a name="composition"></a>Composition

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



