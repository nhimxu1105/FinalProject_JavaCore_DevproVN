package com.yuu.quanlysinhvien;

public class MAIN {
	public static void main(String[] args) {
		// dữ liệu test
		SinhVien sv1 = new SinhVien("sv01","Nguyễn Viết","Linh",1999,"Nam");
		SinhVien sv2 = new SinhVien("sv05","Đỗ Thị","Thơm",1999,"Nữ");
		SinhVien sv3 = new SinhVien("sv03","Hoàng","Lan",2000,"Nữ");
		QuanLySinhVien.dsSV.add(sv1);
		QuanLySinhVien.dsSV.add(sv2);
		QuanLySinhVien.dsSV.add(sv3);
		MonHoc m1 = new MonHoc("mh01","Toán", 4);
		MonHoc m2 = new MonHoc("mh02","Văn", 2);
		MonHoc m3 = new MonHoc("mh03","Anh", 3);
		QuanLyMonHoc.dsMH.add(m1);
		QuanLyMonHoc.dsMH.add(m2);
		QuanLyMonHoc.dsMH.add(m3);
		Diem d1 = new Diem(sv1,m1,9.5f);
		Diem d2 = new Diem(sv2,m2,10f);
		QuanLyBangDiem.dsDiem.add(d1);
		QuanLyBangDiem.dsDiem.add(d2);
//		---------------------------------------
		try {
			do {
				System.out.println("\n=========CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN=========\n");
				System.out.println("\t1. Cập nhật thông tin.");
				System.out.println("\t2. Hiển thị thông tin.");
				System.out.println("\t3. Tìm kiếm thông tin.");
				System.out.println("\t4. Thoát.");
				System.out.println("Bạn chọn: ");
				Helper.choice = Integer.parseInt(Helper.sc.nextLine());
				switch(Helper.choice) {
				case 1:
					capNhatThongTin();
					break;
				case 2: 
					hienThiThongTin();
					break;
				case 3: 
					timKiemThongTin();
					break;
				case 4:
					System.out.println("End Program.");
					return;
				default:
					System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
				}
				
			}while(true);
		}catch(Exception e) {
			System.out.println("Lỗi "+e.getMessage());
		}
	}

	private static void capNhatThongTin() {
		try {
			do {
				System.out.println("\n\t\t----MENU CẬP NHẬT THÔNG TIN----");
				System.out.println("\t1. Cập nhật danh sách sinh viên.");
				System.out.println("\t2. Cập nhật danh sách môn học.");
				System.out.println("\t3. Cập nhật bảng điểm.");
				System.out.println("\t4. Quay lại.");
				System.out.println("Bạn chọn: ");
				Helper.choice = Integer.parseInt(Helper.sc.nextLine());
				switch(Helper.choice) {
				case 1: 
					QuanLySinhVien.menu();
					break;
				case 2:
					QuanLyMonHoc.menu();
					break;
				case 3:
					QuanLyBangDiem.menu();
					break;
				case 4: 
					return;
				default:
					System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
				}
			}while(true);
		}catch(Exception e) {
			System.out.println("Lỗi: "+e.getMessage());
		}
		
	}

	private static void hienThiThongTin() {
		try {
			do {
				System.out.println("\n\t\t----MENU HIỂN THỊ BẢNG ĐIỂM----");
				System.out.println("\t1. Hiển thị bảng điểm theo từng sinh viên.");
				System.out.println("\t2. Hiển thị bảng điểm theo từng môn học.");
				System.out.println("\t3. Quay lại.");
				System.out.println("Bạn chọn: ");
				Helper.choice = Integer.parseInt(Helper.sc.nextLine());
				switch(Helper.choice) {
				case 1: 
					HienThiBangDiem.hienThiTheoSV(QuanLyBangDiem.dsDiem, QuanLySinhVien.dsSV);
					break;
				case 2:
					HienThiBangDiem.hienThiTheoMon(QuanLyBangDiem.dsDiem, QuanLyMonHoc.dsMH);
					break;
				case 3: 
					return;
				default:
					System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
				}
			}while(true);
		}catch(Exception e) {
			System.out.println("Lỗi: "+e.getMessage());
		}
	}

	private static void timKiemThongTin() {
		try {
			do {
				System.out.println("\n\t\t----MENU TÌM KIẾM THÔNG TIN----");
				System.out.println("\t1. Tìm kiếm theo mã sinh viên.");
				System.out.println("\t2. Tìm kiếm theo mã môn học.");
				System.out.println("\t3. Quay lại.");
				System.out.println("Bạn chọn: ");
				Helper.choice = Integer.parseInt(Helper.sc.nextLine());
				switch(Helper.choice) {
				case 1: 
					TimKiemThongTin.timKiemTheoSV(QuanLyBangDiem.dsDiem);
					break;
				case 2:
					TimKiemThongTin.timKiemTheoMon(QuanLyBangDiem.dsDiem);
					break;
				case 3: 
					return;
				default:
					System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
				}
			}while(true);
		}catch(Exception e) {
			System.out.println("Lỗi: "+ e.getMessage());
		}
	}
}
