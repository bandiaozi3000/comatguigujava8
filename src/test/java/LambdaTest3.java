import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest3 {
    /**
     * Java8 内置的四大核心函数式接口
     *
     * Consumer<T>:消费型接口
     *    void accept(T t)
     *
     * Supplier<T>:供给型接口
     *     T get();
     *
     * Function<T,R>:函数型接口
     *     R apply(T t);
     *
     * Predicate<T>:断言型接口
     *     boolean test(T t);
     */

    /**
     * 消费型接口Consumer
     */
    @Test
    public void Test1(){
        Consumer<String> consumer =(x)-> System.out.println(x);
        consumer.accept("aaaa");
    }

    /**
     * 供给型接口Supplier
     */
    @Test
    public void Test2(){
        Supplier<String> supplier = ()->{
           return "aaaa";
        };
        System.out.println(supplier.get());
    }

    /**
     * 函数型接口
     */
    @Test
    public void Test3(){
        Function<String,String> function =(x)->x;
        System.out.println(function.apply("aaaa"));
    }

    /**
     * 断言型接口
     */
    @Test
    public void Test4(){
        Predicate<Integer> predicate = (x)->x>5;
        System.out.println(predicate.test(7));
    }
}
