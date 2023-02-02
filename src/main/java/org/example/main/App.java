package org.example.main;

import org.example.model.Cities;
import org.example.model.Countries;
import org.example.model.Presidents;
import org.example.repository.CountryRepoImpl;
import org.example.repository.PresidentRepoImpl;
import org.example.repository.RepositoryImpl;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Cities cities = new Cities(1l,"Berlin");
        Cities cities1 = new Cities(2l,"London");
        Cities cities2 = new Cities(3l,"JalalAbad");
        RepositoryImpl repository = new RepositoryImpl();
       // repository.save(cities);
        /////////////////////////////////////////////////////////
        Countries countries = new Countries(1l,"America");
        Countries countries1 = new Countries(2l,"Britain");
        Countries countries2 = new Countries(3l,"Austria");
        CountryRepoImpl countryRepo = new CountryRepoImpl();
        //System.out.println(countryRepo.findAll());
        ////////////////////////////////////////////////////////
        Presidents presidents = new Presidents(1l,"Sadyr Japarov");
        Presidents presidents1 = new Presidents(2l,"Vladimir Putin");
        Presidents presidents2 = new Presidents(3l,"Zidane");
        PresidentRepoImpl presidentRepo = new PresidentRepoImpl();
        System.out.println(presidentRepo.findAll());
    }
}