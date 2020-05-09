package com.yuu.quanlysinhvien;

import java.util.List;
import java.util.Scanner;

public class Helper {
	public static int choice;
	public static Scanner sc = new Scanner(System.in);

//	kiểm tra sinh viên có tồn tại trong dsSV hay k?
	public static int indexOfSinhVien(List<SinhVien> dsSV, String maSV) {
		for (int i = 0; i < dsSV.size(); i++) {
			if (dsSV.get(i).getMaSV().equals(maSV)) {
				return i;
			}
		}
		return -1;
	}

// kiểm tra môn học có tồn tại trong dsMon hay k?
	public static int indexOfMonHoc(List<MonHoc> dsMH, String maMon) {
		for (int i = 0; i < dsMH.size(); i++) {
			if (dsMH.get(i).getMaMon().equals(maMon)) {
				return i;
			}
		}
		return -1;
	}

//	lấy thông tin sinh viên theo mã sinh viên
	public static SinhVien getSVByMa(List<SinhVien> dsSV, String maSV) {
		for (SinhVien sv : dsSV) {
			if (sv.getMaSV().equals(maSV)) {
				return sv;
			}
		}
		return null;
	}

//	lấy thông tin môn học theo mã môn
	public static MonHoc getMonByMa(List<MonHoc> dsMH, String maMon) {
		for (MonHoc mon : dsMH) {
			if (mon.getMaMon().equals(maMon)) {
				return mon;
			}
		}
		return null;
	}

//	kiểm tra sinh viên đã học môn có mã xxx hay chưa? đk(sv thuộc dsSv, môn thuộc dsMon)
	public static int checkSVHasMon(List<Diem> dsDiem, SinhVien sv, MonHoc mon) {
		for (Diem diem : dsDiem) {
			if (diem.getSv().getMaSV().equals(sv.getMaSV())) {
				if (diem.getMon().getMaMon().equals(mon.getMaMon()))
					return 1;
			}
		}
		return -1;
	}

//	kiểm tra sinh viên đã học môn nào hay chưa?
	public static int checkSVHasMon(List<Diem> dsDiem, SinhVien sv) {
		for (Diem diem : dsDiem) {
			if (diem.getSv().getMaSV().equals(sv.getMaSV())) {
				if (diem.getMon() != null)
					return 1;
			}
		}
		return -1;
	}

//	kiểm tra môn học có mã xxx đã có sinh viên học hay chưa?
	public static int checkMonHasSV(List<Diem> dsDiem, MonHoc mon) {
		for (Diem diem : dsDiem) {
			if (diem.getMon().getMaMon().equals(mon.getMaMon())) {
				if (diem.getSv() != null)
					return 1;
			}
		}
		return -1;
	}

//	trả về điểm của môn có mã xxx mà sinh viên đang học 
	public static Diem getDiemByMon(List<Diem> dsDiem, SinhVien sv, MonHoc mon) {
		for (Diem diem : dsDiem) {
			if (diem.getSv().getMaSV().equals(sv.getMaSV())) {
				if (diem.getMon().getMaMon().equals(mon.getMaMon()))
					return diem;
			}
		}
		return null;
	}

//	Tính điểm tông kết của sinh viên
	public static float diemTK(List<Diem> dsDiem, SinhVien sinhVien) {
		float sum = 0f;
		int hs = 0;
		for (Diem diem : dsDiem) {
			if (diem.getSv().equals(sinhVien)) {
				sum += diem.getDiem() * diem.getMon().getHeSoMon();
				hs += diem.getMon().getHeSoMon();
			}
		}
		return sum / hs;
	}

//	Tính điểm TB chung của môn
	public static float diemTBMon(List<Diem> dsDiem, MonHoc mon) {
		float sum = 0f;
		int k = 0;
		for (Diem diem : dsDiem) {
			if (diem.getMon().equals(mon)) {
				sum += diem.getDiem();
				k++;
			}
		}
		return sum / k;
	}
}