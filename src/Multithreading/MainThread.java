import java.util.Map;

/**
 * 多线程练习
 */
class MyThread extends Thread {
    private String name;
    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(name + "运行" + i);
            try{
                sleep((int) Math.random()*10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Mythread2 implements Runnable{
    private String name;
    public Mythread2(String name){
        this.name = name;
    }
    @Override
     public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(name + "运行" + i);
            try{
                Thread.sleep((int)Math.random()*100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
     }
}
public class MainThread{
    public static void main(String[] args){
        MyThread t1 = new MyThread("sky");
        MyThread t2 = new MyThread("wxl");
        t2.setPriority(10);
        t1.setPriority(1);
        t1.run();
        t2.run();
        new Thread(new Mythread2("d")).start();
    }

}