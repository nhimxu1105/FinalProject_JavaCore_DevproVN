package com.yuu.quanlysinhvien;

public class Diem {
	private SinhVien sv;
	private MonHoc mon;
	private float diem;

	public Diem() {
		super();
	}

	public Diem(SinhVien sv, MonHoc mon, float diem) {
		super();
		this.sv = sv;
		this.mon = mon;
		this.diem = diem;
	}

	public SinhVien getSv() {
		return sv;
	}

	public void setSv(SinhVien sv) {
		this.sv = sv;
	}

	public MonHoc getMon() {
		return mon;
	}

	public void setMon(MonHoc mon) {
		this.mon = mon;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

}
