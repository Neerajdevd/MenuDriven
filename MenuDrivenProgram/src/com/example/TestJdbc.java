package com.example;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.Studentdao.StudentDao;
import com.example.entity.Student;

public class TestJdbc {

	public static void main(String[] args) throws SQLException{
        
		Student s=new Student();
		System.out.println("Menu Driven Programm");
		 while(true) {
			Scanner sc=new Scanner(System.in);
			StudentDao studentdao=new StudentDao();
			System.out.println(" Menu ");
			System.out.println("1.Create a new student");
			System.out.println("2.Read the data of a student");

			System.out.println("3.Update the values of a student");
			System.out.println("4.Delete the values of a student");
			
			System.out.println("Choose the choice of 5 commands ");
			int choice;
			if(sc.hasNext()) {
				choice=sc.nextInt();
			}else {
				System.out.println("invalid ,you should choose a number");
				continue;
			}
			switch(choice){
			case 1:
				System.out.println("1.Create a new student");
				 
				String createstudent=studentdao.createStudent(s);
			      System.out.println(createstudent);
			      break;
				
			case 2:
				System.out.println("2.Read the data of a student");
		       Student retrieveStudentsByid=studentdao.retrieveStudentsById(1);
		       System.out.println(retrieveStudentsByid);
		       break;
				
			case 3:

				System.out.println("3.Update the values of a student");
			Student updatestudent= studentdao.updateStudent(s);
			System.out.println(updatestudent);
				break;
				
			case 4:
				System.out.println("4.Delete the values of a student");
		          String deletestudent=studentdao.deleteStudentbyid(s);
		          System.out.println(deletestudent);
				break;
				
			default:
				System.out.println("invalid choice");
				break;
			}
			System.out.println("do you want to continue ");
			
			boolean a=sc.hasNext();
			
			if(a=true) {
				continue;
			}
			else if(a=false) {
				break;
			}
			}
		}
		

		
		}


