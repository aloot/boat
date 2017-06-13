CREATE TABLE ships (
 ship_id integer primary key not null,
 ship_name varchar(255) default NULL,
 company varchar(255) default NULL,
 volymtyp_id mediumint default NULL,
foreign key (volymtyp_id) references volymtyp(volymtyp_id)
);