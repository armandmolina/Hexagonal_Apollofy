package cat.tecnocampus.apollofy.track.domain;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LikeTrack {

    private Long id;

    private Boolean liked;

    private LocalDateTime date;

    private UserFy userFy;

    private Track track;

    public LikeTrack(UserFy userFy, Track track) {
        this.userFy = userFy;
        this.track = track;
        this.date = LocalDateTime.now();
        this.liked = true;
    }

    public LikeTrack() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public UserFy getUserFy() {
        return userFy;
    }

    public void setUserFy(UserFy userFy) {
        this.userFy = userFy;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
