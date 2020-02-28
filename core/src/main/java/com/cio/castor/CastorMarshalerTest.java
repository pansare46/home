package com.cio.castor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

public class CastorMarshalerTest {

	public static void main(String[] args) throws IOException, MarshalException, ValidationException, MappingException {
		

		Mapping mapping = new Mapping();
		mapping.loadMapping("contacts-mapping.xml");

		Contacts allContacts = new Contacts();

		Contact nikhil = new Contact();
		nikhil.setName("Nikhil");

		Set<String> nikNumbers = new HashSet<>();

		nikNumbers.add("999999999");
		nikNumbers.add("888888888");
		nikhil.setNumbers(nikNumbers);

		Contact yogesh = new Contact();
		yogesh.setName("Yogesh");

		Set<String> yogNumbers = new HashSet<>();

		yogNumbers.add("777777777");
		yogesh.setNumbers(yogNumbers);

		Set<Contact> allContactDataSet = new HashSet<Contact>();

		allContactDataSet.add(nikhil);
		allContactDataSet.add(yogesh);
		allContacts.setContact(allContactDataSet);

		FileWriter writer = new FileWriter("test.xml");
		// Marshaller.marshal(allContacts, writer);

		Marshaller marshallerObj = new Marshaller(writer);
		marshallerObj.setMapping(mapping);
		marshallerObj.marshal(allContacts);
		writer.flush();
		writer.close();

		// writer

		FileReader reader = new FileReader("test.xml");

		Unmarshaller unMarshallerObj = new Unmarshaller(mapping);
		Contacts whiteList = (Contacts) unMarshallerObj.unmarshal(reader);

	

		Contact kavita = new Contact();
		kavita.setName("kavita");

		Set<String> kavitaNumber = new HashSet<>();

		kavitaNumber.add("666666666");
		kavita.setNumbers(kavitaNumber);

		whiteList.getContact().add(kavita);

		FileWriter writer2 = new FileWriter("test.xml");

		Marshaller marshallerObj2 = new Marshaller(writer2);
		marshallerObj2.setMapping(mapping);
		marshallerObj2.marshal(whiteList);
		writer2.flush();
		writer2.close();

	}
}
