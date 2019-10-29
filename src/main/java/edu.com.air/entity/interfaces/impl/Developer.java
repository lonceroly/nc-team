package edu.com.air.entity.interfaces.impl;

import edu.com.air.entity.classes.Group;
import edu.com.air.entity.classes.Mentor;
import edu.com.air.entity.interfaces.Student;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "developers_table")
public class Developer implements Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private Group group_column;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "studentsDeveloper")
    private List<Mentor> mentors;

}
