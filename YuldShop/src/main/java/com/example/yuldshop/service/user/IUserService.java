package com.example.yuldshop.service.user;

import com.example.yuldshop.model.DTO.UserDTO;
import com.example.yuldshop.model.User;
import com.example.yuldshop.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGenericService<User>, UserDetailsService {
    User getByUsername(String username);

    boolean existsByUserName(String userName);

    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndDeletedIsFalse(String username);

    Optional<UserDTO> findUserDTOByUsername(String username);
}
