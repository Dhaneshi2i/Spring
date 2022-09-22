package com.ideas2it.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@NamedQueries(
        { @NamedQuery(
                name = "findTrainer",
                query = "from Trainer where isActiveEmployee = :isActiveEmployee"
        ),
                @NamedQuery(
                        name = "findTrainerById",
                        query = "from Trainer where employeeId = :employeeId AND isActiveEmployee = :isActiveEmployee"
                )}
)
@Table(name = "Trainer")
public class Trainer extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Trainer_GEN")
    @SequenceGenerator(name = "Trainer_GEN", sequenceName = "Trainer_SEQ")
    @Column(name = "trainer_id", nullable = false)
    private int trainerId;

    @Column
    private byte projectsWorked;

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setProjectsWorked(byte projectsWorked) {
        this.projectsWorked = projectsWorked;
    }

    public byte getProjectsWorked() {
        return projectsWorked;
    }
}
