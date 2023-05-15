package cat.tecnocampus.apollofy.user.adapter.out.persistance;


import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,String>{

    @Query("""
            select  u
                                   from user_fy u
                                   where u.name = :name
            """)
    Optional<UserEntity> getUserByName(@Param("name") String name);

    @Query("""
            select u
            from user_fy u
            """)
    List<UserEntity> loadAllUsers();

  /*  @Query("""
            select u
            from user_fy u
            where u.name =:name
            
""")
    Optional<UserEntity> findByName(@Param("name") String name);*/

    Optional<UserEntity> findByName(String name);


    @Query("""
        select u
        from user_fy u
    """)
    List<UserEntity> getUserProjections();

}
