package cat.tecnocampus.apollofy.user.application.port.in;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;

import java.util.List;

public record UserProjectionListing(String name,String email, String secondName) {
}
