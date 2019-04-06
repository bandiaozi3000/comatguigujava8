import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest2 {
    /**
     * 一:lambda表达式基础语法：java8中引入了一个新的操作符"->" 该操作符成为箭头操作符或lambda操作符,箭头操作符将lambda
     * 表达式拆分成两个部分
     * 左侧:Lambda表达式的参数列表
     * 右侧:Lambda表达式中所需要执行的功能,即Lambda体
     * <p>
     * 语法格式一:无参数,无返回值
     * ()->System.out.println("Hello Lambda");
     * <p>
     * 语法格式二:有一个参数,并且无返回值
     * (x)->System.out.println(x);
     * <p>
     * 语法格式三:有只有一个参数,小括号可以省略不写
     * x->System.out.println(x);
     * <p>
     * 语法格式四:有两个以上的参数,有返回值,并且lambda体中有多条语句
     * Comparator<Integer> com = (x,y)->{
     * System.out.println("函数式接口");
     * return Integer.compare(x,y);
     * };
     * <p>
     * 语法格式五:若Lambda体中只有一条语句,return和大括号都可以省略不写
     * Comparator<Integer> com = (x,y)->Integer.compare(x,y);
     * <p>
     * 语法格式六:Lambda表达式的参数列表的数据类型可以省略不写,因为Jvm编译器通过上下文推断出数据类型,即"类型推断"
     * (Integer x,Integer y)->Integer.compare(x,y);
     * <p>
     * 上联:左右遇一括号省
     * 下联:左侧推断类型省
     * 横批:能省则省
     * <p>
     * 二:Lambda 表达式需要"函数式接口"的支持
     * 函数式接口:接口中只有一个抽象方法的接口,成为函数式接口.可以使用注解 @FunctionalInterface 修饰
     * 可以检查是否是函数式接口
     */


    List<Employee> employees = Arrays.asList(
            new Employee("张三", 15, 5622.54),
            new Employee("李四", 10, 1212.54),
            new Employee("王五", 8, 6465.54),
            new Employee("赵六", 16, 6702.54),
            new Employee("苏七", 40, 2316.54)
    );

    public String testLambda(String str, ChangeString changeString) {
        return changeString.getValue(str);
    }

    public Long testLambda(Long long1, Long long2, SumLong<Long, Long> sumLong) {
        return sumLong.getValue(long1, long2);
    }


    /**
     * 无参数无返回值
     */
    @Test
    public void Test1() {
        int num = 2;  //jdk1.7之前，必须是final. 1.8默认是final，在Lambda表达式里无法做出修改
        Runnable runnable = () -> System.out.println("Hello Lambda!" + num);
        runnable.run();
    }

    /**
     * 有参数,无返回值
     */
    @Test
    public void Test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello Lambda!");
        System.out.println("-------------------------");
        //只有一个参数可以省略括号
        consumer = x -> System.out.println(x);
        consumer.accept("Hello Lambda!");
    }

    /**
     * 有两个参数,有返回值
     */
    @Test
    public void Test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println(comparator.compare(2, 5));

        //只有一条语句,大括号可以省略
        comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(2, 5));
    }

    @Test
    public void Test4() {
        Collections.sort(employees, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return x.getAge().compareTo(y.getAge());
            }
        });
        System.out.println(employees);
    }

    @Test
    public void Test5() {
        String str = "hello lambda";
        System.out.println(testLambda(str, (x) -> x.toUpperCase()));
    }

    @Test
    public void Test6() {
        Long long1 = 100L;
        Long long2 = 200L;
        System.out.println(testLambda(long1,long2, (x,y) -> x+y));
    }
}
