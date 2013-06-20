### Toxtree via web services


#### Algorithms

Retrieve all Toxtree modules, available as OpenTox [algorithms](algorithm.md)
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
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer2",
            "id": "toxtreecramer2",
            "name": "ToxTree: Extended Cramer rules",
            "content": "cramer2.CramerRulesWithExtensions",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#HumanHealthEffects",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecramer2",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeverhaar",
            "id": "toxtreeverhaar",
            "name": "ToxTree: Verhaar scheme for predicting toxicity mode of action",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Acute_toxicity_to_fish_lethality",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeverhaar",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeverhaar2",
            "id": "toxtreeverhaar2",
            "name": "ToxTree: Verhaar scheme (modified) for predicting toxicity mode of action",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Acute_toxicity_to_fish_lethality",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeverhaar2",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeeye",
            "id": "toxtreeeye",
            "name": "ToxTree: Eye irritation",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Eye_irritation_corrosion",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeeye",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeskinirritation",
            "id": "toxtreeskinirritation",
            "name": "ToxTree: Skin irritation",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#SkinIrritationCorrosion",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeskin",
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
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeskinsens",
            "id": "toxtreeskinsens",
            "name": "ToxTree: Skin sensitisation alerts (M. Cronin)",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#SkinSensitisation",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeskinsensitisation",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreednabinding",
            "id": "toxtreednabinding",
            "name": "ToxTree: DNA binding",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#DNABinding",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreednabinding",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeproteinbinding",
            "id": "toxtreeproteinbinding",
            "name": "ToxTree: Protein binding",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#ProteinBinding",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeproteinbinding",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        },
        {
            "uri": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreemichaelacceptors",
            "id": "toxtreemichaelacceptors",
            "name": "ToxTree: Michael acceptors",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#SkinSensitisation",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreemichaelacc",
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

######Retrieve a model, created by a given algorithm

````
    curl -H "Accept:application/json" http://host:port/ambit2/model?algorithm=ALGORITHM_URI
````

Example: Retrieve the model, which will apply the Cramer rules algorithm

````
    curl -H "Accept:application/json" http://apps.ideaconsult.net:8080/ambit2/model?algorithm=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fambit2%2Falgorithm%2Ftoxtreecramer
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
                "URI": "http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer",
                "algFormat": "JAVA_CLASS",
                "img": "/images/toxtree.png"
            },
            "trainingDataset": "http://apps.ideaconsult.net:8080/ambit2/dataset/27764",
            "independent": "http://apps.ideaconsult.net:8080/ambit2/model/2/independent",
            "dependent": "http://apps.ideaconsult.net:8080/ambit2/model/2/dependent",
            "predicted": "http://apps.ideaconsult.net:8080/ambit2/model/2/predicted",
            "ambitprop": {
                "legend": "http://apps.ideaconsult.net:8080/ambit2/model/2?media=image/png",
                "creator": "guest",
                "mimetype": "application/java",
                "content": "toxTree.tree.cramer.CramerRules",
                "evaluations": {},
                "stars": 9
            }
        }
    ]
} 
````


######Create a model 
````
    curl -X POST http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer -H "Accept:application/json"
````
