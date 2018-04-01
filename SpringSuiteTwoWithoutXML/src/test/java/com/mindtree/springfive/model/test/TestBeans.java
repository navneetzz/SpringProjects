/**
 * 
 */
package com.mindtree.springfive.model.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mindtree.springfive.context.BeanConfig;
import com.mindtree.springfive.model.Department;
import com.mindtree.springfive.model.Employee;

/**
 * @author M1044357
 *
 */
public class TestBeans {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanConfig.class);
		System.out.println("Application context loaded.");
		applicationContext.refresh();
	    System.out.println("*********The empRec1 bean ***************");
	    Employee empRec1 = (Employee) applicationContext.getBean("empRec1");
	    System.out.println(empRec1);
	    
	    System.out.println("*********The empRec2 bean ***************");
	    Employee empRec2 = (Employee) applicationContext.getBean("empRec2");
	    Department dept2 = empRec2.getDepartment();
	    System.out.println("First Name: " + empRec2.getFirstName());
	    System.out.println("Last Name: " + empRec2.getLastName());
	    System.out.println("Birthdate: " + empRec2.getBirthDate());
	    System.out.println("Salary: " + empRec2.getSalary());
	    System.out.println("Department Name: " + dept2.getDeptName());
	   
	    System.out.println("*********The empRec3 bean ***************");
	    Employee empRec3 = (Employee) applicationContext.getBean("empRec3");
	    Department dept3 = empRec3.getDepartment();
	    System.out.println("First Name: " + empRec3.getFirstName());
	    System.out.println("Last Name: " + empRec3.getLastName());
	    System.out.println("Birthdate: " + empRec3.getBirthDate());
	    System.out.println("Salary: " + empRec3.getSalary());
	    System.out.println("Department Name: " + dept3.getDeptName());	
	    
	    System.out.println("*********The empRec4 bean ***************");
	    Employee empRec4 = (Employee) applicationContext.getBean("empRec4");
	    Department dept4 = empRec4.getDepartment();
	    System.out.println("First Name: " + empRec4.getFirstName());
	    System.out.println("Last Name: " + empRec4.getLastName());
	    System.out.println("Birthdate: " + empRec4.getBirthDate());
	    System.out.println("Salary: " + empRec4.getSalary());
	    System.out.println("Department Name: " + dept4.getDeptName());	
	    
	    applicationContext.registerShutdownHook();
	}

}
