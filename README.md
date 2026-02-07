# 💻 BridgeLabz-Training

This repository captures my structured learning journey during the **BridgeLabz Training Program**, covering **Core Java, Collections, Java I/O, Java 8 features**, and **real-world scenario-based implementations**.



## 🗓 Week 5: Java IO Programming

Java IO provides powerful APIs for handling **file operations, streams, serialization, CSV and JSON processing** using the `java.io` package.

---

## 📘 Section A: Learning Progress

### 🗓 Day 1 – Java IO Basics & CSV File Handling  
**📅 Date:** 26-Jan-2026

#### 🔹 Topics Covered
- Overview of `java.io` package
- Byte Streams:
  - `InputStream`
  - `OutputStream`
- File handling using:
  - `FileInputStream`
  - `FileOutputStream`
- CSV file format fundamentals
- Efficient file operations using:
  - `BufferedReader`
  - `BufferedWriter`
- OPENCSV library for CSV handling

#### 🔹 Hands-on Practice
- Reading data from CSV files
- Writing processed data back to CSV
- Buffered IO for performance optimization

🔗 **Code Link (CSV Handling):**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-iostreams/gcr-codebase/JavaIOStreamsConcepts/src/com/csvdata

---

### 🗓 Day 2 – JSON Handling & IPL Censor Analyzer  
**📅 Date:** 27-Jan-2026

#### 🔹 Topics Covered
- Reading and parsing JSON files
- Converting Java objects into JSON arrays
- Filtering JSON data using conditions
- Email validation using:
  - Regex
  - JSON Schema
- Merging multiple JSON files
- Data format conversions:
  - JSON → XML
  - CSV → JSON
- Generating JSON reports from data sources

#### 🔹 Mini Project: IPL Censor Analyzer
- Masks IPL team names
- Redacts player-sensitive information
- Supports both **JSON** and **CSV** formats

#### 🔹 JSON Programs Implemented
- `ReadJsonFile`
- `ValidateJson`
- `JsonToXml`
- `CsvToJson`
- `IPLCensorAnalyzer`

🔗 **Code Link (JSON Handling):**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-iostreams/gcr-codebase/JavaIOStreamsConcepts/src/com/jsondata

---



## 📂 Project Structure (Week 5)

```
BridgeLabz-Training/
└── java-iostreams/
    └── gcr-codebase/
        └── JavaIOStreamsConcepts/
            └── src/
                └── com/
                    ├── csvdata/
                    └── jsondata/


```
---

## 🧩 Section B: Scenario-Based Implementations

### 🗓 Day 3 – Annotations, Reflection, CSV & JSON  
**📅 Date:** 28-Jan-2026

#### 🔹 Concepts Applied
- Custom annotations with retention & target policies
- Runtime annotation processing using Reflection API
- CSV reading and structured JSON generation
- Automatic audit logging with timestamps

#### 🔹 Scenario-Based Applications
- **HealthCheckPro** – API Metadata Validator
- **MarkMate** – Student Marksheet Generator (CSV → JSON)
- **EventTracker** – Auto Audit System using annotations

🔗 **Code Link (Scenario-Based Problems):**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-iostreams/scenario-based/ioprogramming/src
