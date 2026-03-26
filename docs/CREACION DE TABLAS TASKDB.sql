create table types_id(
id bigint NOT NULL,
type_id varchar(50)
constraint pk_typesid primary key(id)
);
create table costumers(
id bigint NOT NULL,
name varchar(50),
surname varchar(50),
address varchar(100),
type_id bigint,
dni int,
constraint pk_costumers primary key (id),
constraint fk_costumer_address foreign key (type_id) references types_id (id)
);
create table contacts_type(
id bigint NOT NULL,
type_contact varchar(50),
constraint pk_typescontact primary key(id)
);
create table contacts(
id bigint NOT NULL,
costumer_id bigint,
type_contact bigint,
contact varchar(50),
constraint pk_contacts primary key(id),
constraint fk_contact_costumer foreign key(costumer_id) references costumers(id),
constraint fk_contact_type foreign key(type_contact) references contacts_type(id),

);
create table task_states(
id bigint NOT NULL,
state varchar(50),
constraint pk_task_states primary key (id)
);
create table task_importances(
id bigint NOT NULL,
importance Varchar(50),
constraint pk_task_importances primary key (id)
);
create table tasks(
id bigint NOT NULL AUTO_INCREMENT,
name Varchar(50),
descr Varchar(100),
date_time datetime,
state_id bigint,
importance_id bigint,
constraint pk_tasks primary key (id),
constraint fk_tasks_states foreign key (state_id) references task_states(id),
constraint fk_tasks_importances foreign key (importance_id) references task_importances(id)
);