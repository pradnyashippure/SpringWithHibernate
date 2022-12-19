package com.pradnya.spring_hibernate;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pradnya.spring_hibernate.Entity.Familyinfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container= new ClassPathXmlApplicationContext("applicationContext.xml");
	    SessionFactory factory = (SessionFactory) container.getBean("factory");
	
	Session session	=factory.openSession();
	Familyinfo familyinfo = session.get(Familyinfo.class ,3);
	Familyinfo fi = session.get(Familyinfo.class ,8);
	Familyinfo fi1 = session.get(Familyinfo.class ,13);
	Familyinfo fi2 = session.get(Familyinfo.class ,22);
	System.out.println(familyinfo);
	System.out.println(fi);
	System.out.println(fi1);
	System.out.println(fi2);

	Transaction transaction= session.beginTransaction();
	session.save(familyinfo);
	System.out.println("data saved ");
	transaction.commit();
	session.close();
	
	Familyinfo f = new Familyinfo();
    f.setId(39);
    f.setName("Pranavi");
    f.setAge(17);
    f.setEmail("pranavi@gmail.com");
	}

}
