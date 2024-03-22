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

