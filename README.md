
  
## 📚 Data Structures, Algorithms & Advanced OOP - Week 3 

---

## Day 1 – Linked List Implementation & Modular Design  
**Date:** 02-Jan-2026  

---

### 1. Singly Linked List

**Definition:**  
A singly linked list is a linear data structure in which each element (node) contains data and a reference to the next node in the sequence.

**Key Points:**
- Each node stores data and a pointer to the next node
- Traversal is possible in one direction only
- Insertion and deletion are efficient compared to arrays
- Does not support direct random access


**Code Link:**  
👉https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/linkedlist/singlylinkedlist

---

### 2. Doubly Linked List

**Definition:**  
A doubly linked list is a data structure in which each node contains data, a reference to the previous node, and a reference to the next node.

**Key Points:**
- Supports bidirectional traversal
- Each node maintains two references (previous and next)
- Easier deletion of nodes compared to singly linked lists
- Requires additional memory due to extra pointer

**Code Link:**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/linkedlist/doublylinkedlist

### 3. Circular Linked List

**Definition:**  
A circular linked list is a linked list where the last node points back to the first node instead of pointing to null, forming a circular structure.

**Key Points:**
- No node points to null
- Continuous traversal is possible
- Useful for cyclic processes such as scheduling
- Can be singly or doubly linked

**Code Link:**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/linkedlist/circularlinkedlist


### 4. Helper Methods & Modular Design

**Definition:**  
Modular design is a programming approach that divides complex logic into smaller, reusable, and independent methods to improve code readability and maintainability.

**Key Points:**
- Enhances code reusability and clarity
- Simplifies debugging and testing
- Encourages separation of concerns
- Common helper methods include insertion, deletion, search, and traversal

---


## Day 2 – Stack, Queue, HashMap & OOP Applications  
**Date:** 03-Jan-2026  

**Code Link:**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/stackqueuehashmap


### 1. Stack

**Definition:**  
A stack is a linear data structure that follows the **Last In, First Out (LIFO)** principle, where elements are added and removed from the top.

**Key Points:**
- Supports push and pop operations
- Access is restricted to the top element
- Commonly used in recursion and expression evaluation

---

### 2. Queue

**Definition:**  
A queue is a linear data structure that follows the **First In, First Out (FIFO)** principle, where elements are inserted at the rear and removed from the front.

**Key Points:**
- Supports enqueue and dequeue operations
- Maintains processing order
- Used in scheduling and task management

---

### 3. HashMap

**Definition:**  
A HashMap stores data as key-value pairs and enables fast access using hashing.

**Key Points:**
- Provides average O(1) lookup time
- Does not maintain insertion order
- Allows one null key

---

### 4. Hashing Functions

**Definition:**  
A hashing function maps a key to an index in a hash table for efficient data storage and retrieval.

**Key Points:**
- Distributes keys uniformly
- Reduces collisions
- Improves performance of HashMap operations

---



## 🗓️ Day 3 – Advanced OOP Scenario-Based Applications & Sorting Algorithms 
**Date:** 05-Jan-2026

---
## Sorting Algorithms

This section contains implementations of common sorting algorithms in Java, with brief explanations and time complexity analysis.

---

### Bubble Sort
A simple comparison-based algorithm that repeatedly swaps adjacent elements if they are in the wrong order.

- **Use Case:** Student Marks  
- **Time Complexity:**  
  Best: O(n) | Average: O(n²) | Worst: O(n²)  
- **Code:**  
  https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/sorting/BubbleSortStudentMarks.java  

---

### Insertion Sort
Builds the sorted array one element at a time by inserting elements into their correct position.

- **Use Case:** Employee IDs  
- **Time Complexity:**  
  Best: O(n) | Average: O(n²) | Worst: O(n²)  
- **Code:**  
  https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/sorting/InsertionSortEmployeeIDs.java  

---

### Selection Sort
Selects the minimum element from the unsorted part and places it at the beginning.

