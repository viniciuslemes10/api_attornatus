create table pessoas(
    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    data_de_nascimento varchar(12) not null,
    logradouro varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20) not null,
    cidade varchar(100) not null,

    primary key(id)
);