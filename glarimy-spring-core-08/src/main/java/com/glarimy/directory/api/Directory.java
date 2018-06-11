package com.glarimy.directory.api;

import com.glarimy.directory.domain.Contact;
import com.glarimy.directory.exceptions.DirectoryException;
import com.glarimy.directory.exceptions.EntryNotFoundException;
import com.glarimy.directory.exceptions.InvalidEntryException;

public interface Directory {

	void add(Contact contact) throws InvalidEntryException, DirectoryException;

	Contact find(String name) throws EntryNotFoundException, DirectoryException;

}