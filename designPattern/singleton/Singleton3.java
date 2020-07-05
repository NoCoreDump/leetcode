package designPattern.singleton;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName Singleton3.java
 * @Description 单例模式--double check
 * @createTime 2020年06月30日
 */
public class Singleton3 {
    private static volatile Singleton3 uniqInstance;  //volatile的作用：防止JVM指令重拍
    private Singleton3() {}
    public static Singleton3 getInstance() {
        if (uniqInstance == null) {
            synchronized (Singleton3.class) {
                if (uniqInstance == null) { //双重检查，若没有这次检查，依然是线程不安全的
                    uniqInstance = new Singleton3();
                }
            }
        }
        return uniqInstance;
    }
}
