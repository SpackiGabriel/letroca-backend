# Letroca Backend

Welcome to Letroca Backend! This project is currently under development.

## Installation

1. **Clone the repository:**

    ```
    git clone https://github.com/your-username/letroca-backend.git
    ```

2. **Navigate to the project directory:**

    ```
    cd letroca-backend
    ```

3. **Build the project:**

    ```
    mvn clean install
    ```

4. **Run the application:**

    ```
    mvn spring-boot:run
    ```
## Usage

Once the application is running, you can interact with the backend using the provided [endpoints](./endpoints.MD).

### Authentication

Authentication is implemented using Spring Security with JSON Web Tokens (JWT). Users can register and log in to the platform to access their accounts.

### Book Management

The backend provides endpoints for basic CRUD operations on books. Users can manage their books through these endpoints.

### Exception Handling

Custom exception handling is implemented for better error management. Custom exceptions are thrown for common scenarios such as book already existing, unauthorized access, etc.