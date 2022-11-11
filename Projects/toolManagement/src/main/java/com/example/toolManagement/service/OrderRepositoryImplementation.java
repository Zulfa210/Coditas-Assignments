package com.example.toolManagement.service;

/**
 * @author Zulfa Attar
 */

import com.example.toolManagement.entities.Order;
import com.example.toolManagement.entities.OrderToolQuantity;
import com.example.toolManagement.entities.Tool;
import com.example.toolManagement.entities.Worker;
import com.example.toolManagement.model.dto.OrderDto;
import com.example.toolManagement.model.dto.ToolDto;
import com.example.toolManagement.repository.OrderRepository;
import com.example.toolManagement.repository.OrderToolRepository;
import com.example.toolManagement.repository.ToolRepository;
import com.example.toolManagement.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderRepositoryImplementation {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    ToolRepository toolRepository;

    @Autowired
    OrderToolRepository orderToolRepository;

    public Order createOrder(OrderDto orderDto) {
        List<ToolDto> toolDtos = orderDto.getRequiredTools();
        int count = 0;
        float totalPrice = 0;
        List<Tool> tools = new ArrayList<>();
        System.out.println(orderDto);
        while (count < toolDtos.size()) {
            ToolDto toolDto = toolDtos.get(count++);
            Tool tool = toolRepository.findById(toolDto.getToolId()).orElse(null);
            totalPrice = totalPrice + (tool.getToolPrice() * toolDto.getToolQuantity());
            tools.add(tool);
        }

        Order order = new Order();
        order.setOrderStatus("Pending");
        order.setCustomerName(orderDto.getCustomerName());
        order.setWorker(workerRepository.findById(orderDto.getWorkerId()).orElse(null));
        order.setOrderedTools(tools);
        order.setOrderTotalPrice(totalPrice);
        order = orderRepository.save(order);
        System.out.println(order);
        count = 0;
        while (count < toolDtos.size()) {
            ToolDto toolDto = toolDtos.get(count++);

            Tool tool = toolRepository.findById(toolDto.getToolId()).orElse(null);

            OrderToolQuantity orderToolQuantity = new OrderToolQuantity();
            orderToolQuantity.setOrderId(order.getOrderId());
            orderToolQuantity.setToolId(tool.getToolId());
            orderToolQuantity.setToolQuantity(toolDto.getToolQuantity());
            System.out.println(orderToolQuantity);
            orderToolRepository.save(orderToolQuantity);
        }
        System.out.println(orderRepository.findById(order.getOrderId()).orElse(null));
        return orderRepository.findById(order.getOrderId()).orElse(null);
    }

    public List<Order> getOrders() {
        List<Order> orders = orderRepository.findAll();
        if (orders.size() > 0) {
            int count = 0;
            while (count < orders.size()) {
                Order order = orders.get(count++);
                List<Tool> tools = order.getOrderedTools();
                int innerCount = 0;
                Map<Long, Integer> toolsQuantity = new HashMap<>();
                while (innerCount < tools.size()) {
                    Tool tool = tools.get(innerCount++);
                    int toolQuantity = orderToolRepository.findToolquantity(order.getOrderId(), tool.getToolId());
                    toolsQuantity.put(tool.getToolId(), toolQuantity);
                }
                order.setToolsQuantity(toolsQuantity);
            }
            return orders;
        } else {
            return null;
        }
    }

    public Order updateOrder(OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(orderDto.getOrderId()).orElse(null);
//        List<DummyTool> dummyTools = dummyOrder.getRequiredTools();
//        int count = 0;
//        float totalPrice = 0;
//        List<Tool> tools = new ArrayList<>();

//        while (count < dummyTools.size()) {
//            DummyTool dummyTool = dummyTools.get(count++);
//            Tool tool = toolRepository.findById(dummyTool.getToolId()).orElse(null);
//            tool.setToolQuantity(dummyTool.getToolQuantity());
//            totalPrice = totalPrice + (tool.getToolPrice() * dummyTool.getToolQuantity());
//            tools.add(tool);
//        }

        existingOrder.setOrderStatus(orderDto.getOrderStatus());
//        existingOrder.setCustomerName(dummyOrder.getCustomerName());
        //existingOrder.setWorker(workerRepository.findById(dummyOrder.getWorkerId()).orElse(null));
//        existingOrder.setOrderTotalPrice(totalPrice);
//        existingOrder.setOrderedTools(tools);
        return orderRepository.save(existingOrder);
    }

    public List<Order> getOrdersByWorkerId(Long workerId) {
        Worker worker = workerRepository.findById(workerId).orElse(null);
        if (worker != null) {
            List<Order> orders = worker.getWorker_orders();
            int count = 0;
            while (count < orders.size()) {
                Order order = orders.get(count++);
                List<Tool> tools = order.getOrderedTools();
                int innerCount = 0;
                Map<Long, Integer> toolsQuantity = new HashMap<>();
                while (innerCount < tools.size()) {
                    Tool tool = tools.get(innerCount++);
                    int toolQuantity = orderToolRepository.findToolquantity(order.getOrderId(), tool.getToolId());
                    toolsQuantity.put(tool.getToolId(), toolQuantity);
                }
                order.setToolsQuantity(toolsQuantity);
            }
            return orders;
        } else {
            return null;
        }
    }
}