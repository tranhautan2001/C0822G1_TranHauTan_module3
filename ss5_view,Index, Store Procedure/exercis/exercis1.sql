drop database if exists exercis1;
create database exercis1;
use exercis1;

create table product(
ID int primary key,
product_id int,
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status varchar(45)
);
insert into product(ID,product_id,product_name,product_price,product_amount,product_description,product_status)
value
(1,3,'iphone11',14.000000,5,'đang giảm giá','đang bán'),
(2,12,'iphone12',22.000000,5,'ổn định','đang bán'),
(3,78,'iphone13',18.000000,5,'hot','đang bán'),
(4,56,'iphone14',40.000000,5,'hot','đang bán');



-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục).
alter table product add Unique index i_product_id (product_id);
--  Tạo Composite Index trên bảng products (sử dụng 2 cột product_name và product_price).
alter table product add index i_product_name_price (product_name,product_price);
-- Tạo view lấy về các thông tin: product_code, product_name, product_price, product_status từ bảng products.
create view w_product as
select product_id, product_name, product_price, product_status
from product;
-- Tiến hành sửa đổi view.
update w_product set product_price = 14.000000 where product_name = 'Cafe';
select * from w_product;
-- tiến hành xoá view
drop view w_product;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product.
delimiter //
create procedure sp_get_info_product()
begin
    select * from product;
end //
delimiter ;
call sp_get_info_product();

-- Tạo store procedure thêm một sản phẩm mới.
delimiter //
create procedure sp_add_product (in p_id int, in p_code int, in p_name varchar(45), in p_price int, in p_amount int, in p_desciption text, in p_status bit)
begin
    insert into product values (p_id, p_code, p_name, p_price, p_amount, p_desciption, p_status);
end //
delimiter ;
call sp_add_product(5, 5, 'iphonex', 10000, 60, 'rớt giá', 1);
call sp_get_info_product();

-- Tạo store procedure sửa thông tin sản phẩm theo id.
delimiter //
create procedure sp_set_produc_by_id (in id_set int, in product_name_update varchar(45))
begin
    update product set product_name = product_name_update where id = id_set;
end //
delimiter ;
call sp_set_produc_by_id(5, 'iphonex');
call sp_get_info_product();

-- Tạo store procedure xoá sản phẩm theo id.
delimiter //
create procedure sp_remove_produc_by_id (in id_delete int)
begin
    delete from product where id = id_delete;
end //
delimiter ;
call sp_remove_produc_by_id(5);
call sp_get_info_product();
