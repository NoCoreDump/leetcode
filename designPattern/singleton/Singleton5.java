package designPattern.singleton;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName Singleton5.java
 * @Description 单例模式--枚举类实现，最完美，线程安全，还可以防止反序列化
 * @createTime 2020年06月30日
 */
public enum Singleton5 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Singleton5.INSTANCE.hashCode());
        }
    }
}
