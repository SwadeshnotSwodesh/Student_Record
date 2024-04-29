package com.spring.orm1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm1.dao.StudentDao;
import com.spring.orm1.entities.Student;



public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
       StudentDao sd=context.getBean("studentDao",StudentDao.class);
        
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
       
       while(go)
       {   
    	   System.out.println("---------------------------------------------");
    	   System.out.println("Enter 1 for adding new student:");
    	   System.out.println("Enter 2 for displaying all students:");
    	   System.out.println("Enter 3 for getting details of single student:");
    	   System.out.println("Enter 4 for deleting student's records:");
    	   System.out.println("Enter 5 for updating student:");
    	   System.out.println("Enter 6 for Exit:");
    	   
    	   try
    	   {
    		   int input=Integer.parseInt(br.readLine());
    		   switch(input)
    		   {
    			   case 1:
    				   //adding new student in database
    				   
    				   //taking inputs from the user
    				   
    				   System.out.println("Enter user id:");
    				   int uId=Integer.parseInt(br.readLine());
    				   
    				   System.out.println("Enter user name:");
    				   String uName=br.readLine();
    				   
    				   System.out.println("Enter user city:");
    				   String uCity=br.readLine();
    				   
    				   //creating student object and setting values
    				   Student s=new Student();
    				   s.setStudentId(uId);
    				   s.setStudentName(uName);
    				   s.setStudentCity(uCity);
    				   
    				   //saving student object to database by calling insert of student dao
    				   int r=sd.insert(s);
    				   System.out.println(r+" student added");
    				   System.out.println("**********************");
    				   System.out.println();
    				   break;
    			   case 2:
    				   //displaying all the students' records
    				  List<Student>allStudents= sd.getAllStudents();
    				  for(Student st:allStudents)
    				  {
    					  System.out.println("Id: "+st.getStudentId());
    					  System.out.println("Name: "+st.getStudentName());
    					  System.out.println("City: "+st.getStudentCity());
    				  }
    				  System.out.println("___________________________________");
    				   break;
    			   case 3:
    				   //displaying the particular student's records
    				   System.out.println("Enter user id:");
    				   int userId=Integer.parseInt(br.readLine());
    				   
    				   Student student=sd.getStudent(userId);
    				   System.out.println("Id: "+student.getStudentId());
 					   System.out.println("Name: "+student.getStudentName());
 					   System.out.println("City: "+student.getStudentCity());
 					   System.out.println("___________________________________");
    				   
    				   break;
    			   case 4:
    				   //deleting student's data
    				   System.out.println("Enter user id:");
    				   int id=Integer.parseInt(br.readLine());
    				   
    				   sd.deleteStudent(id);
    				   System.out.println("Student's data deleted");
    				   System.out.println("___________________________________");
    				   break;
    			  
    				   case 5:
    				    // updating student's data
    				    System.out.println("Enter user id:");
    				    int updateId = Integer.parseInt(br.readLine());

    				    // Check if the student exists
    				    if (sd.getStudent(updateId) != null) {
    				        System.out.println("Enter new name:");
    				        String newName = br.readLine();

    				        System.out.println("Enter new city:");
    				        String newCity = br.readLine();

    				        // Create a new Student object with updated details
    				        Student updatedStudent = new Student();
    				        updatedStudent.setStudentId(updateId);
    				        updatedStudent.setStudentName(newName);
    				        updatedStudent.setStudentCity(newCity);

    				        // Update the student record
    				        sd.updateStudent(updatedStudent);
    				        System.out.println("Student's data updated");
    				        System.out.println("___________________________________");
    				    } else {
    				        System.out.println("Student with id " + updateId + " not found.");
    				        System.out.println("___________________________________");
    				    }
    				    break;
    				    
    			   case 6:
    				   //this is the exit section...
    				   go=false;
    				   break;
    				   
    		   }
    	   }
    	   catch(Exception e)
    	   {
    		   System.out.println("Invalid option...please try a valid option!");
    		   System.out.println(e.getMessage());
    	   }
       }
       System.out.println("Thank you for using our service.");
       System.out.println("See you soon!");
       
    }
}
