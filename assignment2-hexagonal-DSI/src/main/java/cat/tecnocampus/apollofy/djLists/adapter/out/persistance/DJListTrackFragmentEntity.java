package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class DJListTrackFragmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long startTimeMillis;

    private Long endTimeMillis;

    @ManyToOne(optional = false)
    @NotNull
    private TrackEntity trackEntity;

    @ManyToOne(optional = false)
    @NotNull
    private DJListEntity djListEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartTimeMillis() {
        return startTimeMillis;
    }

    public void setStartTimeMillis(Long startTimeMillis) {
        this.startTimeMillis = startTimeMillis;
    }

    public Long getEndTimeMillis() {
        return endTimeMillis;
    }

    public void setEndTimeMillis(Long endTimeMillis) {
        this.endTimeMillis = endTimeMillis;
    }

    public TrackEntity getTrackEntity() {
        return trackEntity;
    }

    public void setTrackEntity(TrackEntity trackEntity) {
        this.trackEntity = trackEntity;
    }

    public DJListEntity getPlaylistEntity() {
        return djListEntity;
    }

    public void setPlaylistEntity(DJListEntity djListEntity) {
        this.djListEntity = this.djListEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DJListTrackFragmentEntity that = (DJListTrackFragmentEntity) o;
        return Objects.equals(id, that.getId()) && Objects.equals(startTimeMillis, that.getStartTimeMillis())
                && Objects.equals(endTimeMillis, that.getEndTimeMillis()) && Objects.equals(trackEntity, that.getTrackEntity()) && Objects.equals(djListEntity, that.getPlaylistEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTimeMillis, endTimeMillis, trackEntity, djListEntity);
    }

    @Override
    public String toString() {
        return "PlaylistTrack{" +
                "id=" + id +
                ", startTimeMillis=" + startTimeMillis +
                ", endTimeMillis=" + endTimeMillis +
                ", trackEntity=" + trackEntity +
                ", DJList=" + djListEntity +
                '}';
    }
}
