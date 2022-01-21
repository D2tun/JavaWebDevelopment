package test.ipo.task4.service.impl;

import java.util.Arrays;
import java.util.Collection;

public class TriangleProvider {
	
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{new double[] {2.5, 1}, new double[] {2.1, 3},
				 new double[] {4.7, 1}, 7.519851, 2.2,
				 new boolean[] {false, true, false, false, false},
				 1
			},
			{new double[] {2.4, 1}, new double[] {4.2, 3},
				 new double[] {8.4, 1}, 13.342606, 6,
				 new boolean[] {false, true, false, false, false},
			}
		});
	}
}
