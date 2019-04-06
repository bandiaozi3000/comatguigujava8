public class Singleton4 {
    /**
     * 双重校验锁为什么两次判断Null:
     *    第一次:如果不加null判断,所有线程到该步的时候都会等待其他线程释放锁,会造成阻塞.加了Null值判断,当前线程若判断出不为null，就会直接返回实例.而不用在等待.
     *    第二次:可能同时都多个线程都进入到If代码块中(因为if并没有加同步).所以进入到同步方法后,得再次判断是否为空(因为其他进入到if的代码块可能已经执行了,那么此时的实例就不为Null).
     */
    // 私有构造
    private Singleton4() {
    }

    private static Singleton4 single = null;

    // 双重检查
    public static Singleton4 getInstance() {
        if (single == null) {
            synchronized (Singleton4.class) {
                if (single == null) {
                    single = new Singleton4();
                }
            }
        }
        return single;
    }

}

