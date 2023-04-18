CREATE TABLE categories (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO categories (nome) VALUES ('Pizza');
INSERT INTO categories (nome) VALUES ('Lanche');
INSERT INTO categories (nome) VALUES ('Refrigerante');
