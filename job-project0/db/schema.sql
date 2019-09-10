drop table if exists Accounts;
drop table if exists Persons;
drop table if exists BankAccounts;

create table Persons(
    id serial primary key,
    firstname text not null,
    lastname text not null,
    phonenumber text not null,
    email text not null
);

create table BankAccounts(
	id serial primary key,
	accountNumber text not null,
	Balance numeric(10,2),
	account_id integer REFERENCES Persons(id)
);

create table Accounts (
	id serial primary key,
	UserName text unique not null,
	Password text not null,
	UserType text not null,
	person integer REFERENCES Persons(id)
);

insert into Accounts(UserName, Password, UserType) values ('adminjob', 'passjob', 'ADMIN');

