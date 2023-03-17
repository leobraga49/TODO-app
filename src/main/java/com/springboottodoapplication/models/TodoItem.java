package com.springboottodoapplication.models;

import com.springboottodoapplication.config.DateConfig;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    public String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private String createdDate;

    @Getter
    @Setter
    private String modifiedDate;

    public TodoItem(){};

    public TodoItem(String description){
        this.description = description;
        this.complete = false;
        this.createdDate = DateConfig.getDate();
        this.modifiedDate = DateConfig.getDate();
    }

    @Override
    public String toString(){
        return String.format("TodoItem{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}",
                id,description,complete,createdDate,modifiedDate);
    }
}
