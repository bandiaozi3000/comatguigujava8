import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaTest5 {
    /**
     * 一:Stream的三个操作步骤:
     *   1.创建Stream
     *   2.中间操作
     *   3.终止操作(终端操作)
     */
    @Test
    public void Test1(){
        /**
         *  1.可以通过Collection系列集合提供的stream()或 parallelStream()
         */
        List<String> list =  new ArrayList<>();
        Stream<String> stream1 = list.stream();
        /**
         * 2.通过Arrays中的静态方法stream()获取数组流
         */
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);
        /**
         * 3.通过Stream类中的静态方法of()
         */
         Stream<String> stream3=Stream.of("aa","bb","cc");
        /**
         * 4.创建无限流
         *   迭代
         *   生成
         */
        Stream<Integer> stream4=Stream.iterate(1,(x)->x+2);
        stream4.limit(3).forEach(System.out::println);
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
    }

}
