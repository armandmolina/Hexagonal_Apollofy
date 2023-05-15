package cat.tecnocampus.apollofy.user.adapter.out.persistance;

import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name="fanOf")
public class FanOfEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    private UserEntity origin;

    @ManyToOne(optional = false)
    @NotNull
    private UserEntity destination;

    private LocalDateTime becameFan;

    public FanOfEntity() {
    }

    public FanOfEntity(UserEntity origin, UserEntity destination) {
        this.origin = origin;
        this.destination = destination;
        becameFan = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getOrigin() {
        return origin;
    }

    public void setOrigin(UserEntity origin) {
        this.origin = origin;
    }

    public UserEntity getDestination() {
        return destination;
    }

    public void setDestination(UserEntity destination) {
        this.destination = destination;
    }

    public LocalDateTime getBecameFan() {
        return becameFan;
    }

    public void setBecameFan(LocalDateTime becameFan) {
        this.becameFan = becameFan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FanOfEntity fanOfEntity)) return false;

        return id.equals(fanOfEntity.id);
    }

    @Override
    public int hashCode() {
        int result = origin.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + (becameFan != null ? becameFan.hashCode() : 0);
        return result;
    }
}
