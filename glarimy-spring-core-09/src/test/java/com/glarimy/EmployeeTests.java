package com.glarimy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTests {

	@Test
	public void test() {
		Employee employee = new Employee();
		assertTrue(employee.getId() == 0);
		assertTrue(employee.getName() == null);
		assertTrue(employee.getSalary() == 0);
		assertTrue(employee.isRegular() == false);
		assertTrue(employee.getAddress() == null);
		assertTrue(employee.getQualifications() == null);
	}

	@Test
	public void firstTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("first.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 0);
		assertTrue(employee.getName() == null);
		assertTrue(employee.getSalary() == 0);
		assertTrue(employee.isRegular() == false);
		assertTrue(employee.getAddress() == null);
		assertTrue(employee.getQualifications() == null);
	}

	@Test
	public void secondTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("second.xml", "address.xml",
				"qualifications.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 22061971);
		assertTrue(employee.getName().equals("Krishna Mohan Koyya"));
		assertTrue(employee.getSalary() == 100000.00);
		assertTrue(employee.isRegular() == true);
		assertTrue(employee.getAddress() == null);
		assertTrue(employee.getQualifications() == null);

		Address address = context.getBean(Address.class);
		assertTrue(address.getLocation().equals("Pai Layout"));
		assertTrue(address.getCity().equals("Bengaluru"));
		assertTrue(address.getPincode() == 560016);

		Qualification be = (Qualification) context.getBean("be");
		assertTrue(be.getDegree().equals("BE"));
		assertTrue(be.getUniversity().equals("Andhra University"));

		Qualification mtech = (Qualification) context.getBean("mtech");
		assertTrue(mtech.getDegree().equals("M.Tech"));
		assertTrue(mtech.getUniversity().equals("Andhra University"));

		Qualification pmp = (Qualification) context.getBean("pmp");
		assertTrue(pmp.getDegree().equals("PMP"));
		assertTrue(pmp.getUniversity().equals("PMI"));
	}

	@Test
	public void thirdTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("third.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 22061971);
		assertTrue(employee.getName().equals("Krishna Mohan Koyya"));
		assertTrue(employee.getSalary() == 100000.00);
		assertTrue(employee.isRegular() == true);
		assertTrue(employee.getAddress().getLocation().equals("Pai Layout"));
		assertTrue(employee.getAddress().getCity().equals("Bengaluru"));
		assertTrue(employee.getAddress().getPincode() == 560016);
		employee.getQualifications().forEach(q -> {
			if (q.getDegree().equals("BE"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("M.Tech"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("PMP"))
				assertTrue(q.getUniversity().equals("PMI"));
		});

		Address address = context.getBean(Address.class);
		assertTrue(address.getLocation().equals("Pai Layout"));
		assertTrue(address.getCity().equals("Bengaluru"));
		assertTrue(address.getPincode() == 560016);

		Qualification be = (Qualification) context.getBean("be");
		assertTrue(be.getDegree().equals("BE"));
		assertTrue(be.getUniversity().equals("Andhra University"));

		Qualification mtech = (Qualification) context.getBean("mtech");
		assertTrue(mtech.getDegree().equals("M.Tech"));
		assertTrue(mtech.getUniversity().equals("Andhra University"));

		Qualification pmp = (Qualification) context.getBean("pmp");
		assertTrue(pmp.getDegree().equals("PMP"));
		assertTrue(pmp.getUniversity().equals("PMI"));
	}

	@Test
	public void fourthTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("fourth.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 22061971);
		assertTrue(employee.getName().equals("Krishna Mohan Koyya"));
		assertTrue(employee.getSalary() == 100000.00);
		assertTrue(employee.isRegular() == true);
		assertTrue(employee.getAddress().getLocation().equals("Pai Layout"));
		assertTrue(employee.getAddress().getCity().equals("Bengaluru"));
		assertTrue(employee.getAddress().getPincode() == 560016);
		employee.getQualifications().forEach(q -> {
			if (q.getDegree().equals("BE"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("M.Tech"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("PMP"))
				assertTrue(q.getUniversity().equals("PMI"));
		});
	}

	@Test
	public void fifthTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("fifth.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 22061971);
		assertTrue(employee.getName().equals("Krishna Mohan Koyya"));
		assertTrue(employee.getSalary() == 100000.00);
		assertTrue(employee.isRegular() == true);
		assertTrue(employee.getAddress().getLocation().equals("Pai Layout"));
		assertTrue(employee.getAddress().getCity().equals("Bengaluru"));
		assertTrue(employee.getAddress().getPincode() == 560016);
		employee.getQualifications().forEach(q -> {
			if (q.getDegree().equals("BE"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("M.Tech"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("PMP"))
				assertTrue(q.getUniversity().equals("PMI"));
		});
	}

	@Test
	public void sixthTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("sixth.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 22061971);
		assertTrue(employee.getName().equals("Krishna Mohan Koyya"));
		assertTrue(employee.getSalary() == 100000.00);
		assertTrue(employee.isRegular() == true);
		assertTrue(employee.getRole().getDesignation().equals("Principal Consultant"));
		assertTrue(employee.getAddress().getLocation().equals("Pai Layout"));
		assertTrue(employee.getAddress().getCity().equals("Bengaluru"));
		assertTrue(employee.getAddress().getPincode() == 560016);
		assertTrue(employee.getQualifications().size() == 3);
		employee.getQualifications().forEach(q -> {
			if (q.getDegree().equals("BE"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("M.Tech"))
				assertTrue(q.getUniversity().equals("Andhra University"));
		});

	}

	@Test
	public void seventhTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("seventh.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 22061971);
		assertTrue(employee.getName().equals("Krishna Mohan Koyya"));
		assertTrue(employee.getSalary() == 100000.00);
		assertTrue(employee.isRegular() == true);
		assertTrue(employee.getRole().getDesignation().equals("Principal Consultant"));
		assertTrue(employee.getAddress().getLocation().equals("Pai Layout"));
		assertTrue(employee.getAddress().getCity().equals("Bengaluru"));
		assertTrue(employee.getAddress().getPincode() == 560016);
		assertTrue(employee.getCard() == null);
		assertTrue(employee.getQualifications().size() == 2);
		employee.getQualifications().forEach(q -> {
			if (q.getDegree().equals("BE"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("M.Tech"))
				assertTrue(q.getUniversity().equals("Andhra University"));
		});
	}

	@Test
	public void eighthTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("eighth.xml");
		Employee employee = (Employee) context.getBean("employee");
		assertTrue(employee.getId() == 22061971);
		assertTrue(employee.getName().equals("Krishna Mohan Koyya"));
		assertTrue(employee.getSalary() == 100000.00);
		assertTrue(employee.isRegular() == true);
		assertTrue(employee.getRole().getDesignation().equals("Principal Consultant"));
		assertTrue(employee.getAddress().getLocation().equals("Pai Layout"));
		assertTrue(employee.getAddress().getCity().equals("Bengaluru"));
		assertTrue(employee.getAddress().getPincode() == 560016);
		assertTrue(employee.getCard().isActive() == true);
		assertTrue(employee.getQualifications().size() == 2);
		employee.getQualifications().forEach(q -> {
			if (q.getDegree().equals("BE"))
				assertTrue(q.getUniversity().equals("Andhra University"));
			if (q.getDegree().equals("M.Tech"))
				assertTrue(q.getUniversity().equals("Andhra University"));
		});
	}
}
