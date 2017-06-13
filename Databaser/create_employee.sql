CREATE TABLE `employee` (
`emp_id` integer primary key not null,
  `f_name` varchar(255) default NULL,
  `s_name` varchar(255) default NULL,
  `kk_id` integer default NULL,
  `empstatus_id` integer default NULL,
  `schema_id` integer default NULL,
foreign key (kk_id) references kktyp(kk_id),
foreign key (empstatus_id) references empstatus(empstatus_id),
foreign key (schema_id) references empschema(schema_id));
