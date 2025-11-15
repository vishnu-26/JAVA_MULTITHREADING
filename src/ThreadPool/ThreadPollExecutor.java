package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPollExecutor {

    public static void main(String[] args) {
        
        // ThreadPollExecutoor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
        ThreadPoolExecutor threadPollExecutor = new ThreadPoolExecutor(2,4,10,TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),new CustomThreadFactory(), new customRejectionHandler());
        threadPollExecutor.allowCoreThreadTimeOut(true);  // allow core threads to time out after keep alive time


        
        for(int i=1; i<=7; i++){

            /*Java requires that variables from outside the lambda must be effectively final
            Also if we use i directly inside lambda, by the time task gets executed, value of i would have changed*/
            final int taskId = i;
            threadPollExecutor.submit(() ->{
                try{
                    System.out.println("Task "+taskId+" is being executed by" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
                catch(Exception e){}
            });
        }

        threadPollExecutor.shutdown();
    }

    

}

class CustomThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(false);
        return t;
    }
}

class customRejectionHandler implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected : " + r.toString());
    }
}
