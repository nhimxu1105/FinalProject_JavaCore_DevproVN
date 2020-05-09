package com.yuu.quanlysinhvien;

import java.util.ArrayList;
import java.util.List;

public class QuanLySinhVien {
	public static List<SinhVien> dsSV = new ArrayList<SinhVien>();

	public static void menu() {
		do {
			System.out.println("\n\t\t----MENU SINH VIEN----");
			System.out.println("\t1. Thêm sinh viên mới.");
			System.out.println("\t2. Sửa thông tin sinh viên.");
			System.out.println("\t3. Xóa thông tin sinh viên.");
			System.out.println("\t4. Hiển thi danh sách sinh viên.");
			System.out.println("\t5. Quay lại.");
			System.out.println("Bạn chọn: ");
			Helper.choice = Integer.parseInt(Helper.sc.nextLine());
			switch (Helper.choice) {
			case 1:
				themSinhVien();
				break;
			case 2:
				suaTTSinhVien();
				break;
			case 3:
				xoaSinhVien();
				break;
			case 4:
				hienThiDSSinhVien();
				break;
			case 5:
				return;
			default:
				System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
			}
		} while (true);
	}

	public static void themSinhVien() {
		int index;
		String maSV;
		do {
			System.out.println("Nhập mã sinh viên: ");
			maSV = Helper.sc.nextLine();
			index = Helper.indexOfSinhVien(dsSV, maSV);
			if (index != -1) {
				System.out.println("Sinh Viên có mã số " + maSV + " đã tồn tại. Mời nhập lại");
			}
		} while (index != -1);

		System.out.println("Nhập họ đệm: ");
		String hoDem = Helper.sc.nextLine();
		System.out.println("Nhập tên: ");
		String tenSV = Helper.sc.nextLine();
		System.out.println("Nhập năm sinh: ");
		int namSinh = Helper.sc.nextInt();
		Helper.sc.nextLine();
		System.out.println("Nhập giới tính: ");
		String gioiTinh = Helper.sc.nextLine();

		dsSV.add(new SinhVien(maSV, hoDem, tenSV, namSinh, gioiTinh));
		System.out.println("Thêm thành công.");
	}

	public static void suaTTSinhVien() {
		System.out.println("Nhập mã sinh viên cần sửa: ");
		String maSV = Helper.sc.nextLine();

		int index = Helper.indexOfSinhVien(dsSV, maSV);
		if (index == -1) {
			System.out.println("Không tồn tại sinh viên có mã " + maSV);
			return;
		}
		do {
			System.out.println("\n__> Vui lòng chọn mục cần sửa.");
			System.out.println("\t 1. Họ đệm.");
			System.out.println("\t 2. Tên SV.");
			System.out.println("\t 3. Năm sinh.");
			System.out.println("\t 4. Giới tính.");
			System.out.println("\t 5. Quay lại.");
			System.out.println("Bạn chọn: ");
			Helper.choice = Integer.parseInt(Helper.sc.nextLine());
			switch (Helper.choice) {
			case 1:
				System.out.println("Nhập họ đệm mới: ");
				String hoDem = Helper.sc.nextLine();
				dsSV.get(index).setHoDem(hoDem);
				break;
			case 2:
				System.out.println("Nhập tên mới: ");
				String tenSV = Helper.sc.nextLine();
				dsSV.get(index).setTenSv(tenSV);
				break;
			case 3:
				System.out.println("Nhập năm sinh mới: ");
				int namSinh = Helper.sc.nextInt();
				dsSV.get(index).setNamSinh(namSinh);
				Helper.sc.nextLine();
				break;
			case 4:
				System.out.println("Nhập giới tính mới: ");
				String gioiTinh = Helper.sc.nextLine();
				dsSV.get(index).setGioiTinh(gioiTinh);
				break;
			case 5:
				return;
			default:
				System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
			}
			if (Helper.choice == 1 || Helper.choice == 2 || Helper.choice == 3 || Helper.choice == 4) {
				System.out.println("Sửa thành công.");
				System.out.println("\t\t---Thông tin sinh viên có mã '" + dsSV.get(index).getMaSV() 
						+ "' sau khi sửa---");
				SinhVien.label();
				dsSV.get(index).showInfor();
			}
		} while (true);
	}

	public static void xoaSinhVien() {
		int index;
		SinhVien sv = null;
		do {
			System.out.println("Nhập mã sinh viên muốn thêm điểm: ");
			String maSV = Helper.sc.nextLine();
			index = Helper.indexOfSinhVien(QuanLySinhVien.dsSV, maSV);
			if (index == -1)
				System.out.println("Không tồn tại sinh viên có mã '" + maSV + "' Mời nhập lại.");
			else
				sv = Helper.getSVByMa(QuanLySinhVien.dsSV, maSV);
		} while (index == -1);
		if (Helper.checkSVHasMon(QuanLyBangDiem.dsDiem, sv) != -1) {
			System.out.println("Sinh viên có mã '" + sv.getMaSV() + "' đang học 1 số môn.");
			System.out.println("Vui lòng xóa các môn mà sinh viên này học trước khi xóa sinh viên.");
			return;
		}
		dsSV.remove(Helper.getSVByMa(dsSV, sv.getMaSV()));
		System.out.println("Xóa thành công.");
	}

	public static void hienThiDSSinhVien() {
		System.out.println("\t\t----DANH SACH SINH VIEN----");
		SinhVien.label();
		for (SinhVien sv : dsSV) {
			sv.showInfor();
		}
	}

}
