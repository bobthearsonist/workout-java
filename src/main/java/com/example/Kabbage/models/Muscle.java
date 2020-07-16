package com.example.Kabbage.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Muscle {
    @Id
    private Long id;
    private String name;
}