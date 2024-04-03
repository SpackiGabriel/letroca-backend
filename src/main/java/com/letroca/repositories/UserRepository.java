package com.letroca.repositories;

import com.letroca.entities.users.User;
import com.letroca.infra.custom.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    CustomUserDetails findByEmail(String email);
}