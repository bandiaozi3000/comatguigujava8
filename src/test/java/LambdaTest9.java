import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest9 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 15, 5622.54),
            new Employee("李四", 10, 1212.54),
            new Employee("王五", 8, 6465.54),
            new Employee("赵六", 16, 6702.54),
            new Employee("苏七", 40, 2316.54)
    );
    List<Transcation> transcations = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Ranul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transcations = Arrays.asList(
                new Transcation(brian, 2011, 300),
                new Transcation(raoul, 2012, 1000),
                new Transcation(raoul, 2011, 400),
                new Transcation(mario, 2012, 710),
                new Transcation(mario, 2012, 700),
                new Transcation(alan, 2012, 950)
        );
    }

    /**
     * 将数字列表的每个值换成其平方
     */
    @Test
    public void Test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        List<Integer> lsit2 = list.stream().map((x)->x*x).collect(Collectors.toList());
        list.stream().map((x) -> x * x).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 用Map和reduce返回Employee个数
     */
    @Test
    public void Test2() {
        Optional<Integer> optional = employees.stream().map((x) -> 1).reduce(Integer::sum);
        System.out.println(optional);
    }

    @Test
    public void Test3() {
        /**
         * 找出2011年发生的所有交易,并按交易额排序(从低到高)
         */
        List<Transcation> list = transcations.stream().filter((x) -> x.getYear() == 2011).sorted((x, y) -> Integer.compare(x.getValue(), y.getValue())).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("------------------------");
        /**
         * 交易员都在哪些不同的城市工作过
         * List<String> city = transcations.stream().map((x)->x.getTrader().getCity()).distinct().collect(Collectors.toList());
         */
        List<String> city = transcations.stream().map(Transcation::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        city.forEach(System.out::println);
        System.out.println("------------------------");
        /**
         * 找出所有来自剑桥的交易员,并按照姓名排序
         */
        List<Trader> traders = transcations.stream().map(Transcation::getTrader).filter((x)->x.getCity().equals("Cambridge")).sorted((x, y) -> x.getName().compareTo(y.getName())).collect(Collectors.toList());
        traders.forEach(System.out::println);
        System.out.println("------------------------");
        /**
         * 返回所有交易员的姓名字符串,按字母顺序排序
         */
        List<String> names = transcations.stream().map(Transcation::getTrader).map(Trader::getName).sorted((x, y) -> x.compareTo(y)).collect(Collectors.toList());
        names.forEach(System.out::println);
        System.out.println("------------------------");
        /**
         * 有没有交易员是在米兰工作的
         */
        boolean boo = transcations.stream().map(Transcation::getTrader).anyMatch((x) -> x.getCity().equals("Milan"));
        List<Trader> miLanTraders = transcations.stream().map(Transcation::getTrader).filter((x) -> x.getCity().equals("Milan")).collect(Collectors.toList());
        System.out.println(boo);
        miLanTraders.forEach(System.out::println);
        System.out.println("------------------------");
        /**
         * 打印生活在剑桥的交易员的所有交易额
         */
        List<Integer> cambridgeValue = transcations.stream().filter((x)->(x.getTrader().getCity().equals("Cambridge"))).map(Transcation::getValue).collect(Collectors.toList());
        cambridgeValue.forEach(System.out::println);
        System.out.println("------------------------");
        /**
         * 所有交易中，最高的交易额是多少
         */
        DoubleSummaryStatistics dss = transcations.stream().collect(Collectors.summarizingDouble(Transcation::getValue));
        System.out.println(dss.getMax());
        /**
         * 找出交易额最小的交易
         */
        System.out.println(dss.getMin());
    }


}
