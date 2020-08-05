package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping(value = "/updateStatus")
    public ResponseEntity<Void> updateStatus() {
        HttpHeaders headers = new HttpHeaders();

        String result = statusService.updateStatus();

        if (result.equals("SUCCESS")) {
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAIL", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/test")
    public String test(){
        return "Sucesso!";
    }
}
