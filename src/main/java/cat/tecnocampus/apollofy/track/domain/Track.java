package cat.tecnocampus.apollofy.track.domain;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Track {
    private Long id;

    private String title;

    private Long durationSeconds;

    private Set<Genre> genres = new HashSet<>();

    private Set<UserFy> artists =new HashSet<>();


    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void addGenres(List<Genre> genreList) {
        genres.addAll(genreList);
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Set<UserFy> getArtists() {
        return artists;
    }

    public void setArtists(List<UserFy> artists) {
        this.artists  = new HashSet<>(artists);
    }

    public void addArtist(UserFy artist) {
        artists.add(artist);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

    //override?
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrackEntity trackEntity = (TrackEntity) o;
        return id != null && Objects.equals(id, trackEntity.getId());
    }

    //override?
    public int hashCode() {
        return getClass().hashCode();
    }
}
