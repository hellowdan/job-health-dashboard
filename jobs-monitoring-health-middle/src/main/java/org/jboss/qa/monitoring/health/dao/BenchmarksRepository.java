package org.jboss.qa.monitoring.health.dao;

import org.jboss.qa.monitoring.health.model.BenchmarksEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchmarksRepository extends CrudRepository<BenchmarksEntity, Long> {

}
