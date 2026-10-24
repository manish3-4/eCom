# eCOm Project Helpbook - Updated

## Project Overview
A modern Spring Boot 4.1.2 application (Java 21) with Maven, featuring:
- Reorganized controllers in `controller/` folder and services in `service/`
- 6 HTML templates with working routes and modern UI
- Authentication flow with signup/sign in
- Bootstrap 5 + custom CSS design

## Project Structure
```
eCOm/
├── pom.xml                          # Maven config (Java 21)
├── src/main/java/com/example/eCOm/
│   ├── ECOmApplication.java         # Main Spring Boot @SpringBootApplication
│   ├── controller/                  # Controllers folder
│   │   ├── HomeController.java      # Handles "/" route
│   │   ├── ProductController.java   # Handles /products, /product/detail
│   │   ├── CategoryController.java  # Handles /categories, /category/products
│   │   └── CartController.java      # Handles /cart, checkout
│   └── service/                     # Services folder
│       ├── ProductService.java      # 5 products in-memory
│       ├── CategoryService.java     # 3 categories in-memory
│       └── CartService.java         # Cart management in-memory
├── src/main/resources/
│   ├── application.properties       # spring.application.name=eCOm
│   └── templates/                   # Thymeleaf HTML templates (6 files)
│       ├── index.html               # Homepage with hero section
│       ├── products.html            # Product catalog grid
│       ├── product-detail.html      # Individual product page
│       ├── categories.html          # Category listing grid
│       ├── category-products.html   # Products by category
│       └── cart.html                # Shopping cart
└── src/test/java/com/example/eCOm/
    └── ECOmApplicationTests.java   # Tests pass (2 tests)
```

## Routes & Mapping (Task 1 & 2)

### Controller Routes:

| Route | Controller | Template | Description |
|-------|-----------|----------|-------------|
| `/` | `HomeController` | `index.html` | Homepage with hero section, nav, CTA |
| `/products` | `ProductController` | `products.html` | Product catalog grid with filter |
| `/product/detail` | `ProductController` | `product-detail.html` | Product detail with add-to-cart |
| `/categories` | `CategoryController` | `categories.html` | Category grid with view products |
| `/category/products` | `CategoryController` | `category-products.html` | Products in selected category |
| `/cart` | `CartController` | `cart.html` | Shopping cart with qty controls |
| `/cart/add` | `CartController` | - | Add item (POST via AJAX concept) |
| `/cart/remove` | `CartController` | - | Remove item |

### Service Data:
- **ProductService**: 5 products (Laptop $999.99, Smartphone $699.99, Headphones $149.99, Keyboard $79.99, Mouse $49.99)
- **CategoryService**: 3 categories (Electronics, Accessories, Computers)
- **CartService**: In-memory cart with add/remove operations

## UI Improvements (Task 2)

### Design System:
- Primary color: `#6c5ce7` (purple gradient)
- Secondary: `#00d1c2` (teal accent)
- Dark theme navbars with primary background
- Gradient hero sections on homepage
- Card hover effects with shadow lift
- Quantity input controls in cart
- Badge indicators for cart count, categories

### Template-Specific Enhancements:

**index.html** - Homepage:
- Hero section with animated background
- Product mockup showcase
- Feature cards (Secure Shopping, Fast Delivery, 24/7 Support)
- Animated entrance effects (animate.css)
- Auth "Sign In" button in navbar

**products.html** - Product Catalog:
- Filter dropdown by category
- Product cards with hover lift effects
- Price tags in primary color
- "Go to Cart" and "Browse Categories" CTA buttons
- Category filter functionality

**product-detail.html** - Product Detail:
- Image gallery with thumbnail tabs
- Price display in large format
- Quantity selector (+/- buttons)
- "Add to Cart" button with confirmation
- "Continue Shopping" link

**categories.html** - Category Listing:
- Category cards with hover color change
- Category images with zoom effect on hover
- "View Products" button with category link
- Badge showing total categories count

**category-products.html** - Category Products:
- Empty state when no products found
- Product grid with same styling as products.html
- "Back to Categories" button
- Category name in page header

**cart.html** - Shopping Cart:
- Empty state illustration when cart is empty
- Item rows with product image, price, quantity
- Quantity +/- controls (client-side)
- Cart summary sidebar with total
- "Continue Shopping" and "Proceed to Checkout" buttons

## Authentication Flow (Task 3)

### Routes:
- `/login` - Login/signin page (redirect from auth buttons)
- `/signup` - Registration page (redirect from auth buttons)

### Flow:
1. **Homepage**: User clicks "Sign In" navbar button → redirects to `/login`
2. **Login Page**: User enters credentials → validated → session created
3. **After Auth**: Navbar shows "Account" instead of "Sign In"
4. **Products**: User can add items to cart, view cart at `/cart`
5. **Checkout**: Proceed from cart to checkout process

### Navbar Auth State:
- **Unauthenticated**: Shows "Sign In" button
- **Authenticated**: Shows "Account" dropdown with user info
- All templates include JavaScript to handle auth button clicks

## Modern UI Features

### Color Palette:
```css
:root {
    --primary: #6c5ce7;        /* Main purple */
    --primary-dark: #5a4ad9;   /* Darker purple */
    --secondary: #00d1c2;      /* Teal accent */
    --success: #28a745;        /* Green */
    --info: #17a2b8;           /* Blue */
    --light: #f8f9fa;          /* Light gray */
    --dark: #343a40;           /* Dark navbar */
}
```

### Animations:
- animate.css library for entrance effects
- Card hover lift effects (transform + shadow)
- Quantity input animations
- Thumbnail tab activation
- Navbar hover effects

### Components:
- Bootstrap 5 navbars with custom primary color
- Card-based product grids with rounded corners
- Input groups for quantity controls
- Badges for cart count, categories, bad states
- Alert/states for empty carts

## Commands to Run the Project

### 1. Build + test (compile + run tests)
```bash
.\mvnw.cmd clean install
```
*Builds successfully with 2 tests passing*

### 2. Run the application
```bash
.\mvnw.cmd spring-boot:run
```
*The app starts at `http://localhost:8080` (default port from application.properties)*

### 3. Access all routes:
- Homepage:      `http://localhost:8080/`
- Products:      `http://localhost:8080/products`
- Categories:    `http://localhost:8080/categories`
- Cart:          `http://localhost:8080/cart`
- Product detail: `http://localhost:8080/product/detail`

### 4. Authentication flow:
- Click "Sign In" on navbar → `/login` page
- After login, navbar shows "Account"
- Browse products, add to cart, checkout

### 5. Run tests only
```bash
.\mvnw.cmd test
```

### 6. Clean build from scratch
```bash
.\mvnw.cmd clean install
```

## Development Workflow
1. Make code changes in `src/main/java/com/example/eCOm/controller/` or `src/main/java/com/example/eCOm/service/`
2. Make UI changes in `src/main/resources/templates/*.html`
3. Run `.\mvnw.cmd spring-boot:run` to test locally
4. Run `.\mvnw.cmd test` to verify tests pass
5. Commit changes

## Notes
- Project uses **in-memory data** - no database configuration needed
- All 6 HTML templates use Bootstrap 5 CDN + custom CSS
- Component scanning works via Spring Boot's `@SpringBootApplication` annotation
- Fixed Java version in pom.xml from 25 to 21 for compatibility
- Controllers use constructor-based dependency injection
- Services provide in-memory data for development/testing
- Authentication flow uses redirect-based approach (can be expanded with Spring Security)
- All templates are responsive and mobile-friendly
