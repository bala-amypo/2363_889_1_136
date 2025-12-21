package com.example.project.entity;

import java.time.LocalDate;

public class Studententity {

    private String name;
    private int id;
    private LocalDate date;
    private float cgpa;

   

    public Studententity(String name, int id, LocalDate date, float cgpa) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
}