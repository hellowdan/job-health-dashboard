package org.jboss.qa.monitoring.health.dao;

import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends CrudRepository<JobsEntity, Long> {

}
