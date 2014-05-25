###Ambit applicability domain estimation by [ambit-models](http://ambit.sourceforge.net/download_ambitlibs.html) package

Run
---

    >java -jar target/ambit-appdomain-example-jar-with-dependencies.jar -h
    

````
usage: net.idea.examle.ambit.appdomain.MainApp
 -d,--demo <dataset>       mutagenicity | kowwin
 -f,--descriptors <list>   Comma delimited list of field names (as in the
                           input files) to be used as descriptors.
                           Example -e log_P,eLumo,eHomo,IL
 -h,--help                 Ambit applicability domain estimation by
                           ambit-models package
 -m,--method <method>      Applicability domain estimation method:
                           _modeRANGE	(PCARanges)
                           _modeLEVERAGE	(Leverage)
                           _modeEUCLIDEAN	(Euclidean distance)
                           _modeCITYBLOCK	(City-block distance)
                           _modeMAHALANOBIS	(Mahalanobis distance)
                           _modeDENSITY	(Probability density)
                           _modeFINGERPRINTS_CONSENSUS
                           (Tanimoto Fingerprints (consensus))
                           _modeFINGERPRINT_MISSINGFRAGMENTS
                           (Tanimoto Fingerprints (consensus))
                           Example:
                           -m _modeFINGERPRINTS
 -o,--output <output>      Output file (CSV,SDF)
 -r,--threshold <value>    1.0 : all compounds from training set
                           considered in the applicability domain (default); 0.9 : 90% of compounds
                           from training set
 -s,--test <file>          Test file (CSV,SDF)
 -t,--training <file>      Training file (CSV,SDF)
````

####Example 1
Reads the demo files and apply applicability domain by Tanimoto consensus fingerprint,
assuming all of the training set compounds are in the app.domain. Results saved in result.sdf file. : 
````
java -jar example-ambit-appdomain-jar-with-dependencies.jar	-m _modeFINGERPRINTS_CONSENSUS -d mutagenicity -o result.csv
````

####Example 2
Reads the demo files and apply applicability domain by probability density estimation,
assuming all of the training set compounds are in the app.domain. : 
````
java -jar example-ambit-appdomain-jar-with-dependencies.jar	-m _modeDENSITY -d mutagenicity
````

####Example 3
Reads training and test CSV files and apply applicability domain by probability density estimation,
assuming 90% of the training set compounds are in the app.domain. : 
````
java -jar example-ambit-appdomain-jar-with-dependencies.jar	-m _modeDENSITY -t Debnath_smiles.csv -s Glende_smiles.csv -f log_P,eLumo,eHomo,IL -r 0.9
````

  * Please use the issue tracker to report bugs https://github.com/ideaconsult/examples-ambit/issues 
  
  * Announcements and discussions at [Google+ page](https://plus.google.com/116849658963631645389) 
  
Download
---

###Command line application

   * Download [1.0.0 release](http://sourceforge.net/projects/ambit/files/Ambit2/AMBIT%20applications/appdomain/ambit-appdomain-example-1.0.0.jar/download)

   * Download from [Maven repository](http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;gav~~ambit-appdomain-example~~~) 

###Maven artifact

    <dependency>
        <groupId>net.idea.examples.ambit</groupId>
        <artifactId>ambit-appdomain-example</artifactId>
        <version>1.0.0</version>
    </dependency>
    <repository>
        <id>ambit-plovdiv-releases</id>
        <url>http://ambit.uni-plovdiv.bg:8083/nexus/content/repositories/releases</url>
    </repository>


                             
Build
-----

    >mvn clean package
  

