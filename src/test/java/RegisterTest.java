import junit.framework.TestCase;
import org.junit.Test;

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
        var str = this.register.printReport();

        assertTrue(str.contains("Akua"));
    }

    public void testRegisterCtorShouldAcceptListOfNaughtyStudents() {
        var nStudents = Arrays.asList(
                new NaughtyStudent() {{ setName("Kwesi"); }},
                new NaughtyStudent() {{ setName("Adwoa"); }},
                new NaughtyStudent() {{ setName("Kayce"); }}
        );

        var r = new Register(nStudents);

        assertTrue(r.getRegister().containsAll(Arrays.asList("Kwesi", "Adwoa", "Kayce")));
    }

    public void testGetStudentByName() throws Exception {
        var s = this.register.getStudentByName("Kwame");

        assertEquals("Kwame", s.getName());
    }

    public void testGetStudentByNameShouldThrow() {
        try {
            var s = this.register.getStudentByName("Kukua");

            fail("StudentNotFoundException not thrown but student was not found");
        } catch (StudentNotFoundException ignored) {}
    }
}
