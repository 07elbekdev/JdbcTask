package org.example.model;

public class Cities {
    private Long id;
    private String nameOfCountry;

    public Cities() {
    }

    public Cities(Long id, String nameOfCountry) {
        this.id = id;
        this.nameOfCountry = nameOfCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }
    @Override
    public String toString() {
        return "Cities { " +
                "id=" + id +
                ", nameOfCountry='" + nameOfCountry + '\'' +
                " } ";
    }
}