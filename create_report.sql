CREATE TABLE report(
report_id integer primary key not null
, datum date not null
, pass integer not null
, kaj_id integer not null
, voltyp_id integer not null
, ship_id integer not null
, total_price integer not null
, foreign key(kaj_id) references kajtyp(kaj_id)
, foreign key (voltyp_id) references volymtyp(voltyp_id)
, foreign key (ship_id) references ships(ship_id)
, unique(datum, pass, kaj_id)
);
