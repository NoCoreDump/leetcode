package designPattern.singleton;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName Singleton.java
 * @Description 单例模式--饿汉式
 * 优点：简单实用，线程安全
 * 缺点：不管用没用到实例，只要完成类加载就会初始化一个实例
 * @createTime 2020年06月30日
 */
public class Singleton {
    private static final Singleton uniqInstance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return uniqInstance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }

}
