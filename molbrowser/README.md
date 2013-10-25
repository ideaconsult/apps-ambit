http://ideaconsult.github.io/examples-ambit/molbrowser/


This is a [command line application](https://github.com/ideaconsult/examples-ambit/tree/master/molbrowser), 
which can convert any SDF file into [JSON](http://ideaconsult.github.io/examples-ambit/molbrowser/mol.json) 
and a folder with images. 

[The page](http://ideaconsult.github.io/examples-ambit/molbrowser/) is  a static one,
with some [jQuery](http://jquery.com/) scripts and a bit of styling. The [entire directory structure](https://github.com/ideaconsult/examples-ambit/tree/master/molbrowser/src/main/resources/webapp) can be hosted at any HTTP server.


###Build

````
   mvn clean package
````

Look for target\molbrowser-jar-with-dependencies.jar

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

Running the application will generate *mol.json* and */images* folder with structure diagrams as .png output files.
The newly generated files have to be combined with the [static content](https://github.com/ideaconsult/examples-ambit/tree/master/molbrowser/src/main/resources/webapp)
and copied to a server of choice.

### Download

   [molbrowser-0.0.1-SNAPSHOT-jar-with-dependencies.jar](http://ambit.uni-plovdiv.bg:8083/nexus/content/repositories/snapshots/net/idea/examples/ambit/molbrowser/0.0.1-SNAPSHOT/molbrowser-0.0.1-20131025.084507-1-jar-with-dependencies.jar)

#### Maven artifact [search](http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;quick~molbrowser)

````
<dependency>
  <groupId>net.idea.examples.ambit</groupId>
  <artifactId>molbrowser</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
````


