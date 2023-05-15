package cat.tecnocampus.apollofy.djLists.domain;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


public class Playlist {
    private Long id;
    private String title;
    private String description;
    private Boolean open;

    private UserFy owner;

    private Set<TrackEntity> trackEntities;

    public UserFy getOwner() {
        return owner;
    }

    public void setOwner(UserFy owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Set<TrackEntity> getTracks() {
        return trackEntities;
    }

    public void setTracks(Set<TrackEntity> trackEntities) {
        this.trackEntities = trackEntities;
    }

    public void addTrack(TrackEntity t) {
        this.trackEntities.add(t);
    }
}
