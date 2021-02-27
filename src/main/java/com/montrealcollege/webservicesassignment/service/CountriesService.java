package com.montrealcollege.webservicesassignment.service;

import com.montrealcollege.webservicesassignment.dao.CountriesDAO;
import com.montrealcollege.webservicesassignment.model.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesService {

    @Autowired
    CountriesDAO countriesDAO;

    public void createCountry(Countries country) {
        countriesDAO.addCountry(country);
    }

    public List<Countries> showCountries() {
        return countriesDAO.listCountries();
    }
}
