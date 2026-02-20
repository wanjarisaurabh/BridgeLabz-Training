-- Database setup for Banking System

-- Create accounts table
CREATE TABLE IF NOT EXISTS accounts (
    account_number INT PRIMARY KEY,
    holder_name VARCHAR(100) NOT NULL,
    balance DOUBLE DEFAULT 0
);

-- Create transactions table
CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    from_account INT NOT NULL,
    to_account INT NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Sample data
INSERT INTO accounts VALUES (101, 'John Doe', 5000);
INSERT INTO accounts VALUES (102, 'Jane Smith', 3000);
INSERT INTO accounts VALUES (103, 'Bob Johnson', 7500);
