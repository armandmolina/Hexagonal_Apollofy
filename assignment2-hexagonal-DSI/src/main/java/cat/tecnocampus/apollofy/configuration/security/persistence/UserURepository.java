package cat.tecnocampus.apollofy.configuration.security.persistence;

import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserURepository extends JpaRepository<UserEntity, Long> {
        Optional<UserEntity>findByEmail(String email);
}

