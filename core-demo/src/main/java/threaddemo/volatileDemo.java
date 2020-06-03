package threaddemo;

/**
 * Created by TANG on 2020/6/3 8:04
 *  * 多线程之间获取实时数据：
 *  * 1.使用关键字synchronized，原理为：在获取锁的时候会清空工作内存，从主内存中拷贝共享变量最新的值到工作内存成为副本；
 *  * 2.使用关键字volatile，原理：发出信号通知其他CPU将改变量的缓存值置为无效状态，当CPU使用到这个值的时候，发现是无效的，会从内存重新读取
 */
public class volatileDemo {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        int b = 1;
        while (true) {
            if (thread1.getA() == 1) {
                System.out.println("ok");
            } else {
                //使用System.out.println和使用synchronized关键字一样效果，println内部就是使用的synchronized
                System.out.println("running");
            }
        }
    }
}


class Thread1 extends Thread {
    //使用volatile关键字实现变量共享
    private volatile int a = 0;

    public int getA() {
        return a;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = 1;
        System.out.println("a = " + a);
    }
}