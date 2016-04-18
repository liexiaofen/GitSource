package com.lw.oa.pb.daily.pb001;

import java.io.Serializable;
import java.util.List;

/**
 * *@author yuliang
 */
public class PB001001ResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工id
	private String empid;
	// 员工姓名
	private String empname;
	// 第一天
	private List<PB001Command> one;
	// 第一天
	private String dateofone;
	// 第二天
	private List<PB001Command> two;
	// 第二天
	private String dateoftwo;
	// 第三天
	private List<PB001Command> three;
	// 第三天
	private String dateofthree;
	// 第四天
	private List<PB001Command> four;
	// 第四天
	private String dateoffour;
	// 第五天
	private List<PB001Command> five;
	// 第五天
	private String dateoffive;
	// 第六天
	private List<PB001Command> six;
	// 第六天
	private String dateofsix;
	// 第七天
	private List<PB001Command> seven;
	// 第七天
	private String dateofseven;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public List<PB001Command> getOne() {
		return one;
	}

	public void setOne(List<PB001Command> one) {
		this.one = one;
	}

	public List<PB001Command> getTwo() {
		return two;
	}

	public void setTwo(List<PB001Command> two) {
		this.two = two;
	}

	public List<PB001Command> getThree() {
		return three;
	}

	public void setThree(List<PB001Command> three) {
		this.three = three;
	}

	public List<PB001Command> getFour() {
		return four;
	}

	public void setFour(List<PB001Command> four) {
		this.four = four;
	}

	public List<PB001Command> getFive() {
		return five;
	}

	public void setFive(List<PB001Command> five) {
		this.five = five;
	}

	public List<PB001Command> getSix() {
		return six;
	}

	public void setSix(List<PB001Command> six) {
		this.six = six;
	}

	public List<PB001Command> getSeven() {
		return seven;
	}

	public void setSeven(List<PB001Command> seven) {
		this.seven = seven;
	}

	public String getDateofone() {
		return dateofone;
	}

	public void setDateofone(String dateofone) {
		this.dateofone = dateofone;
	}

	public String getDateoftwo() {
		return dateoftwo;
	}

	public void setDateoftwo(String dateoftwo) {
		this.dateoftwo = dateoftwo;
	}

	public String getDateofthree() {
		return dateofthree;
	}

	public void setDateofthree(String dateofthree) {
		this.dateofthree = dateofthree;
	}

	public String getDateoffour() {
		return dateoffour;
	}

	public void setDateoffour(String dateoffour) {
		this.dateoffour = dateoffour;
	}

	public String getDateoffive() {
		return dateoffive;
	}

	public void setDateoffive(String dateoffive) {
		this.dateoffive = dateoffive;
	}

	public String getDateofsix() {
		return dateofsix;
	}

	public void setDateofsix(String dateofsix) {
		this.dateofsix = dateofsix;
	}

	public String getDateofseven() {
		return dateofseven;
	}

	public void setDateofseven(String dateofseven) {
		this.dateofseven = dateofseven;
	}


}
