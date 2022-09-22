package com.ideas2it.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@NamedQueries(
        { @NamedQuery(
                name = "findTrainee",
                query = "from Trainee where isActiveEmployee = :isActiveEmployee"
        ),
                @NamedQuery(
                        name = "findTraineeById",
                        query = "from Trainee where employeeId = :employeeId AND isActiveEmployee = :isActiveEmployee"
                )}
)
@Entity
@Table(name = "Trainee")
public class Trainee extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainee_id", nullable = false)
    private int traineeId;
    private String reportingManager;
    public Trainee() {
    }
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


}

