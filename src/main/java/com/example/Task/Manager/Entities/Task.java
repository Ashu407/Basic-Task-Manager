package com.example.Task.Manager.Entities;


import com.example.Task.Manager.Entities.Enums.Priority;
import com.example.Task.Manager.Entities.Enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority taskPriority;

    @Enumerated(EnumType.STRING)
    private Status taskStatus;






}


