#Ambit-tautomer configurations

The flags are used for fine-tuning the tautomer generation process and post-generation filtering in [Ambit-Tautomer](README.md) 

* Tautomeric shifts:
[FlagUse13Shifts](#FlagUse13Shifts), [FlagUse15Shifts](#FlagUse15Shifts), [FlagUse17Shifts](#FlagUse17Shifts), [FlagUse19Shifts](#FlagUse19Shifts)

* Rules:
[FlagRecurseBackResultTautomers](#FlagRecurseBackResultTautomers), [FlagUseRingChainRules](#FlagUseRingChainRules), [FlagUseChlorineRules](#FlagUseChlorineRules) 

* <a name="Filters"></a>Filters: 
[FlagApplyWarningFilter](#FlagApplyWarningFilter), [FlagApplyExcludeFilter](#FlagApplyExcludeFilter), [FlagApplyDuplicationFilter](#FlagApplyDuplicationFilter) 

* Duplicates handling:
[FlagCheckDuplicationOnRegistering](#FlagCheckDuplicationOnRegistering),  [FlagApplyDuplicationCheckIsomorphism](#FlagApplyDuplicationCheckIsomorphism), [maxNumOfBackTracks](#maxNumOfBackTracks)


####<a name="FlagUse13Shifts"></a>tman.getKnowledgeBase().FlagUse13Shifts
* Default value : *true*
* Determines whether to use rules for 1-3 tautomer shifts. These are the primary rules therefore this flag should not be false.

####<a name="FlagUse15Shifts"></a>tman.getKnowledgeBase().FlagUse15Shifts | tman.getKnowledgeBase().use15ShiftRules(true)
* Default value : *true*
* Determines whether to use rules for 1-5 tautomer shifts. These rules are also considered as important ones therefore by default this flag is true. This flag could be set to be *false* in order to improve the tautomer generation speed where it is expected the percentage of tautomers omitted to be low.

####<a name="FlagUse17Shifts"></a>tman.getKnowledgeBase().FlagUse17Shifts | tman.getKnowledgeBase().use17ShiftRules(true)
* Default value : *false*
* Determines whether to use the rules for 1-7 tautomer shifts. These rules can be used optionally. If this flag is *true*, the tautomer generation for complicated cases will be slower, however more exhaustive results will be guaranteed. 

####<a name="FlagUse19Shifts"></a>tman.getKnowledgeBase().FlagUse19Shifts
* Default value : *false*
* Preserved for future usage.

####<a name="FlagRecurseBackResultTautomers"></a>tman.FlagRecurseBackResultTautomers
* Default value : *false*
* Determines whether to apply recursion in the tautomer generation process. If this flag is true all generated tautomers are returned back and considered as starting structures hence tautomer generation is run for each tautomer as well. The testing statistics show that this option increases the computation time more than 40 times for medium complexity molecules. This option supplies some sort of extreme exhaustiveness of the generation algorithm which in most of the case is not practically needed except for some theoretical and benchmark tests.

####<a name="FlagUseRingChainRules"></a>tman.getKnowledgeBase().FlagUseRingChainRules
* Default value : *false*
* Preserved for future usage. This functionality is not implemented yet.

####<a name="FlagUseChlorineRules"></a>tman.getKnowledgeBase().FlagUseChlorineRules
* Default value : *false*
* Preserved for future usage. This functionality is not implemented yet.

####<a name="FlagCheckDuplicationOnRegistering"></a>tman.FlagCheckDuplicationOnRegistering
* Default value : *true*
* This is a software specific flag. It determines whether to check the for tautomer duplication during the generation process. The check is performed based on the internal atom/bond numbering therefore only the identical tautomers are filtered. The tautomers which are topologically equivalent are not recognized. This is a sort of pre-filtering option which speeds up the algorithm. Typically this flag should be *tue*.

####<a name="FlagApplyWarningFilter"></a>tman.tautomerFilter.FlagApplyWarningFilter
* Default value : *true*
* Activates / deactivates the post-filtering of type _warning_.  The _warning_ filters are fully customable by the user. The general idea is to detect chemically correct structures which are weird or unwanted for a particular reason.  Currently the default _warning_ filter removes tautomers which contain allene atoms in its acyclic parts (in order to apply this filter, allene atom must not be present in the original structure). 

####<a name="FlagApplyExcludeFilter"></a>tman.tautomerFilter.FlagApplyExcludeFilter
* Default value : *true*
* Activates / deactivates the post-filtering of type _exclusion_.
The _exclusion_ filters are another type of fully customable filters. The structures removed by _exclusion_ filter are considered chemically incorrect. This type of filter is considered to be most strict and expected to be active always (of course for some particular reason the user may deactivate this type of filter as well). The default predefined _exclusion_ filter removes tautomers which contain allene atoms in a cycle. This filter is very practical since cases of cyclic allene atom appear often when there is rule overlapping within a cyclic systems.

####<a name="FlagApplyDuplicationFilter"></a>tman.tautomerFilter.FlagApplyDuplicationFilter
* Default value : *true*
* The duplicate tautomers are detected by comparison of their internal string codes. Ambit-Tautomer uses its own unique string representation of the tautomers which includes mainly information about the bonds orders (and if needed some atoms attributes).  The string code is simple and is calculated very fast. It relies on the fact that the atom bond numbering for each tautomer is the same. The current implementation of the Ambit-Tautomer string code cannot detect topologically equivalent structures.

####<a name="FlagApplyDuplicationCheckIsomorphism"></a>tman.tautomerFilter.FlagApplyDuplicationCheckIsomorphism
* Default value : *true*
* If this flag is *true*, all topologically equivalent structures are to be removed.

####<a name="maxNumOfBackTracks"></a>tman.maxNumOfBackTracks
* Default value : *100000*
* This is the maximal number of back-tracking steps performed by the Depth-First Search algorithm for tautomer generation. Typically a value of *10000* should be enough to find most of the tautomers for quite complicated molecules. The default value of *100000* guarantees full exhaustiveness in majority of the cases, however this value may cause very long calculation times for more complicated molecules. In order to achieve faster calculations one may use a lower value (e.g. *1000*) which would guarantee exhaustiveness for small molecules and quire reasonable tautomer sets for medium and larger molecules.     