- **Use Case:** Exam Scores  
- **Time Complexity:**  
  Best: O(n²) | Average: O(n²) | Worst: O(n²)  
- **Code:**  
  https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/sorting/SelectionSortExamScores.java  

---

### Merge Sort
A divide-and-conquer algorithm that splits the array and merges sorted subarrays.

- **Use Case:** Book Prices  
- **Time Complexity:**  
  Best / Average / Worst: O(n log n)  
- **Code:**  
  https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/sorting/MergeSortBookPrices.java  

---

### Quick Sort
Partitions the array around a pivot and recursively sorts the subarrays.

- **Use Case:** Product Prices  
- **Time Complexity:**  
  Best / Average: O(n log n) | Worst: O(n²)  
- **Code:**  
  https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/sorting/QuickSortProductPrices.java  

---

### Heap Sort
Uses a binary heap data structure to sort elements efficiently.

- **Use Case:** Job Applicant Salaries  
- **Time Complexity:**  
  Best / Average / Worst: O(n log n)  
- **Code:**  
  https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/sorting/HeapSortSalary.java  

---

### Counting Sort
A non-comparison-based sorting algorithm suitable for a known range of integer values.

- **Use Case:** Student Ages  
- **Time Complexity:**  
  Best / Average / Worst: O(n + k)  
- **Code:**  
  https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/sorting/CountingSortStudentAges.java  

---

## Day 4 – String Operations, File I/O, Search Algorithms & OOP Practice  
**Date:** 07-Jan-2026  

---

### 1. StringBuilder & StringBuffer

**Definition:**  
StringBuilder and StringBuffer are mutable classes in Java used to perform efficient string manipulation operations.

**Key Points:**
- StringBuilder is faster but not thread-safe
- StringBuffer is thread-safe but slower
- Both are preferred over String for repeated concatenation

**Code Link:**  
👉 (https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/linearandbinary/stringbuffer)

---

### 2. FileReader & InputStreamReader

**Definition:**  
FileReader and InputStreamReader are Java classes used to read data from files using character-based input streams.

**Key Points:**
- FileReader reads characters directly from files
- InputStreamReader bridges byte streams to character streams
- Suitable for handling large file I/O operations

**Code Link:**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/linearandbinary/filereader

---

### 3. Linear Search

**Definition:**  
Linear Search is a simple searching algorithm that checks each element sequentially until the target value is found.

**Key Points:**
- Works on both sorted and unsorted data
- Time complexity is O(n)
- Simple but inefficient for large datasets

**Code Link:**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/linearandbinary/linearsearch

---

### 4. Binary Search

**Definition:**  
Binary Search is an efficient searching algorithm that repeatedly divides a sorted dataset into halves to locate the target element.

**Key Points:**
- Requires sorted data
- Time complexity is O(log n)
- Significantly faster than linear search for large inputs

**Code Link:**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/linearandbinary/binarysearch

---


## Day 5 – Algorithm Runtime Analysis & Advanced OOP Systems  
**Date:** 08-Jan-2026  

This session focuses on analyzing and comparing the **runtime performance of algorithms and data structures** to understand their efficiency on large-scale inputs.


**Code Link:**  
👉 https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/gcr-codebase/JavaDsaConcepts/src/com/algoruntimeanalysis


### 1. Linear Search vs Binary Search

**Definition:**  
Comparison of two searching algorithms to evaluate their performance on large datasets.

| Aspect        | Linear Search | Binary Search |
|--------------|--------------|---------------|
| Data Order   | Unsorted     | Sorted only   |
| Time Complexity | O(n)      | O(log n)     |
| Performance  | Slow for large data | Fast for large data |

---

### 2. Bubble Sort vs Merge Sort vs Quick Sort

**Definition:**  
Comparison of sorting algorithms to analyze scalability and efficiency.

