package com.example.Studentdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.Util.DatabaseUtil;
import com.example.entity.Student;

public class StudentDao {
	public String createStudent(Student sa) {
     try {
    	 
      Connection connection=getConnection();
      String query="insert into students values(?,?,?,?,?)";
      
      PreparedStatement statement=connection.prepareStatement(query);
		Scanner a=new Scanner(System.in);
		System.out.println("Enter Studentid");
		Integer studentId=a.nextInt();
		System.out.println("Enter StudentName");
		String studentName=a.next();
		System.out.println("Enter StudentAge");
		Integer studentAge=a.nextInt();
		System.out.println("Enter StudentCourse ");
		String studentCourse=a.next();
		System.out.println("Enter StudentCity");
		String studentCity=a.next();
		
//		Student sa=new Student();
		sa.setId(studentId);
		sa.setName(studentName);
		sa.setAge(studentAge);
		sa.setCourse(studentCourse);
		sa.setCity(studentCity);
		
      statement.setInt(1, sa.getId());
      statement.setString(2, sa.getName());
      statement.setInt(3, sa.getAge());
      statement.setString(4, sa.getCourse());
      statement.setString(5, sa.getCity());
    
 //    	Statement statement=connection.createStatement();
      statement.execute();
     
    		return "sucessfull" ;
    		
    	 }catch(Exception e) {
    		 throw new RuntimeException(e);
    	 }
    }
	 private Connection getConnection() throws ClassNotFoundException, SQLException {
	 		//driver class
		 Class.forName(DatabaseUtil.DB_DRIVER_CLASSNAME);
		 //establish connection
		 return DriverManager.getConnection(DatabaseUtil.DB_URL, DatabaseUtil.DB_USERNAME, DatabaseUtil.DB_PASSWORD);
      
       }
	 public Student retrieveStudentsById(Integer id) throws SQLException{
		 try {
			 Connection connection=getConnection();
		 String query="select * from  students where id=?";
		 PreparedStatement statement=connection.prepareStatement(query);
		   
		 Scanner b=new Scanner(System.in);
		 System.out.println("Enter the Id of your Student  ");
		 
	      statement.setInt(1, b.nextInt());
	     
		 
		 ResultSet resultset=statement.executeQuery();
		 Student  student=new Student();
		 while(resultset.next()) {
			 int studentId=resultset.getInt(1);	 
			 String studentName=resultset.getString(2);
			 int studentAge=resultset.getInt(3);
			 String studentCourse=resultset.getString(4);
			 String studentCity=resultset.getString(5);
			 
			 student.setId(studentId);
			 student.setName(studentName);
			 student.setAge(studentAge);
			 student.setCourse(studentCourse);
			 student.setCity(studentCity);
		 
		 }
		 return student;
		 }catch(Exception e) {
			 throw new RuntimeException(e);
	
		 }
	 }
	  public Student updateStudent(Student s1) throws SQLException{
		  try {
			  Connection connection=getConnection();
			  
			  Scanner sc=new Scanner(System.in);
				Integer studentId=sc.nextInt();
				String studentName=sc.next();
				Integer studentAge=sc.nextInt();
				String studentCourse=sc.next();
				String studentCity=sc.next();
				
				Student s=new Student();
				s.setId(studentId);
				s.setName(studentName);
				s.setAge(studentAge);
				s.setCourse(studentCourse);
				s.setCity(studentCity);
			  
			    String query="Update students set name="+"'"+studentName+"'," + "age="
			   +""+studentAge+","+"course="+"'"+studentCourse+"',"+"city="+"'"+studentCity+"'" +
			    		"where id="+studentId;
				 PreparedStatement statement=connection.prepareStatement(query);
				 
				 statement.execute();
				 
				 return s;
			    
			 }catch(Exception e) {
			  throw new RuntimeException(e);
		   }
		
		 }
	  public String deleteStudentbyid(Student s1) {
		  try {
		  Connection connection=getConnection();
		  Scanner b=new Scanner(System.in);
//		  Student s=new Student();
		  String query="DELETE FROM students WHERE id="+b.nextInt();
		  PreparedStatement statement=connection.prepareStatement(query);
		  statement.execute();
		  return "Sucessfully deleted";
		  }catch(Exception e) {
			  throw new RuntimeException(e);
		  }
		 }
     }


//			 
	 
	 
	 
	 
	 
//	 public List<Student> retrieveallstudents(){
//		 
//	 }
//	 private Student mapStudent(Integer id,String name,Integer age,String course,String city) {
//		 Student s=new Student();
//		 s.setId(id);
//		 s.setName(name);
//		 s.setAge(age);
//		 s.setCourse(course);
//		 s.setCity(city);
//		 return s;
		 
	 

	 


