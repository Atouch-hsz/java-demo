package ReferenceDemo;

import java.lang.ref.SoftReference;

/**
 * @author created by hsz 2020/5/26 13:48
 */
public class SoftReferenceDemo {
    /**
     * 软引用，如果内存不足，则会回收软引用对象（JVM将软引用中的对象设置为null，然后GC回收），以此来释放空间
     * @param args
     */
    public static void main(String[] args) {
        Object o1 = new Object();
        SoftReference<Object> o2 = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println("----------------------");
        o1 = null;
        //System.gc();
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(o2.get());
        }

    }
}
