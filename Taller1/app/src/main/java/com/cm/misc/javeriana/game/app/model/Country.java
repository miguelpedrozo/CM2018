package com.cm.misc.javeriana.game.app.model;

public class Country {
    private String countryName;
    private String intCountryName;
    private String capitol;
    private String shortName;

    public Country() {
    }

    public Country(String countryName, String intCountryName, String capitol, String shortName) {
        this.countryName = countryName;
        this.intCountryName = intCountryName;
        this.capitol = capitol;
        this.shortName = shortName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIntCountryName() {
        return intCountryName;
    }

    public void setIntCountryName(String intCountryName) {
        this.intCountryName = intCountryName;
    }

    public String getCapitol() {
        return capitol;
    }

    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
