package rcrscopy.copiers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Mateusz Dygas
 *
 */

public class ParallelTasks {
	private int numberOfThreads;
	
	public ParallelTasks(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}
	
	private final Collection<Runnable> tasks = new ArrayList<Runnable>();

	public void add(final Runnable task) {
		tasks.add(task);
	}

	public void go() throws InterruptedException {
		final ExecutorService threads = Executors.newFixedThreadPool(numberOfThreads);
		try {
			final CountDownLatch latch = new CountDownLatch(tasks.size());
			for (final Runnable task : tasks)
				threads.execute(new Runnable() {
					public void run() {
						try {
							task.run();
						} finally {
							latch.countDown();
						}
					}
				});
			
			latch.await();
		} finally {
			threads.shutdown();
		}
	}
}