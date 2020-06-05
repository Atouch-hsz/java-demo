package threaddemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author created by hsz 2020/5/26 11:55
 */
public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
