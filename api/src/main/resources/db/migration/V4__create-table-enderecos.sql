create table enderecos (
    id bigint not null auto_increment primary key,
    logradouro varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20) not null,
    cidade varchar(100) not null,
    pessoa_id bigint not null,
    foreign key (pessoa_id) references pessoas(id)
);