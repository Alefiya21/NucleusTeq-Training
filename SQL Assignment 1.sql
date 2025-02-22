drop database if exists e_commerce;
create database e_commerce;
show databases;
use e_commerce;

CREATE TABLE Customers(
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50),
	email VARCHAR(50),
	mobile VARCHAR(15)
);
CREATE TABLE Products(
	id INT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(200),
	price DECIMAL(10,2) NOT NULL,
	category VARCHAR(50)
);

INSERT INTO Customers (name, email, mobile) 
VALUES
('Amit Sharma', 'amit@gmail.com', '9823456712'),
('Priya Verma', 'priya@gmail.com', '8765432198'),
('Rahul Gupta', 'rahul@gmail.com', '9345678923'),
('Neha Reddy', 'neha@gmail.com', '9123456789'),
('Vikas Singh', 'vikas@gmail.com', '9654321876'),
('Anjali Mehta', 'anjali@gmail.com', '9988776655'),
('Rohan Iyer', 'rohan@gmail.com', '9876543123'),
('Pooja Nair', 'pooja@gmail.com', '9543216789'),
('Suresh Patil', 'suresh@gmail.com', '9234567891'),
('Kavita Joshi', 'kavita@gmail.com', '9123456798'),
('Arjun Rao', 'arjun@gmail.com', '9786543210'),
('Sneha Kulkarni', 'sneha@gmail.com', '9876123456'),
('Manoj Pillai', 'manoj@gmail.com', '9012345678'),
('Divya Malhotra', 'divya@gmail.com', '9234567812'),
('Vivek Desai', 'vivek@gmail.com', '9678912345'),
('Meera Choudhary', 'meera@gmail.com', '9123786543'),
('Ravi Saxena', 'ravi@gmail.com', '9456123789'),
('Swati Ghosh', 'swati@gmail.com', '9567123489'),
('Karan Kapoor', 'karan@gmail.com', '9687234512'),
('Sonali Banerjee', 'sonali@gmail.com', '9012876543');

INSERT INTO Products (id, name, description, price, category) VALUES
(1, 'Laptop', 'High-performance laptop with 16GB RAM', 1200.00, 'Electronics'),
(2, 'Smartphone', 'Latest model with 5G support', 800, 'Electronics'),
(3, 'Tablet', '10-inch tablet with stylus support', 400, 'Electronics'),
(4, 'Refrigerator', 'Double-door refrigerator with smart cooling', 1200, 'Home Appliances'),
(5, 'Smartwatch', 'Advanced smartwatch with health tracking', 250, 'Electronics'),
(6, 'Gaming Console', 'Next-gen gaming console with 1TB storage', 500, 'Gaming'),
(7, 'Microwave Oven', 'Convection microwave oven with grill', 300, 'Home Appliances'),
(8, 'Keyboard', 'Mechanical keyboard with RGB lighting', 90, 'Accessories'),
(9, 'Mouse', 'Wireless gaming mouse', 50, 'Accessories'),
(10, 'Wireless Charger', 'Fast charging wireless pad', 80, 'Electronics'),
(11, 'Washing Machine', 'Front-load washing machine with heater', 700, 'Home Appliances'),
(12, 'Bluetooth Speaker', 'Portable Bluetooth speaker with deep bass', 80, 'Audio'),
(13, 'E-Reader', 'E-ink reader with backlight', 130, 'Books'),
(14, 'Wireless Earbuds', 'True wireless earbuds with noise cancellation', 150, 'Audio'),
(15, 'Coffee Maker', 'Automatic coffee maker with timer', 70, 'Home Appliances'),
(16, 'Fitness Tracker', 'Wearable fitness tracker with GPS', 150, 'Wearables'),
(17, 'Monitor', '27-inch 4K UHD Monitor', 350, 'Electronics'),
(18, 'VR Headset', 'Virtual reality headset with motion tracking', 400, 'Gaming'),
(19, 'Smart TV', '55-inch 4K Smart TV with HDR', 700, 'Home Entertainment'),
(20, 'Router', 'Dual-band Wi-Fi router with high speed', 130, 'Networking');


SELECT * FROM Customers;
SELECT * FROM Products;

ALTER TABLE Customers
MODIFY name VARCHAR(50) NOT NULL,
MODIFY email VARCHAR(50) NOT NULL UNIQUE;

ALTER TABLE Customers
ADD COLUMN age INT;

