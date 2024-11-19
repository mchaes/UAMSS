DROP SCHEMA IF EXISTS app CASCADE;
CREATE SCHEMA app AUTHORIZATION "usuario-test";

/*Tabla de usuarios*/
CREATE TABLE app.usuarios(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(30)    
);
ALTER TABLE app.usuarios OWNER to "usuario-test";

INSERT INTO app.usuarios(nombre,email,password) VALUES('Marge Simpson','marge@email.com','1234');
INSERT INTO app.usuarios(nombre,email,password) VALUES('Homero Simpson','homero@email.com','1234');


/*Tabla de compras*/
CREATE TABLE app.compras(
	id SERIAL PRIMARY KEY, 
	id_usuario INTEGER,
	producto VARCHAR(100),	
	precio FLOAT,
	FOREIGN KEY(id_usuario) REFERENCES app.usuarios(id)	
);
ALTER TABLE app.compras OWNER to "usuario-test";

INSERT INTO app.compras(id_usuario,producto,precio) VALUES(1,'Caballete',1730.50);
INSERT INTO app.compras(id_usuario,producto,precio) VALUES(1,'Disco vinil Ringo Starr',1500.50);
INSERT INTO app.compras(id_usuario,producto,precio) VALUES(2,'TV',20000.50);
INSERT INTO app.compras(id_usuario,producto,precio) VALUES(2,'Six pack cerveza duff',360);
INSERT INTO app.compras(id_usuario,producto,precio) VALUES(2,'Bolsa papas',500);