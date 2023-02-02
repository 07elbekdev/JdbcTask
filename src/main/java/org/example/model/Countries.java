package org.example.model;

public class Countries {
    private Long id;
    private String name;

    public Countries() {
    }

    public Countries(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Countries { " +
                "id=" + id +
                ", name='" + name + '\'' +
                " } ";
    }
}