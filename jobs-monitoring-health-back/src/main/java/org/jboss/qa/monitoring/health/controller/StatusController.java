package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        if (result.contains("SUCCESS")) {
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAIL", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/updateStatusSubfolder/{subfolder}")
    public ResponseEntity<Void> updateStatusSubfolder(@PathVariable("subfolder") String subfolder) {
        HttpHeaders headers = new HttpHeaders();

        String result = statusService.updateStatusSubfolder(subfolder);

        if (result.contains("SUCCESS")) {
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAIL", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/updateStatus/{job}")
    public ResponseEntity<Void> updateStatus(@PathVariable("job") String job) {
        HttpHeaders headers = new HttpHeaders();

        String result = statusService.updateStatus(job);

        if (result.contains("SUCCESS")) {
            headers.add("SUCCESS", result);
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
