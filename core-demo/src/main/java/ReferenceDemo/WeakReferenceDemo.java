package ReferenceDemo;

import java.lang.ref.WeakReference;

/**
 * @author created by hsz 2020/5/26 15:27
 */
public class WeakReferenceDemo {
    /**
     * 弱引用，不管内存是否够用，只要GC，弱引用对象都会被回收
     * @param args
     */
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> o2 = new WeakReference<Object>(o1);
        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println("----------------------");
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2.get());
    }
}
