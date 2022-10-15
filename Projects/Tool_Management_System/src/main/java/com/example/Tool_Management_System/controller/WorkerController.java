package com.example.Tool_Management_System.controller;

import com.example.Tool_Management_System.entities.Order;
import com.example.Tool_Management_System.entities.Worker;
import com.example.Tool_Management_System.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Zulfa Attar
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity insertOrder(@RequestBody Worker worker){
        try{
            orderService.insertOrder(worker);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateOrder")
    public ResponseEntity updateOrder(@RequestBody Order order) {
        try {
            return new ResponseEntity(Optional.of(orderService.updateOrder(order)), HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
