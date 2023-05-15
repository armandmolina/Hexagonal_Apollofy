package cat.tecnocampus.apollofy.track.application.port.in;

import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;

public record LikeTrackListing(Long id, UserEntity userEntity) {
}
