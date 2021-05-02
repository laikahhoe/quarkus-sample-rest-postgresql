package com.justexample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "fruit", schema = "demo")
public class Fruit extends PanacheEntityBase {
    
    @Id
    @SequenceGenerator(
            name = "fruitSequence",
            sequenceName = "demo.fruit_sequence",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruitSequence")
    public Integer id;

    public String name;
    public String description;

}