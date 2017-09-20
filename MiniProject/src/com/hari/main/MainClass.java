package com.hari.main;
import java.sql.SQLException;
import java.util.Scanner;
import com.hari.controller.CgpaAndGpaController;
import com.hari.util.ProjectConstants;
public class MainClass {
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("       CGPA AND GPA CALCULATOR FOR REGULATION 2013\n");
		System.out.println("THE DEPARTMENTS ARE LISTED BELOW...........\n");
		System.out.println("Enter the DEPARTMENT NUMBER................\n");
		System.out.println("Enter 1 for COMPUTER SCIENCE Department");
		System.out.println("Enter 2 for CIVIL Department");
		System.out.println("Enter 3 for MECHANICAL Department");
		System.out.println("Enter 4 for INFORMATION TECHNOLOGY Department");
		System.out.println("Enter 5 for ELECTRICAL AND ELECTRONICS Department");
		System.out.println("Enter 6 for ELECTRONICS AND COMMUNICATION Department");
		System.out.println("Enter 7 for ELECTRONICS AND INSTRUMENTATION Department");
		int check=s.nextInt();
		System.out.println("Type GPA or CGPA to calculate..");
		String category=s.next();
		int nosem;
		CgpaAndGpaController ctrl =new CgpaAndGpaController();
		if(category.equalsIgnoreCase(ProjectConstants.CGPA))
		{
			System.out.println("Enter the no. of semesters");
			nosem=s.nextInt();
			ctrl.calcgpa(nosem,check);
		}
		else if(category.equalsIgnoreCase(ProjectConstants.GPA))
		{
			System.out.println("Enter the sem no.");
			nosem=s.nextInt();
			ctrl.calgpa(nosem,check);
		}
		else
		{
			System.out.println("Enter the proper value");
		}
	}
}
