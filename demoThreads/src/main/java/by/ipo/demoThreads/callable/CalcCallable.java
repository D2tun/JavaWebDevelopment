package by.ipo.demoThreads.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CalcCallable implements Callable<Number> {
	
	@Override
	public Number call() throws Exception {
		Number res = new Random().nextGaussian(); // имитация вычислений
		return res;
	}
}
