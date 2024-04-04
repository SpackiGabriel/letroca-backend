# Letroca Backend API Endpoints

Welcome to Letroca Backend API documentation! 
Below is a list of all available endpoints:

## Authentication

### Login
    
- **URL:** `/auth/login`
- **Method:** `POST`
- **Description:** Authenticates user login.
- **Request Body:**

```json
{
  "email": "user@example.com",
  "password": "password"
}
```

- Response Body:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyQGV4YW1wbGUuY29tIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```
### Login

- **URL:** `/auth/register`
- **Method:** `POST`
- **Description:** Registers a new user.
- **Request Body:**

```json
{
  "name": "John Doe",
  "email": "user@example.com",
  "password": "password",
  "role": "USER"
}
```
- Response Body:
No response body.

## Book Management

### Get Book Details

- **URL:** `/api/book/{id}`
- **Method:** `GET`
- **Description:** Retrieves the details of a book based on the provided ID.
- **Parameters:**
  - `id`: ID of the book to retrieve.

### Create Book

- **URL:** `/api/book`
- **Method:** `POST`
- **Description:** Creates a new book with the provided data.
- **Request Body:**

```json
{
  "title": "Book Title",
  "isbn": "978-3-16-148410-0",
  "genre": "Fantasy",
  "publication_year": 2022,
  "publisher": "Publisher Name",
  "synopsis": "Book Synopsis",
  "language": "English"
}
```

### Update Book

- **URL:** `/api/book/{id}`
- **Method:** `PUT`
- **Description:** Updates the details of a book specified by the provided ID.
- **Parameters:**
    - `id`: ID of the book to update.
- **Request Body:**

```json
{
  "title": "Updated Book Title",
  "isbn": "978-3-16-148410-0",
  "genre": "Fantasy",
  "publication_year": 2022,
  "publisher": "Publisher Name",
  "synopsis": "Updated Book Synopsis",
  "language": "English"
}
```

### Delete Book

- **URL:** `/api/book/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a book specified by the provided ID.
- **Parameters:**
    - `id`: ID of the book to delete.

## Error Handling

The backend handles various errors gracefully and returns appropriate error messages and status codes.

### Error Response Body Example

```json
{
  "status": "404 Not Found",
  "message": "Book not found."
}
```

