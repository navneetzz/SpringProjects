/**
 * 
 */
package com.mindtree.springfive.model.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mindtree.springfive.context.BeanConfig;
import com.mindtree.springfive.model.Department;
import com.mindtree.springfive.model.Employee;
import com.mindtree.springfive.model.ListEmployees;
import com.mindtree.springfive.model.MapEmpTasks;
import com.mindtree.springfive.model.PropertiesAudition;
import com.mindtree.springfive.model.SetDepartments;

/**
 * @author M1044357
 *
 */
public class TestInjectData {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanConfig.class);
	   
		System.out.println("application context loaded.");
		context.refresh();   
	    
	    ListEmployees listEmps = context.getBean("listEmployees", ListEmployees.class);
	    
	    List<Employee> empRecs = listEmps.getListEmps();
	    Iterator<Employee> iterate = empRecs.iterator();
	    System.out.println("*********Injected List of Employee record ***************");
	    while(iterate.hasNext()){
	    	Employee emp = iterate.next();
	    	System.out.format("%s  %s  %d  \n", emp.getFirstName(), emp.getLastName(),emp.getAge());
	    }
	    System.out.println("*********Injected List of Employee Names ***************");
	    List<String> empNames = listEmps.getListEmpNames();
	    Iterator<String> iterateStr = empNames.iterator();
	    while(iterateStr.hasNext()){
	    	String empName = iterateStr.next();
	    	System.out.format("%s \n", empName);
	    }
	    
	    SetDepartments setDepts = context.getBean("setDepartments", SetDepartments.class);
	    Set<Department> deptRecs = setDepts.getSetDept();
	    Iterator<Department> deptIterate = deptRecs.iterator();
	    System.out.println("*********Injected Set of Department record ***************");
	    while(deptIterate.hasNext()){
	    	Department dept = deptIterate.next();
	    	System.out.format("%d   %s\n", dept.getDeptNo(), dept.getDeptName());
	    }
	    Set<String> deptNames = setDepts.getDeptNames();
	    Iterator<String> deptNameIterate = deptNames.iterator();
	    System.out.println("*********Injected Set of Department Names ***************");
	    while(deptNameIterate.hasNext()){
	    	String deptName = deptNameIterate.next();
	    	System.out.format("%s \n", deptName);
	    }
	    
	   
	    MapEmpTasks empTasks = context.getBean("mapEmpTasks", MapEmpTasks.class);
	    Map<String, Employee> assignTasked = empTasks.getMapEmpTask();
	    Iterator<Entry<String,Employee>> tasksIterate = assignTasked.entrySet().iterator();
	    System.out.println("*********Injected Task and Employee Mapping ***************");
	    while(tasksIterate.hasNext()){
	    	Entry<String,Employee> task = tasksIterate.next();
	    	String key = task.getKey();
	    	Employee value = task.getValue();
	    	System.out.format("Task: %s =  %s   %s  \n", key, value.getFirstName(), value.getLastName());
	    }
	    
	    System.out.println("*********Injected Task and Manager Mapping ***************");
	    Map<String,String> assignMgr = empTasks.getMapEmpMgr();
	    Iterator<Entry<String, String>> mgrIterate = assignMgr.entrySet().iterator();
	    while(mgrIterate.hasNext()){
	    	Entry<String,String> taskMgr = mgrIterate.next();
	    	String key = taskMgr.getKey();
	    	String value = taskMgr.getValue();
	    	System.out.format("Manager: %s = %s\n", value, key);
	    }
	    
	    System.out.println("*********Injected Audition Data ***************");
	    PropertiesAudition auditionInfo = context.getBean("auditionInfo", PropertiesAudition.class);
	    Properties propsAddress = auditionInfo.getAuditionAddress();
	    System.out.format("Audition Address: %s  %s   %s  %s\n", propsAddress.getProperty("building"), propsAddress.getProperty("city"), propsAddress.getProperty("country"), propsAddress.getProperty("zipcode"));
	    Properties propsReqt = auditionInfo.getAuditionRequirement();
	    System.out.format("Audition Requiremtn: Call time @ %s  bring %s and  %s  \n", propsReqt.getProperty("time"), propsReqt.getProperty("document"), propsReqt.getProperty("picture"));
	    
	    context.registerShutdownHook();
	}

}
