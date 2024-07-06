create table medicos(
    id bigint not null auto_increment,
    nombre  varchar(100) not null,
    edad  varchar(20) not null,
    numero_telefono varchar(40),
    email  varchar(100) not null unique,
    identidad  varchar(100) not null unique,
    especialidad  varchar(100) not null,
    pais  varchar(100) not null,
    estado  varchar(100) not null,
    ciudad varchar(100) not null,
    calle varchar(100) not null,
    tipo_vivienda varchar(100) ,
    numero_vivienda varchar(30) ,



    primary key(id)

);