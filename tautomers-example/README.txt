Build

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

>java -jar target/example-ambit-tautomers-jar-with-dependencies.jar -h
Tautomer generation by ambit-tautomers package
usage: net.idea.example.ambit.tautomers.MainApp
 -f,--file <file>        Input file (SDF)
 -h,--help               Tautomer generation by ambit-tautomers package
 -o,--output <output>    Output file (SDF)
 -t,--tautomers <file>   all: Write all tautomers; best: Write only the
                         best tautomer
Examples:
Read file and write all tautomers to the standard out :
java -jar example-ambit-tautomers-jar-with-dependencies.jar     -f filename.sdf

Read file and write only the best tautomer (the lowest rank) to an SDF file :
java -jar example-ambit-tautomers-jar-with-dependencies.jar     -f filename.sdf -o tautomers.sdf -t best



