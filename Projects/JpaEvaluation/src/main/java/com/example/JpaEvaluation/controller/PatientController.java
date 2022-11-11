package com.example.JpaEvaluation.controller;

import com.example.JpaEvaluation.model.dto.TestResultDto;
import com.example.JpaEvaluation.service.DiagnosisService;
import com.example.JpaEvaluation.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zulfa Attar
 */
@RestController
public class PatientController {

    @Autowired
    DiagnosisService diagnosisService;

    @Autowired
    TestResultService testResultService;

    @PostMapping("/getDiagnosis/{patientId}")
    public ResponseEntity getDiagnosis(@PathVariable String patientId) {
        try {
            return new ResponseEntity(diagnosisService.getDiagnosis(Long.parseLong(patientId)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addResult")
    public ResponseEntity getResults(@RequestBody TestResultDto testResultDto){
        try{
            return new ResponseEntity(testResultService.addResult(testResultDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
