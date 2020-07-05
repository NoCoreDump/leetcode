package designPattern.singleton;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName Singleton2.java
 * @Description 单例模式--synchronize关键字实现
 * @createTime 2020年06月30日
 */
public class Singleton2 {
    private static Singleton2 uniqInstance;

    private Singleton2() {}
    public synchronized static Singleton2 getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new Singleton2();
        }
        return uniqInstance;
    }
}
