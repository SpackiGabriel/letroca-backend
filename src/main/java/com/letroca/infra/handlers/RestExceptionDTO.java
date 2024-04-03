package com.letroca.infra.handlers;

import org.springframework.http.HttpStatus;

public record RestExceptionDTO(HttpStatus status, String message) {
}
