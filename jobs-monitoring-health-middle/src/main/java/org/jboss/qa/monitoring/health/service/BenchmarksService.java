package org.jboss.qa.monitoring.health.service;

import org.jboss.qa.monitoring.health.dao.BenchmarksRepository;
import org.jboss.qa.monitoring.health.model.BenchmarksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenchmarksService {

    @Autowired
    BenchmarksRepository benchmarksRepository;

    public BenchmarksEntity updateBenchmarks(BenchmarksEntity benchmarksEntity){
        return benchmarksRepository.save(benchmarksEntity);
    }

}
