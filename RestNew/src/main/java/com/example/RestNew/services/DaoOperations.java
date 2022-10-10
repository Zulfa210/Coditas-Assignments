package com.example.RestNew.services;

import com.example.RestNew.entity.Scientist;

import java.util.HashMap;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface DaoOperations {

    public Scientist fetchScientistById(int id);
     public HashMap<String, List> fetchAllIdAndUsername();

     public HashMap<String, List> invalidUrlException();
}
