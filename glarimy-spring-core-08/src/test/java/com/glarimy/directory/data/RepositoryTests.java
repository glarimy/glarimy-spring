package com.glarimy.directory.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glarimy.directory.domain.Contact;
import com.glarimy.directory.exceptions.DirectoryException;
import com.glarimy.directory.exceptions.EntryNotFoundException;
import com.glarimy.directory.exceptions.InvalidEntryException;

public class RepositoryTests {

	@SuppressWarnings({ "unchecked", "resource" })
	@Test
	public void testSave() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		CRUDRepository<String, Contact> repo = (CRUDRepository<String, Contact>) context.getBean("repo");
		try {
			repo.save(null, new Contact(null, 9731423166L));
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
	public void testFind() {
		CRUDRepository<String, Contact> repo = new InMemoryCRUDRepository<>();

		assertEquals("Should not have found entry for unknown key", repo.find("Krishna"), null);

		repo.save("Krishna", new Contact("Krishna", 9731423166L));
		try {
			Contact contact = repo.find("Krishna");
			assertTrue("Should have returned correct phone number", contact != null);
			assertEquals("Should have returned correct phone number", contact.getPhoneNumber(), 9731423166L);
		} catch (EntryNotFoundException ene) {
			fail("Should not have thrown the exception for existing entry");
		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}
	}
}
