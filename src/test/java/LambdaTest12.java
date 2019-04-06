import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class LambdaTest12 {
    /**
     * 时间日期
     */
    @Test
    public void Test1() {
        /**
         * 传统时间日期转换
         */
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(() -> {
                return simpleDateFormat.format(date);
            }));

        }
        list.stream().forEach((x) -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * java.util.concurrent.ExecutionException: java.lang.NumberFormatException: multiple points
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void Test2() throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> task = () -> {
            return simpleDateFormat.parse("20161218");
        };
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(task));
        }
        for (Future<Date> future : list) {
            System.out.println(future.get());
        }

    }

}
