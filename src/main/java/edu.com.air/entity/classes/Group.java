package edu.com.air.entity.classes;

import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.entity.interfaces.impl.Developer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Mentor> mentors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Analytic> analytics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Developer> developers;

    @Column(name="number_of_students")
    private int numberOfStudents;

}
