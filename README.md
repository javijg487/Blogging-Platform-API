# Blogging-Platform-API
This project is a Blogging Platform API that allows you to perform CRUD (Create, Read, Update, Delete) operations to manage blog posts. The API is built with Java Spring and accepts requests in JSON format to interact with the posts.

## Project URL
[[https://github.com/javijg487/Blogging-Platform-API](https://github.com/javijg487/Blogging-Platform-API)]

## Endpoints

### 1. Create a Post
- **Endpoint:** `POST /api/v1/posts`
- **Body Example:**
  ```json
  {
    "title": "My first Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"]
  }

### 2. Get All Posts or Search by Term
- **Endpoint:** `GET /api/v1/posts?term=<term>`

### 3. Update a Post
- **Endpoint:** `PUT /api/v1/posts/{id}`
- **Body Example:**
  ```json
  {
    "title": "My first Blog Post EDITED"
  }

### 4. Delete a Post
- **Endpoint:** `DELETE /api/v1/posts/{id}`


## Example Responses
### Successful Response for Get Posts
 ```json
 [
  {
    "id": 2,
    "title": "My First Blog Post EDITED",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2024-11-22T19:18:08",
    "updatedAt": "2024-11-22T19:30:21"
  }
]
```
### Successful Response for Creating a Post
 ```json
{
  "id": 4,
  "title": "My fourth Blog Post",
  "content": "This is the content of my fourth blog post.",
  "category": "Maths",
  "tags": ["Programming"],
  "createdAt": "2024-11-22T19:50:00",
  "updatedAt": null
}
```
### Successful Response for Updating a Post
 ```json
{
  "id": 4,
  "title": "My fourth Blog Post EDITED",
  "content": "This is the content of my fourth blog post.",
  "category": "Maths",
  "tags": ["Programming"],
  "createdAt": "2024-11-22T19:50:00",
  "updatedAt": "2024-11-22T19:45:00"
}
```
### Successful Response for Deleting a Post
 - **Status Code:** `200 OK`

## Usage
To use the API, make a `POST`, `GET`, `PUT`, or `DELETE` request to the appropriate endpoint with a JSON body that includes:

- **title**: The title of the post.
- **content**: The content of the post.
- **category**: The category of the post.
- **tags**: The tags associated with the post.

## Running the Project

To run the project locally with the MySQL database:

1. **Clone the Repository**:
   - Clone this repository to your local machine using the following command:
     ```bash
     git clone https://github.com/your-username/blogproject.git
     ```

2. **Install MySQL** (if not already installed):
   - Download and install MySQL from [MySQL Official Website](https://dev.mysql.com/downloads/).
   - After installation, ensure that MySQL is running on your local machine.

3. **Create the Database**:
   - Open MySQL Command Line or MySQL Workbench and create the `blogproject` database by running the following SQL command:
     ```sql
     CREATE DATABASE blogproject;
     ```

4. **Create the Table**:
  - To manually create the `posts` table, execute the following SQL in your MySQL database:

    ```sql
    CREATE TABLE posts (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        content TEXT,
        category VARCHAR(255),
        tags VARBINARY(255),
        created_at DATETIME,
        updated_at DATETIME
    );
    ```

    This will create the table with the required columns that match the `Post` entity class.

5. **Configure the Application**:
   - Ensure the `application.properties` file in the `src/main/resources/` directory contains the correct MySQL configuration:
     ```properties
     spring.application.name=blogproject
     
     # MySQL Database Configuration
     spring.datasource.url=jdbc:mysql://localhost:3306/blogproject
     spring.datasource.username=root
     spring.datasource.password=root
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.show_sql=true
     spring.jpa.properties.hibernate.format_sql=true
     ```
     - Update the `spring.datasource.username` and `spring.datasource.password` if necessary.

6. **Build and Run the Application**:
   - Open a terminal in the project directory.
   - Run the following command to build and run the Spring Boot application:
     ```bash
     mvn clean install
     mvn spring-boot:run
     ```
   - The API will be available at `http://localhost:8080`.

7. **Verify the Application**:
   - Once the application is running, you can access the endpoints and interact with the database, where blog posts will be stored in the `blogproject` database.

8. **Verify Database Tables**:
   - If you want to verify the tables created in the database, you can run the following SQL command:
     ```sql
     SHOW TABLES;
     ```
   - This should display tables such as `posts` that are used to store the blog post data.

Your application is now set up and running with the MySQL database!
