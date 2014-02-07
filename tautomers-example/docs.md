
tman.getKnowledgeBase().FlagUse13Shifts
true
Determines whether to use rules for 1-3 tautomer shifts. These are the primary rules therefore this flag should not be false.

tman.getKnowledgeBase().FlagUse15Shifts
alternative access:
tman.getKnowledgeBase().use15ShiftRules(true)
true
Determines whether to use rules for 1-5 tautomer shifts. These rules are also considered as important ones therefore by default this flag is true. This flag could be set to be false in order to improve tautomer generation speed where it is expected the percentage of omitted tautomers to be low

tman.getKnowledgeBase().FlagUse17Shifts
alternative access:
tman.getKnowledgeBase().use17ShiftRules(true)
false
Determines whether to use rules for 1-7 tautomer shifts. These rules can be used optionally. If this flag is true, the tautomer generation for complicated cases will be slower, however more exhaustive result will be guaranteed. 

tman.getKnowledgeBase().FlagUse19Shifts
false
Preserved for future usage.

tman.FlagRecurseBackResultTautomers
false
Determines whether to apply recursion in the tautomer generation process. If this flag is true all generated tautomers are returned back and considered as starting structures hence tautomer generation is run for each tautomer as well. The testing statistics show that this option increases the computation time more than 40 times for medium complexity molecules. This option supplies some sort of extreme exhaustiveness of the generation algorithm which in most of the case is not practically needed except for some theoretical and benchmark tests.

tman.getKnowledgeBase().FlagUseRingChainRules
false
Preserved for future usage. This functionality is not implemented yet.

tman.getKnowledgeBase().FlagUseChlorineRules
false
Preserved for future usage. This functionality is not implemented yet.

tman.FlagCheckDuplicationOnRegistering
true
This is a software specific flag. Determines whether to check the for tautomer duplication during the generation process. The check is performed based on the internal atom/bond numbering therefore only the identical tautomers are filtered. The tautomers which are topologically equivalent are not recognized. This is a sort of pre-filtering option which speeds up the algorithm. Typically this flag should be true.

tman.tautomerFilter.FlagApplyWarningFilter
true
Activates / deactivates “warning” post filtering. Warning filters are fully customable by the user. The general idea is to detect chemically correct structures which are weird or unwanted for a particular reason.  Currently the default Warning Filter removes tautomers which contain allene atoms in its acyclic parts (in order to apply this filter, allene atom must not be present in the original structure). 

tman.tautomerFilter.FlagApplyExcludeFilter
true
Activates / deactivates “exclusion” post filtering. 
Exclusion filters are another type of filters fully customable filters. The structures removed by Exclude filter are counted as chemically incorrect. This type of filter is considered to be most strict and expected to be active always (of course for some particular reason the user may deactivate this type of filter as well). Default predefined Exclude Filter in Ambit-Tautomer removes tautomers which contain allene atoms in a cycle. This filter is very practical since cases of cyclic allene atom appear often when there is rule overlapping within a cyclic systems.

tman.tautomerFilter.FlagApplyDuplicationFilter
true
Duplicate tautomers are detected by comparison of their internal string codes. Ambit-Tautomer uses its own unique string representation of the tautomers which includes mainly information about the bonds orders (and if needed some atoms attributes).  The string code is simple and calculated very fast. It relies on the fact that the atom bond numbering for each tautomer is the same. The current implementation of Ambit-Tautomer string code cannot detect topologically equivalent structures.

tman.tautomerFilter.FlagApplyDuplicationCheckIsomorphism
true
If this flag is true all topologically equivalent structures are to be removed.

tman.maxNumOfBackTracks
100000
This is the maximal number of back-tracking steps performed by the Depth-First Search algorithm for tautomer generation. Typically a value of 10000 should be enough to find most of the tautomers for quite complicated molecules. The default value of 100000 guarantees full exhaustiveness in majority of the cases however this limit may cause very long calculation times for more complicated molecules. In order to achieve fast calculations one may use limit 1000 which would guarantee exhaustiveness for small molecules and quire reasonable tautomer sets for medium and larger molecules.     