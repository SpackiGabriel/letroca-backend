CREATE TABLE authors
(
    id VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    book_id VARCHAR(255) NOT NULL,

    CONSTRAINT fk_book_author
        FOREIGN KEY (book_id)
        REFERENCES books(id)
        ON DELETE CASCADE
);

