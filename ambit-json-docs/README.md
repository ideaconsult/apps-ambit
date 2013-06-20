##OpenTox REST API

[OpenTox](http://opentox.org) is an European Commission Framework Program 7 funded project (2008-2001), 
aims to develop distributed framework for predictive toxicology. 
The building blocks considered are : data, chemical structures, algorithms and models. 
The framework allows to build models, apply models, validate models, access and query data in various ways.
Technologies used are REST style web services and W3C Resource Description Framework for description of services.

* API Documentation http://opentox.org/dev/apis/api-1.2 

### JSON

OpenTox mandatory representation of REST resources is [RDF](http://www.w3.org/RDF/) (W3C Resource Description Framework). 
Examples: [1](http://opentox.org/dev/apis/api-1.2/dataset),[2](http://ambit.sourceforge.net/api_dataset.html).

The JSON representation is a new development, implemented in AMBIT web services [1](http://ambit.sf.net),[2](http://www.jcheminf.com/content/3/1/18).

* The JSON or JSONP representation could be retrieved via HTTP Accept headers **"application/json"** or **"application/x-javascript"** respectively.
* As a workaround for web browsers restriction, the URI parameter **?media=application/json** or **?media=application/x-javascript** could be used.
 
* How to access [Datasets](dataset.md)
* How to [search chemical compounds](query.md)
* How to access [Algorithms](algorithm.md) 
* How to access [Models](model.md)


### Example  

* How to [run Toxtree predictions](toxtree.md) using REST web services and JSON.




