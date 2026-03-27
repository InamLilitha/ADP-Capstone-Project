[uml_class_diagram.html](https://github.com/user-attachments/files/26309625/uml_class_diagram.html)ADP Capstone Project
Applications Development Practice 3 — Assignment 1
Team Members
Names anad Student Numbers
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

[Uploading
<div id="erd" style="padding:1rem 0"></div>
<script type="module">
import mermaid from 'https://esm.sh/mermaid@11/dist/mermaid.esm.min.mjs';
const dark = matchMedia('(prefers-color-scheme: dark)').matches;
await document.fonts.ready;
mermaid.initialize({
  startOnLoad: false,
  theme: 'base',
  fontFamily: '"Anthropic Sans", sans-serif',
  themeVariables: {
    darkMode: dark,
    fontSize: '13px',
    fontFamily: '"Anthropic Sans", sans-serif',
    lineColor: dark ? '#9c9a92' : '#73726c',
    textColor: dark ? '#c2c0b6' : '#3d3d3a',
    primaryColor: dark ? '#3C3489' : '#EEEDFE',
    primaryTextColor: dark ? '#CECBF6' : '#26215C',
    primaryBorderColor: dark ? '#7F77DD' : '#534AB7',
    secondaryColor: dark ? '#085041' : '#E1F5EE',
    tertiaryColor: dark ? '#3C3489' : '#EEEDFE',
  },
});
const diagram = `erDiagram
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
`;
const { svg } = await mermaid.render('erd-svg', diagram);
document.getElementById('erd').innerHTML = svg;

document.querySelectorAll('#erd svg .node').forEach(node => {
  const firstPath = node.querySelector('path[d]');
  if (!firstPath) return;
  const d = firstPath.getAttribute('d');
  const nums = d.match(/-?[\d.]+/g)?.map(Number);
  if (!nums || nums.length < 8) return;
  const xs = [nums[0], nums[2], nums[4], nums[6]];
  const ys = [nums[1], nums[3], nums[5], nums[7]];
  const x = Math.min(...xs), y = Math.min(...ys);
  const w = Math.max(...xs) - x, h = Math.max(...ys) - y;
  const rect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
  rect.setAttribute('x', x); rect.setAttribute('y', y);
  rect.setAttribute('width', w); rect.setAttribute('height', h);
  rect.setAttribute('rx', '8');
  for (const a of ['fill', 'stroke', 'stroke-width', 'class', 'style']) {
    if (firstPath.hasAttribute(a)) rect.setAttribute(a, firstPath.getAttribute(a));
  }
  firstPath.replaceWith(rect);
});
document.querySelectorAll('#erd svg .row-rect-odd path, #erd svg .row-rect-even path').forEach(p => {
  p.setAttribute('stroke', 'none');
});
</script>
 uml_class_diagram.html…]()


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
