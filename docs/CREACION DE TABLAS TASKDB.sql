create table task_states(
id bigint NOT NULL,
state Varchar(50),
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