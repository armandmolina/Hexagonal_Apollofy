package cat.tecnocampus.apollofy.djLists.application.port.in;

import cat.tecnocampus.apollofy.user.domain.UserFy;

public record DJListListing(Long id, String title, String description, String owner) {
}