| Algorithm    | Average Time Complexity | Performance on Large Data |
|-------------|-------------------------|---------------------------|
| Bubble Sort | O(n²)                   | Poor                      |
| Merge Sort  | O(n log n)              | Very Good                 |
| Quick Sort  | O(n log n)              | Excellent (average case)  |

---

### 3. String vs StringBuilder vs StringBuffer

**Definition:**  
Comparison of string concatenation approaches based on mutability and performance.

| Feature        | String | StringBuilder | StringBuffer |
|---------------|--------|---------------|--------------|
| Mutability   | Immutable | Mutable | Mutable |
| Thread Safety| No | No | Yes |
| Performance  | Slow | Fast | Medium |

---

### 4. FileReader vs InputStreamReader

**Definition:**  
Comparison of file reading techniques for handling large files efficiently.

| Aspect            | FileReader | InputStreamReader |
|------------------|------------|-------------------|
| Stream Type      | Character-based | Byte-to-character |
| Control          | Limited    | Better control    |
| Large File Handling | Moderate | More efficient |

---

### 5. Recursive vs Iterative Fibonacci

**Definition:**  
Analysis of Fibonacci number computation approaches with respect to runtime and memory usage.

| Approach   | Time Complexity | Space Usage | Performance |
|-----------|----------------|-------------|-------------|
| Recursive | Exponential     | High        | Poor        |
| Iterative | Linear          | Low         | Efficient   |

---

### 6. Array vs HashSet vs TreeSet Search

**Definition:**  
Comparison of search efficiency across different data structures.

| Data Structure | Search Complexity | Ordering |
|---------------|------------------|----------|
| Array         | O(n)             | Maintained |
| HashSet       | O(1) (average)   | Unordered |
| TreeSet       | O(log n)         | Sorted |




---

## Day 6 (10-Jan-2026): Scenario-Based DSA Applications

This day focuses on implementing **real-world applications using Data Structures** in Java.  
Each scenario is mapped to a suitable data structure to strengthen problem-solving skills.

---

### 📌 Topics Covered
- Real-world data structure implementations
- HashMap + LinkedList combination
- Doubly LinkedList + Stack for navigation
- Queue-based systems
- Circular LinkedList for round-robin scheduling

---

## 📂 Scenario-Based Projects Implemented

**Base Path:**  
`dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/`

---


###  AmbulanceRoute – Ambulance Route Tracker  
**Data Structures Used:** Graph (Adjacency List) / Queue  
**Location:**  
📁 `ambulanceroute`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/ambulanceroute

**Description:**  
Tracks ambulance navigation and route traversal for emergency response.

**Key Features:**  
- Route calculation  
- Fast traversal simulation  
- Emergency path planning  

---

###  Bookshelf – Book Arrangement & Search System  
**Data Structures Used:** ArrayList / LinkedList  
**Location:**  
📁 `bookshelf`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/bookshelf

**Description:**  
Manages books organization, searching, and tracking in a digital bookshelf.

**Key Features:**  
- Book insert/remove operations  
- Search by title/author  
- Organized book records  

---

###  BrowserBuddy – Browser Tab Management  
**Data Structures Used:** Stack  
**Location:**  
📁 `browserbuddy`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/browserbuddy

**Description:**  
Simulates browser back/forward navigation using stack operations.

**Key Features:**  
- Back button simulation  
- Forward button simulation  
- Tab navigation tracking  

---

###  CallCenter – Call Management System  
**Data Structures Used:** Queue  
**Location:**  
📁 `callcenter`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/callcenter

**Description:**  
Manages call requests and agent assignment in a call center environment.

**Key Features:**  
- Customer call queue handling  
- Agent allocation simulation  
- Smooth call processing  

---

###  EventManager – Event Registration & Attendance  
**Data Structures Used:** ArrayList / LinkedList  
**Location:**  
📁 `eventmanager`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/eventmanager

**Description:**  
Handles user registrations and event flow management for events and programs.

**Key Features:**  
- Attendee registration system  
- Attendance tracking  
- Smooth event operations  

---

