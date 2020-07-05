package designPattern.singleton;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName Singleton4.java
 * @Description 单例模式--静态内部类实现
 * @createTime 2020年06月30日
 */
public class Singleton4 {
    private Singleton4() {}
    private static class SingletonInstanceHolder {
        private final static Singleton4 uniqInstance = new Singleton4();
    }
    public static Singleton4 getInstance() {
        return SingletonInstanceHolder.uniqInstance;
    }
}
