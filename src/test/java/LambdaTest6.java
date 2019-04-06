import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaTest6 {
    /**
     * 中间操作
     *    筛选与切片:
     *    filter-接收Lambda,从流中排除某些元素
     *    limit-截断流,使其元素不超过给定数量
     *    skip(n)-跳过元素,返回一个扔掉了前n个元素的流.若流中的元素不足n个,则返回一个空流.与limit(n)互补
     *    distinct-筛选.通过流所生成的元素的hashCode()和equals()去除重复元素(要重写类的hashCode()和equals()方法)
     *
     *    映射:
     *    map-接收Lambda,将元素转换成其他形式或提取信息.接收一个函数作为参数,该函数会被应用到每一个元素上,并将其映射成一个新的元素
     *    flatMap-接收一个函数作为参数,将流中的每个值都换成另一个流,然后把所有流连接成一个流
     *
     *    排序：
     *    sorted()-自然排序
     *    sorted(Comparator com)-定制排序
     *
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 15, 5622.54),
            new Employee("李四", 10, 1212.54),
            new Employee("王五", 8, 6465.54),
            new Employee("赵六", 16, 6702.54),
            new Employee("苏七", 40, 2316.54),
            new Employee("苏七", 40, 2316.54)
    );
    @Test
    public void Test1(){
        Stream<Employee> stream = employees.stream().filter((x)->{
            System.out.println("Stream Api 的中间操作");
            return x.getAge()>10;
        });
        //stream.limit(2).forEach(System.out::println);
        stream.skip(1).distinct().forEach(System.out::println);

    }

    @Test
    public void Test2(){
        List<String> list = Arrays.asList("aa","bb","ccc");
        Stream<String> stream = list.stream().map((x)->x.toUpperCase());
        stream.forEach(System.out::println);
        Stream<String> stream1 = employees.stream().map((x)->x.getName());
        stream1.forEach(System.out::println);
    }

    @Test
    public void Test3(){
        List<Integer> list = Arrays.asList(2,4,21,6,213);
        Stream<Integer> stream =list.stream().sorted();
        stream.forEach(System.out::println);
        Stream<Employee> stream1 =employees.stream().sorted((x,y)->{
            if(x.getAge().equals(y.getAge())){
                return x.getName().compareTo(y.getName());
            }else{
                return  x.getAge().compareTo(y.getAge());
            }
        });
        stream1.forEach(System.out::println);
    }
}
