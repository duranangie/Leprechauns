# Leprechauns - Spring Boot

## Introduction
This project aims to develop software that enables the support of operations for a gardening sector company. Its structure encompasses various areas, from office and employee details to the management of clients, orders, products, and payments. Java programming language, Spring Boot framework, and either MySQL or PostgreSQL database will be used for development. The scope of this development is limited to creating a web application with both backend and frontend components following good development practices.

## Technologies
- JWT
- Java
- MySQL
- UI Verse
- Hibernate
- JavaScript
- HTML/CSS
- Spring Web
- Spring Boot
- Spring Security
- Spring Data JPA
- Adobe Illustrator
- Swagger (OpenApi)

## Usage
**Note:** To use and run the project in a better way we really recommend you have installed an IDE such as IntelliJ.

1. First, clone the repository on your local machine.

  ' git clone https://github.com/duranangie/Leprechauns '


  2. Open the project in your IDE.

**Important:** Before running the project, you must have created the database. Run the following SQL script (`fenixgardenDB.sql`) in your MySQL DBMS.

3. Change the `application.properties` if you have modified your MySQL properties like host, port, username, or password.

4. Now run the project. If everything is alright, you won't see any errors in the output console.

**Tip:** Enjoy our software.

## Database
For this project, there is a database named "fenixgarden," designed to support the operations and management of a company dedicated to gardening. Its structure includes various tables covering key aspects of business operations, from internal office organization and employee management to detailed tracking of products, orders, and financial transactions with customers.

- **oficina:** Stores information about the company's different locations, including details such as city, country, and postal code.
- **empleado:** Encompasses data related to personnel, such as names, positions, and hierarchical relationships.
- **producto:** Manages products, including details such as name, range, and quantity in stock.
- **cliente:** Records customer information, including contact details, credit limits, and sales representatives.
- **pedido:** Details customer orders.
- **detalle_pedido:** Provides specific information about the products included in each order, such as quantity and price.
- **pago:** Records transactions made by customers, detailing the payment method, date, and total amount.
- **gama_producto:** Defines product range management, containing descriptions and links to images for each category of offered products.

Overall, this MySQL database provides an organized structure to support the comprehensive operation of a gardening company, covering internal management, customer interactions, and associated financial transactions.

## Model

