# Warehouse Management System

A console-based inventory management application built with Java.

The system helps manage products, suppliers, stock movements, and inventory reports through a simple menu-driven interface.

## Features

- **Inventory Dashboard** — View product counts, supplier counts, stock quantities, low-stock items, and warehouse value.
- **Product Management** — Add, view, search, update, and delete products.
- **Supplier Management** — Add, view, search, and delete suppliers.
- **Stock Management** — Record incoming and outgoing stock.
- **Low-Stock Alerts** — Identify products that need restocking.
- **Profit Calculation** — Calculate estimated profit on sales.
- **Purchase History** — Record incoming stock transactions with timestamps.
- **Sales History** — Save sales details and calculated profit.
- **Inventory Reports** — Generate reports containing product details.
- **Admin Login** — Restrict access through a basic login system.

## Tech Stack

- **Language:** Java
- **Collections:** ArrayList
- **File Handling:** FileWriter and Java I/O
- **Data Persistence:** Object serialization
- **Date and Time:** LocalDateTime, DateTimeFormatter
- **Concepts:** Object-oriented programming, encapsulation, constructors, getters, and setters

## Project Structure

```text
Warehouse-Management-System/
├── Main.java
├── Login.java
├── Menu.java
├── Inventory.java
├── Product.java
├── Supplier.java
├── Report.java
├── warehouse_management_system.jar
├── .gitignore
└── LICENSE
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- A Java IDE, such as Eclipse, or a terminal

### 1. Clone the repository

```bash
git clone https://github.com/Ankita-yadav-12/Warehouse-Management-System.git
```

### 2. Open the project

Open the project in your Java IDE and ensure the source files are in the `warehouse_management` package.

### 3. Run the application

Run `Main.java` from your IDE.

Alternatively, compile and run from the directory containing the `warehouse_management` folder:

```bash
javac warehouse_management/*.java
java warehouse_management.Main
```

## Default Login

| Username | Password |
|---|---|
| `admin` | `1234` |

**Note:** The credentials are hardcoded for this project. This login system is intended for demonstration and learning, not production security.

## Data Storage

The application stores data locally using the following files:

- `inventory.dat` — Serialized product and supplier data.
- `PurchaseHistory.txt` — Purchase and incoming-stock records.
- `SalesHistory.txt` — Sales transactions and profit records.
- `InventoryReport.txt` — Generated inventory reports.

These files may be created when the application runs.

## Team & Contributions

**Team:** CodeCrafters

**Ankita Yadav — Team Leader & Lead Developer**

- Led the team and developed the core Java application.
- Implemented inventory, product, and supplier management.
- Developed stock tracking, low-stock alerts, and profit calculations.
- Implemented file-based data storage and report generation.

**Team Members:** Contributed to preparing the project presentation, handling the ppt creation and submission

## Future Improvements

- Develop a web-based user interface.
- Integrate a database such as MySQL.
- Improve authentication and input validation.
- Add visual analytics to the dashboard.
- Introduce automated testing.

## License

This project is licensed under the **Apache License 2.0**. See the `LICENSE` file for details.
