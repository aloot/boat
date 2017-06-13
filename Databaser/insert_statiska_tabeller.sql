insert into kajtyp(kaj_namn) values ('KAJ 101');
insert into kajtyp(kaj_namn) values ('KAJ 201');
insert into kajtyp(kaj_namn) values ('KAJ 301');

insert into kktyp(kk_namn, kk_pris) values('A', 500);
insert into kktyp(kk_namn, kk_pris) values('AA', 700);
insert into kktyp(kk_namn, kk_pris) values('B', 900);
insert into kktyp(kk_namn, kk_pris) values('BB', 1000);
insert into kktyp(kk_namn, kk_pris) values('C', 1250);
insert into kktyp(kk_namn, kk_pris) values('CC', 1500);
insert into kktyp(kk_namn, kk_pris) values('CCC', 3000);
insert into kktyp(kk_namn, kk_pris) values('K', 5000);

insert into trucktyp(tr_typ_namn, tr_typ_pris) values('A001', 1000);
insert into trucktyp(tr_typ_namn, tr_typ_pris) values('AA01', 1500);
insert into trucktyp(tr_typ_namn, tr_typ_pris) values('B001', 2000);
insert into trucktyp(tr_typ_namn, tr_typ_pris) values('BB01', 2500);
insert into trucktyp(tr_typ_namn, tr_typ_pris) values('C001', 3000);
insert into trucktyp(tr_typ_namn, tr_typ_pris) values('CC01', 3500);
insert into trucktyp(tr_typ_namn, tr_typ_pris) values('CCC1', 4000);
insert into trucktyp(tr_typ_namn, tr_typ_pris) values('K001', 6000);

insert into truckstatus(tr_status_namn) values('OK');
insert into truckstatus(tr_status_namn) values('Reparation');
insert into truckstatus(tr_status_namn) values('Reserv');
insert into truckstatus(tr_status_namn) values('Skada');

insert into empschema(schema_namn) values('MF_1');
insert into empschema(schema_namn) values('LS_1');
insert into empschema(schema_namn) values('S_1');
insert into empschema(schema_namn) values('MF_2');
insert into empschema(schema_namn) values('LS_2');
insert into empschema(schema_namn) values('S_2');
insert into empschema(schema_namn) values('MF_3');
insert into empschema(schema_namn) values('LS_3');
insert into empschema(schema_namn) values('S_3');

insert into empstatus(empstatus_namn) values('100%');
insert into empstatus(empstatus_namn) values('50%');
insert into empstatus(empstatus_namn) values('Sjuk');
insert into empstatus(empstatus_namn) values('VAB');
insert into empstatus(empstatus_namn) values('Studier');
insert into empstatus(empstatus_namn) values('Semester');
insert into empstatus(empstatus_namn) values('Slutat');

insert into hours(hours_123) values('00-08');
insert into hours(hours_123) values('08-16');
insert into hours(hours_123) values('16-00');

insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('A005', 5, 1, 1, 1);
insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('AA07', 7, 2, 1, 2);
insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('B005', 5, 3, 2, 3);
insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('BB07', 7, 4, 2, 4);
insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('C005', 5, 5, 2, 5);
insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('CC07', 7, 6, 3, 6);
insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('CCC5', 5, 7, 3, 8);
insert into volymtyp(voltyp_namn, voltyp_ant_emp, kk_id, kaj_id, tr_typ_id) 
values ('K007', 7, 8, 3, 8);

