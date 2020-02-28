package com.cio.castor;

import java.util.HashSet;
import java.util.Set;

public class Contact implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name = null;

	private Set<String> numbers = new HashSet<String>();

	/**
	 * Creates a Person with no name
	 */
	public Contact() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<String> numbers) {
		this.numbers = numbers;
	}
	
	
}
