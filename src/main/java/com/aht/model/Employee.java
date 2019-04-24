package com.aht.model;

import com.opencsv.bean.CsvBindByPosition;

public class Employee {
	@CsvBindByPosition(position = 4)
	private String ten;
	@CsvBindByPosition(position = 5)
	private String ngay;
	@CsvBindByPosition(position = 7)
	private String ca;
	@CsvBindByPosition(position = 10)
	private String ra;

	public Employee() {
		// TODO Auto-generated constructor stub

	}

	public Employee(String ten, String ngay, String ca, String ra) {
		this.ten = ten;
		this.ngay = ngay;
		this.ca = ca;
		this.ra = ra;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	@Override
	public String toString() {
		return "Employee [Ten=" + ten + ", Ngay=" + ngay + ", Va=" + ca + ", Ra=" + ra + "]";
	}

}
