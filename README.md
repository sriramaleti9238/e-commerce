# Mini E-Commerce Showcase

A modern Java Spring Boot e-commerce showcase application demonstrating robust product management and administrative functionality with responsive design. This application provides both user-facing and admin features in a clean, well-structured architecture.


## Features

- **Public Product Listings**: Browse products with thumbnails, prices, and smooth image loading
- **Product Detail Pages**: View comprehensive product information with high-quality images
- **Admin Authentication**: Secure login system with session management
- **Admin Product Management**: Create, edit, and delete product listings with intuitive UI
- **Responsive Design**: Mobile-friendly interface using Bootstrap 5
- **About Page**: Information about the application and its features
- **Contact Page**: Email redirection to contact email with GitHub and LinkedIn links

## Technology Stack

- **Backend**: Java (JDK 17), Spring Boot 3.2.6, Spring MVC, Spring Data JPA, Spring Security 6.x
- **Frontend**: Thymeleaf 3.x, Bootstrap 5, Bootstrap Icons, HTML5, CSS3, JavaScript
- **Database**: PostgreSQL
- **Build Tool**: Maven

## System Requirements

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6+ for build management
- PostgreSQL database
- Apache Tomcat 10.0+ (for WAR deployment option)

## Database Schema

The application uses a streamlined database schema:

```sql
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0,
    image_url VARCHAR(500),
    thumbnail_url VARCHAR(500),
    active BOOLEAN DEFAULT TRUE
);
```

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/sriramaleti9238/ecommerce.git
   cd ecommerce
   ```

2. Configure the database connection in `src/main/resources/application-dev.properties` for development:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Option 1: Run as a Spring Boot Application

3. Build and run the project with the development profile:
   ```bash
   mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
   ```

4. Access the application in your browser:
   ```
   http://localhost:8000
   ```

### Option 2: Deploy as WAR to Tomcat Server

3. Configure the database connection in `src/main/resources/application-prod.properties` for production:
   ```properties
   spring.datasource.url=jdbc:postgresql://your-prod-host:5432/ecommerce
   spring.datasource.username=your_prod_username
   spring.datasource.password=your_prod_password
   ```

4. Build the project with the production profile:
   ```bash
   mvn clean package -Pprod
   ```

5. Deploy the WAR file to Tomcat:
    - Copy `target/e-commerce-0.0.1-SNAPSHOT.war` to Tomcat's `webapps` directory, or
    - Upload through Tomcat Manager interface at `http://localhost:8080/manager/html`

6. Access the application in your browser:
   ```
   http://localhost:8080/e-commerce-0.0.1-SNAPSHOT/
   ```

## Admin Access

Use these credentials to access the admin panel:
- **Username**: admin
- **Password**: admin123

## Project Structure

- `src/main/java/com/ecommerce/showcase/` - Java source files
    - `config/` - Configuration classes (Security, Web)
    - `controller/` - MVC controllers
    - `model/` - Entity classes
    - `repository/` - Data access interfaces
    - `service/` - Business logic
    - `util/` - Utility classes
- `src/main/resources/` - Configuration and static resources
    - `static/` - CSS, JavaScript, and images
    - `templates/` - Thymeleaf templates
    - `application.properties` - Application configuration
    - `schema.sql` - Database schema
    - `data.sql` - Sample data

## Dummy Data

- For dummy fakestore products API data is been used 
  ```
   https://fakestoreapi.com/products
   ```

## Key Features

### User-Facing Pages
- **Home Page**: Introduction with featured products and admin login information
- **Products Page**: Grid view of all active products with thumbnails
- **Product Detail**: Comprehensive view of individual product with images and information
- **About Page**: Information about the application and technologies used
- **Contact Page**: Contact information and social media links

### Admin Features
- **Login Page**: Secure authentication portal
- **Product Management**: CRUD operations for products with intuitive UI
- **Logout**: Secure session termination

## UI/UX Features

- **Responsive Design**: Mobile-first approach with Bootstrap 5
- **Clean Interface**: Minimalist design focusing on products
- **Image Optimization**: Lazy loading and fallback images
- **Animation Effects**: Subtle transitions and hover effects
- **Intuitive Navigation**: Clear menu structure and breadcrumbs

## Deployment Options

### Local Development Server

When running the application using Spring Boot's embedded Tomcat server, the application will be available at:

```
http://localhost:8000
```

This mode is ideal for development and testing with automatic restart capabilities when code changes are detected. The application runs with the `dev` profile, which has enhanced logging and other development-friendly settings.

### External Tomcat Deployment

When deployed as a WAR file to an external Tomcat server, the application will be available at:

```
http://your-server:8080/e-commerce-0.0.1-SNAPSHOT/
```

This deployment mode uses the `prod` profile with optimized settings for production use, including:
- More aggressive caching
- Reduced logging verbosity
- Disabled schema initialization by default
- Context path configuration for proper URL handling in the WAR container

