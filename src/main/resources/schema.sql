use eventuate;

drop table if exists transaction;

create table transaction (
  id bigint(20) not null auto_increment,
  customer_id bigint(20) not null,
  total_amount decimal(19,3) not null,
  primary key(id)
);

