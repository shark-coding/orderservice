-- products
INSERT INTO products VALUES ('1', '아이스 아메리카노', '차가운 ice cold', 3500.0);
INSERT INTO products VALUES ('2', '아메리카노', '뜨거운', 3000.0);
INSERT INTO products VALUES ('3', '아이스라떼', '아이스아메리카노 + 우유', 5500.0);
INSERT INTO products VALUES ('4', '라떼', '아메리카노 + 뜨거운 우유', 5000.0);

-- stores
insert into stores values ('1', '하남점', '서울', '02-1111-1111', '0900', '1800');

-- store_products
insert into store_products values ('1', '1', '1', 10);
insert into store_products values ('2', '1', '2', 20);
insert into store_products values ('3', '1', '3', 30);
insert into store_products values ('4', '1', '4', 40);