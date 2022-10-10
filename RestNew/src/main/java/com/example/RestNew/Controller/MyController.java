package com.example.RestNew.Controller;

import com.example.RestNew.entity.Scientist;
import com.example.RestNew.services.DaoOperations;
import com.example.RestNew.services.DaoOperationsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author Zulfa Attar
 */
@RestController
@CrossOrigin(origins={"*"} , maxAge = 4800,allowCredentials = "false")
public class MyController {


    @Autowired
    DaoOperations operations;

    @CrossOrigin
    @GetMapping("/fetchAll")
    public HashMap<String, List> showAll(){
        return operations.fetchAllIdAndUsername();
    }
    @CrossOrigin
    @GetMapping("/fetch/{scientistId}")
    public ResponseEntity showScientist(@PathVariable int scientistId){

        Scientist scientist =  operations.fetchScientistById(scientistId);
        if(scientist!= null){
            return ResponseEntity.of(Optional.of(scientist));
        }else {
            HashMap hashMap = new HashMap();
            hashMap.put("error", "Invalid Id");
            return ResponseEntity.of(Optional.of(hashMap));
        }
    }
//    @CrossOrigin
//    @GetMapping("/fetch")
//    public HashMap<String, List> showScientistError(){
//        return operations.invalidUrlException();
//    }

    @CrossOrigin
    @GetMapping("/**")
    public HashMap showNull(){
        operations = new DaoOperationsImplementation();
        return operations.invalidUrlException();
    }
}
