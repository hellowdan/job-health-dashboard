package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.jboss.qa.monitoring.health.model.StatusEntity;
import org.json.simple.JSONObject;

public class StatusData {

    public StatusData() {
    }

    public StatusEntity getParsedStatusData(JSONObject statusRowJSON, JobsEntity jobsEntity) {
        StatusRow statusRow = new StatusRow(statusRowJSON);

        StatusEntity statusEntity = new StatusEntity(statusRow, jobsEntity);

        return statusEntity;
    }
}
