package org.jboss.qa.monitoring.health.service;

import org.jboss.qa.monitoring.health.dao.StatusRepository;
import org.jboss.qa.monitoring.health.model.StatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStatusService {

    @Autowired
    StatusRepository statusRepository;

    public StatusEntity updateStatus(StatusEntity statusEntity){
        return statusRepository.save(statusEntity);
    }
}
