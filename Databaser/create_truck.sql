CREATE TABLE truck (
truck_id integer primary key not null,
  tr_typ_id  mediumint default NULL,
  tr_status_id mediumint default NULL,
foreign key (tr_typ_id) references trucktyp(tr_typ_id),
foreign key (tr_status_id) references trstatus(tr_status_id)
);
