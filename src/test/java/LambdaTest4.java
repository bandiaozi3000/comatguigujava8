import org.junit.Test;

import javax.jws.WebMethod;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest4 {
    /**
     * 方法引用:若 Lambada 体中的内容有方法已经实现了,我们可以使用"方法引用"
     * (可以理解为方法引用是Lambda表达式的另外一种表现形式)
     * <p>
     * 前提条件:调用方法的返回值和参数和lambda要实现的接口方法应该一致.
     * <p>
     * 主要有三种语法格式:
     * 对象::实例方法名
     * <p>
     * 类::静态方法名
     * <p>
     * 类::实例方法名
     * 注意:
     * 1.Lambda体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的函数列表和返回值类型保持一致.
     * 2.若Lambda参数列表中的第一参数是实例方法的调用者,而第二个参数是实例方法的参数时,可是使用ClassName:method
     * <p>
     * 二:构造器引用
     * 格式:ClassName:new
     * 注意:需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致!
     * <p>
     * 三:数组引用
     * Type[]::new
     */
    @Test
    public void Test() {
        /**
         * void accept(T t);
         * public void println(String x)
         * 前提条件符合.
         * 对象::实例方法名
         */
        Consumer<String> consumer = System.out::println;
        consumer.accept("aaaaa");
    }

    @Test
    public void Test2() {
        /**
         * int compare(T o1, T o2);
         * int compare(int x, int y)
         * 条件符合
         * 类::静态方法名
         */
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1, 5));
    }

    @Test
    public void Test3() {
        /**
         *  类::实例方法名
         */
        BiPredicate<Integer, Integer> biPredicate = Integer::equals;
        System.out.println(biPredicate.test(2, 2));
        System.out.println(biPredicate.test(2, 5));
    }

    @Test
    public void Test4() {
        /**
         *  构造器引用
         *  Supplier<Employee> supplier = ()->new Employee();
         *  Function<String,Employee> function = (x)->new Employee(x);
         */
        Supplier<Employee> supplier = Employee::new;
        System.out.println(supplier.get());
        Function<String, Employee> function = Employee::new;
        System.out.println(function.apply("张三"));
    }

    @Test
    public void Test5() {
        /**
         * 数组引用
         *   Function<Integer,String[]> function = (x)->new String[x];
         *   String[] str = function.apply(10);
         *   System.out.println(str.length);
         */
        Function<Integer, String[]> function = String[]::new;
        String[] str = function.apply(10);
        System.out.println(str.length);

    }

}
