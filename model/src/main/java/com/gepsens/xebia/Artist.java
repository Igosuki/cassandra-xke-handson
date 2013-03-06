package com.gepsens.xebia;

import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist extends Artefact {

    String name;

    GeoLocation location;

    @JsonProperty("similar")
    List<Artist> similar;

    public List<Artist> getSimilar() {
        return similar;
    }

    public void setSimilar(List<Artist> similar) {
        this.similar = similar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", similar=" + similar +
                "} " + super.toString();
    }
}
