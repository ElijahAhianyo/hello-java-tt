import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterTest extends TestCase {

    Register register;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        this.register = new Register (
            Arrays.asList(
                    new Student("Kwame", Arrays.asList(1.0, 2.0, 3.0), Level.L100),
                    new Student("Akua", Arrays.asList(4.0, 5.0, 3.0), Level.L100),
                    new Student("Sylvia", Arrays.asList(1.0, 9.0, 3.0), Level.L300)
            )
        );
    }

    public void testGetRegister() {
        var reg = this.register.getRegister();

        assertTrue(reg instanceof List);
        assertTrue(reg.get(0) instanceof String);

        assertTrue(reg.containsAll(
                Arrays.asList("Kwame", "Sylvia", "Akua")
        ));
    }

    public void testPrintRegister() {
        var str = register.printReport();

        assertTrue(str.contains("Akua"));
    }
}
