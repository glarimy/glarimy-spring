package com.glarimy.directory.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.glarimy.directory.domain.Contact;
import com.glarimy.directory.exceptions.DirectoryException;
import com.glarimy.directory.exceptions.EntryNotFoundException;
import com.glarimy.directory.exceptions.InvalidEntryException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/data.xml" })
public class RepositoryTests implements ApplicationContextAware {
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Test
	@SuppressWarnings({ "unchecked" })
	public void testSave() {
		CRUDRepository<String, Contact> repo = (CRUDRepository<String, Contact>) context.getBean("repo");

		try {
			repo.save(null, new Contact("Krishna", 9731423166L));
			fail("Should not have added the null entry");
		} catch (RuntimeException iee) {

		}

		try {
			repo.save("Krishna", new Contact("Krishna", 9731423166L));
		} catch (InvalidEntryException iee) {
			fail("Should not have thrown the exception for valid data");
		}
	}

	@Test
	@SuppressWarnings({ "unchecked" })
	public void testFind() {
		CRUDRepository<String, Contact> repo = (CRUDRepository<String, Contact>) context.getBean("repo");
		try {
			Contact contact = repo.find("Krishnammm");
			assertTrue("Should have returned correct phone number", contact != null);
			assertEquals("Should have returned correct phone number", contact.getPhoneNumber(), 9731423166L);
		} catch (EntryNotFoundException ene) {
			fail("Should not have thrown the exception for existing entry");
		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}
	}
}
