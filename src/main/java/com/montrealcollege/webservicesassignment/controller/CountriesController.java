package com.montrealcollege.webservicesassignment.controller;

import com.montrealcollege.webservicesassignment.model.Countries;
import com.montrealcollege.webservicesassignment.model.CountryList;
import com.montrealcollege.webservicesassignment.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    @Autowired
    private CountriesService service;

    @Autowired
    Countries country;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_XML_VALUE)
    public CountryList showCountries(){
        return new CountryList(service.showCountries());
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_XML_VALUE)
    public Countries createCountry(@RequestParam(name = "countryId") String countryId,
                                   @RequestParam(name = "countryName") String countryName,
                                   @RequestParam(name = "regionId") Integer regionId) {
        country.setCountryId(countryId);
        country.setCountryName(countryName);
        country.setRegionId(regionId);
        service.createCountry(country);
        return country;
    }
}
