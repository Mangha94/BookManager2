CREATE TABLE books (
  id varchar(30) NOT NULL,
  title varchar(255) DEFAULT NULL,
  writer varchar(50) DEFAULT NULL,
  publisher varchar(255) DEFAULT NULL,
  price int(11) DEFAULT NULL,
  classification varchar(255) DEFAULT NULL,
  regDate datetime DEFAULT NULL,
  rented tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO books (id,title,writer,publisher,price,classification,regDate,rented) VALUES ('0001' , '백설공주', '월트 디즈니', '디즈니', 3000, '동화', NOW(), false);
INSERT INTO books (id,title,writer,publisher,price,classification,regDate,rented) VALUES ('0002' , '신데렐라', '월트 디즈니', '디즈니', 4000, '동화', NOW(), false);
INSERT INTO books (id,title,writer,publisher,price,classification,regDate,rented) VALUES ('0003' , '인어공주', '월트 디즈니', '디즈니', 7000, '동화', NOW(), false);
INSERT INTO books (id,title,writer,publisher,price,classification,regDate,rented) VALUES ('0004' , '겨울왕국', '월트 디즈니', '디즈니', 1500, '동화', NOW(), false);
INSERT INTO books (id,title,writer,publisher,price,classification,regDate,rented) VALUES ('0005' , '라푼젤', '월트 디즈니', '디즈니', 9000, '동화', NOW(), false);


CREATE TABLE members (
  memberId varchar(30) NOT NULL PRIMARY KEY,
  name varchar(100),
  phonnumber varchar(255) DEFAULT NULL,
  birthday varchar(50) DEFAULT NULL,
  regDate DATETIME,
  pw varchar(60) DEFAULT NULL,
  memberNum VARCHAR(50)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;