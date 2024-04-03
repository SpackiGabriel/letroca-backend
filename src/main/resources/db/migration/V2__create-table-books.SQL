CREATE TABLE books
(
    id VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    publication_year INT NOT NULL,
    publisher VARCHAR(100) NOT NULL,
    synopsis TEXT NOT NULL,
    language VARCHAR(50) NOT NULL,
    user_id VARCHAR(255) NOT NULL,

    CONSTRAINT fk_user_book
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

