package edu.com.air.entity.interfaces.impl;

import edu.com.air.entity.interfaces.Student;
import edu.com.air.entity.classes.Group;
import edu.com.air.entity.classes.Mentor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "analytics")
public class Analytic implements Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group")
    private Group group;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "studentsAnalytic")
    private List<Mentor> mentors;



    public Analytic(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void addMentor(Mentor mentor) {
        mentors.add(mentor);
    }
}
