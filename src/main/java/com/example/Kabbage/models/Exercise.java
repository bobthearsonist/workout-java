package com.example.Kabbage.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Exercise {
    @Id
    @GeneratedValue
    Long id;
    private String name;

    @OneToMany
    private Collection<Muscle> primaryMuscles;
    @OneToMany
    private Collection<Muscle> secondaryMuscles;
    @OneToMany
    private Collection<Muscle> tertiaryMuscles;
}