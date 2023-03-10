package org.example.model;

public class Presidents {
    private Long id;
    private String name;

    public Presidents() {
    }

    public Presidents(Long id, String name) {
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
        return " Presidents " +
                "id=" + id +
                ", name='" + name + '\'' +
                " } ";
    }
}