-- Create a sample table and insert data
CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);

INSERT INTO employee (first_name, last_name, email) VALUES
    ('Rose', 'Doe', 'john.doe@example.com'),
    ('Jane', 'Smith', 'jane.smith@example.com');

ALTER TABLE employee
ADD COLUMN adress VARCHAR(100);

UPDATE employee
SET adress = 'Rua do Comércio, 22'
WHERE first_name = 'Rose';