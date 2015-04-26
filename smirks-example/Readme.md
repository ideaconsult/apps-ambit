#Ambit-SMIRKS

Best poster award at [OpenTox Euro 2013](http://www.opentox.org/meet/opentoxeu2013/opentoxeuro13awards) |
[This page](http://tinyurl.com/ambitsmirks) | [Ambit at Google+](https://plus.google.com/b/116849658963631645389/116849658963631645389/posts) |
<a href="https://twitter.com/share" class="twitter-share-button" data-via="10705013" data-related="10705013" data-count="none" data-hashtags="ambit,smirks,metabolism,oteu13,opentox">Tweet</a>

--
Ambit-SMIRKS is an extension of the [Ambit-SMARTS](http://onlinelibrary.wiley.com/doi/10.1002/minf.201100028/abstract) Java library, both part of the [AMBIT project](http://ambit.sf.net)

The SMIRKS module is used to enable metabolite predictions in [Toxtree](http://toxtree.sourceforge.net),
once that site of metabolisms are predicted by [SMARTCyp](http://www.farma.ku.dk/smartcyp/)

##Main functionality

* Parsing of [SMIRKS linear notations](http://www.daylight.com/dayhtml_tutorials/languages/smirks/) into internal reaction (transformation) representations based on [The Chemistry Development Kit](http://cdk.sf.net) objects 
* Application of the stored reactions against target molecules for actual transformation of the target chemical objects 

##### Transformation mapping modes

The transformations can be applied on various sites of the target molecule in several modes: 
* single 
* non-overlapping 
* non-identical
* non-homomorphic or
* externally specified list of sites

##### [Test online](https://apps.ideaconsult.net/data/depict/reaction?search=c1ccccc1&smirks=%5Bc%3A1%5D%5BH%3A2%5D%3E%3E%5Bc%3A1%5D%5BO%5D%5BH%3A2%5D)

#### Maven artifacts

* Depends on [The CDK](http://cdk.sf.net) 1.4.11 
 
````
    <dependency>
      <groupId>ambit</groupId>
      <artifactId>ambit2-smarts</artifactId>
      <version>2.7.3</version>
    </dependency>
    <repository>
        <id>ambit-plovdiv-releases</id>
        <url>http://ambit.uni-plovdiv.bg:8083/nexus/content/repositories/releases</url>
    </repository> 
````

* Depends on [The CDK](http://cdk.sf.net) 1.5.10

````
    <dependency>
      <groupId>ambit</groupId>
      <artifactId>ambit2-smarts</artifactId>
      <version>3.0.0-SNAPSHOT</version>
    </dependency>
    <repository>
        <id>ambit-plovdiv-snapshots</id>
        <url>http://ambit.uni-plovdiv.bg:8083/nexus/content/repositories/snapshots</url>
    </repository>
````

#### Code examples

```java
    IAtomContainer target = (initialize)
    SMIRKSManager smrkMan = new SMIRKSManager();
    SMIRKSReaction reaction = smrkMan.parse(smirks);
    if (!smrkMan.getErrors().equals(""))  {
           throw(new Exception("Smirks Parser errors:\n" + smrkMan.getErrors()));
    }
    if (smrkMan.applyTransformation(target, reaction)) 
           return target; //all products inside the same atomcontainer, could be disconnected
    else return null;
```
* Generate separate products for every possible reaction (used in [Toxtree](http://toxtree.sf.net/smartcyp.html))

```java
    SMIRKSManager smrkMan = new SMIRKSManager();
    SMIRKSReaction smr = smrkMan.parse(reaction.getSMIRKS());
    IAtomContainer product = reactant; //(IAtomContainer) reactant.clone();
    IAtomContainerSet rproducts = smrkMan.applyTransformationWithSingleCopyForEachPos(product, null, smr);
    //products returned in a separate atom sontainer set
```

##Application in metabolite generation

[Toxtree](http://toxtree.sf.net) is an open-source application that predicts various kinds of toxic effects, mostly by applying structural alerts, arranged in a decision tree fashion.
You could [download the application](http://toxtree.sourceforge.net/download.html) or test [Toxtree online](http://toxtree.sourceforge.net/predict?search=omeprazole)

[SMARTCyp](http://www.farma.ku.dk/smartcyp/) (Cytochrome P450-Mediated Drug Metabolism) model is developed by [Patrik Rydberg](https://plus.google.com/108819997902788567005) et al and is included as [Toxtree module](http://toxtree.sourceforge.net/smartcyp.html) since Toxtree 2.1.0. 

<img src='toxtree-metabolites.png'>'

