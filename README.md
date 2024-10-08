# Kosta Auto Part Shop API and Blazor UI

Kosta Auto is a car part shop management system that allows users to manage car parts and their corresponding warehouses. This repository contains both the backend API built with Spring Boot and a frontend UI built using Blazor, allowing for seamless interaction with the system.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Blazor UI](#blazor-ui)
- [API Documentation](#api-documentation)

## Overview

This project is split into two components:

1. **Backend (API)**: A Spring Boot-based RESTful API that manages car parts (`Alkatresz`) and warehouses (`Raktar`).
2. **Frontend (Blazor UI)**: A Blazor WebAssembly project that interacts with the backend API to provide a user interface for managing car parts and warehouses.

The API enables CRUD (Create, Read, Update, Delete) operations on car parts and warehouses, while the Blazor UI serves as the user interface for interacting with these features.

## Features

- **Car Parts Management**: Add, retrieve, update, and search for car parts.
- **Warehouse Management**: Retrieve and manage warehouses and their associated items.
- **Price Update**: Update the price of individual car parts.
- **Item Update**: Update the details of existing items.
- **User Interface**: Blazor UI for interacting with the API through a web browser.
- **Consistent API Response**: Standardized API response format for non-GET operations using `ApiResponseDTO`.

## Technologies Used

- **Backend**:
  - **Java 17**
  - **Spring Boot** (v2.5.6+)
  - **Spring Data JPA**: For database interactions.
  - **H2 Database**: In-memory database for development and testing.
  - **Lombok**: For reducing boilerplate code.
  - **Spring Web**: For building RESTful APIs.
  
- **Frontend**:
  - **Blazor WebAssembly**: For building the web-based user interface.
  - **C#**: As the primary programming language for Blazor.
  - **Razor Components**: For building interactive UI.

## UI Documentation

The Blazor UI provides a web-based interface for managing car parts and warehouses. Through the UI, users can:

- Add, update, and view car parts and their details.
- Search for car parts by name or ID.
- View warehouses and the car parts they store.
- Update car part prices.

Make sure both the API and the Blazor UI are running simultaneously for full functionality.

## API Documentation

Here are the main endpoints available in the API:

### Car Parts

- **Get all items**: `GET /api/getallitems`
- **Search items by name**: `GET /api/search/{name}`
- **Get item by ID**: `GET /api/getitem/{id}`
- **Add item**: `POST /api/additem/{warehouseId}`
- **Update item price**: `PUT /api/updateprice`
- **Update item**: `PUT /api/updateitem/{id}`

### Warehouses

- **Get all warehouses**: `GET /api/getallwarehouses`
- **Get all items by warehouse**: `GET /api/getallitemsbywarehouse`
- **Get warehouses by item**: `GET /api/getallwarehousesbyitem`
- **Get warehouse by ID**: `GET /api/getwarehousebyid/{warehouseId}`
- **Get warehouse by name**: `GET /api/getwarehousebyname/{warehouseName}`

### Response Format

All non-GET operations return a standard response using `ApiResponseDTO`:

```json
{
  "message": "Operation result message",
  "data": null
}
```

For more detailed API documentation, you can refer to the Javadoc comments within the codebase.  
