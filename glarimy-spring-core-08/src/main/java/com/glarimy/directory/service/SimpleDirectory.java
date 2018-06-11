package com.glarimy.directory.service;

import java.beans.ConstructorProperties;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.data.CRUDRepository;
import com.glarimy.directory.domain.Contact;
import com.glarimy.directory.exceptions.EntryNotFoundException;
import com.glarimy.directory.exceptions.InvalidEntryException;

public class SimpleDirectory implements Directory {
	private CRUDRepository<String, Contact> repo;

	@ConstructorProperties({ "repo" })
	public SimpleDirectory(CRUDRepository<String, Contact> repo) {
		this.repo = repo;
	}

	@Override
	public void add(Contact contact) {
		if (contact.getName() == null || contact.getName().trim().length() == 0 || contact.getPhoneNumber() < 1)
			throw new InvalidEntryException();
		repo.save(contact.getName(), contact);
	}

	@Override
	public Contact find(String name) {
		Contact contact = repo.find(name);
		if (contact == null)
			throw new EntryNotFoundException();
		return contact;
	}
}
