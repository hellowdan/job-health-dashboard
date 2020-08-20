package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvSessionFileColumns;
import org.json.simple.JSONObject;

public class SessionRow extends BenchmarksRow {

    private String async = "";
    private String asyncInserts = "";
    private String batchFire = "";
    private String cep = "";
    private String doUpdate = "";
    private String exerciseSession = "";
    private String factsNr = "";
    private String initialSessionPoolSize = "";
    private String joinsNr = "";
    private String loopCount = "";
    private String multithread = "";
    private String numberOfFacts = "";
    private String numberOfRules = "";
    private String rulelinked = "";
    private String rulesNr = "";
    private String treesNr = "";
    private String typesNr = "";
    private String useCanonicalModel = "";
    private String useNotExistingField = "";
    private String usePool = "";

    public SessionRow() {
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvSessionFileColumns.ASYNC.getColumn()) != null) {
            this.async = reportRow.get(CsvSessionFileColumns.ASYNC.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.ASYNC_INSERTS.getColumn()) != null) {
            this.asyncInserts = reportRow.get(CsvSessionFileColumns.ASYNC_INSERTS.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.BATCH_FIRE.getColumn()) != null) {
            this.batchFire = reportRow.get(CsvSessionFileColumns.BATCH_FIRE.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.CEP.getColumn()) != null) {
            this.cep = reportRow.get(CsvSessionFileColumns.CEP.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.DO_UPDATE.getColumn()) != null) {
            this.doUpdate = reportRow.get(CsvSessionFileColumns.DO_UPDATE.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.EXERCISE_SESSION.getColumn()) != null) {
            this.exerciseSession = reportRow.get(CsvSessionFileColumns.EXERCISE_SESSION.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.FACTS_NR.getColumn()) != null) {
            this.factsNr = reportRow.get(CsvSessionFileColumns.FACTS_NR.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.INITIAL_SESSION_POOL_SIZE.getColumn()) != null) {
            this.initialSessionPoolSize = reportRow.get(CsvSessionFileColumns.INITIAL_SESSION_POOL_SIZE.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.JOINS_NR.getColumn()) != null) {
            this.joinsNr = reportRow.get(CsvSessionFileColumns.JOINS_NR.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.LOOP_COUNT.getColumn()) != null) {
            this.loopCount = reportRow.get(CsvSessionFileColumns.LOOP_COUNT.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.MULTITHREAD.getColumn()) != null) {
            this.multithread = reportRow.get(CsvSessionFileColumns.MULTITHREAD.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.NUMBER_OF_FACTS.getColumn()) != null) {
            this.numberOfFacts = reportRow.get(CsvSessionFileColumns.NUMBER_OF_FACTS.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.NUMBER_OF_RULES.getColumn()) != null) {
            this.numberOfRules = reportRow.get(CsvSessionFileColumns.NUMBER_OF_RULES.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.RULE_LINKED.getColumn()) != null) {
            this.rulelinked = reportRow.get(CsvSessionFileColumns.RULE_LINKED.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.RULES_NR.getColumn()) != null) {
            this.rulesNr = reportRow.get(CsvSessionFileColumns.RULES_NR.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.TREES_NR.getColumn()) != null) {
            this.treesNr = reportRow.get(CsvSessionFileColumns.TREES_NR.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.TYPES_NR.getColumn()) != null) {
            this.typesNr = reportRow.get(CsvSessionFileColumns.TYPES_NR.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.USE_CANONICAL_MODEL.getColumn()) != null) {
            this.useCanonicalModel = reportRow.get(CsvSessionFileColumns.USE_CANONICAL_MODEL.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.USE_NOT_EXISTING_FIELD.getColumn()) != null) {
            this.useNotExistingField = reportRow.get(CsvSessionFileColumns.USE_NOT_EXISTING_FIELD.getColumn()).toString();
        }

        if (reportRow.get(CsvSessionFileColumns.USE_POOL.getColumn()) != null) {
            this.usePool = reportRow.get(CsvSessionFileColumns.USE_POOL.getColumn()).toString();
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        if (!this.async.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.ASYNC.getColumn() + ":" + this.async;
        }
        if (!this.asyncInserts.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.ASYNC_INSERTS.getColumn() + ":" + this.asyncInserts;
        }
        if (!this.batchFire.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.BATCH_FIRE.getColumn() + ":" + this.batchFire;
        }
        if (!this.cep.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.CEP.getColumn() + ":" + this.cep;
        }
        if (!this.doUpdate.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.DO_UPDATE.getColumn() + ":" + this.doUpdate;
        }
        if (!this.exerciseSession.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.EXERCISE_SESSION.getColumn() + ":" + this.exerciseSession;
        }
        if (!this.factsNr.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.FACTS_NR.getColumn() + ":" + this.factsNr;
        }
        if (!this.initialSessionPoolSize.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.INITIAL_SESSION_POOL_SIZE.getColumn() + ":" + this.initialSessionPoolSize;
        }
        if (!this.joinsNr.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.JOINS_NR.getColumn() + ":" + this.joinsNr;
        }
        if (!this.loopCount.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.LOOP_COUNT.getColumn() + ":" + this.loopCount;
        }
        if (!this.multithread.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.MULTITHREAD.getColumn() + ":" + this.multithread;
        }
        if (!this.numberOfFacts.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.NUMBER_OF_FACTS.getColumn() + ":" + this.numberOfFacts;
        }
        if (!this.numberOfRules.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.NUMBER_OF_RULES.getColumn() + ":" + this.numberOfRules;
        }
        if (!this.rulelinked.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.RULE_LINKED.getColumn() + ":" + this.rulelinked;
        }
        if (!this.rulesNr.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.RULES_NR.getColumn() + ":" + this.rulesNr;
        }
        if (!this.treesNr.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.TREES_NR.getColumn() + ":" + this.treesNr;
        }
        if (!this.typesNr.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.TYPES_NR.getColumn() + ":" + this.typesNr;
        }
        if (!this.useCanonicalModel.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.USE_CANONICAL_MODEL.getColumn() + ":" + this.useCanonicalModel;
        }
        if (!this.useNotExistingField.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.USE_NOT_EXISTING_FIELD.getColumn() + ":" + this.useNotExistingField;
        }
        if (!this.usePool.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvSessionFileColumns.USE_POOL.getColumn() + ":" + this.usePool;
        }
    }
}
