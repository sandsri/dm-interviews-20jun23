# Inventory Controller

The Inventory Controller is responsible for managing the inventory of products in the system. It provides RESTful API endpoints for performing CRUD (Create, Read, Update, Delete) operations on the inventory.

## API Endpoints

The following API endpoints are available:

- `GET /api/inventory/{id}` - Get a specific product by its ID.
- `POST /api/inventory` - Create set of product in the inventory.
- `PUT /api/inventory/{id}` - Update an existing product in the inventory.
- `DELETE /api/inventory/{id}` - Delete a product from the inventory.

For detailed information about each endpoint and the request/response payloads, refer to the API documentation.

## Technologies Used

The Inventory Controller is built with the following technologies:

- Java
- Spring Boot
- Spring Data JPA
- MySQL (or your preferred database)

## Getting Started

To run the Inventory Controller locally, follow these steps:

1. Clone the repository: `git clone https://github.com/sandsri/dm-interviews-20jun23.git`
2. Navigate niranjan branch: `git checkout Niranjan_branch_search`
3. Configure the database connection in the `application.yml` file.
4. Build the application: `./gradlew build`
5. Run the application: `./gradlew bootRun`
6. The API will be accessible at `http://localhost:8080/api/search/{name}`.

Make sure you have Java and Gradle installed on your system.

## Configuration

The following configuration properties can be modified in the `application.yml` file:

```properties
# Database configuration
app.search.url=url

