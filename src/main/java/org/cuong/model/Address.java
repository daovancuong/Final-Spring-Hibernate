package org.cuong.model;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
public class Address {
    private String city;
    private String street;
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", street=" + street + "]";
    }
    
    
}
