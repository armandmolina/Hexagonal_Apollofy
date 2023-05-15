package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.application.port.in.UserProjectionListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;

public class MapperUserEntityUserProjectionListing {
    public static UserProjectionListing userEntityToUserProjectionListing(UserEntity userEntity) {
        return new UserProjectionListing(userEntity.getName(),userEntity.getEmail(),userEntity.getSecondName());
    }
}
