/**
 * 通过timer进行简单的任务调度
 */

import java.util.Timer;
import java.util.TimerTask ;

public class TimeScheduler extends TimerTask{
    private String jobName = "";
    public TimeScheduler(String jobName){
        super();
        this.jobName = jobName;
    }
    @Override
    public void run(){
        System.out.println("execte" + jobName);
    }

    public static void main(String[] args){
        Timer timer = new Timer();
        long delay1 = 1*1000;
        long period1 = 1000;
        //从现在开始1秒钟之后，每隔1秒钟执行一次job
        timer.schedule(new TimeScheduler("job1"), delay1, period1);
        long delay2 = 2*1000;
        long period2 = 2000;
        timer.schedule(new TimeScheduler("job2"), delay2, period2);
    }
}
