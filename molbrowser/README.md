http://ideaconsult.github.io/examples-ambit/molbrowser/


This is a [command line application](https://github.com/ideaconsult/examples-ambit/tree/master/molbrowser), 
which can convert any SDF file into [JSON](http://ideaconsult.github.io/examples-ambit/molbrowser/mol.json) 
and a folder with images. 

[The page](http://ideaconsult.github.io/examples-ambit/molbrowser/) is  a static one,
with some [jQuery](http://jquery.com/) scripts and a bit of styling. The [entire directory structure](https://github.com/ideaconsult/examples-ambit/tree/master/molbrowser/src/main/resources/webapp) can be hosted at any HTTP server.


###Build

````
   mvn clean install
````

###Run
````
java -jar molbrowser-jar-with-dependencies.jar
File not assigned! Use -f command line option.
Molbrowser
usage: net.idea.ambit.molbrowser.MainApp
 -f,--file <file>       Input file name ( .sdf | .txt  | .csv | .cml ) -
                        recognised by extension!
 -h,--help              Molbrowser
 -o,--output <output>   Output folder
````
