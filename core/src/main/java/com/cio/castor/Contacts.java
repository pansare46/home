package com.cio.castor;

import java.util.HashSet;
import java.util.Set;

/**
 * An simple person class
 */
public class Contacts implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<Contact> contact = new HashSet<Contact>();

	/**
	 * Creates a Person with no name
	 */
	public Contacts() {
		super();
	}

	public Set<Contact> getContact() {
		return contact;
	}

	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}

}