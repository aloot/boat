PRAGMA foreign_keys=ON; 

create table kajtyp(
kaj_id integer primary key not null, 
kaj_namn text not null);

create table kktyp(
kk_id integer primary key not null,
kk_namn text not null, 
kk_pris integer not null);

create table trucktyp(
tr_typ_id integer primary key not null,
tr_typ_namn text not null, 
tr_typ_pris integer not null);

create table truckstatus(
tr_status_id integer primary key not null,
tr_status_namn text not null);

create table empschema(
schema_id  integer primary key not null,
schema_namn text not null);

create table empstatus(
empstatus_id  integer primary key not null,
empstatus_namn text not null);

create table hours(
hours_id integer primary key not null,
hours_123 text not null);

create table volymtyp (
voltyp_id integer primary key not null,
voltyp_namn varchar(255) default NULL,
voltyp_ant_emp integer default NULL,
kk_id integer default NULL,
kaj_id integer default NULL,
tr_typ_id integer default NULL,
foreign key (kk_id) references kktyp(kk_id),
foreign key (kaj_id) references kajtyp(kaj_id),
foreign key (tr_typ_id) references trucktyp(tr_typ_id));

