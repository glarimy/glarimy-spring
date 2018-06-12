package com.glarimy.bank.data;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.glarimy.bank.api.model.Account;
import com.glarimy.bank.api.model.Address;
import com.glarimy.bank.api.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dao.xml")
public class InMemoryAccountDAOTest implements ApplicationContextAware {
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Test
	public void testSave() {
		Address address = new Address();
		address.setLocation("Old Madras Road");
		address.setCity("Bengaluru");
		address.setPincode(560016);

		Customer customer = new Customer();
		customer.setName("Krishna");
		customer.setPhoneNumber(9731423166L);
		customer.setAddress(address);

		Account account = new Account();
		account.setCustomer(customer);

		AccountDAO dao = (AccountDAO) context.getBean("dao");
		int number = dao.save(account);

		assertTrue(number != 0);
		Account result = dao.find(number);
		assertTrue(result != null);

		int nextNumber = dao.save(account);

		assertTrue(number + 1 == nextNumber);
	}

	@Test
	public void testFind() {
		AccountDAO dao = (AccountDAO) context.getBean("dao");
		Account configured = (Account) context.getBean("account");
		Account account = dao.find(configured.getNumber());
		assertTrue(account == configured);
		System.out.println(account);
	}

}
