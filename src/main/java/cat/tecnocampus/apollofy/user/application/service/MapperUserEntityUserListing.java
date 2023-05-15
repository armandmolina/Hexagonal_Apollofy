package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.track.application.service.MapperTrackEntityTrackListing;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackEntity;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackListing;
import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;

public class MapperUserEntityUserListing {
    public static UserListing userEntityToUserListing(UserEntity userEntity) {
        return new UserListing(userEntity.getId(),userEntity.getName(),userEntity.getSecondName(),userEntity.getPassword(), userEntity.getEmail(), MapperTrackEntityTrackListing.trackEntityListToTrackListingList(userEntity.getAuthoredTracks()));
    }
}
