###[AMBIT](http://ambit.sf.net) applicability domain estimation examples

[ambit-model](http://ambit.sourceforge.net/download_ambitlibs.html) package is an implementation of methods described in


* [Jaworska, J., Nikolova-Jeliazkova, N., & Aldenberg, T. (2005). QSAR applicabilty domain estimation by projection of the training set descriptor space: a review. Alternatives to Laboratory Animals ATLA, 33(5), 445–459.](http://www.ncbi.nlm.nih.gov/pubmed/16268757)
* [Nikolova-Jeliazkova, N., & Jaworska, J. (2005). An approach to determining applicability domains for QSAR group contribution models: an analysis of SRC KOWWIN. Alternatives to Laboratory Animals ATLA, 33(5), 461–470.](http://www.ncbi.nlm.nih.gov/pubmed/16268758)
* [Netzeva, T. I., Worth, A., Aldenberg, T., Benigni, R., Cronin, M. T. D., Gramatica, P., … Yang, C. (2005). Current status of methods for defining the applicability domain of (quantitative) structure-activity relationships. The report and recommendations of ECVAM Workshop 52. Alternatives to Laboratory Animals ATLA.](http://www.ncbi.nlm.nih.gov/pubmed/16180989)
* [Jaworska, J., & Nikolova-Jeliazkova, N. (2007). How can structural similarity analysis help in category formation? SAR and QSAR in Environmental Research, 18(3-4), 195–207. doi:10.1080/10629360701306050](http://www.ncbi.nlm.nih.gov/pubmed/17514565)

This project  (appdomain-example) is a command line application, demonstrating how to use [ambit-model](http://ambit.sourceforge.net/download_ambitlibs.html) package. 
Alternatively, the applicability domain algorithms are implemented in [Ambit Discovery](http://ambit.sourceforge.net/download_ambitdiscovery.html) desktop application as well as REST web services in [Ambit web application](http://ambit.sourceforge.net/download_ambitrest.html).

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

#### Example files

* Mutagenicity  [1](http://www.ncbi.nlm.nih.gov/pubmed/1732103) (structures and descriptors) [Training set](https://github.com/ideaconsult/examples-ambit/blob/master/appdomain-example/src/main/resources/net/idea/example/ambit/appdomain/Debnath_smiles.csv) [Test set](https://github.com/ideaconsult/examples-ambit/blob/master/appdomain-example/src/main/resources/net/idea/example/ambit/appdomain/Glende_smiles.csv)
    
* EPI Suite KOWWIN [2](http://www.epa.gov/opptintr/exposure/pubs/episuite.htm) (structures only) [Training set](https://github.com/ideaconsult/examples-ambit/blob/master/appdomain-example/src/main/resources/net/idea/example/ambit/appdomain/kowwin_training.csv) [Test set](https://github.com/ideaconsult/examples-ambit/blob/master/appdomain-example/src/main/resources/net/idea/example/ambit/appdomain/kowwin_validation.csv)
    

### Support

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
  

