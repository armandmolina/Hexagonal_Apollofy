package cat.tecnocampus.apollofy.djLists.application.port.in;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;

import java.util.Set;

public record CreatePlaylistCommand(Long id, String title, String description, Boolean open, UserFy owner, Set<TrackEntity> trackEntities) {
}
