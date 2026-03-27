# ADP Capstone Project
### Applications Development Practice 3 — Assignment 1

## Team Members
| Name | Student Number | Role/Focus |
| :--- | :--- | :--- |
| Siphamandla | 240256891 | |
| Ryan Paledi | 230969429 | |
| Maghdie Petersen | 230600204 | |
| Simphiwe | 221549323 | |
| Inam Ngqokomashe | 222660155 | |
| Tebogo Pii | 230226442 | Warehouse Backend |

---

## Reason for Second Repository
We faced some issues in our previous repository that led us to create a new repository late in the development cycle. The primary cause was merging conflicts resulting from inconsistent project structuring.

**Backstory Reference:** [Link to previous repository]((https://github.com/Maghdie-Happy/ADP-Capstone.git)) — *Provided to show commit history and development progress.*

---

## Domain Problem
This project models an **Inventory and Order Management System** for a supply chain business. The system effectively manages the lifecycle of customers, their orders, products, suppliers, warehouses, and shipments.

---

## UML Class Diagram
![UML Diagram](https://github.com/user-attachments/assets/9978c502-37e3-4fab-a0d7-f9a72ba7cdcf)

---

## Entity Relationship Diagram (ERD)

```mermaid
erDiagram
    Customer ||--o{ CustomerOrder : "places"
    CustomerOrder ||--|{ Shipment : "shipped via"
    CustomerOrder }o--o{ ProductDomain : "contains"
    Supplier }o--o{ ProductDomain : "supplies"
    Warehouse }o--o{ ProductDomain : "stores"

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
