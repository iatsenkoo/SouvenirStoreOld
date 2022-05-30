package com.example.demo2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Factory implements Serializable {
    private int id;
    private String name;
    private String country;
}
