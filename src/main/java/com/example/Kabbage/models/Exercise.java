package com.example.Kabbage.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
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