package com.example.Event_Management_System.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "Event_Category")
public class EventCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id" , nullable = false,updatable = false)
    private long categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @JsonIgnore
    @OneToMany(mappedBy = "eventCategory", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();

    public EventCategory(long categoryId, String categoryName, boolean isDeleted) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "EventCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
