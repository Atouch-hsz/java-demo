package threaddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author created by hsz 2020/5/28 19:56
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 3;
        long keepAliveTime = 1;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(3);
        //BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(3);
        //BlockingQueue<Runnable> workQueue = new SynchronousQueue<>();
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, handler);
        for (int i = 0; i < 10; i++) {
            try {
                executor.execute(() -> test());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //System.out.println("test");
    }

    public static void test() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
