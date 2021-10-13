package org.jboss.qa.monitoring.health.dao;

import org.jboss.qa.monitoring.health.model.JobsLastBuildEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsLastBuildRepository extends CrudRepository<JobsLastBuildEntity, Long> {

}
