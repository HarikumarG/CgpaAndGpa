package com.hari.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.hari.dao.CgpaAndGpaDao;
import com.hari.dto.CgpaAndGpa;
import com.hari.util.Utility;
import java.io.*;
import static java.lang.System.*;
public class CgpaAndGpaController {
	Scanner s=new Scanner(System.in);
	CgpaAndGpaDao dao=new CgpaAndGpaDao();
	public void calgpa(int nosem,int check)
	{
		ArrayList<CgpaAndGpa> subdetails=new ArrayList<CgpaAndGpa>();
		try
		{
			subdetails=dao.getSubjectdetails(nosem,check);
			System.out.println("Enter the grades for semester number "+nosem);
			for(int i=0;i<subdetails.size();i++) 
			{
				System.out.println(subdetails.get(i).getSubcode()+"  "+subdetails.get(i).getSubject());
				subdetails.get(i).setGrade(s.next().charAt(0));
			}
			float gradesum=0;
			float creditsum=0;
			for(int i=0;i<subdetails.size();i++)
			{
				int gradeval=Utility.getGradevalue(subdetails.get(i).getGrade());
				int creditval=subdetails.get(i).getCredits();
				creditsum=creditsum+creditval;
				gradesum= gradesum + (creditval * gradeval);
			}
			float gpa=gradesum/creditsum;
			System.out.println("\n");
			System.out.println("The GPA for the semester number "+nosem+" is "+gpa);
			try
			{
				File file = new File("C:\\Users\\Ravi\\Desktop\\gpa.rtf");
				FileWriter fw = new FileWriter(file);
				PrintWriter pw=new PrintWriter(fw);
				pw.println("    GRADE POINT AVERAGE");
				pw.println("\n");
				pw.println("NAME OF THE STUDENT : ");
				pw.println("\n");
				for(int i=0;i<subdetails.size();i++)
				{
					pw.println(subdetails.get(i).getSubcode()+"     "+subdetails.get(i).getSubject()+"    =    "+subdetails.get(i).getGrade());
				}
				pw.println("\n");
				pw.println("The GPA for the semester number "+nosem+" is "+gpa);
				pw.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("Error");
			}
		}
			catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void calcgpa(int nosem,int check)
	{
		ArrayList<CgpaAndGpa> details=new ArrayList<CgpaAndGpa>();
		for(int j=1;j<=nosem;j++)
		{
			ArrayList<CgpaAndGpa> subdetails=new ArrayList<CgpaAndGpa>();
			try
			{
				subdetails=dao.getSubjectdetails(j,check);
				System.out.println("Enter the grades for semester number "+j);
				for(int i=0;i<subdetails.size();i++)
				{
					System.out.println(subdetails.get(i).getSubcode()+"  "+subdetails.get(i).getSubject());
					subdetails.get(i).setGrade(s.next().charAt(0));
				}
				details.addAll(subdetails);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		float gradesum=0;
		float creditsum=0;
		for(int i=0;i<details.size();i++)
		{
			int gradeval=Utility.getGradevalue(details.get(i).getGrade());
			int creditval=details.get(i).getCredits();
			creditsum=creditsum+creditval;
			gradesum= gradesum + (creditval * gradeval);
		}
		float cgpa=gradesum/creditsum;
		System.out.println("\n");
		System.out.println("The CGPA for "+nosem+" semesters is "+cgpa);
		try 
		{
			File file1 = new File("C:\\Users\\Ravi\\Desktop\\cgpa.rtf");
			FileWriter fw1 = new FileWriter(file1);
			PrintWriter pw1=new PrintWriter(fw1);
			pw1.println("   CUMULATIVE GRADE POINT AVERAGE");
			pw1.println("\n");
			pw1.println("NAME OF THE STUDENT : ");
			pw1.println("\n");
			
			for(int i=0;i<details.size();i++)
			{
				pw1.println(details.get(i).getSubcode()+"     "+details.get(i).getSubject()+"    =    "+details.get(i).getGrade());
			}
			pw1.println("\n");
			pw1.println("The CGPA for "+nosem+" semesters is "+cgpa);
			pw1.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Error");
		}
	}
}
