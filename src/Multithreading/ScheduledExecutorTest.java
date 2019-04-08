import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest implements Runnable {

    private String jobName = "";
    public ScheduledExecutorTest(String jobName){
        super();
        this.jobName = jobName;
    }

    @Override
    public void run(){
        System.out.println("execute"+ jobName);
    }
    public static void main(String[] args){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        long initialDelay1 = 1;
        long period1 = 1;
        service.scheduleAtFixedRate(new ScheduledExecutorTest("job1"), initialDelay1, period1, TimeUnit.SECONDS);

        long initialDelay2 = 1;
        long period2 = 1;
        service.scheduleAtFixedRate(new ScheduledExecutorTest("job2"), initialDelay2, period2,TimeUnit.SECONDS );
    }
}
