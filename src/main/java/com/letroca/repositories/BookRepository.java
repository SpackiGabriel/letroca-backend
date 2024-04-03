package com.letroca.repositories;

import com.letroca.entities.books.Book;
import com.letroca.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByIsbnAndUserId(String isbn, String userId);
}