![image](https://github.com/duranangie/Leprechauns/assets/117625258/534c49f9-e77f-4c43-a8f5-4c42323cb42c)



# Query

## Customer
### Get all
- **URL:** http://localhost:9090/customers
- **Description:** Return a list with the names of all Spanish clients.

### Return a list with the client code of those clients who made some payment in 2008.
- **URL:** http://localhost:9090/customers/clients-from-country/{country}
- **Description:** Return a list with the client code of those clients who made some payment in 2008. Keep in mind that you should remove any repeated client codes.

### Return a list with all clients who are from the city of Madrid and whose sales representative has the employee code 11 or 30.
- **URL:** http://localhost:9090/customers/clients-with-payments-year/{year}
- **Description:** Return a list with all clients who are from the city of Madrid and whose sales representative has the employee code 11 or 30.

### Obtain a list with the name of each client and the name and surname of their sales representative.
- **URL:** http://localhost:9090/customers/clients-in-madrid-with-specific-representatives
- **Description:** Obtain a list with the name of each client and the name and surname of their sales representative.

### Show the name of clients who have made payments along with the name of their sales representatives.
- **URL:** http://localhost:9090/customers/clients-sales-representatives
- **Description:** Show the name of clients who have made payments along with the name of their sales representatives.

### Show the name of clients who have not made payments along with the name of their sales representatives.
- **URL:** http://localhost:9090/customers/clients-with-payments-and-representatives
- **Description:** Show the name of clients who have not made payments along with the name of their sales representatives.

### Return the name of clients who have made payments and the name of their representatives along with the city of the office to which the representative belongs.
- **URL:** http://localhost:9090/customers/clients-without-payments-and-representatives
- **Description:** Return the name of clients who have made payments and the name of their representatives along with the city of the office to which the representative belongs.

### Return the name of clients who have not made payments and the name of their representatives along with the city of the office to which the representative belongs.
- **URL:** http://localhost:9090/customers/clients-with-payments-and-representatives-with-office-city
- **Description:** Return the name of clients who have not made payments and the name of their representatives along with the city of the office to which the representative belongs.

### Return a list showing only the clients who have not made any payments.
- **URL:** http://localhost:9090/customers/clients-without-payments
- **Description:** Return a list showing only the clients who have not made any payments.

### Return a list showing only the clients who have not placed any orders.
- **URL:** http://localhost:9090/customers/clients-without-orders
- **Description:** Return a list showing only the clients who have not placed any orders.

### Return a list showing the clients who have not made any payments and those who have not placed any orders.
- **URL:** http://localhost:9090/customers/clients-without-payments-and-orders
- **Description:** Return a list showing the clients who have not made any payments and those who have not placed any orders.

### Return the name of clients who have not been delivered an order on time.
- **URL:** http://localhost:9090/customers/clients-without-payments-and-orders
- **Description:** Return the name of clients who have not been delivered an order on time.

### Return a list of clients who have placed orders but have not made any payments.
- **URL:** http://localhost:9090/customers/clients-with-late-deliveries
- **Description:** Return a list of clients who have placed orders but have not made any payments.

### How many clients does each country have?
- **URL:** http://localhost:9090/customers/clients-count-by-country
- **Description:** How many clients does each country have?

### Calculate the number of clients the company has.
- **URL:** http://localhost:9090/customers/total-clients
- **Description:** Calculate the number of clients the company has.

### How many clients are located in the city of Madrid?
- **URL:** http://localhost:9090/customers/clients-count-city/{city}
- **Description:** How many clients are located in the city of Madrid?

### Calculate how many clients each of the cities starting with 'M' has.
- **URL:** http://localhost:9090/customers//clients-count-in-cities-starting-with/{letter}
- **Description:** Calculate how many clients each of the cities starting with 'M' has.

### Calculate the number of clients who do not have an assigned sales representative.
- **URL:** http://localhost:9090/customers/clients-without-sales-representative
- **Description:** Calculate the number of clients who do not have an assigned sales representative.

### Return the name of sales representatives and the number of clients each one serves.
- **URL:** http://localhost:9090/customers/sales-representatives-and-client-count
- **Description:** Return the name of sales representatives and the number of clients each one serves.

### Calculate the date of the first and last payment made by each client. The list should display the name and surnames of each client.
- **URL:** http://localhost:9090/customers/first-last-payment-date-by-client
- **Description:** Calculate the date of the first and last payment made by each client. The list should display the name and surnames of each client.

## Office
### Get all
- **URL:** http://localhost:9090/offices
- **Description:** Return a list with the office code and the city where there are offices.

### Return a list with the city and phone number of the offices in Spain.
- **URL:** http://localhost:9090/offices/list-office-and-country"
- **Description:** Return a list with the city and phone number of the offices in Spain.

### List the address of offices that have clients in Fuenlabrada.
- **URL:** http://localhost:9090/offices/city-and-phone
- **Description:** List the address of offices that have clients in Fuenlabrada.

### Return the offices where none of the employees who have been sales representatives for a client who has purchased a product from the Fruits range work.
- **URL:** http://localhost:9090/offices/without-employees-representing-clients-with-fruit-orders
- **Description:** Return the offices where none of the employees who have been sales representatives for a client who has purchased a product from the Fruits range work.

## Employee
### Get all
- **URL:** http://localhost:9090/employees
- **Description:** Return a list with the name, surname, and email of employees whose boss has a boss code equal to 7.

### Return a list with the name, surname, and email of employees whose boss has a boss code equal to 7.
- **URL:** http://localhost:9090/employees/


## Employees

### Boss Details
- **Endpoint:** `http://localhost:8080/employees/boss-details`
- **Description:** Return the position name, name, surname, and email of the company's boss.

### Non-Sales Representatives Details
- **Endpoint:** `http://localhost:8080/employees/non-sales-representatives-details`
- **Description:** Return a list with the name, surname, and position of those employees who are not sales representatives.

### Employees with Supervisors
- **Endpoint:** `http://localhost:8080/employees/employees-with-supervisors`
- **Description:** Return a list with the name of each employee, the name of their boss, and the name of their boss's boss.

### Employees without Office
- **Endpoint:** `http://localhost:8080/employees/employees-without-office`
- **Description:** Return a list showing only the employees who do not have an associated office.

### Employees without Clients
- **Endpoint:** `http://localhost:8080/employees/employees-without-clients`
- **Description:** Return a list showing only the employees who do not have an associated client.

### Employees without Clients and Office Details
- **Endpoint:** `http://localhost:8080/employees/employees-without-clients-and-office-details`
- **Description:** Return a list showing the employees who do not have an associated office and those who do not have an associated client.

### Employees without Office and Clients
- **Endpoint:** `http://localhost:8080/employees/employees-without-office-and-clients`
- **Description:** Return a list with the data of employees who do not have associated clients and the name of their associated boss.

### Total Employees
- **Endpoint:** `http://localhost:8080/employees/total-employees`
- **Description:** Return the total number of employees in the company.

## Payments

### Payment by Paypal
- **Endpoint:** `http://localhost:8080/payments/payment-by-paypal`
- **Description:** Return a list with all payments made in the year 2008 through Paypal, sorted from highest to lowest.

### Way to Pay
- **Endpoint:** `http://localhost:8080/payments/way-to-pay`
- **Description:** Return a list with all payment methods that appear in the payment table, without repetitions.

### Average Payment
- **Endpoint:** `http://localhost:8080/payments/average-payment`
- **Description:** Calculate the average payment in 2009.

### Total Payment by Year
- **Endpoint:** `http://localhost:8080/payments/total-payment-by-year`
- **Description:** Show the total sum of all payments made for each of the years appearing in the payments table.

## Orders

### Find Status
- **Endpoint:** `http://localhost:8080/orders/find-status`
- **Description:** Return a list with the different statuses an order can go through.

### Order Delivered Late
- **Endpoint:** `http://localhost:8080/orders/order-delivered-late`
- **Description:** Return a list of orders that have not been delivered on time.

### Order Delivered Late At Least
- **Endpoint:** `http://localhost:8080/orders/order-delivered-late-at-least`
- **Description:** Return a list of orders whose delivery date has been at least two days before the expected date.

### Rejected in Year
- **Endpoint:** `http://localhost:8080/orders/rejected-in-year/{year}`
- **Description:** Return a list of orders that were rejected in a specific year.

### Delivered January
- **Endpoint:** `http://localhost:8080/orders/delivered-january`
- **Description:** Return a list of orders that have been delivered in the month of January of any year.

### Count by State
- **Endpoint:** `http://localhost:8080/orders/count-by-state`
- **Description:** Count the number of orders in each state, sorted in descending order by the number of orders.

## Products

### Gama Name
- **Endpoint:** `http://localhost:8080/products/gama-name/{gama}`
- **Description:** Return a list of products belonging to a specific range and having more than 100 units in stock, ordered by their selling price.

### Not in Order
- **Endpoint:** `http://localhost:8080/products/not-in-order`
- **Description:** Return a list of products that have never appeared in an order.

### Not in Order with Name
- **Endpoint:** `http://localhost:8080/products/not-in-order-with-name`
- **Description:** Return a list of products that have never appeared in an order, displaying their name, description, and image.

### Prices Range
- **Endpoint:** `http://localhost:8080/products/prices-range`
- **Description:** Calculate the selling price of the most expensive and cheapest product in a single query.

### Top 20 Best Selling
- **Endpoint:** `http://localhost:8080/products/top-20-best-selling`
- **Description:** Return a list of the top 20 best-selling products and the total number of units sold for each one.

## Order Details

### Total Revenue
- **Endpoint:** `http://localhost:8080/orderdetails/total-revenue`
- **Description:** Calculate the total revenue the company has had, including taxable base, VAT, and total invoiced.

### Total Revenue by Product
- **Endpoint:** `http://localhost:8080/orderdetails/total-revenue-by-product`
- **Description:** Calculate the total revenue grouped by product code.

### Total Revenue by Product by OR
- **Endpoint:** `http://localhost:8080/orderdetails/total-revenue-by-product-by-or`
- **Description:** Calculate the total revenue grouped by product code, filtered by codes starting with 'OR'.

### List Total Sales Product Over
- **Endpoint:** `http://localhost:8080/orderdetails/list-total-sales-product-over`
- **Description:** List the total sales of products that have invoiced more than 3000 euros.

### Number of Product per Order
- **Endpoint:** `http://localhost:8080/orderdetails/number-of-product-per-order`
- **Description:** Calculate the number of different products in each order.

### Total Amount per Order
- **Endpoint:** `http://localhost:8080/orderdetails/total-amount-per-order`
- **Description:** Calculate the sum of the total quantity of all products appearing in each order.

## Gama Product

### List Gamas
- **Endpoint:** `http://localhost:8080/gamaproducts/list-gamas`
- **Description:** Return a list of the different product gamas that each client has purchased.

## Backend

### Description
The backend of this project developed in Spring Boot acts as the central engine that handles business logic and data management.

### Class Diagram
- [Class Diagram](link_to_diagram)


## Models

### Customer
Represents a customer in a management system, such as a company's database. Here's a general description of each attribute and its purpose:

- **customerCode:** It's the unique code identifying each customer in the database.
- **customerName:** It's the name of the customer.
- **contactName:** It's the name of the customer's main contact.
- **contactLastName:** It's the last name of the customer's main contact.
- **phone:** It's the phone number of the customer.
- **fax:** It's the fax number of the customer.
- **addressLine1:** It's the first line of the customer's address.
- **addressLine2:** It's the second line of the customer's address (optional).
- **city:** It's the city where the customer is located.
- **region:** It's the region or state where the customer is located (optional).
- **country:** It's the country where the customer is located.
- **zipCode:** It's the zip code of the customer.
- **creditLimit:** It's the credit limit assigned to the customer.
- **repSales:** It's the sales representative assigned to the customer, which is an object of the Employee class.
- **payments:** It's a list of payments made by the customer, which are objects of the Payment class.
- **orders:** It's a list of orders placed by the customer, which are objects of the Order class.

In addition to the attributes, the class also has methods to convert a Customer object to a CustomerDTO (Data Transfer Object) for facilitating data transfer between application layers.

The `toString()` method provides a string representation of a Customer object, useful for debugging and logging.

### Office
Represents an office location in a management system, typically used in the context of a company or organization. Here's a general description of each attribute and its purpose:

- **officeCode:** It's a unique code identifying each office.
- **city:** It's the city where the office is located.
- **country:** It's the country where the office is located.
- **region:** It's the region or state where the office is located (optional).
- **zipCode:** It's the zip code or postal code of the office.
- **phone:** It's the phone number of the office.
- **addressLine1:** It's the first line of the office's address.
- **addressLine2:** It's the second line of the office's address (optional).
- **employees:** It's a list of employees associated with this office.

Additionally, the class has methods to convert an Office object to an OfficeDTO (Data Transfer Object) for transferring data between application layers.

The `toString()` method provides a string representation of an Office object, useful for debugging and logging purposes.

### Employee
Represents an employee within an organization. Here's a general description of each attribute and its purpose:

- **employeeCode:** It's a unique code identifying each employee.
- **name:** It's the first name of the employee.
- **lastName1:** It's the first part of the last name of the employee.
- **lastName2:** It's the second part of the last name of the employee (optional).
- **extension:** It's the extension number of the employee's phone.
- **email:** It's the email address of the employee.
- **role:** It's the job role or position of the employee.
- **office:** It's the office where the employee works, which is an object of the Office class.
- **boss:** It's the supervisor or manager of the employee, which is also an object of the Employee class.
- **customers:** It's a list of customers associated with this employee, typically representing the clients the employee manages.

Additionally, the class has methods to convert an Employee object to an EmployeeDTO (Data Transfer Object) for transferring data between application layers.

The `toString()` method provides a string representation of an Employee object, useful for debugging and logging purposes.

### Payment
Represents a payment transaction within a system. Here's a general description of each attribute and its purpose:

- **transactionId:** It's a unique identifier for each payment transaction.
- **wayToPay:** It indicates the method used for the payment (e.g., credit card, cash, etc.).
- **paymentDate:** It's the date when the payment was made.
- **total:** It's the total amount of the payment.
- **customer:** It's the customer associated with this payment transaction, represented by an object of the Customer class.

Additionally, the class has a method to convert a Payment object to a PaymentDTO (Data Transfer Object) for transferring data between application layers.

The `toString()` method provides a string representation of a Payment object, useful for debugging and logging purposes.

### Order
Represents an order placed within a system. Here's a general description of each attribute and its purpose:

- **orderCode:** It's a unique identifier for each order.
- **orderDate:** It's the date when the order was placed.
- **expectedDate:** It's the expected delivery date for the order.
- **deliverDate:** It's the actual delivery date of the order (nullable).
- **status:** It indicates the status of the order (e.g., pending, delivered, etc.).
- **comments:** It allows for additional comments or notes regarding the order (nullable).
- **customer:** It's the customer associated with this order, represented by an object of the Customer class.

Additionally, the class has a method to convert an Order object to an OrderDTO (Data Transfer Object) for transferring data between application layers.

The `toString()` method provides a string representation of an Order object, useful for debugging and logging purposes.

### Product
Represents a product within a system. Here's a general description of each attribute and its purpose:

- **productCode:** It's a unique identifier for each product.
- **name:** It's the name of the product.
- **gamaProduct:** It represents the product category or range, associated with an object of the GamaProduct class.
- **dimensions:** It provides the dimensions or size of the product.
- **supplier:** It indicates the supplier of the product.
- **description:** It describes the product.
- **amountInStock:** It's the quantity of the product available in stock.
- **salePrice:** It's the selling price of the product.
- **supplierPrice:** It's the price at which the product is purchased from the supplier.

Additionally, the class has a method to convert a Product object to a ProductDTO (Data Transfer Object) for transferring data between application layers.

The `toString()` method provides a string representation of a Product object, useful for debugging and logging purposes.

### OrderDetail
Represents the details of an order, including information about the products included in the order. Below is an overview of each attribute and its purpose:

- **id:** It's an embedded composite primary key consisting of the order code and the product code.
- **order:** It represents the order associated with this order detail.
- **product:** It represents the product included in this order detail.
- **amount:** It indicates the quantity of the product included in the order detail.
- **unitPrice:** It's the price per unit of the product.
- **numberLine:** It
# Services

## OfficeService
- Responsible for handling operations related to office entities in the application.
- Annotated with `@Service` to indicate it's a service component in a Spring application.
- Key methods:
  - `getAllOffices`: Retrieves a list of all offices and maps them to DTOs.
  - `listOfficeCodeAndCity`: Retrieves a list of office codes and cities for all offices.
  - `listCityAndPhoneOfSpanishOffices`: Retrieves a list of office codes, cities, and phone numbers for Spanish offices.
  - `listOfficeAddressesWithClientsInFuenlabrada`: Retrieves a list of office addresses where clients are located in Fuenlabrada.
  - `findOfficesWithoutFruitOrders`: Retrieves a list of offices that do not have orders for fruit products.

## EmployeeService
- Responsible for handling operations related to employee entities in the application.
- Annotated with `@Service`.
- Key methods:
  - `getAllEmployees`
  - `employeesUnderSupervisorCode`
  - `bossDetails`
  - `nonSalesRepresentativesDetails`
  - `employeesWithSupervisors`
  - `employeesWithSupervisorsAndGrandSupervisors`
  - `employeesWithoutOffice`
  - `employeesWithoutClients`
  - `employeesWithoutClientsAndOfficeDetails`
  - `employeesWithoutOfficeAndClients`
  - `employeesWithoutClientsAndSupervisor`
  - `totalEmployees`

## PaymentService
- Manages operations related to payment entities within the application.
- Annotated with `@Service`.
- Key methods:
  - `getAllPayments`
  - `findPaymentsIn2008ByPaypal`
  - `findAllPaymentMethods`
  - `findAveragePaymentFor2009`
  - `findTotalPaymentsByYear`

## OrderService
- Manages operations related to order entities within the application.
- Annotated with `@Service`.
- Key methods:
  - `getAllOrders`
  - `findDistinctStatus`
  - `findOrderDeliveredLate`
  - `findOrderDeliveredLateAtLeast`
  - `findRejectedOrdersInYear`
  - `findAllOrdersDeliveredInJanuary`
  - `findClientsWithDelayedDeliveries`
  - `countOrdersByState`

## ProductService
- Manages operations related to product entities within the application.
- Annotated with `@Service`.
- Key methods:
  - `getAllProducts`
  - `findOrnamentalProductsInStockGreaterThan100`
  - `findProductsNeverOrdered`
  - `findProductsNeverOrderedWithName`
  - `findMaxAndMinProductPrices`
  - `findTop20BestSellingProducts`

## OrderDetailService
- Manages operations related to order detail entities within the application.
- Annotated with `@Service`.
- Key methods:
  - `getAllOrderDetails`
  - `calculateTotalRevenue`
  - `calculateRevenueByProduct`
  - `calculateRevenueByProductFilteredByOR`
  - `listTotalSalesOfProductsOver3000Euros`
  - `calculateNumberOfProductsPerOrder`
  - `calculateTotalQuantityPerOrder`

## GamaProductService
- Manages operations related to product ranges (gammas) within the application.
- Annotated with `@Service`.
- Key methods:
  - `getAllGamaProducts`
  - `listProductRangesPurchasedByCustomer`

## UserService
- Responsible for managing user-related operations within the application.
- Annotated with `@Service`.
- Key methods:
  - `userValidation`
  - `registerUser`

# Controllers

## CustomerController
- Handles HTTP requests related to customer data in the FenixGarden application.

## OfficeController
- Manages HTTP requests related to office data within the FenixGarden application.

## EmployeeController
- Manages HTTP requests related to office data within the FenixGarden application.

## PaymentController
- Manages HTTP requests related to payment data in the FenixGarden application.

## OrderController
- Manages HTTP requests related to orders in the FenixGarden application.

## ProductController
- Responsible for handling HTTP requests related to products in the FenixGarden application.

## OrderDetailController
- Manages HTTP requests related to order details within the FenixGarden application.

## GamaProductController
- Responsible for handling HTTP requests related to gama products in the FenixGarden application.

## UserController
- Responsible for handling user-related HTTP requests in the FenixGarden application.

## EndpointsFilterController
- Responsible for filtering incoming requests to ensure they target valid endpoints.

# Exceptions

## ErrorResponses
- A simple data model used to represent error responses returned by the API.

## GlobalExceptionHandler
- A centralized exception handler for handling various types of exceptions that may occur in the FenixGarden application.

# Security

## Constants
- Contains various constants related to security configurations, especially for handling JWT authentication in the FenixGarden application.

## JWTAuthenticationConfig
- Generates a JWT token for user authentication in the FenixGarden application.

## JWTAuthorizationFilter
- Filters incoming HTTP requests to verify and authorize JWT tokens in the FenixGarden application.

## OpenApiConfig
- Configures security schemes for OpenAPI (Swagger) documentation in the FenixGarden application.

## WebSecurityConfig
- Configures web security settings in the FenixGarden application using Spring Security.

## CORS
- Configures Cross-Origin Resource Sharing (CORS) in the FenixGarden application.

# Frontend

## Designs
- The user interface that end users directly interact with.
![image](https://github.com/duranangie/Leprechauns/assets/117625258/61e813dd-75d6-4721-b4b5-fd6d71421b88)


![image](https://github.com/duranangie/Leprechauns/assets/117625258/8dfc56b5-01de-4609-a543-0fc19c5b17a4)


![image](https://github.com/duranangie/Leprechauns/assets/117625258/4880756b-1a1b-4d33-a9a2-daf68554c11d)


![image](https://github.com/duranangie/Leprechauns/assets/117625258/7266745c-bfa0-4609-94b5-120eec04c393)

![image](https://github.com/duranangie/Leprechauns/assets/117625258/95f4a6b3-6b4d-4877-b47f-6763c8662d60)
![image](https://github.com/duranangie/Leprechauns/assets/117625258/a9d3b3cc-13a5-47f8-9a4a-e13887011396)


![image](https://github.com/duranangie/Leprechauns/assets/117625258/61ca2cc3-6b05-463b-8da2-2b7c659313b3)


![image](https://github.com/duranangie/Leprechauns/assets/117625258/8b41c988-9896-48ed-b445-e15f2a14ba19)


## Functionalities

### app.js
- This JavaScript script manages the loading of the login and main pages based on the current URL.
- It enables logout functionality and redirects users to the main page upon successful login.

### loadLogin.js
- Handles the login functionality, allowing users to log in or register.
- Sends login or registration data to the backend API.
- Displays corresponding messages using SweetAlert.
- Redirects users to the main page upon successful login.

### loadMain.js
- Loads the main page.
- Retrieves the username from the session storage to display it.
- Attaches event listeners to various elements.
- Validates user token and redirects users accordingly using the backend API when they click on different sections.

### validateToken.js
- Validates the user's token by sending a request to the server.
- If the token is valid, retrieves data from the API and displays it using the `displayData` function.
- If the token has expired or is invalid, displays an error message and redirects the user to the login page after a brief delay.

### displayData.js
- Responsible for displaying data on the frontend based on the API endpoint and the type of data.

### Entities
- These files contain the logic to map the entire data corresponding to the endpoint or entity.
- Specifies which data will be displayed in each card HTML.
  - Customers
  - Offices
  - Employees
  - Payments
  - Orders
  - Products
  - OrderDetails
  - Gamas
