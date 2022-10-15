package com.example.Tool_Management_System.controller;

import com.example.Tool_Management_System.entities.Tool;
import com.example.Tool_Management_System.entities.Worker;
import com.example.Tool_Management_System.service.ToolService;
import com.example.Tool_Management_System.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author Zulfa Attar
 */
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    ToolService toolOperations;

    @Autowired
    WorkerService workerService;

    @RequestMapping(value = "/showTools", method = RequestMethod.GET)
    public ResponseEntity fetchTools(){

        try{
            List<Tool> tools = toolOperations.getTools();
            HashMap map = new HashMap();
            if(tools.size() > 0){
                map.put("data", tools);
                map.put("error", null);
                return new ResponseEntity(map, HttpStatus.OK);
            }
            else{
                map.put("data", null);
                map.put("error", "No data Exists in Database");
                return ResponseEntity.of(Optional.of(map));
            }

        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/createTool")
    public ResponseEntity createTool(@RequestBody Tool tool){
        try{
            return new ResponseEntity(Optional.of(toolOperations.insertTool(tool)), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteTool/{toolId}")
    public ResponseEntity deleteTool(@PathVariable(value = "toolId") Long toolId){
        try{
            toolOperations.deleteTool(toolId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateTool")
    public ResponseEntity updateTool(@RequestBody Tool tool){
        try{
            return new ResponseEntity(Optional.of(toolOperations.updateTool(tool)), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createWorker")
    public ResponseEntity createWorker(@RequestBody Worker worker){
        try{
            return new ResponseEntity(Optional.of(workerService.insertWorker(worker)), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/showWorkers", method = RequestMethod.GET)
    public ResponseEntity fetchWorkers(){

        try{
            List<Worker> workers = workerService.getWorkers();
            HashMap map = new HashMap();
            if(workers.size() > 0){
                map.put("data", workers);
                map.put("error", null);
                return new ResponseEntity(map, HttpStatus.OK);
            }
            else{
                map.put("data", null);
                map.put("error", "No data Exists in Database");
                return ResponseEntity.of(Optional.of(map));
            }

        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteWorker/{workerId}")
    public ResponseEntity deleteWorker(@PathVariable(value = "workerId") Long workerId){
        try{
           workerService.deleteWorker(workerId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateWorker")
    public ResponseEntity updateWorker(@RequestBody Worker worker){
        try{
            return new ResponseEntity(Optional.of(workerService.updateWorker(worker)), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
