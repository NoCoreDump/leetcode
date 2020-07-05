package designPattern.singleton;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName Singleton1.java
 * @Description 单例模式--懒汉式，在用的时候初始化
 * 缺点：线程不安全
 * @createTime 2020年06月30日
 */
public class Singleton1 {
    private static Singleton1 uniqInstance;  //这里不能用final修饰，final修饰时必须初始化
    private Singleton1() {}
    public static Singleton1 getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new Singleton1();
        }
        return uniqInstance;
    }

    public static void main(String[] args) {

    }
}
