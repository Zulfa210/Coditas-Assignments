package com.example.JpaEvaluation.service;

import com.example.JpaEvaluation.entities.Diagnosis;
import com.example.JpaEvaluation.entities.Test;
import com.example.JpaEvaluation.entities.TestResults;
import com.example.JpaEvaluation.model.dto.TestResultDto;
import com.example.JpaEvaluation.repository.DiagnosisRepository;
import com.example.JpaEvaluation.repository.TestRepository;
import com.example.JpaEvaluation.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zulfa Attar
 */
@Service
public class TestResultServiceImpl implements TestResultService{

    @Autowired
    DiagnosisRepository diagnosisRepository;

    @Autowired
    TestResultRepository testResultRepository;

    @Autowired
    TestRepository testRepository;

    @Override
    public TestResults getResults(long diagnosisId) {
        Diagnosis diagnosis = diagnosisRepository.findById(diagnosisId).orElse(null);
        if(diagnosis!= null){
            return testResultRepository.findByDiagnosis(diagnosis);
        }
        return null;
    }

    @Override
    public TestResults addResult(TestResultDto testResultDto) {

        Diagnosis diagnosis =diagnosisRepository.findById(testResultDto.getDiagnosisId()).orElse(null);
        if(diagnosis!= null){
            TestResults testResults = new TestResults();
            testResults.setDiagnosis(diagnosis);
            Map<Float, Test> testValues = new HashMap<>();

            String comment = "";
            List<Test> testList = diagnosis.getTestsList();
            for(Map.Entry<Long, Float> element: testResultDto.getResults().entrySet() ) {

                    Test myTest = testRepository.findById(element.getKey()).orElse(null);
                    if(element.getValue()<myTest.getTestMinValue() ){
                         comment += " Low " + myTest.getTestName() ;
                    }else if(element.getValue()>myTest.getTestMaxValue()){
                        comment += " High " + myTest.getTestName();
                    }

                    testValues.put(element.getValue(), myTest);

            }
            testResults.setTestComment(comment);
            testResults.setTestValues(testValues);
            return testResultRepository.save(testResults);
        }

        return null;
    }
}
