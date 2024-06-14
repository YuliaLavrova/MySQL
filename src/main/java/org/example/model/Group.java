package org.example.model;

public class Group {

    private int id;

    private String number;

    public Group(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
