
import java.util.*;
import java.util.concurrent.*;

import static java.util.Arrays.asList;

public class CallableTest {

    static class Sum implements Callable<Long> {
        private final long from;
        private final long to;

        Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            long acc = 0;
            for (long i = from; i <= to; i++) {
                acc = acc + i;
            }
            System.out.println(Thread.currentThread().getName() + " : " + acc);
            return acc;
        }
    }

    static class printTest implements Runnable{
        public void run(){
            System.out.println("runable test");
        }
    }

    static class printTest1 implements Callable<String>{
        public String call(){
            String result = "callable test";
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Long>> results = executor.invokeAll(asList(
                new Sum(0, 10), new Sum(0, 1_000), new Sum(0, 1_000_000)
        ));
        executor.submit(new printTest());
        Future<String> results1 = executor.submit(new printTest1());
        System.out.println(results1.get());
        executor.shutdown();

        for (Future<Long> result : results) {
            System.out.println(result.get());
        }
    }
}