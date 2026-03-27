ADP Capstone Project
Applications Development Practice 3 — Assignment 1
Team Members
Names and Student Numbers
Siphamandla 240256891
Ryan Paledi 230969429
Maghdie Petersen230600204
Simphiwe 221549323
Inam Ngqokomashe 222660155
Tebogo Pii 230226442 (Warehouse Backend)

Reason for second repository
We faced some issues in our previous repository that lead us to try making a new repository late as our code was merging due to inconsistent structuring
Here is the link to the previous repository to show we have been working on for commit backstory reasons: 

Domain Problem
This project models an Inventory and Order Management System for a supply chain business. The system manages customers, their orders, products, suppliers, warehouses, and shipments.

UML Class Diagram

<img width="1181" height="896" alt="UML Diagram" src="https://github.com/user-attachments/assets/9978c502-37e3-4fab-a0d7-f9a72ba7cdcf" />


mermaiderDiagram
  Customer {
    String customerId PK
    String name
    String email
    String address
  }
  CustomerOrder {
    String orderId PK
    String orderDate
    String orderStatus
    double totalAmount
    String customerId FK
  }
  ProductDomain {
    String productId PK
    String description
    String category
    double price
    String unitOfMeasure
  }
  Shipment {
    String shipmentId PK
    String orderId FK
    LocalDate shipmentDate
    LocalDate deliveryDate
    String status
    String carrier
  }
  Supplier {
    String supplierId PK
    String supplierName
    String supplierEmail
    String phoneNumber
    String supplierAddress
  }
  Warehouse {
    String warehouseId PK
    String location
    int capacity
  }

  Customer ||--o{ CustomerOrder : "places"
  CustomerOrder ||--|{ Shipment : "shipped via"
  CustomerOrder }o--o{ ProductDomain : "contains"
  Supplier }o--o{ ProductDomain : "supplies"
  Warehouse }o--o{ ProductDomain : "stores"
Relationships explained

A Customer places zero or many CustomerOrders
A CustomerOrder is shipped via one or many Shipments
A CustomerOrder contains one or many ProductDomains (and a product can appear in many orders)
A Supplier supplies one or many ProductDomains (and a product can be supplied by many suppliers)
A Warehouse stores one or many ProductDomains (and a product can be stored in many warehouses)


Project Structure
src/
├── main/java/za/ac/cput/
│   ├── domain/         # Entity classes (Builder Pattern)
│   ├── factory/        # Factory classes
│   └── repository/     # Repository interfaces and implementations
└── test/java/za/ac/cput/
    ├── factory/        # Factory test classes
    └── repository/     # Repository test classes
