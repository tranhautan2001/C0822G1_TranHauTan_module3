use case_study;

select * from nhan_vien where (ho_ten like 'K%' or ho_ten like 'T%' or ho_ten like 'H%') and (char_length(ho_ten) <=15 );

select * from khach_hang where (year(curdate()) -year(ngay_sinh) between 18 and 50) and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select khach_hang.ma_khach_hang , khach_hang.ho_ten, count(hop_dong.ma_hop_dong ) as so_lan_dat_phong
from khach_hang
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach = 'Diamond'
group by ma_khach_hang
order by so_lan_dat_phong;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
--  (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
--  cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select  khach_hang.ma_khach_hang,
   khach_hang.ho_ten,
   loai_khach.ten_loai_khach,
   hop_dong.ma_hop_dong,
   hop_dong.ngay_lam_hop_dong,
   hop_dong.ngay_ket_thuc,
   dich_vu.ten_dich_vu,
   (ifnull(dich_vu.chi_phi_thue,0)+SUM(ifnull( hop_dong_chi_tiet.so_luong,0)*ifnull(dich_vu_di_kem.gia,0))) as tong_tien
   from khach_hang
   left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
   left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
   left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
   left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
   left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
   group by hop_dong.ma_hop_dong,khach_hang.ma_khach_hang
   order by khach_hang.ma_khach_hang;
   
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
   select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu  from loai_dich_vu 
join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where hop_dong.ma_dich_vu NOT IN (
select hop_dong.ma_dich_vu 
from hop_dong
where (month(ngay_lam_hop_dong) in (1,2,3)) and (year(ngay_lam_hop_dong) >= 2021))
group by ma_dich_vu;

 -- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
 select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu  from loai_dich_vu
 join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
 join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where year(ngay_lam_hop_dong) = 2020 and hop_dong.ma_dich_vu not in(
select hop_dong.ma_dich_vu 
from hop_dong
where year(ngay_lam_hop_dong) = 2021)
group by ma_dich_vu;

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
select ho_ten from khach_hang
group by ho_ten;

select distinct ho_ten from khach_hang;

select ho_ten from khach_hang
union select ho_ten from khach_hang;

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng

select month(ngay_lam_hop_dong) as thang ,count(ma_khach_hang) as so_luong_khach_hang from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by thang
order by thang;

-- 10 Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hop_dong.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc , sum(ifnull(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem from hop_dong
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem  = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong_chi_tiet.ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem from loai_khach
join khach_hang on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where (ten_loai_khach like 'Diamond') and (dia_chi  like '%Vinh%') or( dia_chi  like '%Vinh%');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
 SELECT 
    hop_dong.ma_hop_dong,
    nhan_vien.ho_ten,
    khach_hang.ho_ten,
    khach_hang.so_dien_thoai,
    dich_vu.ten_dich_vu,
    hop_dong.tien_dat_coc,
    dich_vu.ma_dich_vu,
    SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS so_luong_dich_vu_di_kem
FROM
    nhan_vien
        JOIN
    hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
        JOIN
    khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
WHERE
    MONTH(ngay_lam_hop_dong) IN (10 , 11, 12)
        AND YEAR(ngay_lam_hop_dong) = '2020'
        AND hop_dong.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            MONTH(ngay_lam_hop_dong) IN (1 , 2, 3, 4, 5, 6)
                AND YEAR(ngay_lam_hop_dong) = '2021')
GROUP BY ma_hop_dong;
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS so_luong_dich_vu_di_kem
FROM
    hop_dong_chi_tiet
        JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
   group by  dich_vu_di_kem.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem like 15;
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select hop_dong.ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung from loai_dich_vu
join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by  dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung like 1;

-- 15. Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi from nhan_vien
join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) IN (2020 , 2021)
GROUP BY hop_dong.ma_nhan_vien
HAVING COUNT(hop_dong.ma_nhan_vien) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien
where
nhan_vien.ma_nhan_vien NOT IN (
    SELECT 
		hop_dong.ma_nhan_vien
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2019 AND 2021
            group by nhan_vien.ma_nhan_vien);
            
select * from nhan_vien;
SET SQL_SAFE_UPDATES = 1;

-- 17. Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
-- select * from khach_hang
-- join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
-- join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
-- where loai_khach.ten_loai_khach like 'Platinum';
CREATE VIEW v_khach_hang_diamond AS
			SELECT 
                khach_hang.ma_khach_hang,
                    khach_hang.ho_ten,
                    IFNULL(dich_vu.chi_phi_thue, 0) + SUM(IFNULL(dich_vu_di_kem.gia, 0) * IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS tong_tien,
                    loai_khach.ma_loai_khach
            FROM
                khach_hang 
			JOIN loai_khach  ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
			JOIN hop_dong  ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
            LEFT JOIN hop_dong_chi_tiet  ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            LEFT JOIN dich_vu_di_kem  ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
			JOIN dich_vu  ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
            WHERE
                YEAR(hop_dong.ngay_lam_hop_dong) = 2021
                AND loai_khach.ma_loai_khach = 2 ;
           
			UPDATE khach_hang 
            SET ma_loai_khach = 1
            WHERE ma_khach_hang =(SELECT 
            ma_khach_hang
            FROM v_khach_hang_diamond
            GROUP BY ma_khach_hang
            HAVING SUM(tong_tien)>1000000
            );

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0;   -- không hiểu hàm này dùng làm gì thấy mn chỉ nhưng chưa hiểu ý nghĩa của nó ....! nhưng không có hàm này thì không chạy được
delete from khach_hang
where
khach_hang.ma_khach_hang  IN (
    SELECT 
		hop_dong.ma_khach_hang
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) <2021
            group by khach_hang.ma_khach_hang);
            
select * from khach_hang;
SET SQL_SAFE_UPDATES = 1;
 -- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
select dich_vu_di_kem.ma_dich_vu_di_kem from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
where year(ngay_lam_hop_dong ) = 2020;



-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
  -- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
  SELECT ma_nhan_vien, ho_ten, email,so_dien_thoai, ngay_sinh, dia_chi FROM nhan_vien union
  SELECT ma_khach_hang, ho_ten, email,so_dien_thoai, ngay_sinh, dia_chi FROM khach_hang;
