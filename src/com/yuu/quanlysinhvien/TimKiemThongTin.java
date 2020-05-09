package com.yuu.quanlysinhvien;

import java.util.List;

public class TimKiemThongTin {

	public static void timKiemTheoSV(List<Diem> dsDiem) {
		int index;
		SinhVien sv = null;
		do {
			System.out.println("Nhập mã sinh viên muốn tìm kiếm: ");
			String maSV = Helper.sc.nextLine();
			index = Helper.indexOfSinhVien(QuanLySinhVien.dsSV, maSV);
			if (index == -1)
				System.out.println("Không tồn tại sinh viên có mã '" + maSV + "' Mời nhập lại.");
			else
				sv = Helper.getSVByMa(QuanLySinhVien.dsSV, maSV);
		} while (index == -1);
		System.out.println("\tKẾT QUẢ TÌM KIẾM");
		System.out.println("Họ Tên: " + sv.getHoDem() + " " + sv.getTenSv());
		if (Helper.checkSVHasMon(dsDiem, sv) != -1) {
			System.out.format("%-10s%-10s%n", "Tên Môn", "Điểm");
			for (Diem diem : dsDiem) {
				if (diem.getSv().equals(sv)) {
					System.out.format("%-10s%-10.1f%n", diem.getMon().getTenMon(), diem.getDiem());
				}
			}
			System.out.printf("Điểm tổng kết: %-2.1f", Helper.diemTK(dsDiem, sv));
		} else {
			System.out.println("Sinh viên này chưa học môn nào.");
		}

	}

	public static void timKiemTheoMon(List<Diem> dsDiem) {
		int index;
		MonHoc mon = null;
		do {
			System.out.println("Nhập mã môn học muốn tìm kiếm: ");
			String maMon = Helper.sc.nextLine();
			index = Helper.indexOfMonHoc(QuanLyMonHoc.dsMH, maMon);
			if (index == -1)
				System.out.println("Không tồn tại môn học có mã '" + maMon + "' Mời nhập lại.");
			else
				mon = Helper.getMonByMa(QuanLyMonHoc.dsMH, maMon);
		} while (index == -1);
		System.out.println("\tKẾT QUẢ TÌM KIẾM");
		System.out.println("Môn: " + mon.getTenMon());
		if (Helper.checkMonHasSV(dsDiem, mon) != -1) {
			System.out.format("%-25s%-10s%n", "Họ Tên", "Điểm");
			for (Diem diem : dsDiem) {
				if (diem.getMon().equals(mon)) {
					System.out.format("%-25s%-10.1f%n",
							diem.getSv().getHoDem() + " " + diem.getSv().getTenSv(),
							diem.getDiem());
				}
			}
			System.out.printf("Điểm TB chung môn: %-2.1f", Helper.diemTBMon(dsDiem, mon));
		} else {
			System.out.println("Chưa có sinh viên nào học môn này.");
		}

	}
}
