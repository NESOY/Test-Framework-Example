import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSuite implements Test {
    List<Test> test = new ArrayList<>();

    public TestSuite(Class<? extends TestCase> testClass) {
        Arrays.stream(testClass.getDeclaredMethods())
                .filter(m -> m.getAnnotation(annotation.Test.class) != null)
                .forEach(m ->{
                    try {
                        test.add(testClass.getConstructor(String.class).newInstance(m.getName()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public TestSuite() {

    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(TestCaseTest.class);
        return suite;
    }
    public void add(Test testBrokenMethod) {
        test.add(testBrokenMethod);
    }

    public void run(TestResult result) {
        test.forEach(t -> {
            t.run(result);
        });
    }
}
