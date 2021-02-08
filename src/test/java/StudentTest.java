import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class StudentTest extends TestCase {
    Student student;

    public void setUp() throws Exception {
        super.setUp();
        List<Double> l = Arrays.asList(1.0, 2.0, 3.0);

        student = new Student(l);
    }

    public void testGetAverageGrade() {
        assertEquals(2.0, student.getAverageGrade());
    }
}