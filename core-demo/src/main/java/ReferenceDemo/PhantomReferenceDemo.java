package ReferenceDemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author created by hsz 2020/5/26 15:36
 */
public class PhantomReferenceDemo {
    /**
     * 虚引用，不管内存是否够用，只要GC，虚引用对象都会被回收，必须使用引用队列
     * @param args
     */
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<Object>();
        PhantomReference<Object> o2 = new PhantomReference<Object>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println(referenceQueue.poll());
        System.out.println("----------------------");
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println(referenceQueue.poll());
    }
}
