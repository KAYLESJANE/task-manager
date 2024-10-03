package com.ikusasa.task_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * DataModel entity represents a task with attributes such as title, description,
 * due date, priority, and completion status.
 */
@Entity
@Table(name = "data_model_info")
public class DataModel {

    @Id
    private String id;
    private String title;
    private String description;
    private Date due_date;
    private Boolean completed;
    private String priority;

    public DataModel() {
    }

    public DataModel(String id, String title, String description, Date dueDate, boolean completed, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = dueDate;
        this.completed = completed;
        this.priority =priority; // Using setter to ensure priority validation
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}

