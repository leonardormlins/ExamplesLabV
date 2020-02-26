create schema estoque;

use estoque;

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_photo varchar(80) not null,
  usr_senha varchar(50) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table pos_post (
	pos_id bigint unsigned not null auto_increment,
    pos_desc varchar(120),
    pos_picture varchar(80),
    pos_date varchar(20),
    usr_id bigint unsigned not null,
    primary key (pos_id),
    foreign key pos_usr_id (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade
);

create table ufu_followers (
	usr_id_following bigint unsigned not null,
    usr_id_followed bigint unsigned not null,
    primary key (usr_id_following, usr_id_followed),
    foreign key usr_following_fk (usr_id_following) references usr_usuario (usr_id) on delete restrict on update cascade,
    foreign key usr_followed_fk (usr_id_followed) references usr_usuario (usr_id) on delete restrict on update cascade
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key uau_usr_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key uau_aut_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_anotacao (
  ant_id bigint unsigned not null auto_increment,
  ant_assunto varchar(100) not null,
  ant_texto varchar(500) not null,
  ant_data_hora datetime not null,
  usr_criacao_id bigint unsigned not null,
  primary key (ant_id),
  foreign key ant_usr_fk (usr_criacao_id) references usr_usuario(usr_id) on delete restrict on update cascade
);

insert into usr_usuario(usr_nome, usr_senha) values('teste', concat('{MD5}',md5('teste')));
insert into usr_usuario(usr_nome, usr_senha) values('admin', concat('{MD5}',md5('admin')));
insert into aut_autorizacao(aut_nome) values('ROLE_USUARIO');
insert into aut_autorizacao(aut_nome) values('ROLE_ADMIN');
insert into uau_usuario_autorizacao(usr_id, aut_id)
select usr_id, aut_id
from usr_usuario, aut_autorizacao
where usr_nome = 'teste'
and aut_nome = 'ROLE_USUARIO';
insert into uau_usuario_autorizacao(usr_id, aut_id)
select usr_id, aut_id
from usr_usuario, aut_autorizacao
where usr_nome = 'admin';
