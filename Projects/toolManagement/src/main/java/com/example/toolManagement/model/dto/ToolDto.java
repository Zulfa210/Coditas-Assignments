package com.example.toolManagement.model.dto;

/**
 * @author Zulfa Attar
 */

public class ToolDto {
    private Long toolId;
    private int toolQuantity;

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public int getToolQuantity() {
        return toolQuantity;
    }

    public void setToolQuantity(int toolQuantity) {
        this.toolQuantity = toolQuantity;
    }
}
