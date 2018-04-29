create table phonebook(
  id bigint primary key not null,
  firstname varchar(255),
  middlename varchar(255),
  lastname varchar(255),
  phonenumber varchar(32),
  email varchar(255)
);

create sequence seq_phonebook_id as bigint cycle;
