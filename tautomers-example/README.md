AMBIT-TAUTOMER
==============

[Ambit-Tautomer](http://ambit.sourceforge.net/AMBIT2-LIBS/ambit2-tautomers/index.html) is a new open source software tool for automatic generation of all the tautomeric forms of a given
organic compound. Tautomerization is important in a number of chemoinformatics routines such as structure
representation, chemical database searching, molecular descriptor calculation, estimation of physicochemical
properties, QSAR modelling, virtual screening and more. Ambit-Tautomer is part of the [Ambit2](http://ambit.sf.net),
built on top of the [Chemistry Development Kit library](http://cdk.sf.net). Ambit-Tautomer utilizes a depth-first search algorithm, combined with a
set of rules for tautomeric transformation. Each rule represents two possible states of the molecule part, which
undergoes tautomerization. Ambit-Tautomer [EuroQSAR 2012 poster](http://www.slideshare.net/jeliazkova_nina/ambittautomer-an-open-source-tool-for-tautomer-generation).

The predefined knowledge base covers 1-3, 1-5 and 1-7 proton tautomeric shifts. As an
extra feature, there are rules, which use chlorine atom as a mobile group and a few ring-chain tautomerism rules.
Some typical supported tautomerism rules are keto-enol, amin-imin, nitroso-oxime, azo-hydrazone,
thioketo-thioenol, thionitroso-thiooxime, amidine-imidine, diazoamino-diazoamino, thioamide-iminothiol and
nitrosamine-diazohydroxide. Ambit-Tautomer uses a simple energy based system for tautomer ranking
implemented by a set of empirically derived rules. Additionally, the user may apply a set of post-generation
filters, allowing more fine-grained output control.


This project contains examples how to use ambit2-tautomer package. The package code itself is hosted at [sourceforge.net](http://ambit.sourceforge.net/AMBIT2-LIBS/ambit2-tautomers/index.html)
and the artifacts are available at the [Maven repository](http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;quick~ambit2-tautomer).
For a quick test, try [test page](http://apps.ideaconsult.net:8080/ambit2/depict/tautomer?search=NC%3D1N%3DCN%3DC2N%3DCNC2%3D1) online.

Build
-----

    >mvn clean package
    [INFO] Scanning for projects...
    [INFO] ------------------------------------------------------------------------
    [INFO] Building ambit-tautomers-example
    [INFO]    task-segment: [clean, package]
    [INFO] ------------------------------------------------------------------------
    [INFO] [clean:clean {execution: default-clean}]
    [INFO] Deleting directory /examples-ambit/tautomers-example/target
    [INFO] [resources:resources {execution: default-resources}]
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] Copying 1 resource
    [INFO] snapshot ambit:ambit2-smarts:2.4.9-SNAPSHOT: checking for updates from ambit-plovdiv-snapshots
    [INFO] snapshot ambit:ambit2-core:2.4.9-SNAPSHOT: checking for updates from ambit-plovdiv-snapshots
    [INFO] snapshot ambit:ambit2-base:2.4.9-SNAPSHOT: checking for updates from ambit-plovdiv-snapshots
    [INFO] snapshot org.bitbucket.nanojava:nanojava:0.0.1-SNAPSHOT: checking for updates from ambit-plovdiv-snapshots
    [INFO] snapshot ambit:ambit2-hashcode:2.4.9-SNAPSHOT: checking for updates from ambit-plovdiv-snapshots
    [INFO] [compiler:compile {execution: default-compile}]
    [INFO] Compiling 2 source files to /examples-ambit/tautomers-example/target/classes
    [INFO] [resources:testResources {execution: default-testResources}]
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] Copying 1 resource
    [INFO] [compiler:testCompile {execution: default-testCompile}]
    [INFO] Nothing to compile - all classes are up to date
    [INFO] [surefire:test {execution: default-test}]
    [INFO] Tests are skipped.
    [INFO] [jar:jar {execution: default-jar}]
    [INFO] Building jar: /examples-ambit/tautomers-example/target/example-ambit-tautomers.jar
    [INFO] [assembly:single {execution: create-executable-jar}]
    [INFO] Processing DependencySet (output=)
    [INFO] Building jar: /examples-ambit/tautomers-example/target/example-ambit-tautomers-jar-with-dependencies.jar
    [INFO] [jar:test-jar {execution: default}]
    [INFO] Building jar: examples-ambit/tautomers-example/target/example-ambit-tautomers-tests.jar
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESSFUL
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 20 seconds
    [INFO] Finished at: Wed Sep 19 16:13:08 EEST 2012
    [INFO] Final Memory: 34M/497M
    [INFO] ------------------------------------------------------------------------


Run
---

    >java -jar target/example-ambit-tautomers-jar-with-dependencies.jar -h
    Tautomer generation by ambit-tautomers package
    usage: net.idea.example.ambit.tautomers.MainApp
     -f,--file <file>        Input file (SDF)
     -h,--help               Tautomer generation by ambit-tautomers package
     -o,--output <output>    Output file (SDF)
     -t,--tautomers <file>   all: Write all tautomers; best: Write only the
                             best tautomer
Examples:
---------
Read file and write all tautomers to the standard out :
    
    java -jar example-ambit-tautomers-jar-with-dependencies.jar     -f filename.sdf

Read file and write only the best tautomer (the lowest rank) to an SDF file :
    
    java -jar example-ambit-tautomers-jar-with-dependencies.jar     -f filename.sdf -o tautomers.sdf -t best



