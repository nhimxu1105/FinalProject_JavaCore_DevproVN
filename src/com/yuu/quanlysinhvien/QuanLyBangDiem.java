package com.yuu.quanlysinhvien;

import java.util.ArrayList;
import java.util.List;

public class QuanLyBangDiem {
	public static List<Diem> dsDiem = new ArrayList<>();
	static SinhVien sv = null;
	static MonHoc mon = null;

	public static void menu() {
		do {
			System.out.println("\n\t\t----MENU ĐIỂM----");
			System.out.println("\t1. Thêm điểm cho sinh viên.");
			System.out.println("\t2. Sửa thông tin điểm cho sinh viên.");
			System.out.println("\t3. Xóa thông tin điểm cho sinh viên");
			System.out.println("\t4. Quay lại.");
			System.out.println("Bạn chọn: ");
			Helper.choice = Integer.parseInt(Helper.sc.nextLine());
			switch (Helper.choice) {
			case 1:
				themDiem();
				break;
			case 2:
				suaTTDiem();
				break;
			case 3:
				xoaDiem();
				break;
			case 4:
				return;
			default:
				System.out.println("Không hợp lệ! Bạn vui lòng nhập lại.");
			}
		} while (true);
	}

	private static void themDiem() {
		int index;
		do {
			System.out.println("Nhập mã sinh viên muốn thêm điểm: ");
			String maSV = Helper.sc.nextLine();
			index = Helper.indexOfSinhVien(QuanLySinhVien.dsSV, maSV);
			if (index == -1)
				System.out.println("Không tồn tại sinh viên có mã '" + maSV + "' Mời nhập lại.");
			else
				sv = Helper.getSVByMa(QuanLySinhVien.dsSV, maSV);
		} while (index == -1);

		do {
			System.out.println("Nhập mã môn học muốn thêm điểm: ");
			String maMon = Helper.sc.nextLine();
			index = Helper.indexOfMonHoc(QuanLyMonHoc.dsMH, maMon);
			if (index == -1)
				System.out.println("Không tồn tại môn học có mã '" + maMon + "' Mời nhập lại.");
			else
				mon = Helper.getMonByMa(QuanLyMonHoc.dsMH, maMon);
		} while (index == -1);

		if (Helper.checkSVHasMon(dsDiem, sv, mon) != -1) {
			System.out.println("Sinh viên đã học xong môn có mã '" + mon.getMaMon() + "' .Không thể thêm điểm.");
			return;
		}
		float diem;
		do {
			System.out.println("Nhập điểm: ");
			diem = Helper.sc.nextFloat();
			if (diem < 0 || diem > 10)
				System.out.println("Không hợp lệ. Mời nhập lại.");
		} while (diem < 0 || diem > 10);
		Helper.sc.nextLine();
		Diem d = new Diem(sv, mon, diem);
		dsDiem.add(d);
		System.out.println("Thêm thành công.\n");
		System.out.println("----THÔNG TIN SINH VIÊN VỪA THÊM ĐIỂM----");
		xuatDSMonVaDiem(sv);
		System.out.println("------------------------------------------");
	}

	private static void suaTTDiem() {
		int index;
		do {
			System.out.println("Nhập mã sinh viên muốn sửa điểm: ");
			String maSV = Helper.sc.nextLine();
			index = Helper.indexOfSinhVien(QuanLySinhVien.dsSV, maSV);
			if (index == -1)
				System.out.println("Không tồn tại sinh viên có mã '" + maSV + "' Mời nhập lại.");
			else
				sv = Helper.getSVByMa(QuanLySinhVien.dsSV, maSV);
		} while (index == -1);

		do {
			System.out.println("Nhập mã môn học muốn sửa điểm: ");
			String maMon = Helper.sc.nextLine();
			index = Helper.indexOfMonHoc(QuanLyMonHoc.dsMH, maMon);
			if (index == -1)
				System.out.println("Không tồn tại môn học có mã '" + maMon + "' Mời nhập lại.");
			else
				mon = Helper.getMonByMa(QuanLyMonHoc.dsMH, maMon);
		} while (index == -1);

		if (Helper.checkSVHasMon(dsDiem, sv, mon) == -1) {
			System.out.println("Sinh viên chưa học môn có mã " + mon.getMaMon());
			System.out.println("Vui lòng thêm môn cho sinh viên trước khi sửa.");
			return;
		}
		float diem;
		do {
			System.out.println("Nhập điểm: ");
			diem = Helper.sc.nextFloat();
			if (diem < 0 || diem > 10)
				System.out.println("Không hợp lệ. Mời nhập lại.");
		} while (diem < 0 || diem > 10);
		Helper.sc.nextLine();
		Diem d = Helper.getDiemByMon(dsDiem, sv, mon);
		d.setDiem(diem);
		System.out.println("Thêm thành công.\n");
		System.out.println("----THÔNG TIN SINH VIÊN SAU KHI SUA----");
		xuatDSMonVaDiem(sv);
		System.out.println("------------------------------------------");
	}

	private static void xoaDiem() {
		int index;
		do {
			System.out.println("Nhập mã sinh viên muốn xóa điểm: ");
			String maSV = Helper.sc.nextLine();
			index = Helper.indexOfSinhVien(QuanLySinhVien.dsSV, maSV);
			if (index == -1)
				System.out.println("Không tồn tại sinh viên có mã '" + maSV + "' Mời nhập lại.");
			else
				sv = Helper.getSVByMa(QuanLySinhVien.dsSV, maSV);
		} while (index == -1);

		do {
			System.out.println("Nhập mã môn học muốn xóa điểm: ");
			String maMon = Helper.sc.nextLine();
			index = Helper.indexOfMonHoc(QuanLyMonHoc.dsMH, maMon);
			if (index == -1)
				System.out.println("Không tồn tại môn học có mã '" + maMon + "' Mời nhập lại.");
			else
				mon = Helper.getMonByMa(QuanLyMonHoc.dsMH, maMon);
		} while (index == -1);

		if (Helper.checkSVHasMon(dsDiem, sv, mon) == -1) {
			System.out.println("Sinh viên chưa học môn có mã " + mon.getMaMon());
			System.out.println("Vui lòng thêm môn cho sinh viên trước khi xóa.");
			return;
		}

		dsDiem.remove(Helper.getDiemByMon(dsDiem, sv, mon));

		System.out.println("Xóa thành công.\n");
		System.out.println("----THÔNG TIN SINH VIÊN SAU KHI XÓA ĐIỂM 1 MÔN----");
		xuatDSMonVaDiem(sv);
		System.out.println("------------------------------------------");
	}

	private static void xuatDSMonVaDiem(SinhVien sv) {
		System.out.printf("Mã SV: %-10s\t", sv.getMaSV());
		System.out.printf("Tên SV: %-30s%n", sv.getHoDem() + " " + sv.getTenSv());
		System.out.println("\tDANH SÁCH MÔN");
		System.out.format("%-10s%-10s%-10s%n",
				"Mã Môn", "Tên Môn", "Điểm");
		if (Helper.checkSVHasMon(dsDiem, sv) != -1) {
			for (Diem diem : dsDiem) {
				if (diem.getSv().equals(sv)) {
					System.out.format("%-10s%-10s%-10.1f%n",
							diem.getMon().getMaMon(),
							diem.getMon().getTenMon(),
							diem.getDiem());
				}
			}
		} else
			System.out.println("Sinh viên chưa học môn nào.");
	}

}
