package cat.tecnocampus.apollofy.user.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackRepository;
import cat.tecnocampus.apollofy.track.application.port.in.CreateTrackCommand;
import cat.tecnocampus.apollofy.track.application.port.out.StoreTrackPort;
import cat.tecnocampus.apollofy.user.application.port.in.CreateUserCommand;
import cat.tecnocampus.apollofy.user.application.port.out.StoreUserPort;
import org.springframework.stereotype.Component;

@Component
public class StoreUserAdapter implements StoreUserPort {
    private final UserRepository userRepository;

    public StoreUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void storeUser(CreateUserCommand createUserCommand) {
        userRepository.save(userCommand2UserEntity(createUserCommand));
    }

    private UserEntity userCommand2UserEntity(CreateUserCommand createUserCommand) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(createUserCommand.email());
        userEntity.setName(createUserCommand.name());
        userEntity.setPassword(createUserCommand.password());

        return userEntity;
    }
}
