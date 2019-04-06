import org.junit.Test;

import java.util.Optional;

public class LambdaTest11 {
    /**
     * Optional 容器类的常用方法:
     *    Optional.of(T t):创建一个Optional实例
     *    Optional.empty():创建一个空的Optional实例
     *    Optional.ofNullable(T t):若T不为null,创建Optional实例,否则创建空实例
     *    isPresent():判断你是否包含值
     *    orElse(T t):如果调用对象包含值,返回该值,否则返回T
     *    orElseGet(Supplier s):如果调用对象包含值,返回该值,否则返回s获取的值
     *    map(Function f):如果有值对其处理,并返回处理后的Optional,否则返回Optional.empty()
     *    flatMap(Function mapper):与map类似,要求返回值必须是Optional
     */

    @Test
    public void Test1(){
        Optional<Employee> optional  = Optional.of(new Employee("张三"));
        System.out.println(optional);
        /**
         *   Optional<Employee> optiona2  = Optional.of(null);
         *   会报空指针异常
         */
        Optional<Employee> optiona2  = Optional.empty();
        System.out.println(optiona2);
        Optional<Employee> optiona3  = Optional.ofNullable(null);
        System.out.println(optiona3);
        Optional<Employee> optiona4 = Optional.ofNullable(new Employee("张三"));
        System.out.println(optiona4);
        System.out.println(optiona3.isPresent());
        System.out.println(optiona4.isPresent());
        System.out.println(optiona3.orElse(new Employee("李四")));
        System.out.println(optiona4.orElse(new Employee("李四")));
        System.out.println(optiona3.orElseGet(()->new Employee("李四")));
        System.out.println(optiona4.orElseGet(()->new Employee("李四")));
        System.out.println(optiona3.map((x)->x.getName()));
        System.out.println(optiona4.map((x)->x.getName()));
        System.out.println(optiona3.flatMap((x)->Optional.of(x.getName())));
        System.out.println(optiona4.flatMap((x)->Optional.of(x.getName())));


    }

}
