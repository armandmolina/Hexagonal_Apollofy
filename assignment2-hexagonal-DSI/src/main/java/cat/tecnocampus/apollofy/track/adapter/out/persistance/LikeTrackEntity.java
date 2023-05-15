package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name="like_track")
public class LikeTrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "liked")
    private Boolean liked;

    //https://thorben-janssen.com/persist-creation-update-timestamps-hibernate/
    @UpdateTimestamp
    private LocalDateTime date;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("likeTracks")
    private UserEntity userEntity;



    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("likeTracks")
    private TrackEntity trackEntity;

    public LikeTrackEntity(UserEntity userEntity, TrackEntity trackEntity) {
        this.userEntity = userEntity;
        this.trackEntity = trackEntity;
        this.date = LocalDateTime.now();
        this.liked = true;
    }

    public LikeTrackEntity() {
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public TrackEntity getTrack() {
        return trackEntity;
    }

    public void setTrack(TrackEntity trackEntity) {
        this.trackEntity = trackEntity;
    }
    public void setTrackEntity(TrackEntity trackEntity) {
        this.trackEntity = trackEntity;
    }
}
