package edu.com.air.entity.classes;

import edu.com.air.entity.interfaces.impl.Analytic;
import edu.com.air.entity.interfaces.impl.Developer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groups_table")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group_column")
    private List<Mentor> mentors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group_column")
    private List<Analytic> analytics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group_column")
    private List<Developer> developers;

    public Group(String type) {
        this.type = type;
    }

    public void addMentor(Mentor mentor) {
        this.mentors.add(mentor);
    }

    public void addAnalytic(Analytic analytic) {
        this.analytics.add(analytic);
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }
}
