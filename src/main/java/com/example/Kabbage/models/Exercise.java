package com.example.Kabbage.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Exercise {
    @Id
    @GeneratedValue
    Long id;
    private String name;

    @ManyToMany
    private Collection<Muscle> primaryMuscles;
    @ManyToMany
    private Collection<Muscle> secondaryMuscles;
    @ManyToMany
    private Collection<Muscle> tertiaryMuscles;
}