package com.letroca.entities.books;

import com.letroca.entities.users.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int publication_year;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String synopsis;

    @Column(nullable = false)
    private String language;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
