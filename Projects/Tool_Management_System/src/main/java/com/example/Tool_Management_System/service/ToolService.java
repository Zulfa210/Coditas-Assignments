package com.example.Tool_Management_System.service;

import com.example.Tool_Management_System.entities.Tool;
import com.example.Tool_Management_System.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Zulfa Attar
 */
@Service
public class ToolService {

    @Autowired
    ToolRepository toolRepository;

    public List<Tool> getTools(){
        return toolRepository.findAll();
    }

    public Tool insertTool(Tool tool){
        return toolRepository.save(tool);
    }

    public void deleteTool(Long toolId){
        toolRepository.deleteById(toolId);
    }

    public int updateTool(Tool tool){
        Tool updatableTool = toolRepository.findById(tool.getToolId()).orElse(null);

        if(updatableTool!= null){
            toolRepository.save(tool);
            return 1;
        }
        return 0;
    }

}
