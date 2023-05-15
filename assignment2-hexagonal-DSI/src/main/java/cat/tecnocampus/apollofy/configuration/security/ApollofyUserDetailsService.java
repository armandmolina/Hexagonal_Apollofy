package cat.tecnocampus.apollofy.configuration.security;

import cat.tecnocampus.apollofy.configuration.security.persistence.UserURepository;
import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserRepository;

import cat.tecnocampus.apollofy.user.application.service.MapperUserFyUserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ApollofyUserDetailsService implements UserDetailsService {
    private UserURepository userURepository;

    public ApollofyUserDetailsService(UserURepository userURepository) {
        this.userURepository = userURepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserEntity user = userURepository.findByEmail(name)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + name));

        return ApollofyUserDetails.build(user);
    }

}