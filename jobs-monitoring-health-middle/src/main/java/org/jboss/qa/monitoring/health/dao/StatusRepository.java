package org.jboss.qa.monitoring.health.dao;

import org.jboss.qa.monitoring.health.model.StatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<StatusEntity, Long> {

}
