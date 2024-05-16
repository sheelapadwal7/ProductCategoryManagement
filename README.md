Category and Product Management API
This Spring Boot application provides RESTful APIs for managing categories and products. It allows users to perform CRUD operations on both categories and products, including creating, reading, updating, and deleting records.

Features
Category Management:

Retrieve all categories.
Create a new category.
Retrieve a category by ID.
Update a category.
Delete a category by ID.
Product Management:

Retrieve all products.
Create a new product.
Retrieve a product by ID.
Update a product.
Delete a product by ID.
One-to-Many Relationship:

Each category can have multiple products associated with it.
Category Details in Product Response:

When retrieving a single product, the response includes details of the associated category.
Technologies Used
Spring Boot
Spring Data JPA
Hibernate
MySQL 
Maven

Prerequisites
Java 8 or higher installed on your machine
Maven installed on your machine
MySQL installed on your machine 


Setup
Clone the repository:

git clone https://github.com/your-username/category-product-management.git


apllication.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=db_username
spring.datasource.password=db_password
