# Spring Boot Kotlin Web Assignment

This Spring Boot web application, developed using Kotlin and Gradle, allows users to upload files containing meter readings. Users can specify the file format (CSV, XLS, or HTML), and the application parses the file, processes the data, and stores it in an H2 database.

---

## Features

- **File Upload:** Users can upload files containing meter readings.
- **File Format Selection:** Supports CSV, XLS, and HTML formats.
- **Data Parsing:** Extracts and processes meter readings from the uploaded file.
- **Consumption Calculation** Normalize values and calculate the consumption.
- **H2 Database Integration:** Stores parsed data into two tables:
  - `Readings`: Contains raw data (meterID, date, and value).
  - `Consumptions`: Contains processed data (meterID, previousDate, currentDate, and consumption).

---

## How It Works

### 1. File Upload
- Users upload a file containing meter readings.
- Example file content:
  ```csv
  meterID,date,value
  12345,2025-01-01,100
  12345,2025-01-02,120
  ```

### 2. File Parsing
- The application parses the file based on the selected format (CSV, XLS, or HTML).
- Extracted data includes:
  - `meterID`
  - `readingDate`
  - `rawValue`

### 3. Database Operations
- **Readings Table:** Stores raw data from the file.
- **Consumptions Table:** Calculates consumption for each meter by comparing consecutive readings. Fields include:
  - `meterID`
  - `lastReadingDate`
  - `currentReadingDate`
  - `consumption` (calculated as `(current value - previous value)`, normalized to cubic meters).

---

## Setup Instructions

### Prerequisites

- **Java Development Kit (JDK):** JDK 17 or higher.
- **Gradle:** Ensure Gradle is installed (or use the included wrapper).

### Steps to Run the Application

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Build the Application:**
   Use the Gradle wrapper to build the project:
   ```bash
   ./gradlew build
   ```

3. **Run the Application:**
   Start the application using the Gradle wrapper:
   ```bash
   ./gradlew bootRun
   ```

4. **Access the Application:**
   Open your web browser and navigate to:
   ```
   http://localhost:8080
   ```

---

## Usage Instructions

1. **Upload a File:**
   - Select a file containing meter readings.
   - Choose the file format (CSV, XLS, or HTML).

2. **Submit the File:**
   - Click the "Upload" button to parse and process the file.

3. **View the Results:**
   - The data is stored in the H2 database.
   - Access the H2 database console at:
     ```
     http://localhost:8080/h2-console
     ```
   - Use the following credentials to log in:
     - **JDBC URL:** `jdbc:h2:mem:testdb`
     - **Username:** `sa`
     - **Password:** (leave blank)

4. **Query the Tables:**
   - `Readings` Table: View raw data.
   - `Consumptions` Table: View calculated consumption data.

---


## Technical Details

### Dependencies

- **Spring Boot Starter Web:** For building the web application.
- **Spring Boot Starter Data JPA:** For database integration.
- **H2 Database:** In-memory database for storing data.


- **H2 Database Console:**
  Enabled in `application.properties`:
  ```properties
  spring.h2.console.enabled=true
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  ```