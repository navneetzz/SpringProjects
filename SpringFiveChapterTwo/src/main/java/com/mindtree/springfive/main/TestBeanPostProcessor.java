/**
 * 
 */
package com.mindtree.springfive.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.springfive.beans.Demo_Custom_init;

/**
 * @author M1044357
 *
 */
public class TestBeanPostProcessor {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_lifecycle.xml");
		Demo_Custom_init objOne = (Demo_Custom_init) applicationContext.getBean("objOne");
		
		System.out.println(objOne);
	}

}
