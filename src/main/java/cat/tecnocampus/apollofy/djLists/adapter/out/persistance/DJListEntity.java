package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "dj_list")
public class DJListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties({"authoredTracks"})
    private UserEntity owner;

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

}
