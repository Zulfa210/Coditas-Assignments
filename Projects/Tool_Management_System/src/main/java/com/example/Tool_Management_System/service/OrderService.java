package com.example.Tool_Management_System.service;

import com.example.Tool_Management_System.entities.Order;
import com.example.Tool_Management_System.entities.Tool;
import com.example.Tool_Management_System.entities.Worker;
import com.example.Tool_Management_System.repository.OrderRepository;
import com.example.Tool_Management_System.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author Zulfa Attar
 */
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    WorkerRepository workerRepository;
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Worker insertOrder(Worker worker){
        Worker orderWorker = workerRepository.findById(worker.getWorkerId()).orElse(null);
        Set<Order> orders = orderWorker.getWorker_orders();
        Set<Order> addedOrders = worker.getWorker_orders();
        float totalPrice = 0;
        for(Order order: addedOrders){

            for(Tool tool: order.getOrderedTools()){
                totalPrice +=tool.getToolPrice();
            }
            order.setOrderTotalPrice(totalPrice);
            order.setWorker(orderWorker);
            orders.add(order);
            System.out.println(order);

        }
        return workerRepository.save(orderWorker);
    }


    public int updateOrder(Order order){
        Order orderPresent = orderRepository.findById(order.getOrderId()).orElse(null);

//        Worker orderWorker = workerRepository.findById(worker.getWorkerId()).orElse(null);
//        Set<Order> orders = orderWorker.getWorker_orders();
//        Set<Order> addedOrders = worker.getWorker_orders();
//        if(orderWorker != null) {
//            float totalPrice = 0;
//            for (Order order : addedOrders) {
//
//                for (Tool tool : order.getOrderedTools()) {
//                    totalPrice += tool.getToolPrice();
//                }
//                order.setOrderTotalPrice(totalPrice);
//                order.setWorker(orderWorker);
//                orders.add(order);
//                System.out.println(order);
//
//            }
//             workerRepository.save(orderWorker);
//            return 1;
//        }
//        return 0;

        if(orderPresent!= null){
            orderRepository.save(order);
            return 1;
        }
        return 0;
    }

    public Set<Order> getOrdersByWorkerId(Long workerId) {
        Worker worker = workerRepository.findById(workerId).orElse(null);
        if (worker != null) {
            return worker.getWorker_orders();
        }
        else {
            return null;
        }
    }

}
