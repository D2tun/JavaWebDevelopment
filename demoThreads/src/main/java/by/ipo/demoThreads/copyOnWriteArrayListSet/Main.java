package by.ipo.demoThreads.copyOnWriteArrayListSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> temp = new Random().ints(5, 0, 10).boxed().collect(Collectors.toList());
		List<Integer> newList = new ArrayList<>();
		//CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>(temp);
		CopyOnWriteArraySet<Integer> copyList = new CopyOnWriteArraySet<>(temp);
		System.out.printf("%17s: %s%n ", "copyList before", temp);
		// ArrayList<Integer> list = new ArrayList<>(temp);
		new Thread(() -> { // thread # 1
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Iterator<Integer> iterator = copyList.iterator();
			while (iterator.hasNext()) {
				Integer current = iterator.next();
				newList.add(current);
			}
			System.out.printf("%16s: %s%n ", "newList Th #1", newList);
		}).start();
		new Thread(() -> { // thread # 2
			for (int i = 0; i < 10; i++) {
				try {
					TimeUnit.MILLISECONDS.sleep(10);// change to 100
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//copyList.addIfAbsent(i);
				copyList.add(i);
			}
		}).start();

		try {
			TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%16s: %s%n ", "copyList Th #2", copyList);
		System.out.printf("%16s: %s%n ", "newList Th #1", newList);

	}

}
