package edu.com.air.entity.classes;

import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.entity.interfaces.impl.Developer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "mentors")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "mentor_developer",
                joinColumns = {@JoinColumn(name = "mentor_id")},
                inverseJoinColumns = {@JoinColumn(name = "developer_id")})
    private List<Developer> studentsDeveloper;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "mentor_analytic",
            joinColumns = {@JoinColumn(name = "mentor_id")},
            inverseJoinColumns = {@JoinColumn(name = "analytic_id")})
    private List<Analytic> studentsAnalytic;

    public Mentor(String name, int age){
        this.name = name;
        this.age = age;
    }
}
