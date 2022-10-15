package com.example.Tool_Management_System.service;

import com.example.Tool_Management_System.entities.Tool;
import com.example.Tool_Management_System.entities.Worker;
import com.example.Tool_Management_System.repository.ToolRepository;
import com.example.Tool_Management_System.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zulfa Attar
 */
@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }

    public Worker insertWorker(Worker worker){

        return workerRepository.save(worker);
    }

    public void deleteWorker(Long workerId){
        workerRepository.deleteById(workerId);
    }

    public int updateWorker(Worker worker){
        Worker workerPresent = workerRepository.findById(worker.getWorkerId()).orElse(null);

        if(workerPresent!= null){
            workerRepository.save(worker);
            return 1;
        }
        return 0;
    }
}
