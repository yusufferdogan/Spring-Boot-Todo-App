package com.yusuferdogan.todoapp.domain;
import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "task")
@Entity()
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String taskName;

    private String taskDescription;

    private Boolean isDone;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task(String taskName, String taskDescription, Boolean isDone) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isDone = isDone;
    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", isDone=" + isDone +
                ", user=" + user.getemail() + "," +user.getPassword() + ", user ID:" + user.getId()+
                '}';
    }
}
