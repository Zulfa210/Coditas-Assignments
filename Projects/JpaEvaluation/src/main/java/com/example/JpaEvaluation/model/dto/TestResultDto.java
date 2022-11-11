package com.example.JpaEvaluation.model.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zulfa Attar
 */
@Data
public class TestResultDto {

    private Long diagnosisId;
    private Map< Long, Float> results= new HashMap<>();
}
