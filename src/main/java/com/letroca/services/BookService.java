package com.letroca.services;

import com.letroca.dtos.books.BookDTO;
import com.letroca.entities.books.Book;
import com.letroca.entities.users.User;
import com.letroca.infra.custom.CustomUserDetails;
import com.letroca.repositories.BookRepository;
import com.letroca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Retrieves the details of a book based on the provided ID.
     *
     * This method retrieves the details of a book from the database based on the given ID.
     *
     * @param id The ID of the book to retrieve.
     * @return A BookDTO object containing the details of the book.
     * @throws RuntimeException If the book with the provided ID is not found in the database.
     */
    public BookDTO getBook(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found."));
        return new BookDTO( book.getTitle(), book.getIsbn(), book.getGenre(), book.getPublication_year(), book.getPublisher(), book.getSynopsis(), book.getLanguage() );
    }

    /**
     * Creates a new book with the provided data.
     *
     * This method creates a new book using the information provided in the BookDTO object.
     * It associates the book with the authenticated user who is creating it.
     *
     * @param data The data representing the book to be created.
     * @return The created Book object.
     * @throws RuntimeException If the authenticated user is not found, or if a book with the same ISBN
     *         already exists for the user.
     */
    public Book createBook(BookDTO data) {
        CustomUserDetails authentication = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = authentication.getId();

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        Optional<Book> existingBook = bookRepository.findByIsbnAndUserId(data.isbn(), user.getId());
        if (existingBook.isPresent()) {
            throw new RuntimeException("A book with the same ISBN already exists for this user!");
        }

        Book book = new Book();
        book.setTitle(data.title());
        book.setIsbn(data.isbn());
        book.setGenre(data.genre());
        book.setPublication_year(data.publication_year());
        book.setPublisher(data.publisher());
        book.setSynopsis(data.synopsis());
        book.setLanguage(data.language());
        book.setUser(user);

        return bookRepository.save(book);
    }

    /**
     * Updates the details of a book specified by the provided ID.
     *
     * This method updates the details of a book in the database identified by the given ID
     * using the information provided in the BookDTO object.
     * It checks if the authenticated user has permission to update the book.
     *
     * @param data The updated data for the book.
     * @param id The ID of the book to update.
     * @throws RuntimeException If the authenticated user is not found, if the book with the provided ID is not found,
     *         or if the authenticated user is not authorized to update the book.
     */
    public void updateBook(BookDTO data, String id) {
        CustomUserDetails authentication = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = authentication.getId();

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!"));

        if (!bookToUpdate.getUser().getId().equals(userId)) {
            throw new RuntimeException("You are not authorized to update this book!");
        }

        bookToUpdate.setTitle(data.title());
        bookToUpdate.setIsbn(data.isbn());
        bookToUpdate.setGenre(data.genre());
        bookToUpdate.setPublication_year(data.publication_year());
        bookToUpdate.setPublisher(data.publisher());
        bookToUpdate.setSynopsis(data.synopsis());
        bookToUpdate.setLanguage(data.language());

        bookRepository.save(bookToUpdate);
    }

    /**
     * Deletes a book specified by the provided ID.
     *
     * This method deletes a book from the database identified by the given ID.
     * It checks if the authenticated user has permission to delete the book.
     *
     * @param id The ID of the book to delete.
     * @throws RuntimeException If the book with the provided ID is not found,
     *         or if the authenticated user is not authorized to delete the book.
     */
    public void deleteBook(String id) {
        CustomUserDetails authentication = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = authentication.getId();

        Book bookToDelete = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!"));

        if (!bookToDelete.getUser().getId().equals(userId)) {
            throw new RuntimeException("You are not authorized to delete this book!");
        }

        bookRepository.delete(bookToDelete);
    }
}
