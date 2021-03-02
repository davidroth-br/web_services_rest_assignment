package com.montrealcollege.webservicesassignment.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CountryList {

    private static final long serialVersionUID = 22L;

    private List<Countries> countries = new ArrayList<>();

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }

    public CountryList(List<Countries> countries) {
        this.countries = countries;
    }

    public CountryList() {
    }
}
