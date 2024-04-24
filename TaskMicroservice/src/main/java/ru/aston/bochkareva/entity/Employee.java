package ru.aston.bochkareva.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees", schema = "consumer")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Override
    public String toString() {
        return "Employee " + name + ' ' + surname + ", task: " + task.getTitle();
    }
}
