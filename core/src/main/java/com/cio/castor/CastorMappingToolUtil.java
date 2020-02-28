package com.cio.castor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.tools.MappingTool;

public class CastorMappingToolUtil {

	public static void generate() throws MappingException, FileNotFoundException {
		MappingTool tool = new MappingTool();
		tool.setInternalContext(new org.castor.xml.BackwardCompatibilityContext());
		tool.addClass(Contacts.class);
		OutputStream file = new FileOutputStream("contacts-mapping.xml");

		Writer writer = new OutputStreamWriter(file);
		tool.write(writer);
		// SourceGenerator.main(options);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CastorMappingToolUtil.generate();
		} catch (MappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
