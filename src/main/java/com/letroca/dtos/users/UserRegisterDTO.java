package com.letroca.dtos.users;

import com.letroca.entities.users.UserRole;

public record UserRegisterDTO(String name, String email, String password, UserRole role) {
}
