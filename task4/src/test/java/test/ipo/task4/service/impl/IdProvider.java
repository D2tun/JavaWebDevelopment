package test.ipo.task4.service.impl;

import java.util.Arrays;
import java.util.Collection;

public class IdProvider {
	
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {{1}, {2}, {3}});
	}

	public static Collection<Object[]> wrongData() {
		return Arrays.asList(new Object[][] {{0}, {-1}});
	}
}
