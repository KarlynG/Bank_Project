CREATE TABLE usuarios(
id       int(255) auto_increment not null,
Nombre     varchar(20),
Apellidos    varchar(255),
Genero     varchar(255),
Tarjeta  varchar(255),
Email varchar(255),
Balance     varchar(50),
Rol      varchar(255)
);

INSERT INTO usuarios VALUES
(0, 42069, 1234, 'Karlyn', 'Garcia Rojas', 'Masculino', '010101010101', 'karlynl251@gmail.com', 0, 'admin');
