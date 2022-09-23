package com.example.yuldshop.repository;

import com.example.yuldshop.model.Role;
import com.example.yuldshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
