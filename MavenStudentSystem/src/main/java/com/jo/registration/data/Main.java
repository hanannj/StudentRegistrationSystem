package com.jo.registration.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.jo.registration.boo.Admin;
import com.jo.registration.boo.Course;
import com.jo.registration.boo.Department;
import com.jo.registration.boo.Instructor;
import com.jo.registration.boo.Student;
import com.jo.registration.boo.User;

public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Admin.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Department.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		
		tx.commit();

	}

}
