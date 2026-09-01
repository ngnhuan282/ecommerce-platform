# 🛒 E-Commerce Platform

A full-stack e-commerce platform designed to provide a complete online shopping experience for customers and a comprehensive management system for administrators.

The system is built with **Spring Boot** for the backend and **React** for the frontend, following RESTful API principles and a layered architecture. It focuses on real-world e-commerce workflows such as product management, shopping carts, order processing, inventory management, authentication, payment processing, and administration.

---

## 📖 Overview

The **E-Commerce Platform** is an online shopping system that connects customers with products through a secure and scalable web application.

Customers can:

* Browse and search for products
* Filter and sort products
* View product details
* Add products to their shopping cart
* Manage shipping addresses
* Place orders
* Make payments
* Track order status
* Review purchased products
* Manage their wishlist

Administrators can manage:

* Products
* Categories
* Inventory
* Orders
* Customers
* Payments
* Reviews
* Promotions
* Business reports

The application is designed with a focus on **maintainability, security, scalability, and real-world backend development practices**.

---

# ✨ Features

## 👤 Customer

### Authentication

* User registration
* User login
* JWT-based authentication
* Password encryption
* Logout
* User profile management
* Password change
* Role-based authorization

### Product

* Browse products
* View product details
* Search products
* Filter by category
* Filter by price
* Sort products
* Pagination
* Product availability

### Shopping Cart

* Add products to cart
* Update product quantity
* Remove products
* Clear cart
* Automatically calculate cart total
* Validate product availability

### Checkout

* Select shipping address
* Review order information
* Apply discount codes
* Calculate shipping fee
* Calculate final order total
* Select payment method
* Place order

### Orders

* View order history
* View order details
* Track order status
* Cancel eligible orders

### Reviews

* Rate products
* Write product reviews
* Update reviews
* Delete reviews
* Review verification based on purchase history

### Wishlist

* Add products to wishlist
* Remove products from wishlist
* View wishlist

---

# 👨‍💼 Administration

Administrators have access to a dedicated management system.

### Dashboard

* Total revenue
* Total orders
* Total customers
* Total products
* Sales statistics
* Order statistics

### Product Management

* Create products
* Update products
* Delete products
* Manage product status
* Manage product pricing
* Manage product inventory

### Category Management

* Create categories
* Update categories
* Delete categories
* Manage category status

### Order Management

* View orders
* View order details
* Update order status
* Process orders
* Cancel orders
* Manage order fulfillment

### Customer Management

* View customers
* View customer details
* Manage customer status
* Manage customer roles

### Inventory Management

* View inventory
* Update stock
* Track stock changes
* Prevent overselling

### Review Management

* View reviews
* Moderate reviews
* Remove inappropriate reviews

### Reports

* Revenue reports
* Order statistics
* Best-selling products
* Customer statistics
* Inventory reports

---

# 🔐 Security

The application uses **Spring Security** to protect APIs and manage user access.

Security features include:

* JWT authentication
* Password hashing with BCrypt
* Role-based access control
* Authentication and authorization
* Request validation
* Centralized exception handling
* Protected administrative APIs
* Secure handling of sensitive information

Example roles:

```text
CUSTOMER
STAFF
ADMIN
```

Authorization flow:

```text
Client
   │
   │ Authorization: Bearer <JWT>
   ▼
Spring Security
   │
   ├── Authenticate user
   │
   ├── Validate JWT
   │
   └── Check roles/permissions
           │
           ▼
       REST Controller
```

---

# 🏗️ Architecture

The backend follows a layered architecture to separate responsibilities between different components.

```text
                    ┌───────────────┐
                    │    Client     │
                    │ React / API   │
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │  Controller   │
                    │   REST API    │
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │    Service    │
                    │ Business Logic│
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │  Repository   │
                    │ Data Access   │
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │     MySQL     │
                    └───────────────┘
```

Additional infrastructure:

```text
                 Spring Boot Backend
                         │
          ┌──────────────┼──────────────┐
          │              │              │
          ▼              ▼              ▼
        MySQL          Redis        RabbitMQ
       Database        Cache       Message Queue
```

---

# 🧩 Main Modules

The system is organized into several major modules:

