package com.ideas2it.entity;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(
                name = "findTrainer",
                query = "from Trainer where isActiveEmployee = :isActiveEmployee"
        ),
                @NamedQuery(
                name = "findTrainerById",
                query = "from Trainer where employeeId = :employeeId AND isActiveEmployee = :isActiveEmployee"
        ),
                @NamedQuery(
                name = "findByTrainerId",
                query = "from Trainer where trainer_id = :trainer_id AND isActiveEmployee = :isActiveEmployee"
                )
        }
)
@Table(name = "Trainer")
public class Trainer extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Trainer_GEN")
    @SequenceGenerator(name = "Trainer_GEN", sequenceName = "Trainer_SEQ")
    @Column(nullable = false)
    private int trainerId;
    @NotNull
    private byte projectsWorked;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Link_employees",
            joinColumns =@JoinColumn(name="TrainerId"),
            inverseJoinColumns =@JoinColumn(name="TraineeId"))
    private List<Trainee> trainees;

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

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }
}
