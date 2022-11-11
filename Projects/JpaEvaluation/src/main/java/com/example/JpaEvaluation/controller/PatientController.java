package com.example.JpaEvaluation.controller;

import com.example.JpaEvaluation.entities.Patient;
import com.example.JpaEvaluation.model.dto.TestResultDto;
import com.example.JpaEvaluation.service.DiagnosisService;
import com.example.JpaEvaluation.service.PatientService;
import com.example.JpaEvaluation.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zulfa Attar
 */
@RestController
public class PatientController {

    @Autowired
    DiagnosisService diagnosisService;

    @Autowired
    TestResultService testResultService;

    @Autowired
    PatientService patientService;

    @PostMapping("/getDiagnosis/{patientId}")
    public ResponseEntity getDiagnosis(@PathVariable String patientId) {
        try {
            return new ResponseEntity(diagnosisService.getDiagnosis(Long.parseLong(patientId)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addResult")
    public ResponseEntity addResults(@RequestBody TestResultDto testResultDto){
        try{
            return new ResponseEntity(testResultService.addResult(testResultDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getResult/{diagnosisId}")
    public ResponseEntity getResults(Long diagnosisId){
        try{
            return new ResponseEntity(testResultService.getResults(diagnosisId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registerPatient")
    public ResponseEntity registerPatient(@RequestBody Patient patient){
        try{
            return new ResponseEntity(patientService.addPatient(patient), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
