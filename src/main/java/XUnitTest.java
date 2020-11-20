
public class XUnitTest {
    public static void main(String[] args) {
        TestSuite suite = TestSuite.suite();
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.getSummary());
    }
}
