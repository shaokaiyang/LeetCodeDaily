
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static int POOL_NUM = 10;     //线程池数量

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i<POOL_NUM; i++)
        {
            RunnableThread thread = new RunnableThread();

            //Thread.sleep(1000);
            executorService.execute(thread);
        }
        //关闭线程池
        executorService.shutdown();
    }
}

class RunnableThread implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");

    }
}

