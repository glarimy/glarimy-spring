package com.glarimy.directory.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.domain.Contact;
import com.glarimy.directory.exceptions.DirectoryException;
import com.glarimy.directory.exceptions.EntryNotFoundException;
import com.glarimy.directory.exceptions.InvalidEntryException;

public class DirectoryTests {

	@Test
	public void testAddContact() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Directory directory = context.getBean(Directory.class);
		try {
			directory.add(new Contact(null, 9731423166L));
			fail("Should not have added the null entry");
		} catch (InvalidEntryException iee) {

		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}

		try {
			directory.add(new Contact(" ", 9731423166L));
			fail("Should not have added the empty entry");
		} catch (InvalidEntryException iee) {

		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}

		try {
			directory.add(new Contact("Krishna", -100));
			fail("Should not have added the invalid phone number");
		} catch (InvalidEntryException iee) {

		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}

		try {
			directory.add(new Contact("Krishna", 9731423166L));
		} catch (InvalidEntryException iee) {
			fail("Should not have thrown the exception for valid data");
		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}
	}

	@Test
	public void testFindContact() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Directory directory = context.getBean(Directory.class);
		try {
			directory.find("Krishna");
			fail("Should not have found phone number for unknown entry");
		} catch (EntryNotFoundException iee) {

		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}

		try {
			directory.add(new Contact("Krishna", 9731423166L));
		} catch (InvalidEntryException iee) {
			fail("Should not have thrown the exception for valid data");
		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}

		try {
			Contact contact = directory.find("Krishna");
			assertEquals("Should have returned correct phone number", contact.getPhoneNumber(), 9731423166L);
		} catch (EntryNotFoundException ene) {
			fail("Should not have thrown the exception for existing entry");
		} catch (DirectoryException de) {
			fail("Should not have thrown general exception");
		}
	}
}
