package concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName AtomicReferenceTest.java
 * @Description TODO
 * @createTime 2020年07月03日
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("zhangsan", 20);
        atomicReference.set(user);
        User updateUser = new User("lishi", 22);
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(updateUser==atomicReference.get());
        System.out.println(atomicReference.get().getAge());
        System.out.println(atomicReference.get().getName());
    }

    static class User {
        private String name;
        private int age;
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return this.name;
        }
        public int getAge() {
            return this.age;
        }
    }
}
