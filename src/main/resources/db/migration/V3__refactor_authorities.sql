CREATE TABLE db.authorities (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    KEY customer_id (customer_id),
    CONSTRAINT authorities_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);