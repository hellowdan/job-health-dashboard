package org.jboss.qa.monitoring.health.definitions;

public enum CsvSessionFileColumns {
    ASYNC("Param: async"),
    ASYNC_INSERTS("Param: asyncInserts"),
    BATCH_FIRE("Param: batchFire"),
    CEP("Param: cep"),
    DO_UPDATE("Param: doUpdate"),
    EXERCISE_SESSION("Param: exerciseSession"),
    FACTS_NR("Param: factsNr"),
    INITIAL_SESSION_POOL_SIZE("Param: initialSessionPoolSize"),
    JOINS_NR("Param: joinsNr"),
    LOOP_COUNT("Param: loopCount"),
    MULTITHREAD("Param: multithread"),
    NUMBER_OF_FACTS("Param: numberOfFacts"),
    NUMBER_OF_RULES("Param: numberOfRules"),
    RULE_LINKED("Param: rulelinked"),
    RULES_NR("Param: rulesNr"),
    TREES_NR("Param: treesNr"),
    TYPES_NR("Param: typesNr"),
    USE_CANONICAL_MODEL("Param: useCanonicalModel"),
    USE_NOT_EXISTING_FIELD("Param: useNotExistingField"),
    USE_POOL("Param: usePool");

    private String column;

    CsvSessionFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
