



````json
{
    "query": {
        "summary": "Query description"
    },
    "dataEntry": [
        {
            "compound": {
                "URI": "http://apps.ideaconsult.net:8080/ambit2/compound/{id}/conformer/{id}",
                "metric": null
            },
            "values": {
                "key1": "value1",
                "key2": 3.14
            }
        },
        {
            "compound": {
                "URI": "http://host:port/ambit2/compound/{id}/conformer/{id}",
                "metric": null
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
            "title": "http://www.opentox.org/api/1.1#ChemicalName",
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