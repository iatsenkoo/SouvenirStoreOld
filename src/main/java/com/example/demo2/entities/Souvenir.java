package com.example.demo2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Souvenir implements Serializable {
    private int id;
    private String name;
    private Factory factory;
    private LocalDate dateOfProduction;
    private double price;
}
