
CREATE TABLE inventory_niranjan (
  id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(100) NOT NULL,
  product_desc VARCHAR(100) NOT NULL,
  quantity INT NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO inventory_niranjan (product_name, product_desc, quantity, price) VALUES ('Product_1', 'Product_1', 100, 10);
INSERT INTO inventory_niranjan (product_name, product_desc, quantity, price) VALUES ('Product_2', 'Product_2', 500, 50);