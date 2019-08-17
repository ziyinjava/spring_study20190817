package proxy;

/**
 * @author ziyin
 @create 2019-06-2019/6/23-13:07
 */
public class TestImpl implements Test {

    @Override
    public void test1() {
        System.out.println("test1...");
        test2();
    }

    @Override
    public void test2() {
        System.out.println("test2...");
    }
}
