##OpenTox REST API

[OpenTox](http://opentox.org) is an European Commission Framework Program 7 funded project (2008-2011), 
aims to develop distributed framework for predictive toxicology. 
The building blocks considered are : data, chemical structures, algorithms and models. 
The framework allows to build models, apply models, validate models, access and query data in various ways.
Technologies used are [REST](http://ambit.sourceforge.net/rest.html) style web services and [W3C Resource Description Framework](http://ambit.sourceforge.net/rdf.html) for description of services.

* API Documentation http://opentox.org/dev/apis/api-1.2 
* OpenTox API discussion, new ideas and examples at https://github.com/opentox-api
* API Documentation by Swagger-ui http://ideaconsult.github.io/examples-ambit/apidocs/

### JSON

OpenTox mandatory representation of REST resources is [RDF](http://www.w3.org/RDF/) (W3C Resource Description Framework). 
Examples: [1](http://opentox.org/dev/apis/api-1.2/dataset),[2](http://ambit.sourceforge.net/api_dataset.html).

The JSON representation is a new development, implemented in AMBIT web services [1](http://ambit.sf.net),[2](http://www.jcheminf.com/content/3/1/18), [3](http://www.beilstein-journals.org/bjnano/single/articleFullText.htm?publicId=2190-4286-6-165).

* The JSON or JSONP representation could be retrieved via HTTP Accept headers **"application/json"** or **"application/x-javascript"** respectively. The callback parameter when using JSONP is 'callback'.
* As a workaround for web browsers restriction, the URI parameter **?media=application/json** or **?media=application/x-javascript** could be used.
 
* How to access [Datasets](dataset.md)
* How to [search chemical compounds](query.md)
* How to access [Algorithms](algorithm.md) 
* How to access [Models](model.md)


### Example  

* How to [run Toxtree predictions](toxtree.md) using REST web services and JSON. 
* Try [Toxtree web edition](http://toxtree.sf.net/predict)




