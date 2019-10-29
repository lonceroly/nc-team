package edu.com.air.entity.classes;

import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.entity.interfaces.impl.Developer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "mentors_table")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group_column;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "mentor_developer",
                joinColumns = {@JoinColumn(name = "mentor_id")},
                inverseJoinColumns = {@JoinColumn(name = "developer_id")})
    private List<Developer> studentsDeveloper;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "mentor_analytic",
            joinColumns = {@JoinColumn(name = "mentor_id")},
            inverseJoinColumns = {@JoinColumn(name = "analytic_id")})
    private List<Analytic> studentsAnalytic;

    public Mentor(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setGroup(Group group) {
        this.group_column = group;
    }

    public void addDeveloper(Developer developer) {
        this.studentsDeveloper.add(developer);
    }

    public void addAnalytic(Analytic analytic) {
        this.studentsAnalytic.add(analytic);
    }
}
