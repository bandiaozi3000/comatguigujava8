import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaTest8 {
    /**
     * 归约:
     * reduce(T identity,BinaryOperator)/reduce(BinaryOperator)--可以将流中元素反复结合起来,得到一个值
     * <p>
     * 收集:
     * collect-将流转换成其他形式.接收一个Collector接口的实现,用于给Stream中元素做汇总的方法.
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
    public void Test1() {
        /**
         * list.stream().reduce(0,(x,y)->x+y)
         *    解释:将0赋值给x，从stream中取一个值给y,得到的x+y的值赋给x,周而复始
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        Optional<Double> optionalDouble = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(optionalDouble);
    }

    @Test
    public void Test2() {
        List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("----------------------------");
        Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("----------------------------");
        HashSet<String> hashSet = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    @Test
    public void Test3(){
        /**
         * 总数
         */
        Long count = employees.stream().collect(Collectors.counting());
        System.out.println(count);
        /**
         * 平均值
         */
        Double average = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(average);
        /**
         * 总和
         */
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
        /**
         * 最大值
         */
        Optional<Employee> max = employees.stream().collect(Collectors.maxBy((x,y)->Double.compare(x.getSalary(),y.getSalary())));
        System.out.println(max);
        /**
         * 最小值
         */
        Optional<Double> min = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(min);
        /**
         * 分组
         */
        Map<String,List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(map);
        /**
         * 多级分组
         */
        Map<String,Map<String,List<Employee>>> map1 = employees.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.groupingBy((e)->{
            if(((Employee)e).getAge()<10){
                return "幼年";
            }else if(((Employee)e).getAge()>10&&((Employee)e).getAge()<25){
                return "青年";
            }else{
                return "中年";
            }
        })));
        System.out.println(map1);
        /**
         * 分区
         */
        Map<Boolean,List<Employee>> map2 = employees.stream().collect(Collectors.partitioningBy((e)->e.getSalary()>5000));
        System.out.println(map2);
        /**
         * DoubleSummaryStatistics
         */
        DoubleSummaryStatistics dss = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getAverage());
        System.out.println(dss.getCount());
        System.out.println(dss.getMin());
        System.out.println(dss.getSum());
        /**
         * 字符串连接
         */
        String str = employees.stream().map(Employee::getName).collect(Collectors.joining(",","===","==="));
        System.out.println(str);



    }




}
