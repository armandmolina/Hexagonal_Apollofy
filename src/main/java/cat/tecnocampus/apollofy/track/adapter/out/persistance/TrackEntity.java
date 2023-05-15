package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.domain.Genre;
import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

//TODO 1.0 Somewhere in this class you need to add some annotations to validate the title and the duration
@Entity(name="track")
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Z][a-z0-9\s_-]*$", message = "TrackEntity title must begin with capital letter")
    @NotNull
    private String title;

    @Column(name = "duration_seconds")
    @Min(5)
    @Max(300)
    private Long durationSeconds;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "track_genre",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreEntity> genres = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "track_artist",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<UserEntity> artists =new HashSet<>();

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

    public Set<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreEntity> genres) {
        this.genres = genres;
    }

    public void addGenre(GenreEntity genre) {
        this.genres.add(genre);
    }

    public void addGenres(List<GenreEntity> genreList) {
        genres.addAll(genreList);
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Set<UserEntity> getArtists() {
        return artists;
    }

    public void setArtists(List<UserEntity> artists) {
        this.artists  = new HashSet<>(artists);
    }

    public void addArtist(UserEntity artist) {
        artists.add(artist);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrackEntity trackEntity = (TrackEntity) o;
        return id != null && Objects.equals(id, trackEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
