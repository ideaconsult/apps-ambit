##OpenTox REST API: Algorithm

Provides access to OpenTox algorithms. 



* There are multiple kinds of algorithms (descriptor calculation, machine learning procedures or various data preprocessing). 
* Generally, a machine learning algorithm takes a [dataset](dataset.md) URI as input and generate a [model](model.md), also identified with an URI.
* The Algorithm types ontology provides a hierarchical classification of [Algorithm types](http://opentox.org/data/documents/development/RDF%20files/AlgorithmTypes).
* Documentation http://opentox.org/dev/apis/api-1.2/Algorithm


### JSON

OpenTox mandatory representation of REST resources is [RDF](http://www.w3.org/RDF/) (W3C Resource Description Framework). 
Examples: [1](http://opentox.org/dev/apis/api-1.2/algorithm),[2](http://ambit.sourceforge.net/api_algorithm.html).

The JSON representation is a new development, implemented in AMBIT web services [1](http://ambit.sf.net),[2](http://www.jcheminf.com/content/3/1/18).

* The algorithm JSON representation closely follows the RDF data model;

* The JSON or JSONP representation could be retrieved via HTTP Accept headers **"application/json"** or **"application/x-javascript"** respectively.
* As a workaround for web browsers restriction, the URI parameter **?media=application/json** or **?media=application/x-javascript** could be used.


````json
{
    "algorithm": [
        {
            "uri": "http://host:port/ambit2/algorithm/SimpleKMeans",
            "id": "SimpleKMeans",
            "name": "Clustering: k-means",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Clustering",
                "http://www.opentox.org/algorithmTypes.owl#SingleTarget",
                "http://www.opentox.org/algorithmTypes.owl#LazyLearning",
                "http://www.opentox.org/algorithmTypes.owl#UnSupervised"
            ]
        },
        {
            "uri": "http://host:port:8080/ambit2/algorithm/J48",
            "id": "J48",
            "name": "Classification: Decision tree J48",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Classification",
                "http://www.opentox.org/algorithmTypes.owl#SingleTarget",
                "http://www.opentox.org/algorithmTypes.owl#EagerLearning",
                "http://www.opentox.org/algorithmTypes.owl#Supervised"
            ]
        },
        {
            "uri": "http://host:port/ambit2/algorithm/LR",
            "id": "LR",
            "name": "Regression: Linear regression",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Regression",
                "http://www.opentox.org/algorithmTypes.owl#SingleTarget",
                "http://www.opentox.org/algorithmTypes.owl#EagerLearning",
                "http://www.opentox.org/algorithmTypes.owl#Supervised"
            ]
        },
        {
            "uri": "http://host:port/ambit2/algorithm/org.openscience.cdk.qsar.descriptors.molecular.XLogPDescriptor",
            "id": "org.openscience.cdk.qsar.descriptors.molecular.XLogPDescriptor",
            "name": "XLogP",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Octanol-water_partition_coefficient_Kow",
            "implementationOf": "http://www.blueobelisk.org/ontologies/chemoinformatics-algorithms/#xlogP",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#DescriptorCalculation"
            ]
        },
        {
            "uri": "http://host:port/ambit2/algorithm/toxtreecramer",
            "id": "toxtreecramer",
            "name": "ToxTree: Cramer rules",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#HumanHealthEffects",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecramer",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        }
    ]
}
````

#### [cURL](http://curl.haxx.se/) examples:

Retrieve the list of [Descriptor calculation](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=DescriptorCalculation) algorithms
````
    curl -H "Accept:application/x-javascript" "http://apps.ideaconsult.net:8080/ambit2/algorithm?type=DescriptorCalculation"
````

Retrieve the list of [Classification](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Classification) algorithms
````
    curl "http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Classification&media=application/json"
````

Retrieve the list of [Regression](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Regression) algorithms
````
    curl -H "Accept:application/json" http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Regression
````

Retrieve the list of algorithms based on [Expert rules](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Rules) 
````
    curl "http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Rules&media=application/x-javascript" 
````

Retrieve the list of [Applicability domain](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=AppDomain) algorithms
````
    curl "http://apps.ideaconsult.net:8080/ambit2/algorithm?type=AppDomain&media=application/x-javascript"
````

### <a id="ONTOLOGY_ENTRY">The ontology entries</a>

* An algorithm resource may contain an "implementationOf" field, linking to the BlueObelisk ontology , e.g. http://www.blueobelisk.org/ontologies/chemoinformatics-algorithms/#xlogP. 
* The BlueObelisk ontology provides details of the algorithm itself, e.g. publication reference.
* The BlueObelisk ontology can be queried via Ontology service [SPARQL](http://apps.ideaconsult.net:8080/ontology/query/BODO).

* An algorithm resource may contain an "endpoint" field, linking to the [endpoints ontology](http://www.opentox.org/echaEndpoints.owl) , e.g. http://www.opentox.org/echaEndpoints.owl#Carcinogenicity. 


 



