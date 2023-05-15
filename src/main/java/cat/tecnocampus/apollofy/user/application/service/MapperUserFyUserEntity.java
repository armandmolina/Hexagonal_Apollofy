package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.track.domain.Track;
import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;

public class MapperUserFyUserEntity {
    public static UserEntity userFyToUserEntity(UserFy userFy) {
        UserEntity userEntity = new UserEntity();
            userEntity.setEmail(userFy.getEmail());
            userEntity.setName(userFy.getName());
            userEntity.setSecondName(userFy.getSecondName());
            userEntity.setPassword(userFy.getPassword());
        return userEntity;
    }

    public static UserFy userEntityToUserFy(UserEntity userEntity) {
        UserFy userFy = new UserFy();
        userFy.setEmail(userEntity.getEmail());
        userFy.setName(userEntity.getName());
        userFy.setSecondName(userEntity.getSecondName());
        userFy.setPassword(userEntity.getPassword());

        return userFy;
    }
}

