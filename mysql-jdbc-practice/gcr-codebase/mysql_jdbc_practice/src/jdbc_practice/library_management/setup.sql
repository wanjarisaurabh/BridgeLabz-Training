-- Database setup for Library Management System

-- Create books table
CREATE TABLE IF NOT EXISTS books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    quantity INT DEFAULT 1,
    available INT DEFAULT 1
);

-- Create students table
CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);

-- Create borrowing records table
CREATE TABLE IF NOT EXISTS borrowing (
    borrow_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    book_id INT NOT NULL,
    issue_date DATE NOT NULL,
    return_date DATE NOT NULL,
    actual_return_date DATE,
    status VARCHAR(20) DEFAULT 'ISSUED',
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);

-- Sample data
INSERT INTO books VALUES (1, 'Java Programming', 'Herbert Schildt', 'Programming', 5, 5);
INSERT INTO books VALUES (2, 'Data Structures', 'Mark Allen Weiss', 'Computer Science', 3, 3);
INSERT INTO books VALUES (3, 'Clean Code', 'Robert Martin', 'Programming', 4, 4);

INSERT INTO students VALUES (1001, 'Alice Brown', 'alice@email.com');
INSERT INTO students VALUES (1002, 'Charlie Davis', 'charlie@email.com');
