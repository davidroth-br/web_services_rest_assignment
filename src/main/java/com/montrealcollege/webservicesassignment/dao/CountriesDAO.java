package com.montrealcollege.webservicesassignment.dao;

import com.montrealcollege.webservicesassignment.model.Countries;

import java.util.List;

public interface CountriesDAO {

    void addCountry(Countries country);

    List<Countries> listCountries();
}
