##AMBIT REST API: Bundle resource

> bundle: a collection of things, or a quantity of material, tied or wrapped up together. 

A Bundle resource provides means to define collections of [Substance](substance.md), [Compounds](dataset.md) and Endpoints. 

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle

### Bundle

#### create an empty bundle

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/createBundle

#### update a bundle

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateBundle

#### get all bundles. The result is a [Dataset](dataset.md) metadata.

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundles

#### delete a bundle

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/deleteBundle

### Summary of studies 

#### get study summary per bundle (similar to [/substance/id/studysummary](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance/getSubstanceStudySummary) )

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleStudySummary

### Substances in a bundle

#### get all substances. The result is a list of [Substance](substance.md)s (similar to [/substance](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance/getSubstances)

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleSubstances

#### add or delete substance to / from a bundle

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateSubstanceInBundle

### Compounds in a bundle

#### get all compounds. The result is a [Dataset](dataset.md)

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleCompounds

#### add or delete compound to / from a bundle

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateCompoundInBundle

### Endpoints in a bundle. 

#### get all endpoint categories. The result is a list of [Properties](feature.md)

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleProperties

#### add or delete endpoint categories to / from a bundle

http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updatePropertyInBundle

