import org.junit.Test;

import java.util.*;

public class LambdaTest1 {

    /**
     * Arrays.asList生成的集合长度不变,不能用add等方法
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 15, 5622.54),
            new Employee("李四", 10, 1212.54),
            new Employee("王五", 8, 6465.54),
            new Employee("赵六", 16, 6702.54),
            new Employee("苏七", 40, 2316.54)
    );


    public List<Employee> getEmplyee(List<Employee> employees, EmployeeFilter employeeFilter) {
        List<Employee> list = new ArrayList<>();
        for (Employee emp : employees) {
            if (employeeFilter.testEmployee(emp)) {
                list.add(emp);
            }
        }
        return list;
    }

    /**
     * 原先匿名内部类的创建方式
     */
    @Test
    public void Test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(6);
        treeSet.add(2);
        System.out.println(treeSet);

    }

    /**
     * lambda表达式创建
     * 格式:lambda实现的接口里面有唯一一个需要实现的接口方法."->"之前为方法参数,可以任意取名字,但参数个数需要和接口方法一致
     * "->"后面为方法具体实现的内容.
     */
    @Test
    public void Test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(6);
        treeSet.add(2);
        System.out.println(treeSet);
    }

    /**
     * 根据员工年龄和工资获取相应员工集合,用普通匿名内部类的方式
     */
    @Test
    public void Test3() {
        //获取员工年龄大于10的员工
        List<Employee> list = getEmplyee(employees, new EmployeeFilter() {

            @Override
            public boolean testEmployee(Employee employee) {
                if (employee.getAge() > 10) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        System.out.println(list);
        //获取薪资大于5000的员工
        list = getEmplyee(employees, new EmployeeFilter() {
            @Override
            public boolean testEmployee(Employee employee) {
                if (employee.getSalary() > 5000) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        System.out.println(list);
    }

    /**
     * 利用Lambda表达式进行优化
     */
    @Test
    public void lambdaTest(){
        getEmplyee(employees,(x)->x.getAge()>10).forEach(System.out::println);
        System.out.println("-----------------");
        getEmplyee(employees,(x)->x.getSalary()>5000).forEach(System.out::println);
    }

    /**
     * 利用stream进行优化
     */
    @Test
    public void streamTest(){
        employees.stream().filter((x)->x.getAge()>10).forEach(System.out::println);
        System.out.println("-------------------------");
        employees.stream().filter((x)->x.getAge()>10).limit(2).forEach(System.out::println);
        System.out.println("-------------------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }



}
