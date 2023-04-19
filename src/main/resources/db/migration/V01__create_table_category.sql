CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO category (name) VALUES ('Pizza');
INSERT INTO category (name) VALUES ('Lanche');
INSERT INTO category (name) VALUES ('Refrigerante');