###  ExamCell – Exam Cell Allocation & Student Handling  
**Data Structures Used:** LinkedList / HashMap  
**Location:**  
📁 `examcell`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/examcell

**Description:**  
Manages student assignment and exam-related operations using dynamic handling.

**Key Features:**  
- Student registration handling  
- Easy record updates  
- Dynamic data management  

---

###  ExamProctor – Exam Proctoring & Monitoring  
**Data Structures Used:** Stack / LinkedList  
**Location:**  
📁 `examproctor`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/examproctor

**Description:**  
Simulates proctor monitoring system for exam halls and activity tracking.

**Key Features:**  
- Proctor monitoring workflow  
- Student activity tracking  
- Sequential hall traversal  

---

###  HospitalQueue – Hospital Patient Queue Management  
**Data Structures Used:** Queue  
**Location:**  
📁 `hospitalqueue`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/hospitalqueue

**Description:**  
Manages patients in a hospital based on arrival priority and treatment order.

**Key Features:**  
- Patient enqueue/dequeue  
- Fair treatment order handling  
- Smooth patient flow simulation  

---

###  ParcelTracker – Parcel Tracking System  
**Data Structures Used:** Queue / LinkedList  
**Location:**  
📁 `parcelTracker`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/parcelTracker

**Description:**  
Tracks parcel movement, status updates, and delivery flow using sequential processing.

**Key Features:**  
- Parcel enqueue/dequeue handling  
- Delivery status updates  
- Efficient parcel processing pipeline  

---

###  SmartCheckout – Smart Checkout Billing System  
**Data Structures Used:** Stack / Queue  
**Location:**  
📁 `smartcheckout`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/smartcheckout

**Description:**  
Simulates checkout counters for billing and customer item processing.

**Key Features:**  
- Billing queue simulation  
- Item scanning & total calculation  
- Faster sequential transaction handling  

---

###  TextEditor – Text Editor Undo/Redo Manager  
**Data Structures Used:** Stack  
**Location:**  
📁 `texteditor`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/texteditor

**Description:**  
Implements a text editor with undo/redo functionality using stacks.

**Key Features:**  
- Undo operations  
- Redo operations  
- Efficient edit history tracking  

---

###  TrainCompanion – Train Compartment Navigation  
**Data Structures Used:** LinkedList  
**Location:**  
📁 `traincompanion`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/traincompanion

**Description:**  
Manages passenger movement and compartment navigation in a train.

**Key Features:**  
- Dynamic passenger handling  
- Sequential compartment traversal  
- LinkedList-based data management  

---

###  ZipZipMart – Mart Billing & Customer Flow  
**Data Structures Used:** Queue / ArrayList  
**Location:**  
📁 `zipzipmart`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/zipzipmart

**Description:**  
Handles customer line processing and billing system of a smart mart.

**Key Features:**  
- Customer queue management  
- Fast billing counter simulation  
- Organized customer checkout flow  

---

###  ExamProctor – Exam Proctoring & Monitoring  
**Data Structures Used:** Stack / LinkedList  
**Location:**  
📁 `examproctor`

🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-dsa-practice/dsa-practice/scenario-based/DSAScenarioBasedPractice/src/com/examproctor

**Description:**  
Simulates proctor monitoring system for exam halls and activity tracking.

**Key Features:**  
- Proctor monitoring workflow  
- Student activity tracking  
- Sequential hall traversal  



## Java OOPS – Scenario Based Practice

✅ **Branch:** `java-oops-practice`  
✅ **Path:** `java-oops-practice/scenario-based`

---


### 1️⃣4️⃣ LoanBuddy – Loan Approval Automation  
**Location:** 📁 `loanbuddy`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/loanbuddy

**Short Description:**  
Automates loan approval and EMI calculation based on applicant eligibility.

**Key Features:**  
- Applicant eligibility check (credit score, income)  
- EMI calculation using formula  
- Inheritance for loan types (Home/Auto)  
- Polymorphic EMI logic per loan type  

