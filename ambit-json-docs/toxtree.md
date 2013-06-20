### Toxtree via web services


Retrieve all Toxtree modules, available as OpenTox [algorithms](algorithm.md)
````
    curl "http://apps.ideaconsult.net:8080/ambit2/algorithm?search=ToxTree&media=application/x-javascript"
````

###JSON

````json
{"algorithm": [
{
  "uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer",
	"id": "toxtreecramer",
	"name": "ToxTree: Cramer rules",
	"content": "toxTree.tree.cramer.CramerRules",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#HumanHealthEffects",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecramer",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecramer2",
	"id": "toxtreecramer2",
	"name": "ToxTree: Extended Cramer rules",
	"content": "cramer2.CramerRulesWithExtensions",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#HumanHealthEffects",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecramer2",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeverhaar",
	"id": "toxtreeverhaar",
	"name": "ToxTree: Verhaar scheme for predicting toxicity mode of action",
	"content": "verhaar.VerhaarScheme",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#Acute_toxicity_to_fish_lethality",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeverhaar",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeverhaar2",
	"id": "toxtreeverhaar2",
	"name": "ToxTree: Verhaar scheme (modified) for predicting toxicity mode of action",
	"content": "toxtree.plugins.verhaar2.VerhaarScheme2",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#Acute_toxicity_to_fish_lethality",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeverhaar2",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeeye",
	"id": "toxtreeeye",
	"name": "ToxTree: Eye irritation",
	"content": "eye.EyeIrritationRules",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#Eye_irritation_corrosion",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeeye",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeskinirritation",
	"id": "toxtreeskinirritation",
	"name": "ToxTree: Skin irritation",
	"content": "sicret.SicretRules",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#SkinIrritationCorrosion",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeskin",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreemic",
	"id": "toxtreemic",
	"name": "ToxTree: Structure Alerts for the in vivo micronucleus assay in rodents",
	"content": "mic.MICRules",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#Endpoints",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreemic",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeskinsens",
	"id": "toxtreeskinsens",
	"name": "ToxTree: Skin sensitisation alerts (M. Cronin)",
	"content": "toxtree.plugins.skinsensitisation.SkinSensitisationPlugin",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#SkinSensitisation",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeskinsensitisation",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreednabinding",
	"id": "toxtreednabinding",
	"name": "ToxTree: DNA binding",
	"content": "toxtree.plugins.dnabinding.DNABindingPlugin",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#DNABinding",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreednabinding",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeproteinbinding",
	"id": "toxtreeproteinbinding",
	"name": "ToxTree: Protein binding",
	"content": "toxtree.plugins.proteinbinding.ProteinBindingPlugin",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#ProteinBinding",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeproteinbinding",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreemichaelacceptors",
	"id": "toxtreemichaelacceptors",
	"name": "ToxTree: Michael acceptors",
	"content": "michaelacceptors.MichaelAcceptorRules",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#SkinSensitisation",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreemichaelacc",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreecarc",
	"id": "toxtreecarc",
	"name": "ToxTree: Benigni/Bossa rules for carcinogenicity and mutagenicity",
	"content": "mutant.BB_CarcMutRules",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#Carcinogenicity",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreecarc",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreeames",
	"id": "toxtreeames",
	"name": "ToxTree: In vitro mutagenicity (Ames test) alerts by ISS",
	"content": "toxtree.plugins.ames.AmesMutagenicityRules",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#Mutagenicity",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreeames",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
},
{
	"uri":"http://apps.ideaconsult.net:8080/ambit2/algorithm/toxtreekroes",
	"id": "toxtreekroes",
	"name": "ToxTree: ILSI/Kroes decision tree for TTC",
	"content": "toxtree.plugins.kroes.Kroes1Tree",
	"endpoint": "http://www.opentox.org/echaEndpoints.owl#HumanHealthEffects",
	"description": "",
	"format": "JAVA_CLASS",
	"implementationOf": "http://ambit.sourceforge.net/descriptors.owl#toxtreekroes",
	"isDataProcessing": false,
	"requiresDataset": false,
	"isSupevised": false,
	"requires": "structure",
	"type": [
		"http://www.opentox.org/algorithmTypes.owl#Rules"]
}
]
} 
````
