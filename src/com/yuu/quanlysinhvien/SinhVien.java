package com.yuu.quanlysinhvien;

public class SinhVien {
	private String maSV;
	private String hoDem;
	private String tenSv;
	private int namSinh;
	private String gioiTinh;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String maSV, String hoDem, String tenSv, int namSinh, String gioiTinh) {
		super();
		this.maSV = maSV;
		this.hoDem = hoDem;
		this.tenSv = tenSv;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public static void label() {
		System.out.format("%-10s%-25s%-10s%-10s%n",
				"Mã SV", "Họ Tên", "Năm Sinh", "Giới Tính");
	}

	public void showInfor() {
		System.out.format("%-10s%-25s%-10d%-10s%n", 
				maSV, tenSv + " " + hoDem, namSinh, gioiTinh);
	}
}
