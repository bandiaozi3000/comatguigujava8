import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LambdaTest7 {
    /**
     * 终止操作
     *     查找与匹配:
     *     allMatch-检查是否匹配所有元素
     *     anyMatch-检查是否至少匹配一个元素
     *     noneMatch-检查是否没有匹配所有元素
     *     findFirst-返回第一个元素
     *     count-返回流中元素的总个数
     *     max-返回流中最大值
     *     min-返回流中最小值
     *
     */

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 15, 5622.54),
            new Employee("李四", 10, 1212.54),
            new Employee("王五", 8, 6465.54),
            new Employee("赵六", 16, 6702.54),
            new Employee("苏七", 40, 2316.54)
    );

    @Test
    public void Test(){
        boolean boo = employees.stream().allMatch((x)->x.getAge()>10);
        System.out.println(boo);
        boo = employees.stream().anyMatch((x)->x.getAge()>10);
        System.out.println(boo);
        boo = employees.stream().noneMatch((x)->x.getAge()>10);
        System.out.println(boo);
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);
        long count = employees.stream().count();
        System.out.println(count);
        employee = employees.stream().max((x,y)-> Integer.compare(x.getAge(),y.getAge()));
        System.out.println(employee);
        employee = employees.stream().min((x,y)-> Integer.compare(x.getAge(),y.getAge()));
        System.out.println(employee);
    }
}
