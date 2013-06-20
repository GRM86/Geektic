drop table t_user if exists cascade;

create table t_user (
    id numeric not null,
	age varchar(255) not null,
    nom varchar(255) not null,
    prenom varchar(255) not null,
    pseudo varchar(255) not null,
    mail varchar(255) not null,
    sexe varchar(255) not null,
	avatar integer not null,
    primary key (id)
);
create table t_interet (
    id numeric not null,
    libelle varchar(255) not null,
    primary key (id),
);
create table t_userInteret(
    idUser numeric not null,
    idInteret numeric not null,
    primary key (iduser, idInteret),
    foreign key (iduser) references t_user(id),
    foreign key (idInteret) references t_Interet(id),
);
create table t_audit(
    idUser numeric not null,
    DateHeure TIMESTAMP ,
	IPVISITEUR varchar(255) not null,
	TYPE varchar(255) not null,
    primary key (iduser, DateHeure),
    foreign key (iduser) references t_user(id),
);

insert into t_user values (1,24,'RODRIGO', 'Gabriel', 'Duende', 'gab@rod.com','H',1);
insert into t_user values (2,32,'NIPANTALON', 'Sandra', 'Tounu', 'san@nip.com','F',4);
insert into t_user values (3,42,'SAIRIEN', 'Jean', 'Question', 'jea@sai.com','H',14);
insert into t_user values (4,20,'BAR', 'Leny', 'Boobs', 'gab@rod.com','H',11);
insert into t_user values (5,28,'DEAU', 'Remy', 'Doremi', 'rem@dea.com','H',13);
insert into t_user values (6,23,'PASFAISA', 'Jenna', 'Pasmoi', 'jen@pas.com','F',3);
insert into t_user values (7,38,'RATON', 'Candy', 'What', 'can@rat.com','F',8);
insert into t_user values (8,39,'GELISTE', 'Eva', 'Relique', 'eva@gel.com','F',9);
insert into t_user values (9,39,'HOPOSTE', 'Fidel', 'Guerrier', 'fidhop.com','H',10);
insert into t_user values (10,25,'VAISSEL', 'Aude', 'Propre', 'aud@sav.vai','F',15);
insert into t_user values (11,52,'TREMBLAY', 'Yvon', 'Secousse', 'yvo@tre.com','H',6);
insert into t_user values (12,49,'TERIEUR', 'Alex', 'Outdoor', 'ale@ter.com','H',7);
insert into t_user values (13,24,'DELUNE', 'Claire', 'Lune', 'cla@del.com','F',12);
insert into t_user values (14,24,'KOLLYCK', 'Al', 'Ivre', 'al@kol.com','H',2);
insert into t_user values (15,38,'MEURDESOIF', 'Jean', 'Alcool', 'jea@meu.com','H',1);
insert into t_user values (16,29,'ALAIRE', 'Sabine', 'Ciel', 'sab@all.com','F',5);
insert into t_user values (17,19,'DIOTE', 'Kelly', 'Lista', 'kel@dio.com','F',8);
insert into t_user values (18,26,'STRUEUX', 'Simon', 'Monster', 'sim@tru.com','H',10);
insert into t_user values (19,38,'TABAC', 'Bart', 'Clop', 'bar@tab.com','H',7);
insert into t_user values (20,22,'COURCI', 'Sarah', 'Courte', 'sar@cour.com','F',12);

insert into t_interet values (1, 'JAVA');
insert into t_interet values (2, 'HTML');
insert into t_interet values (3, 'CSS');
insert into t_interet values (4, 'PHP');
insert into t_interet values (5, 'JS');
insert into t_interet values (6, 'CS');
insert into t_interet values (7, 'CPP');
insert into t_interet values (8, 'VB');

insert into T_USERINTERET values (1, 1);
insert into T_USERINTERET values (1, 6);
insert into T_USERINTERET values (1, 5);
insert into T_USERINTERET values (1, 4);
insert into T_USERINTERET values (2, 1);
insert into T_USERINTERET values (2, 6);
insert into T_USERINTERET values (2, 5);
insert into T_USERINTERET values (2, 4);
insert into T_USERINTERET values (3, 3);
insert into T_USERINTERET values (4, 4);
insert into T_USERINTERET values (5, 5);
insert into T_USERINTERET values (6, 6);
insert into T_USERINTERET values (7, 7);
insert into T_USERINTERET values (8, 8);
insert into T_USERINTERET values (9, 1);
insert into T_USERINTERET values (10, 2);
insert into T_USERINTERET values (11, 3);
insert into T_USERINTERET values (12, 3);
insert into T_USERINTERET values (13, 4);
insert into T_USERINTERET values (14, 5);
insert into T_USERINTERET values (15, 6);
insert into T_USERINTERET values (16, 7);
insert into T_USERINTERET values (17, 8);
insert into T_USERINTERET values (18, 1);
insert into T_USERINTERET values (19, 2);
insert into T_USERINTERET values (20, 3);
insert into T_USERINTERET values (10, 4);
insert into T_USERINTERET values (11, 5);
insert into T_USERINTERET values (12, 5);
insert into T_USERINTERET values (13, 6);
insert into T_USERINTERET values (14, 7);
insert into T_USERINTERET values (15, 8);
insert into T_USERINTERET values (16, 1);
insert into T_USERINTERET values (17, 2);
insert into T_USERINTERET values (18, 3);
insert into T_USERINTERET values (19, 4);
insert into T_USERINTERET values (20, 5);