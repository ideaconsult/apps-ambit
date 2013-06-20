##OpenTox REST API: Algorithm

Provides access to OpenTox algorithms. There are several algorithm services, developed by different OpenTox partners. List of algorithms can be retrieved by HTTP GET operation at http://host:port/algorithm.

* There are multiple kinds of algorithms, some are descriptor calculation algorithms, and others provide access to different machine learning procedures or data preprocessing. 
* Algorithm types are distinguished by means of [Algorithm types](http://opentox.org/data/documents/development/RDF%20files/AlgorithmTypes) ontology.
* The Algorithm types ontologyp rovides a hierarchical classification of algorithm types. 


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
            "content": "weka.clusterers.SimpleKMeans",
            "endpoint": "",
            "description": "",
            "format": "WEKA",
            "implementationOf": "",
            "isDataProcessing": false,
            "requiresDataset": true,
            "isSupevised": false,
            "requires": "property",
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
            "content": "weka.classifiers.trees.J48",
            "endpoint": "",
            "description": "",
            "format": "WEKA",
            "implementationOf": "",
            "isDataProcessing": false,
            "requiresDataset": true,
            "isSupevised": true,
            "requires": "property",
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
            "content": "weka.classifiers.functions.LinearRegression",
            "endpoint": "",
            "description": "",
            "format": "WEKA",
            "implementationOf": "",
            "isDataProcessing": false,
            "requiresDataset": true,
            "isSupevised": true,
            "requires": "property",
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
            "content": "org.openscience.cdk.qsar.descriptors.molecular.XLogPDescriptor",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#Octanol-water_partition_coefficient_Kow",
            "description": "",
            "format": "WEKA",
            "implementationOf": "http://www.blueobelisk.org/ontologies/chemoinformatics-algorithms/#xlogP",
            "isDataProcessing": true,
            "requiresDataset": true,
            "isSupevised": false,
            "requires": "structure",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#DescriptorCalculation"
            ]
        },
        {
            "uri": "http://host:port/ambit2/algorithm/toxtreecramer",
            "id": "toxtreecramer",
            "name": "ToxTree: Cramer rules",
            "content": "toxTree.tree.cramer.CramerRules",
            "endpoint": "http://www.opentox.org/echaEndpoints.owl#HumanHealthEffects",
            "description": "",
            "format": "JAVA_CLASS",
            "implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecramer",
            "isDataProcessing": false,
            "requiresDataset": false,
            "isSupevised": false,
            "requires": "structure",
            "type": [
                "http://www.opentox.org/algorithmTypes.owl#Rules"
            ]
        }
    ]
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

Examples:

[Descriptor calculation](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=DescriptorCalculation), [Classification](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Classification),
[Regression](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Regression),
[Expert rules](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=Rules),
[Applicability domain](http://apps.ideaconsult.net:8080/ambit2/algorithm?type=AppDomain),
[Toxtree](http://apps.ideaconsult.net:8080/ambit2/algorithm?search=ToxTree)
 