ALTER TABLE Products 
CHANGE id product_id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE Products 
MODIFY description TEXT;

CREATE TABLE `Order`(
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT NOT NULL,
    order_date DATE NOT NULL,
    status ENUM('Pending', 'Success', 'Cancel'),
    payment_method ENUM('Credit', 'Debit', 'UPI'),
    total_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

ALTER TABLE `Order` 
RENAME TO Orders;

ALTER TABLE Orders 
MODIFY status ENUM('Pending', 'Success', 'Cancel') DEFAULT 'Pending';

ALTER TABLE Orders 
MODIFY payment_method ENUM('Credit', 'Debit', 'UPI', 'COD');

ALTER TABLE Orders 
ADD CONSTRAINT fk 
FOREIGN KEY (product_id) REFERENCES Products(product_id);

-- a. Count the number of products as product_count in each category.
select category, count(name) as product_count from Products
group by category;

-- b. Retrieve all products that belong to the 'Electronics' category, have a price between $50 and $500, and whose name contains the letter 'a'.
select * FROM Products 
where category = 'Electronics' AND price BETWEEN 50 AND 500 AND name LIKE '%a%';

-- c. Get the top 5 most expensive products in the 'Electronics' category, skipping the first 2.
select * FROM Products 
where category = 'Electronics'
order by price desc
limit 5 offset 2;

INSERT INTO Orders (customer_id, product_id, quantity, order_date, status, payment_method, total_amount) VALUES
(1, 3, 2, '2024-02-01', 'Success', 'Credit', 3000.00),
(2, 1, 1, '2024-02-02', 'Pending', 'UPI', 1200.00),
(3, 5, 1, '2024-02-03', 'Success', 'Debit', 2500.00),
(4, 7, 2, '2024-02-04', 'Cancel', 'COD', 600.00),
(5, 2, 1, '2024-02-05', 'Pending', 'Credit', 800.00),
(6, 10, 3, '2024-02-06', 'Success', 'UPI', 240.00),
(null , 4, 1, '2024-02-07', 'Success', 'Debit', 1200.00),
(8, 6, 2, '2024-02-08', 'Pending', 'COD', 1000.00),
(9, 8, 5, '2024-02-09', 'Success', 'Credit', 450.00),
(10, 9, 2, '2024-02-10', 'Success', 'UPI', 100.00),
(null, 11, 1, '2024-02-11', 'Pending', 'Debit', 700.00),
(12, 12, 1, '2024-02-12', 'Cancel', 'COD', 80.00),
(13, 14, 2, '2024-02-13', 'Success', 'Credit', 300.00),
(14, 16, 1, '2024-02-14', 'Pending', 'UPI', 150.00),
(15, 18, 1, '2024-02-15', 'Success', 'Debit', 400.00),
(16, 19, 2, '2024-02-16', 'Cancel', 'COD', 1400.00),
(17, 20, 1, '2024-02-17', 'Success', 'Credit', 130.00),
(18, 17, 1, '2024-02-18', 'Pending', 'UPI', 200.00),
(19, 13, 3, '2024-02-19', 'Success', 'Debit', 390.00),
(20, 15, 1, '2024-02-20', 'Pending', 'COD', 70.00);

-- d. Retrieve customers who have not placed any orders.
SELECT c.customer_id, c.name, c.email, c.mobile
FROM Customers c
LEFT JOIN Orders o ON c.customer_id = o.customer_id
WHERE o.customer_id IS NULL;

-- e. Find the average total amount spent by each customer.
select customer_id, avg(total_amount) from Orders
group by customer_id;

-- f. Get the products that have a price less than the average price of all products.
select name from Products
where price < (select avg(price) from Products);

-- g. Calculate the total quantity of products ordered by each customer
select customer_id, sum(quantity) from Orders
group by customer_id;

-- h. List all orders along with customer name and product name.
select o.order_id, c.name AS customer_name, p.name AS product_name, o.quantity, o.total_amount, o.status, o.order_date
from Orders as o
join Customers as c ON o.customer_id = c.customer_id
join Products as p ON o.product_id = p.product_id;

-- i. Find products that have never been ordered.
select p.product_id, p.name, p.price, COUNT(o.product_id) as order_count
from Products p
LEFT JOIN Orders o ON p.product_id = o.product_id
group by p.product_id
having order_count = 0;
