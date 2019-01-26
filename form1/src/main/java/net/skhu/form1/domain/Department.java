package net.skhu.form1.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="departmentName")
    String name;
}
