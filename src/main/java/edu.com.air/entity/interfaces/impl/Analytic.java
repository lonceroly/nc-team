package edu.com.air.entity.interfaces.impl;

import edu.com.air.entity.classes.Group;
import edu.com.air.entity.classes.Mentor;
import edu.com.air.entity.interfaces.Student;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "analytics_table")
@RequiredArgsConstructor
public class Analytic implements Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_column")
    private Group group_column;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "studentsAnalytic")
    private List<Mentor> mentors;

    public Analytic(Group group, String name, int age, List<Mentor> mentors) {
        this.group_column = group;
        this.name = name;
        this.age = age;
        this.mentors = mentors;
    }

    public Analytic(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
