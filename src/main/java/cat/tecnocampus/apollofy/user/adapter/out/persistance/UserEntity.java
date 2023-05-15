package cat.tecnocampus.apollofy.user.adapter.out.persistance;

import cat.tecnocampus.apollofy.configuration.security.persistence.Role;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.user.domain.FanOf;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="user_fy")
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String secondName;
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private String password;

        @NaturalId
        private String email;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(  name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        @ManyToMany(mappedBy = "artists")
        @JsonIgnoreProperties("artists")
        private List<TrackEntity> authoredTrackEntities = new ArrayList<>();

        @OneToMany(mappedBy = "origin", cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        }, fetch = FetchType.LAZY)
        @JsonIgnoreProperties("origin")
        private Set<FanOfEntity> fanOfEntity = new HashSet<>();

        public Long getId() {
            return id;
        }

        protected void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        protected void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

        public List<TrackEntity> getAuthoredTracks() {
            return authoredTrackEntities;
        }

    protected void setAuthoredTracks(List<TrackEntity> authoredTrackEntities) {
        this.authoredTrackEntities = authoredTrackEntities;
    }

    public void addAuthoredTrack(TrackEntity authoredTrackEntity) {
        this.authoredTrackEntities.add(authoredTrackEntity);
        authoredTrackEntity.addArtist(this);
    }

    public void addNewFan(UserEntity destination) {
        fanOfEntity.add(new FanOfEntity(this, destination));
    }

    public Set<FanOfEntity> getFanOf() {
        return fanOfEntity;
    }

    //override?s
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;

        UserEntity userEntity = (UserEntity) o;

        if (id != null ? !id.equals(userEntity.id) : userEntity.id != null) return false;
        return email.equals(userEntity.email);
    }

    //override?
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result +  email.hashCode();
        return result;
    }
}
