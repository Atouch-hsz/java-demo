package ReferenceDemo;

/**
 * @author created by hsz 2020/5/26 11:56
 */
public class StrongReference {
    /**
     * 强引用，即便是内存空间不足时，也不会回收，宁可让系统报OOM，都不会回收对象
     * @param args
     */
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        System.out.println(o1);
        System.out.println(o2);
        System.out.println("----------------------");
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2);
    }
}
