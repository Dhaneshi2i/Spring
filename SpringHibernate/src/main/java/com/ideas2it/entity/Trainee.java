package com.ideas2it.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(
                name = "findTrainee",
                query = "from Trainee where isActiveEmployee = :isActiveEmployee"
        ),
                @NamedQuery(
                name = "findTraineeById",
                query = "from Trainee where employeeId = :employeeId AND isActiveEmployee = :isActiveEmployee"
        ),
                @NamedQuery(
                name = "findByTraineeId",
                query = "from Trainee where traineeId = :traineeId AND isActiveEmployee = :isActiveEmployee"
        )
        }
)
@Entity
@Table(name = "Trainee")
public class Trainee extends Employee {
    public Trainee() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int traineeId;
    private String reportingManager;
    @ManyToMany(mappedBy = "trainees", fetch = FetchType.EAGER)
    private List<Trainer> trainers;

    public Trainee(String reportingManager) {
        this.reportingManager = reportingManager;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

}

