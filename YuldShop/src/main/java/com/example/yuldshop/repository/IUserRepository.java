package com.example.yuldshop.repository;

import com.example.yuldshop.model.DTO.UserDTO;
import com.example.yuldshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    boolean existsByUsernameEquals(String userName);
    Optional<User> findByUsername(String userName);
    Optional<User> findByUsernameAndDeletedIsFalse(String userName);

    @Query("SELECT NEW com.example.yuldshop.model.DTO.UserDTO (" +
            "u.id, " +
            "u.username" +
            ") " +
            "FROM User AS u " +
            "WHERE u.username = ?1"
    )
    Optional<UserDTO> findUserDTOByUsername(String username);
}
