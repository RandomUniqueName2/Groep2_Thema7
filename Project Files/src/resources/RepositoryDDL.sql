drop table BRG_BusinessRule cascade constraints;
drop table BRG_BusinessRuleType cascade constraints;
drop table BRG_BusinessRuleValues cascade constraints;
drop table BRG_Category cascade constraints;
drop table BRG_Column cascade constraints;
drop table BRG_Database cascade constraints;
drop table BRG_RuleToColumn cascade constraints;
drop table BRG_RuleToTable cascade constraints;
drop table BRG_Table cascade constraints;
drop table BRG_View cascade constraints;
drop sequence BRG_key_sequence;

create sequence BRG_key_sequence
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE;

create table BRG_BusinessRule (
	id 						number(10,0) 		not null
  , name 					varchar2(255 char) 	not null
  , operator 				varchar2(255 char)  not null 
  		check(operator in(
  			'IN'
  		  , 'NOTIN'
  		  , 'EQ'
  		  , 'NEQ'
  		  , 'GT'
  		  , 'GTE'
  		  , 'LT'
  		  , 'LTE'
  		))
  , businessruletype_id 	number(10,0)   		not null
  , primary key (id)
 );
 
create table BRG_BusinessRuleType (
	id 						number(10,0) 		not null
  , code					varchar2(4 char)    not null 
  												unique 
  		check(code in(
  			'ARNG'
  		  , 'ACMP'
  		  , 'ALIS'
  		  , 'AOTH'
  		  , 'TCMP'
  		  , 'TOTH'
  		  , 'ICMP'
  		  , 'EOTH'
  		  , 'MODI'
  		))
  ,	description				varchar2(500 char)  not null
  , name					varchar2(255 char)  not null
  , category_id				number(10,0)		not null
  , primary key (id)
);

create table BRG_BusinessRuleValues (
	id 						number(10,0) 		not null
  , value 					varchar2(255 char) 	not null
  , businessRule_id 		number(10,0)        not null
  , primary key (id)
);

create table BRG_Category (
	id 						number(10,0) 		not null
  , name 					varchar2(255 char) 	not null
  , primary key (id)
);

create table BRG_Column (
	id 						number(10,0) 		not null
  , name 					varchar2(255 char) 	not null
  , table_id 				number(10,0)
  , primary key (id)
);

create table BRG_Database (
	id 						number(10,0) 		not null
  , connectionString 		varchar2(255 char)  not null
  , databaseProvider 		varchar2(255 char)  not null
  , primary key (id)
);

create table BRG_RuleToColumn (
    type 					varchar2(255 char)  not null
  , column_id 				number(10,0)		not null
  , rule_id 				number(10,0) 		not null
 );

create table BRG_RuleToTable (
    rule_id 				number(10,0)		not null
  , table_id 				number(10,0)		not null
);

create table BRG_Table (
	id 						number(10,0) 		not null
  , name 					varchar2(255 char) 	not null
  , view_id 				number(10,0)		not null
  , primary key (id)
);

create table BRG_View (
	id 						number(10,0) 		not null
  , name 					varchar2(255 char) 	not null
  , database_id 			number(10,0)		not null
  , primary key (id)
);

alter table BRG_BusinessRule 
	add constraint FK_RuleToType
	foreign key (businessRuleType_id) 
	references BRG_BusinessRuleType;

alter table BRG_BusinessRuleType 
	add constraint FK_TypeToCategory 
	foreign key (category_id) 
	references BRG_Category;

alter table BRG_BusinessRuleValues 
	add constraint FK_ValueToRule 
	foreign key (businessRule_id) 
	references BRG_BusinessRule;

alter table BRG_Column 
	add constraint FK_ColumnToTable 
	foreign key (table_id) 
	references BRG_Table;

alter table BRG_RuleToColumn
	add constraint UC_RTCunique
	unique (column_id, rule_id);
	
alter table BRG_RuleToColumn 
	add constraint FK_RTC_Column 
	foreign key (column_id) 
	references BRG_Column;
	
alter table BRG_RuleToColumn 
	add constraint FK_RTC_Rule 
	foreign key (rule_id) 
	references BRG_BusinessRule;

alter table BRG_RuleToTable 
	add constraint UC_RTTunique 
	unique(table_id, rule_id);
	
alter table BRG_RuleToTable 
	add constraint FK_RTT_Rule
	foreign key (rule_id) 
	references BRG_BusinessRule;
	
alter table BRG_RuleToTable 
	add constraint FK_RTT_Table
	foreign key (table_id) 
	references BRG_Table;

alter table BRG_Table 
	add constraint FK_TableToView
	foreign key (view_id) 
	references BRG_View;

alter table BRG_View 
	add constraint FK_ViewToDatabase
	foreign key (database_id) 
	references BRG_Database;

create or replace trigger BRG_BusinessRule_Trig_ID
  	before insert on BRG_BusinessRule
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;
 
create or replace trigger BRG_BusinessRuleType_Trig_ID
  	before insert on BRG_BusinessRuleType
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;

create or replace trigger BRG_BusinessRuleValues_Trig_ID
  	before insert on BRG_BusinessRuleValues
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;

create or replace trigger BRG_Column_Trig_ID
  	before insert on BRG_Column
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;

create or replace trigger BRG_Database_Trig_ID
  	before insert on BRG_Database
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;
  	
create or replace trigger BRG_Table_Trig_ID
  	before insert on BRG_Table
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;
  	
create or replace trigger BRG_View_Trig_ID
  	before insert on BRG_View
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;
  	
 create or replace trigger BRG_Category_Trig_ID
  	before insert on BRG_Category
  	for each row
  	begin
		select BRG_key_sequence.nextval into :new.ID from dual;
  	end;