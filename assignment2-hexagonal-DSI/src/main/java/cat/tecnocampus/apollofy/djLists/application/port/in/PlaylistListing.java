package cat.tecnocampus.apollofy.djLists.application.port.in;

import cat.tecnocampus.apollofy.user.domain.UserFy;

public record PlaylistListing(Long id, String title, String description, boolean open, UserFy owner) {
}
