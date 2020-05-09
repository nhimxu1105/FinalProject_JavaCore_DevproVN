package com.yuu.quanlysinhvien;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HienThiBangDiem {

	public static void hienThiTheoSV(List<Diem> dsDiem, List<SinhVien> dsSV) {
		Comparator<SinhVien> c = new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getMaSV().compareTo(o2.getMaSV());
			}
		};
		Collections.sort(dsSV, c);
		for (SinhVien sv : dsSV) {
			System.out.printf("Mã SV: %-10s\t", sv.getMaSV());
			System.out.printf("Tên SV: %-25s%n", sv.getHoDem() + " " + sv.getTenSv());
			if (Helper.checkSVHasMon(dsDiem, sv) != -1) {
				System.out.println("\tDANH SÁCH MÔN MÀ SINH VIÊN HỌC");
				System.out.format("%-10s%-10s%-10s%-10s%n",
						"Mã Môn", "Tên Môn", "Điểm", "Hệ Số Môn");
				for (Diem diem : dsDiem) {
					if (diem.getSv().equals(sv)) {
						System.out.format("%-10s%-10s%-10.1f%-10d%n", 
								diem.getMon().getMaMon(),
								diem.getMon().getTenMon(), 
								diem.getDiem(),
								diem.getMon().getHeSoMon());
					}
				}
				System.out.printf("Điểm Tổng Kết: %-2.1f\n", Helper.diemTK(dsDiem, sv));
			} else {
				System.out.println("Sinh viên chưa học môn nào.");
			}

			System.out.println("-----------------------------------\n");
		}
	}

	public static void hienThiTheoMon(List<Diem> dsDiem, List<MonHoc> dsMH) {
		for (MonHoc mon : dsMH) {
			System.out.printf("Mã Môn: %-10s\t", mon.getMaMon());
			System.out.printf("Tên Môn: %-25s%n", mon.getTenMon());
			if (Helper.checkMonHasSV(dsDiem, mon) != -1) {
				System.out.println("\t\tBẢNG ĐIỂM");
				System.out.format("%-10s%-25s%-10s%n",
						"Mã SV", "Họ Tên", "Điểm");
				for (Diem diem : dsDiem) {
					if (diem.getMon().equals(mon)) {
						System.out.format("%-10s%-25s%-10.1f%n",
								diem.getSv().getMaSV(),
								diem.getSv().getHoDem() + " " + diem.getSv().getTenSv(),
								diem.getDiem());
					}
				}
				System.out.printf("Điểm TB chung môn: %-2.1f\n", Helper.diemTBMon(dsDiem, mon));
			} else {
				System.out.println("Chưa có sinh viên nào học môn này.");
			}

			System.out.println("-----------------------------------\n");
		}
	}
}
