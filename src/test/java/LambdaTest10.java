import org.junit.Test;

import java.util.stream.LongStream;

public class LambdaTest10 {
    /**
     * 并行流
     *   parallel()：并行
     *   sequential(): 串行
     *
     */
    @Test
    public void Test(){
        Long startTime =System.currentTimeMillis();
        Long sum = 0L;
        for(int i =0;i<=1000000000L;i++){
            sum+=i;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("花费时间为:"+(endTime-startTime));
        System.out.println(sum);
    }

    @Test
    public void Test2(){
        Long startTime =System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0,1000000000L).parallel().reduce(0,Long::sum);
        Long endTime = System.currentTimeMillis();
        System.out.println("花费时间为:"+(endTime-startTime));
        System.out.println(sum);
    }

    @Test
    public void Test3(){
        Long startTime =System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0,1000000000L).reduce(0,Long::sum);
        Long endTime = System.currentTimeMillis();
        System.out.println("花费时间为:"+(endTime-startTime));
        System.out.println(sum);
    }
}
