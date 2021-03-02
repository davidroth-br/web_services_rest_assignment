package com.montrealcollege.webservicesassignment.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
@Component
@Entity
@Table(name = "COUNTRIES")
public class Countries {

    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Column(name = "REGION_ID")
    private Integer regionId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}
