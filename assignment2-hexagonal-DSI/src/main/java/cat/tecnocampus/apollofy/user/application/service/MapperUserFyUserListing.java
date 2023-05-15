package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;

public class MapperUserFyUserListing {

    public static UserFy userListingToUserFy(UserListing userListing){
        UserFy userFy= new UserFy();
        userFy.setEmail(userListing.email());
        userFy.setName(userListing.name());
        userFy.setPassword(userListing.password());
        userFy.setSecondName(userListing.secondName());

        return userFy;
    }
}
