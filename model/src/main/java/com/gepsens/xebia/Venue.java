package com.gepsens.xebia;

import java.util.Date;
import java.util.List;

public class Venue extends Artefact {

    Date occurence;

    GeoLocation place;

    String city;

    String country;

    String name;

    List<Artist> artists;

    public Date getOccurence() {
        return occurence;
    }

    public void setOccurence(Date occurence) {
        this.occurence = occurence;
    }

    public GeoLocation getPlace() {
        return place;
    }

    public void setPlace(GeoLocation place) {
        this.place = place;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
