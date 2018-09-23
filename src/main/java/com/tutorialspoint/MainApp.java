package com.tutorialspoint;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config/Beans.xml");

		//		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		//
		//		ApplicationContext annotatedContext = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		//
		//		HelloWorld annotatedHelloWorld = (HelloWorld) annotatedContext.getBean("helloWorld");
		//
		//		System.out.println(annotatedHelloWorld.getMessage1());
		//
		//		HelloIndia hi = (HelloIndia)annotatedContext.getBean("helloIndia3BeanName");
		//		System.out.println(hi.getMessage1());
		//
		//		ConfigurableApplicationContext configurableContext = new ClassPathXmlApplicationContext("Beans.xml");
		//		configurableContext.start();
		//		configurableContext.stop();
		//
		//		CustomEventPublisher cvp = (CustomEventPublisher) configurableContext.getBean("customEventPublisher");
		//		cvp.publish();
		//		cvp.publish();

		//		Student student = (Student) context.getBean("student");
		//		System.out.println(student.getName());
		//
		//		System.out.println(student.getAge());
		//		student.printThrowException();

		//		BasicDataSource dmds = (BasicDataSource) context.getBean("dataSource");
		//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		//		jdbcTemplate.setDataSource(dmds);
		//
		//
		//		Properties props = new Properties();
		//        props.put("autoReconnect","true");
		//        props.put("user","root");
		//        props.put("password","root");
		//        props.put("socketTimeout", "15");
		//
		//		ConnectionFactory cf = new DriverManagerConnectionFactory("jdbc:mysql://localhost:3306", props) ;
		//		try {
		//			cf.createConnection();
		//		} catch (SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}


		BasicDataSource bds = new BasicDataSource();
		bds.setUsername("root");
		bds.setPassword("root");
		bds.setUrl("jdbc:mysql://localhost:3306/TEST");
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		JdbcTemplate temp = new JdbcTemplate(bds);
		//
		//		temp.execute("CREATE DATABASE IF NOT EXISTS TEST;");

		temp.execute("CREATE TABLE STUDENTS_TWO (id int, name varchar(255))");

		//		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:config/Beans.xml");
		//		BasicDataSource bds = (BasicDataSource)ac.getBean("mySQLDataSource");
		//
		//Student s = (Student)context.getBean("student");

		//		BasicDataSource msServer = new BasicDataSource();
		//		msServer.setUsername("sa");
		//		msServer.setPassword("root");
		//		msServer.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//		msServer.setUrl("jdbc:sqlserver://localhost:1433;Database=TEST");
		//
		//		JdbcTemplate msSQL = new JdbcTemplate(msServer);
		//
		//msSQL.execute("CREATE DATABASE TEST");

		//				msSQL.execute("IF NOT EXISTS (select * from sysobjects where name='Student')"
		//						+ "CREATE TABLE Student("
		//						+ "id int, "
		//						+ "name varchar(255)"
		//						+ ")");
	}



}
