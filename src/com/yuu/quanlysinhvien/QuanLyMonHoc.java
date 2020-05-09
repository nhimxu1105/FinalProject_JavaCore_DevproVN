package com.yuu.quanlysinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyMonHoc {
	public static List<MonHoc> dsMH = new ArrayList<>();

	public static void menu() {
		do {
			System.out.println("\n\t\t----MENU MÔN HỌC----");
			System.out.println("\t1. Thêm môn học mới.");
			System.out.println("\t2. Sửa thông tin môn học.");
			System.out.println("\t3. Xóa thông tin môn học.");
			System.out.println("\t4. Hiển thi danh sách môn học.");
			System.out.println("\t5. Quay lại.");
			System.out.println("Bạn chọn: ");
			Helper.choice = Integer.parseInt(Helper.sc.nextLine());
			switch (Helper.choice) {
			case 1:
				themMonHoc();
				break;
			case 2:
				suaTTMonHoc();
				break;
			case 3:
				xoaMonHoc();
				break;
			case 4:
				hienThiDSMonHoc();
				break;
			case 5:
				return;
			default:
				System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
			}
		} while (true);
	}

	private static void themMonHoc() {
		int index;
		String maMon;
		do {
			System.out.println("Nhập mã môn học: ");
			maMon = Helper.sc.nextLine();
			index = Helper.indexOfMonHoc(dsMH, maMon);
			if (index != -1) {
				System.out.println("Môn học có mã số " + maMon + " đã tồn tại. Mời nhập lại");
			}
		} while (index != -1);

		System.out.println("Nhập tên môn học: ");
		String tenMon = Helper.sc.nextLine();
		System.out.println("Nhập hệ số môn: ");
		int hsMon = Helper.sc.nextInt();
		Helper.sc.nextLine();
		dsMH.add(new MonHoc(maMon, tenMon, hsMon));
		System.out.println("Thêm thành công.");
	}

	private static void suaTTMonHoc() {
		System.out.println("Nhập mã môn học cần sửa: ");
		String maMon = Helper.sc.nextLine();

		int index = Helper.indexOfMonHoc(dsMH, maMon);
		if (index == -1) {
			System.out.println("Không tồn tại môn học có mã " + maMon);
			return;
		}
		do {
			System.out.println("\n__> Vui lòng chọn mục cần sửa.");
			System.out.println("\t 1. Tên môn học.");
			System.out.println("\t 2. Hệ số môn học.");
			System.out.println("\t 3. Quay lại.");
			System.out.println("Bạn chọn: ");
			Helper.choice = Integer.parseInt(Helper.sc.nextLine());
			switch (Helper.choice) {
			case 1:
				System.out.println("Nhập mã môn học mới: ");
				String tenMon = Helper.sc.nextLine();
				dsMH.get(index).setTenMon(tenMon);
				break;
			case 2:
				System.out.println("Nhập hệ số môn học mới: ");
				int hsMon = Helper.sc.nextInt();
				Helper.sc.nextLine();
				dsMH.get(index).setHeSoMon(hsMon);
				break;
			case 3:
				return;
			default:
				System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
			}
			if (Helper.choice == 1 || Helper.choice == 2) {
				System.out.println("Sửa thành công.");
				System.out.println("\t\t---Thông tin môn học có mã '" + dsMH.get(index).getMaMon() 
						+ "' sau khi sửa---");
				MonHoc.label();
				dsMH.get(index).showInfor();
			}
		} while (true);

	}

	private static void xoaMonHoc() {
		int index;
		MonHoc mon = null;
		do {
			System.out.println("Nhập mã môn học muốn xóa: ");
			String maMon = Helper.sc.nextLine();
			index = Helper.indexOfMonHoc(dsMH, maMon);
			if (index == -1)
				System.out.println("Không tồn tại môn học có mã '" + maMon + "' Mời nhập lại.");
			else
				mon = Helper.getMonByMa(dsMH, maMon);
		} while (index == -1);
		if (Helper.checkMonHasSV(QuanLyBangDiem.dsDiem, mon) != -1) {
			System.out.println("Môn học có mã '" + mon.getMaMon() + "'đã có sinh viên học.");
			System.out.println("Vui lòng xóa tất cả sinh viên học môn này trước khi xóa môn.");
			return;
		}
		dsMH.remove(Helper.getMonByMa(dsMH, mon.getMaMon()));
		System.out.println("Xóa thành công.");
	}

	private static void hienThiDSMonHoc() {
		Comparator<MonHoc> c = new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMon().compareTo(o2.getTenMon());
			}
		};
		Collections.sort(dsMH, c);
		System.out.println("\t\t----DANH SACH MÔN HỌC----");
		MonHoc.label();
		for (MonHoc monHoc : dsMH) {
			monHoc.showInfor();
		}
	}

}
