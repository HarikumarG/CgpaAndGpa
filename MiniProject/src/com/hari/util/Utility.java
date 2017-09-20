package com.hari.util;
public class Utility {
	public static String getTablename(int check)
	{
		switch(check)
		{
			case 1:
				return ProjectConstants.CSE_DEPT;
			case 2:
				return ProjectConstants.CIVIL_DEPT;
			case 3:
				return ProjectConstants.MECHANICAL_DEPT;
			case 4:
				return ProjectConstants.IT_DEPT;
			case 5:
				return ProjectConstants.EEE_DEPT;
			case 6:
				return ProjectConstants.ECE_DEPT;
			case 7:
				return ProjectConstants.EIE_DEPT;
			default:
				return null;
		}
	}
	public static int getGradevalue(char grade)
	{
		switch(grade)
		{
			case 'S':
				return ProjectConstants.S_GRADE;
			case 'A':
				return ProjectConstants.A_GRADE;
			case 'B':
				return ProjectConstants.B_GRADE;
			case 'C':
				return ProjectConstants.C_GRADE;
			case 'D':
				return ProjectConstants.D_GRADE;
			case 'E':
				return ProjectConstants.E_GRADE;
			default:
				return 0;
		}
	}
}
