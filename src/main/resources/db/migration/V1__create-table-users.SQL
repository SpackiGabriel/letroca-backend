CREATE TABLE users
(
    id VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role SMALLINT NOT NULL
);