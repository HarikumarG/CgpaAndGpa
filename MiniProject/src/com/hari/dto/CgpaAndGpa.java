package com.hari.dto;
public class CgpaAndGpa {
	private String Subject;
	private String Subcode;
	private char Grade;
	private int Credits;
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getSubcode() {
		return Subcode;
	}
	public void setSubcode(String subcode) {
		Subcode = subcode;
	}
	public char getGrade() {
		return Grade;
	}
	public void setGrade(char grade) {
		Grade = grade;
	}
	public int getCredits() {
		return Credits;
	}
	public void setCredits(int credits) {
		Credits = credits;
	}
}
