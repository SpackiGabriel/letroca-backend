package com.letroca.dtos.books;

public record BookDTO(String title, String isbn, String genre, int publication_year, String publisher, String synopsis, String language) {
}
