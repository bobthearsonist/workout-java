package com.example.Kabbage.repositories;

import com.example.Kabbage.models.Workout;

import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
}