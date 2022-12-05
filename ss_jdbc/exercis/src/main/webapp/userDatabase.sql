DROP DATABASE IF EXISTS denmo1;
CREATE DATABASE demo1;
USE demo1;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER //
CREATE PROCEDURE `delete`(IN user_id INT)
BEGIN 
delete from users where id =user_id;
END//
DELIMITER ;

call `delete`(1);


DELIMITER //
CREATE PROCEDURE display_list_user()
BEGIN 
SELECT * FROM users;
END//
DELIMITER ;

CALL display_list_user();

DELIMITER //
CREATE PROCEDURE update_info(IN name VARCHAR(50),IN email VARCHAR(50),IN country VARCHAR(50),IN id_user INT)
BEGIN 
update users set name = name,email= email, country =country where id = id_user;
END//
DELIMITER ;

CALL update_info("tan",'tantran@gmail','vietnam',15);