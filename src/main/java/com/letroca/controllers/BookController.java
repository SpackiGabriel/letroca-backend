package com.letroca.controllers;

import com.letroca.dtos.books.BookDTO;
import com.letroca.dtos.utils.GenericResponseDTO;
import com.letroca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/book", produces = {"application/json"})
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * Retrieves the details of a book based on the provided ID.
     *
     * This endpoint allows retrieving the details of a book specified by the given ID.
     *
     * @param id The ID of the book to retrieve.
     * @return A ResponseEntity containing the details of the book with a status of 200 OK upon success.
     *         In case of failure to retrieve the book, the response status will be appropriate
     *         as specified by the service logic.
     */
    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable String id) {
        BookDTO book = bookService.getBook(id);
        return ResponseEntity.ok(book);
    }

    /**
     * Creates a new book with the provided data.
     *
     * This endpoint allows creating a new book using the information provided in the request body.
     *
     * @param data The data representing the book to be created.
     * @return A ResponseEntity indicating successful creation of the book with a status of 200 OK.
     *         In case of failure to create the book, the response status will be appropriate
     *         as specified by the service logic.
     */
    @PostMapping
    public ResponseEntity createBook(@RequestBody BookDTO data) {
        bookService.createBook(data);
        return ResponseEntity.ok(new GenericResponseDTO("Successfully created book."));
    }

    /**
     * Updates the details of a book specified by the provided ID.
     *
     * This endpoint allows updating the details of a book identified by the given ID
     * using the information provided in the request body.
     *
     * @param data The updated data for the book.
     * @param id The ID of the book to update.
     * @return A ResponseEntity indicating successful update of the book with a status of 200 OK.
     *         In case of failure to update the book, the response status will be appropriate
     *         as specified by the service logic.
     */
    @PutMapping("/{id}")
    public ResponseEntity updateBook(@RequestBody BookDTO data, @PathVariable String id) {
        bookService.updateBook(data, id);
        return ResponseEntity.ok(new GenericResponseDTO("Successfully updated book."));
    }

    /**
     * Deletes a book specified by the provided ID.
     *
     * This endpoint allows deleting a book identified by the given ID.
     *
     * @param id The ID of the book to delete.
     * @return A ResponseEntity indicating successful deletion of the book with a status of 200 OK.
     *         In case of failure to delete the book, the response status will be appropriate
     *         as specified by the service logic.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new GenericResponseDTO("Successfully deleted book."));
    }
}
