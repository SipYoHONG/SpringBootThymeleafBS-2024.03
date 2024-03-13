package com.example.abbs.entity;

import java.util.List;

public class SchDay {
	private int day;						// 1 ~ 31
	private int date;						// 요일, 0 - 일요일, ... , 6 - 토요일
	private int isHoliday;					// 휴일
	private int isOtherMonth;				// 지난달,다음달 숫자 나오는거 투명도 50% 설정!
	private String sdate;					// 20240313
	private List<String> annivList;			// 겹치는 기념일 대비용
	private List<Schedule> schedule;
	
	public SchDay() { }
	public SchDay(int day, int date, int isHoliday, int isOtherMonth, String sdate, List<String> annivList,
			List<Schedule> schedule) {
		this.day = day;
		this.date = date;
		this.isHoliday = isHoliday;
		this.isOtherMonth = isOtherMonth;
		this.sdate = sdate;
		this.annivList = annivList;
		this.schedule = schedule;
	}

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(int isHoliday) {
		this.isHoliday = isHoliday;
	}
	public int getIsOtherMonth() {
		return isOtherMonth;
	}
	public void setIsOtherMonth(int isOtherMonth) {
		this.isOtherMonth = isOtherMonth;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public List<String> getAnnivList() {
		return annivList;
	}
	public void setAnnivList(List<String> annivList) {
		this.annivList = annivList;
	}
	public List<Schedule> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}
}
