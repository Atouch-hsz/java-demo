package threaddemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author created by hsz 2020/5/26 11:55
 */
public class SyncDemo {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("jvm");
        System.out.println(ClassLayout.parseInstance(test).toPrintable());
    }
}

class Test {
    boolean f = false;
}
