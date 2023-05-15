package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;

public class MapperUserUserListing {
    public static UserFy userListingToUser (UserListing userListing) {
        UserFy user = new UserFy();
        user.setEmail(userListing.email());
        user.setName(userListing.name());
        user.setSecondName(userListing.secondName());
        user.setPassword(userListing.password());

        return user;
    }

}
