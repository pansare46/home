package com.cio.core;

import java.util.ArrayList;
import java.util.List;

public class MioLoopTester {

	private static List<String> aList = new ArrayList<String>();

	private static int counter = 100000000;

	private void fillList()

	{
		long start = System.currentTimeMillis();
		int i = 0;
		while (i < counter) {
			aList.add("a");
			i++;
			// Increase in the time is large if we start printing value of i
			// System.out.println(" i value = " + i );
		}
		long end = System.currentTimeMillis();

		System.out.println(" Time Taken = " + ((end - start)));
	}

	private void fetchSize() {

		long start = System.currentTimeMillis();
		for (int i = 0; i < aList.size(); i++) {
			// just loop no computation
		}
		long end = System.currentTimeMillis();

		System.out.println(" Time Taken ListSize() = " + (end - start));
	}

	private void fetchVariable() {

		long start = System.currentTimeMillis();
		for (int i = 0; i < counter; i++) {
			// just loop no computation
		}
		long end = System.currentTimeMillis();

		System.out.println(" Time Taken variable = " + (end - start));
	}

	public static void main(String[] args) {
		MioLoopTester obj = new MioLoopTester();
		obj.fillList();
		obj.fetchVariable();
		obj.fetchSize();
	}

}