```text
E-Commerce Platform
│
├── Authentication
├── User Management
├── Role & Authorization
├── Product Management
├── Category Management
├── Shopping Cart
├── Address Management
├── Wishlist
├── Order Management
├── Inventory
├── Payment
├── Review
├── Coupon & Promotion
├── Notification
└── Administration
```

---

# 🗄️ Database Design

The application uses **MySQL** as the primary relational database.

Main entities include:

```text
User
Role
Category
Product
Inventory
Cart
CartItem
Address
Order
OrderItem
Payment
Review
Wishlist
Coupon
Notification
```

High-level relationship:

```text
                    ┌──────────┐
                    │   User   │
                    └────┬─────┘
                         │
          ┌──────────────┼──────────────┐
          │              │              │
          ▼              ▼              ▼
        Cart           Order        Address
          │              │
          ▼              ▼
      CartItem       OrderItem
          │              │
          └───────┬──────┘
                  │
                  ▼
              Product
                  │
                  ▼
              Inventory

Product
   │
   ├── Category
   ├── Review
   └── Wishlist
```

---

# 🌐 RESTful API

The backend exposes RESTful APIs using the `/api/v1` prefix.

Example endpoints:

### Authentication

```http
POST /api/v1/auth/register
POST /api/v1/auth/login
POST /api/v1/auth/logout
```

### Products

```http
GET    /api/v1/products
GET    /api/v1/products/{id}
POST   /api/v1/products
PUT    /api/v1/products/{id}
DELETE /api/v1/products/{id}
```

### Cart

```http
GET    /api/v1/cart
POST   /api/v1/cart/items
PUT    /api/v1/cart/items/{id}
DELETE /api/v1/cart/items/{id}
```

### Orders

```http
POST   /api/v1/orders
GET    /api/v1/orders
GET    /api/v1/orders/{id}
PUT    /api/v1/orders/{id}/status
```

### Reviews

```http
GET    /api/v1/products/{id}/reviews
POST   /api/v1/products/{id}/reviews
PUT    /api/v1/reviews/{id}
DELETE /api/v1/reviews/{id}
```

API documentation is provided through Swagger / OpenAPI.

---

# 🚨 Exception Handling

The application uses centralized exception handling to provide a consistent API response format.

```text
Service
   │
   │ throw AppException
   ▼
GlobalExceptionHandler
   │
   ▼
ApiResponse
```

Example:

```java
throw new AppException(ErrorCode.PRODUCT_NOT_FOUND);
```

Response:

```json
{
  "code": 1007,
  "message": "Product not found",
  "result": null
}
```

This allows business exceptions to be handled consistently across the entire application.

---

# ⚡ Performance & Scalability

The architecture is designed to support future performance improvements.

Planned infrastructure includes:

### Redis

Used for caching frequently accessed data such as:

* Product information
* Categories
* Popular products
* Session-related data

### RabbitMQ

Used for asynchronous processing such as:

* Order events
* Email notifications
* Notification processing
* Background tasks

Example:

```text
Order Created
      │
      ▼
   RabbitMQ
      │
 ┌────┼─────┐
 ▼    ▼     ▼
Email Notification Analytics
```

---

# 💳 Payment

The payment module supports multiple payment methods.

Initial payment method:

```text
Cash on Delivery (COD)
```

The architecture is designed to support online payment gateways in the future.

Payment flow:

```text
Checkout
   │
   ▼
Create Order
   │
   ▼
Create Payment
   │
   ▼
Payment Gateway
   │
   ▼
Payment Callback
   │
   ▼
Verify Payment
   │
   ▼
Update Payment & Order
```

---

# 🛡️ Inventory & Concurrency

Inventory management is designed to prevent overselling when multiple customers attempt to purchase the same product simultaneously.

Example:

```text
Stock = 1

Customer A ──┐
             ├── Checkout
Customer B ──┘
```

The system uses database-level concurrency control to ensure that stock cannot become negative.

---

# 🧪 Testing

The application is designed to support multiple levels of testing:

### Unit Testing

* Service layer
* Business logic
* Utility classes

### Integration Testing

* Controller
* Service
* Repository
* Database

### API Testing

REST APIs can be tested using Postman and Swagger/OpenAPI.

Important business flows include:

* Registration
* Authentication
* Product management
* Cart operations
* Checkout
* Inventory validation
* Order processing
* Payment processing

