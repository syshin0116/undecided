package com.ss.Jamong.user.repository;

import com.ss.Jamong.user.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    @EntityGraph(attributePaths = {"boards"})
    List<User> findAll();


    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);


//    User findByUsername2(String username);
//
//    @Query("select u from User u where u.username like %?1%")
//    List<User> findByUsernameQuery(String username);
//
//    @Query(value = "select * from User u where u.username like %?1%", nativeQuery = true)
//    List<User> findByUsernameNativeQuery(String username);
//
    boolean existsByUsername(String username);
}