---

### 1️⃣5️⃣ BookBazaar – Digital Bookstore System  
**Location:** 📁 `bookbazaar`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/bookbazaar

**Short Description:**  
Manages bookstore inventory, orders, and discount logic.

**Key Features:**  
- Book inventory & stock handling  
- Order creation with multiple books  
- Discounts using interface method  
- Polymorphism for EBook vs PrintedBook  

---

### 1️⃣6️⃣ ParkEase – Smart Parking Management System  
**Location:** 📁 `parkease`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/parkease

**Short Description:**  
Assigns parking slots and calculates parking charges for vehicles.

**Key Features:**  
- Slot booking & occupancy tracking  
- Vehicle-based charge calculation  
- Polymorphism for Car/Bike/Truck  
- Encapsulated booking records  

---

### 1️⃣7️⃣ MediStore – Pharmacy Inventory & Sales System  
**Location:** 📁 `medistore`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/medistore

**Short Description:**  
Tracks medicine stock, expiry, and sales operations.

**Key Features:**  
- Medicine inventory management  
- Expiry checking logic  
- Inheritance for Tablet/Syrup/Injection  
- Polymorphic expiry handling  

---

### 1️⃣8️⃣ TourMate – Travel Itinerary Planner  
**Location:** 📁 `tourmate`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/tourmate

**Short Description:**  
Creates trip packages with booking and budget calculations.

**Key Features:**  
- Trip package creation with services  
- Total budget calculation (hotel + transport + activities)  
- Inheritance for Domestic/International trip  
- Polymorphic booking behavior  

---

### 1️⃣9️⃣ Artify – Digital Art Marketplace  
**Location:** 📁 `artify`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/artify

**Short Description:**  
Supports artwork purchase and licensing in a marketplace.

**Key Features:**  
- Artwork listing with license type  
- Wallet deduction on purchase  
- Inheritance for DigitalArt vs PrintArt  
- Polymorphic licensing rules  

---

### 2️⃣0️⃣ FoodLoop – Restaurant Ordering System  
**Location:** 📁 `foodloop`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/foodloop

**Short Description:**  
Manages food ordering, stock, and discount logic.

**Key Features:**  
- Food item availability handling  
- Order total calculation with discount  
- Inheritance for VegItem / NonVegItem  
- Polymorphic discount application  

---

### 2️⃣1️⃣ SkillForge – Online Learning Portal  
**Location:** 📁 `skillforge`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/skillforge

**Short Description:**  
Handles course creation, enrollment, progress, and certification.

**Key Features:**  
- Courses with modules & rating  
- Student/Instructor inheritance  
- Certificate generation interface  
- Polymorphic certificate formats  

---

### 2️⃣2️⃣ HomeNest – Smart Home Device Manager  
**Location:** 📁 `homenest`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/homenest

**Short Description:**  
Controls smart devices like lights, cameras, locks, and thermostats.

**Key Features:**  
- Device base class + subclasses  
- Interface-based control methods  
- Encapsulated device status  
- Polymorphic reset behavior  

---

### 2️⃣3️⃣ BudgetWise – Personal Finance Tracker  
**Location:** 📁 `budgetwise`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/budgetwise

**Short Description:**  
Tracks transactions and generates budget reports.

**Key Features:**  
- Income/expense tracking by category  
- Overspend detection system  
- Monthly vs Annual budget inheritance  
- Polymorphic reporting format  

---

### 2️⃣4️⃣ GameBox – Mobile Game Distribution Platform  
**Location:** 📁 `gamebox`  
🔗 **Folder Link:**  
https://github.com/wanjarisaurabh/BridgeLabz-Training/tree/java-oops-practice/java-oops-practice/scenario-based/gamebox

**Short Description:**  
Manages mobile games with download and demo features.

**Key Features:**  
- Game download & demo system  
- Owned games list per user  
- Inheritance for game genres  
- Polymorphic demo behavior  

---


