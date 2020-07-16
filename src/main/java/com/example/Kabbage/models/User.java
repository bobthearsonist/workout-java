package com.example.Kabbage.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class User {
    @Id
    @GeneratedValue
    Long id;
    private String userName;
    private String name; // use lib for parsing first/last/sir/etc leaves abstracted

    @OneToOne
    private Body body;

    @OneToMany
    private Collection<Workout> workouts;
}