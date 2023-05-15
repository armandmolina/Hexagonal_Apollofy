package cat.tecnocampus.apollofy.user.domain;

import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class FanOf {

    private Long id;

    private UserFy origin;

    private UserFy destination;

    private LocalDateTime becameFan;

    public FanOf() {
    }

    public FanOf(UserFy origin, UserFy destination) {
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

    public UserFy getOrigin() {
        return origin;
    }

    public void setOrigin(UserFy origin) {
        this.origin = origin;
    }

    public UserFy getDestination() {
        return destination;
    }

    public void setDestination(UserFy destination) {
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
        if (!(o instanceof FanOf fanOf)) return false;

        return id.equals(fanOf.id);
    }

    @Override
    public int hashCode() {
        int result = origin.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + (becameFan != null ? becameFan.hashCode() : 0);
        return result;
    }
}
