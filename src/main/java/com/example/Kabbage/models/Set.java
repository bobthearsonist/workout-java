package com.example.Kabbage.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Integer reps;

    @OneToMany
    private Collection<Exercise> exercises;
}