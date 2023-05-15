package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity(name="play_list")
public class PlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean open;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties({"authoredTracks"})
    private UserEntity owner;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonIgnoreProperties("artists")
    private Set<TrackEntity> trackEntities;

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
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

    public void addTrack(TrackEntity trackEntity) {
        this.trackEntities.add(trackEntity);
    }
}