---

# 🛠️ Tech Stack

## Backend

| Technology      | Purpose                        |
| --------------- | ------------------------------ |
| Java 21         | Programming language           |
| Spring Boot     | Backend framework              |
| Spring Web      | RESTful APIs                   |
| Spring Data JPA | Database access                |
| Spring Security | Authentication & authorization |
| JWT             | Stateless authentication       |
| Bean Validation | Request validation             |
| Lombok          | Reduce boilerplate             |
| MapStruct       | DTO mapping                    |
| Maven           | Dependency management          |

## Frontend

| Technology   | Purpose             |
| ------------ | ------------------- |
| React        | Frontend framework  |
| TypeScript   | Type safety         |
| Vite         | Build tool          |
| Axios        | HTTP client         |
| React Router | Client-side routing |
| Material UI  | UI components       |

## Database & Infrastructure

| Technology | Purpose          |
| ---------- | ---------------- |
| MySQL      | Primary database |
| Redis      | Caching          |
| RabbitMQ   | Message broker   |
| Docker     | Containerization |

## DevOps

| Technology     | Purpose                |
| -------------- | ---------------------- |
| Git            | Version control        |
| GitHub         | Source code management |
| GitHub Actions | CI/CD                  |
| Docker Hub     | Container registry     |
| AWS            | Cloud deployment       |

---

# 📁 Project Structure

```text
ecommerce-platform/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/ecommerce/
│   │   │       │
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       │   ├── request/
│   │   │       │   └── response/
│   │   │       ├── entity/
│   │   │       ├── exception/
│   │   │       ├── mapper/
│   │   │       ├── repository/
│   │   │       ├── security/
│   │   │       └── service/
│   │   │           └── impl/
│   │   │
│   │   └── resources/
│   │       ├── application.yml
│   │       └── ...
│   │
│   └── test/
│
├── pom.xml
├── Dockerfile
├── docker-compose.yml
├── .gitignore
└── README.md
```

---

# 🚀 Getting Started

## Prerequisites

Make sure you have installed:

* Java 21+
* Maven
* MySQL
* Node.js
* Docker
* Git

---

## Clone Repository

```bash
git clone https://github.com/<your-username>/ecommerce-platform.git

cd ecommerce-platform
```

---

## Configure Database

Create the database:

```sql
CREATE DATABASE ecommerce;
```

Configure the application using environment variables:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ecommerce
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

---

## Run Backend

```bash
mvn spring-boot:run
```

Backend:

```text
http://localhost:8080
```

---

## Run Frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend:

```text
http://localhost:5173
```

---

# 🐳 Docker

The application can be containerized using Docker.

Planned architecture:

```text
                    Internet
                       │
                       ▼
                    Nginx
                       │
              ┌────────┴────────┐
              ▼                 ▼
           React            Spring Boot
                              │
                    ┌─────────┼─────────┐
                    ▼         ▼         ▼
                  MySQL     Redis    RabbitMQ
```

Docker Compose can be used to run the application and supporting infrastructure locally.

---

# 📸 Screenshots

Screenshots will be added for:

* Home page
* Product listing
* Product detail
* Shopping cart
* Checkout
* Order history
* Admin dashboard
* Product management
* Order management

---

# 🔮 Future Improvements

Potential future improvements include:

* Email verification
* Forgot / reset password
* OAuth2 authentication
* Refresh token rotation
* Advanced product recommendation
* Elasticsearch-based product search
* Full-text search
* Real-time notifications
* Advanced analytics
* Distributed tracing
* Application monitoring
* Rate limiting
* Kubernetes deployment
* Advanced AWS architecture

---

# 🎯 Project Objectives

This project aims to demonstrate practical experience in building a production-oriented web application using modern backend technologies.

Key areas include:

* RESTful API design
* Layered architecture
* Database modeling
* Authentication & authorization
* Transaction management
* Concurrency control
* Exception handling
* Caching
* Asynchronous processing
* Automated testing
* Containerization
* CI/CD
* Cloud deployment

The project emphasizes not only implementing features, but also designing a system that is **maintainable, secure, scalable, and suitable for real-world usage**.

---

## 👨‍💻 Author

**Nguyen Nhuan**

Full-stack E-Commerce Platform built with Spring Boot and React.
