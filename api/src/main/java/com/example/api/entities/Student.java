package com.example.api.entities;

/**
 * @author - Anuradha Ranasinghe on 2021-07-07
 * @project - GuavaCache
 **/
public class Student {

    String id;
    String name;
    String dpt;

    public Student(String id, String name, String dpt) {
        super();
        this.id = id;
        this.name = name;
        this.dpt = dpt;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

}
