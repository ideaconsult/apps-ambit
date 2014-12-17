##AMBIT REST API: Bundle resource

> bundle: a collection of things, or a quantity of material, tied or wrapped up together. 

A Bundle resource provides means to define collections of [Substance](substance.md), [Compounds](dataset.md) and Endpoints. [API documentation](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle)

### Bundle

1. Bundle summary [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleSummary)]
2. List compounds in a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleCompounds)]
3. List substances in a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleSubstances)]
4. List endpoints in a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleProperties)]
5. List studies defined by a bundle  [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleStudySummary)]
6. Compound role (*bundle_uri* parameter added to compound queries) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/compound_0/searchBySimilarity)] [[example](http://apps.ideaconsult.net:8080/data/query/similarity?search=C%3DO&type=smiles&bundle_uri=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
7. Substance role (*bundle_uri* parameter added to substance queries) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance_1/getSubstances)] [[example](http://apps.ideaconsult.net:8080/data/substance?search=formaldehyde&type=name&bundle_uri=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
8. Endpoint role (*bundle_uri* parameter added to endpoint queries) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/query/getEndpointSummary)] [[example](http://apps.ideaconsult.net:8080/data/query/study?topcategory=P-CHEM&category=PC_MELTING&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
9. Filter endpoints by endpoints, defined in a bundle (*filterbybundle* parameter ) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/query/getEndpointSummary)] [[examples](http://apps.ideaconsult.net:8080/data/query/study?selected=endpoints&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
10. Filter endpoints by substances, defined in a bundle (*filterbybundle* parameter ) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/query/getEndpointSummary)] [[examples](http://apps.ideaconsult.net:8080/data/query/study?selected=substances&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
11. Filter substances by a bundle (*filterbybundle* parameter ) [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/substance/searchByRelatedCompound)] [[examples](http://apps.ideaconsult.net:8080/data/query/substance/related?compound_uri=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fcompound%2F21219&filterbybundle=http%3A%2F%2Fapps.ideaconsult.net%3A8080%2Fdata%2Fbundle%2F1)]
12. Create an empty bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/createBundle)]
13. Update a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateBundle)]
14. Get all bundles [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundles)]
  The result is a [Dataset](dataset.md) metadata.
15. Delete a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/deleteBundle)]
16. Dataset of substances, defined by the bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/getBundleDataset)]
  The format is the same as for [Substance dataset](substance_dataset.md). The substances and the endpoints can be added and removed to / from the bundle.
17. Add or delete substance to / from a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateSubstanceInBundle)]
18. Add or delete compound to / from a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updateCompoundInBundle)]
19. Add or delete endpoint categories to / from a bundle [[api-docs](http://ideaconsult.github.io/examples-ambit/apidocs/#!/bundle/updatePropertyInBundle)]


