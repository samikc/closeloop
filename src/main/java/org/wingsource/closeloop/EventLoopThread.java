package org.wingsource.closeloop;

import org.wingsource.closeloop.util.Constants;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by sa on 15-06-2014.
 */
public class EventLoopThread {
    private static EventLoopThread SINGLETON = new EventLoopThread();
    private ExecutorService EXECUTOR;
    private EventLoopThread() {
        EXECUTOR = Executors.newFixedThreadPool(Constants.TOTAL_THREADS);
    };

    public static EventLoopThread getInstance() {
        return SINGLETON;
    }

    public Future submit(Callable callable) {
        return this.EXECUTOR.submit(callable);
    }

    public void execute(Runnable command) {
        this.EXECUTOR.execute(command);
    }

    public void shutdown() {
        this.EXECUTOR.shutdown();
    }

}
