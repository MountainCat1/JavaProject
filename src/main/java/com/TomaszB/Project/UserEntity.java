package com.TomaszB.Project;

public class UserEntity {
    private String name;
    private String email;



    private int id;

    public UserEntity(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() { return id;}

    public void setId(int id) { this.id = id; }
}
