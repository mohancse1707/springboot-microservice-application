DROP TABLE IF EXISTS product_review;

CREATE TABLE product_review (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              product_id VARCHAR(250) NOT NULL,
                              average_review_score BIGINT DEFAULT NULL,
                              number_of_review BIGINT DEFAULT NULL
);

INSERT INTO product_review (product_id, average_review_score, number_of_review) VALUES
('S23867', 4, 20),
('BB5476', 5, 45)