##AMBIT REST API: Bundle resource

> bundle: a collection of things, or a quantity of material, tied or wrapped up together. 

A Bundle resource provides means to define collections of [Substance](substance.md), [Compounds](dataset.md) and Endpoints. 

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle

### Bundle

#### create an empty bundle [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/createBundle)

#### update a bundle [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateBundle)

* Accepts "application/x-www-form-urlencoded"

#### get all bundles [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundles)

* The result is a [Dataset](dataset.md) metadata.

#### delete a bundle [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/deleteBundle)

### Dataset of substances [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleDataset)

* The format is the same as for [Substance dataset](substance_dataset.md). The substances and the endpoints can be added and removed to / from the bundle.
 
### Summary of studies 

#### get study summary per bundle [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleStudySummary)

* The outcome is the same format as for  [/substance/id/studysummary](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance/getSubstanceStudySummary) 

### Substances in a bundle

#### get all substances [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleSubstances)

* The result is a list of [Substance](substance.md)s ; the same format as for  [/substance](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance/getSubstances)

#### add or delete substance to / from a bundle [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateSubstanceInBundle)

* accepts "application/x-www-form-urlencoded"

### Compounds in a bundle

#### get all compounds  [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleCompounds)

* The result is a [Dataset](dataset.md)

#### add or delete compound to / from a bundle [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateCompoundInBundle)

* accepts "application/x-www-form-urlencoded"

### Endpoints in a bundle. 

#### get all endpoint categories [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleProperties)

* The result is a list of [Properties](feature.md)

#### add or delete endpoint categories to / from a bundle [api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updatePropertyInBundle)

* accepts "application/x-www-form-urlencoded"
