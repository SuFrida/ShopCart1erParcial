CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE item (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE shopping_cart (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE shopping_cart ADD CONSTRAINT FK_shopping_cart_customer_id FOREIGN KEY (customer_id) REFERENCES customer(id);

CREATE TABLE shopping_cart_item (
    id INT NOT NULL AUTO_INCREMENT,
    shopping_cart_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE shopping_cart_item ADD CONSTRAINT FK_shopping_cart_item_shopping_cart_id FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id);
ALTER TABLE shopping_cart_item ADD CONSTRAINT FK_shopping_cart_item_item_id FOREIGN KEY (item_id) REFERENCES item(id);


