use management;

drop table items_promotions;
drop table items;
drop table promotions;
drop table categories;
 
create table items (
  id int(11) NOT NULL auto_increment,
  barcode varchar(30) NOT NULL,
  name varchar(30) NOT NULL,
  unit varchar(4) NOT NULL,
  price double NOT NULL,
  categoryId int(11) default NULL,
  PRIMARY KEY  (id)
);

create table promotions(
   id int not null auto_increment,
   proDesc varchar(200),
   type int not null,
   primary key(id)
);

create table items_promotions(
   itemId int not null references items(id),
   proId int not null references promotions(id),
   discount double,
   primary key(itemId,proId),
   foreign key(itemId) references items(id),
   foreign key(proId) references promotions(id)
);
create table categories (
  id int(11) NOT NULL auto_increment,
  name varchar(30) NOT NULL,
  PRIMARY KEY  (id)
);
alter table items add constraint cate_item_fk foreign key(categoryId) references categories(id);
insert into categories values(null,'水果');
insert into categories values(null,'饮料');
insert into categories values(null,'运动器材');

insert into items values(null,'ITEM000001','葡萄','斤',6.5,1);
insert into items values(null,'ITEM000002','橙汁','瓶',3.5,2);
insert into items values(null,'ITEM000003','苹果','斤',2.5,1);
insert into items values(null,'ITEM000004','羽毛球','个',1.0,3);
insert into items values(null,'ITEM000005','可口可乐','瓶',4.0,2);

insert into promotions values(null,'买二赠一', 1);
insert into promotions values(null,'第二件半价', 2);
insert into promotions values(null,'打折', 3);

insert into items_promotions values(1,1,1.0);
insert into items_promotions values(1,2,1.0);
insert into items_promotions values(1,3,0.65);
insert into items_promotions values(3,1,1.0);
insert into items_promotions values(3,2,1.0);
insert into items_promotions values(3,3,0.70);
insert into items_promotions values(5,1,1.0);
insert into items_promotions values(5,2,1.0);
insert into items_promotions values(5,3,0.75);

