package cat.tecnocampus.apollofy.user.adapter.out.persistance;


import cat.tecnocampus.apollofy.configuration.security.persistence.UserURepository;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackListing;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.in.UserProjectionListing;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;
import cat.tecnocampus.apollofy.user.application.service.MapperUserEntityUserListing;
import cat.tecnocampus.apollofy.user.application.service.MapperUserEntityUserProjectionListing;
import cat.tecnocampus.apollofy.user.application.service.MapperUserFyUserEntity;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FetchUserListingAdapter implements ListUserPort {
    UserRepository userRepository;
    UserURepository userURepository;

    public FetchUserListingAdapter(UserRepository userRepository, UserURepository userURepository) {
        this.userRepository = userRepository;
        this.userURepository = userURepository;
    }

    @Override
    public UserListing loadUserByName(String name) {
        return MapperUserEntityUserListing.userEntityToUserListing(userURepository.findByEmail(name).get());
    }

    @Override
    public List<UserListing> loadAllUsers() {
        return userRepository.loadAllUsers()
                .stream()
                .map(userEntity -> MapperUserFyUserEntity.userEntityToUserFy(userEntity))
                .map(userFy -> new UserListing(userFy.getId(),
                        userFy.getName(),
                        userFy.getSecondName(),
                        userFy.getPassword(),
                        userFy.getEmail(),
                        MapperTrackTrackListing.trackListToTrackListingList(userFy.getAuthoredTracks())))
                .toList();
    }

    @Override
    public UserListing findByName(String name) {
       return MapperUserEntityUserListing.userEntityToUserListing(userURepository.findByEmail(name).get());
    }

    @Override
    public List<UserProjectionListing> getUserProjections(){
        return userRepository.getUserProjections()
                .stream()
                .map(userEntity-> MapperUserEntityUserProjectionListing.userEntityToUserProjectionListing(userEntity))
                .map(userFy ->new UserProjectionListing(userFy.name(),
                        userFy.email(),
                        userFy.secondName()))
                .toList();
    }



}
