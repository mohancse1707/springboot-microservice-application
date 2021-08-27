DROP TABLE IF EXISTS product;

CREATE TABLE product (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              product_id VARCHAR(250) NOT NULL,
                              product_title VARCHAR(250) NULL,
                              price BIGINT DEFAULT NULL
);

INSERT INTO product (product_id, product_title, price) VALUES
('H0001', 'HP Elite Laptop', 2500),
('M0001', 'MacBook Laptop', 8500),
('L0001', 'Lenovo Laptop', 4000),
('D0001', 'Dell Laptop', 4000);