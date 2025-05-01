# **TestSoftwareDeveloper Project**

This project is a Spring Boot application designed to manage people (`Persona`) and invoices (`Factura`). Below are the steps to run the project and test the main endpoints using Postman and the H2 database console.

---

## 🚀 Step 1: Run the Project

To start the application, use the following command in your terminal:
```bash
# using gradle
./gradlew bootRun
```
---

## 🌐 Step 2: Access the H2 Database Console

Once the project is running, open the following URL in your browser:
http://localhost:8080/h2-console/


- **JDBC URL**: `jdbc:h2:mem:directorio_db`
- **Username**: `sa`
- **Password**: (leave blank)

Click on **"Connect"** to access the in-memory H2 database and view the `persona` and `factura` tables.

---

## 📬 Step 3: Use Postman to Consume the Endpoints

You can use [Postman](https://www.postman.com/) to test the available endpoints.

---
### 📌 Endpoint: Register a New Persona

-  **Method:**  `POST`
-  **URL:**  `http://localhost:8080/directorio/storePersona`
-  **Body (JSON):**

```json
{
	"nombre": "Rodrigo",
	"apellidoPaterno": "Garcia",
	"apellidoMaterno": "Perez",
	"identificacion": "RGP02305"
}
```

---
### 📌 Endpoint: Get Persona by Identificacion

-  **Method:**  `GET`
-  **URL:** `http://localhost:8080/directorio/findPersonaByIdentificacion/{identificacion}`
- Replace `{identificacion}` with the identification string of the `Persona`.

---
### 📌 Endpoint: Get all Personas

-  **Method:**  `GET`
-  **URL:** `http://localhost:8080/directorio/findPersonas`

---
### 📌 Endpoint: Delete a Persona

-  **Method:**  `DELETE`
- **URL:** `http://localhost:8080/directorio/deletePersona/{identificacion}`
- Replace `{identificacion}` with the identification string of the `Persona`.

---
### 📌 Endpoint: Create a Factura

-  **Method:**  `POST`
-  **URL:**  `http://localhost:8080/factura/storeFactura`
-  **Body (JSON):**

```json
{
	"fecha": "2025-05-01",
	"monto": 500.0,
	"persona": {
		"id": 1
	}
}
```
> Make sure the `Persona` with the given ID already exists.

---
### 📌 Endpoint: Get Facturas by Persona

-  **Method:**  `GET`
-  **URL:** `http://localhost:8080/factura/findFacturasByPersona/{identificacion}`

- Replace `{identificacion}` with the identification of the `Persona`.

---
## ✅ Notes

- Make sure to run the server before testing the endpoints.
- You can view logs in the console to see stored entities.
- The H2 database is in-memory unless configured to persist data.
---
Enjoy coding! 🚀
