create table alkatresz(
	id int primary key not null,
    cikkszam varchar(15) not null,
    megnevezes varchar(60) not null,
    auto_tipus varchar(30) not null,
    ar int not null,
    raktar_id int not null
);

create table raktar(
	id int primary key not null,
    nev varchar(50) not null,
    varos varchar(30) not null
);

alter table alkatresz
add constraint alkatresz_fk foreign key(raktar_id) references raktar(id);