package com.yuu.quanlysinhvien;

public class MonHoc {
	private String maMon;
	private String tenMon;
	private int heSoMon;

	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonHoc(String maMon, String tenMon, int heSoMon) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.heSoMon = heSoMon;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public int getHeSoMon() {
		return heSoMon;
	}

	public void setHeSoMon(int heSoMon) {
		this.heSoMon = heSoMon;
	}

	public static void label() {
		System.out.format("%-10s%-15s%-10s%n", "Mã môn", "Tên môn", "Hệ số môn");
	}

	public void showInfor() {
		System.out.format("%-10s%-15s%-10d%n", maMon, tenMon, heSoMon);
	}
}
