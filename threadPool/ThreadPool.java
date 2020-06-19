package threadPool;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName ThreadPool.java
 * @Description TODO
 * @createTime 2020年06月18日
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);
    void shutdown();
    void addWorkers(int num);
    void removeWorker(int num);
    int getJobSize();
}
