package rcrscopy.jobs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Parallelize tasks for files copy
 * @author Mateusz Dygas
 * @author Krystian Bajno
 *
 */

public class ParallelTasks {
    private int numberOfThreads;
    
    /**
     * @param numberOfThreads - number of threads used in copy process
     */
    public ParallelTasks(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }
    
    private final Collection<Runnable> tasks = new ArrayList<Runnable>();

    /**
     * Queues tasks for file copying process
     * @param task - single task for file copy 
     */
    public void add(final Runnable task) {
        tasks.add(task);
    }

    /**
     * Executes runnable tasks to copy files 
     * @throws InterruptedException - Interrupted exception
     */
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