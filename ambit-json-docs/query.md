## Searching chemical compounds

* Documentation (runnable) [Chemical structure search](http://ideaconsult.github.io/examples-ambit/apidocs/#!/compound_0)

All search queries return the results in the [dataset](dataset.md) format 

#### Exact search and search by chemical identifier
````
    curl -H "Accept:application/json" \
        "http://host:port/ambit2/query/compound/search/all?search=caffeine&page=0&pagesize=1" 
````

Examples:

[Search by name](https://apps.ideaconsult.net/ambit2/query/compound/search/all?search=caffeine&media=application/json&page=0&pagesize=1) for compound with name *caffeine*
````
    curl -H "Accept:application/json" \
        "https://apps.ideaconsult.net/ambit2/query/compound/search/all?search=caffeine&page=0&pagesize=1" 
````

[Search by registry number](https://apps.ideaconsult.net/ambit2/query/compound/search/all?search=50-00-0&media=application/json&page=0&pagesize=1) for compound with registry number *50-00-0*
````
    curl -H "Accept:application/json" \
        "https://apps.ideaconsult.net/ambit2/query/compound/search/all?search=50-00-0&page=0&pagesize=1" 
````

[Search by SMILES](https://apps.ideaconsult.net/ambit2/query/compound/search/all?search=c1ccccc1&media=application/json&page=0&pagesize=1) for compound with [SMILES](http://en.wikipedia.org/wiki/Simplified_molecular-input_line-entry_system) *c1cccc1*
````
    curl -H "Accept:application/json" \
        "http://apps.ideaconsult.net:8080/ambit2/query/compound/search/all?search=c1ccccc1&page=0&pagesize=1" 
````

[Search by InChI](https://apps.ideaconsult.net/ambit2/query/compound/search/all?search=InChI%3D1%2FC2H6O%2Fc1-2-3%2Fh3H%2C2H2%2C1H3&media=application/json&page=0&pagesize=1) for compound with [InChI](http://en.wikipedia.org/wiki/International_Chemical_Identifier) *InChI=1/C2H6O/c1-2-3/h3H,2H2,1H3*
````
    curl -H "Accept:application/json" \
        "https://apps.ideaconsult.net/ambit2/query/compound/search/all?search=InChI%3D1%2FC2H6O%2Fc1-2-3%2Fh3H%2C2H2%2C1H3&page=0&pagesize=1" 
````

[Search by URI](https://apps.ideaconsult.net/ambit2/query/compound/search/allnlinks?search=https://apps.ideaconsult.net/ambit2/compound/1&media=application/json&page=0&pagesize=1) for compound with URI https://apps.ideaconsult.net/ambit2/compound/1
````
    curl -H "Accept:application/json" \
        "https://apps.ideaconsult.net/ambit2/query/compound/search/allnlinks?search=https://apps.ideaconsult.net/ambit2/compound/1&media=application/json&page=0&pagesize=1" 
````

#### Similarity search
````
    curl -H "Accept:application/json" \
        "http://host:port/ambit2/query/compound/search/all?search=caffeine&page=0&pagesize=1" 
````

Examples:

[Compounds similar](https://apps.ideaconsult.net/ambit2/query/similarity?search=c1ccccc1&threshold=0.8&page=0&pagesize=100&media=application/json) to SMILES c1ccccc1 with Tanimoto distance>=0.8
````
    curl -H "Accept:application/json" \
        "https://apps.ideaconsult.net/ambit2/query/similarity?search=c1ccccc1&threshold=0.8&page=0&pagesize=100" 
````

#### Substructure search
````
    curl -H "Accept:application/json" \
        "http://host:port/ambit2/query/compound/search/all?search=caffeine&page=0&pagesize=1" 
````

Examples:

[Compounds containing substructure](https://apps.ideaconsult.net/ambit2/query/smarts?search=c1ccccc1&page=0&pagesize=100&media=application/json) , specified by SMILES c1ccccc1
````
    curl -H "Accept:application/json" \
        "https://apps.ideaconsult.net/ambit2/query/smarts?search=c1ccccc1&page=0&pagesize=100" 
````
