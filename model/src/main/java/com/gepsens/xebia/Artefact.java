package com.gepsens.xebia;

import javax.persistence.Entity;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
    @JsonSubTypes.Type(value = Artist.class, name = "artist"),
    @JsonSubTypes.Type(value = Track.class, name = "track"),
    @JsonSubTypes.Type(value = Venue.class, name = "venue")
})
@Entity
public abstract class Artefact {

    @JsonProperty("mbid")
    protected UUID id;

    protected Integer likes;

    protected Integer hits;

    protected List<String> tags;

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artefact{" +
                "id=" + id +
                ", likes=" + likes +
                ", hits=" + hits +
                ", tags=" + tags +
                "} " + super.toString();
    }
}
