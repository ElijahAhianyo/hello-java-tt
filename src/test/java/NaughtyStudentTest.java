import junit.framework.TestCase;

import java.util.Arrays;

public class NaughtyStudentTest extends TestCase {

    NaughtyStudent nStudent;

    public void setUp() throws Exception {
        super.setUp();

        this.nStudent = new NaughtyStudent();
    }

    public void testGetAverageGrade() {
        var results = Arrays.asList(1.0, 2.0, 3.0);
        double expectedAverage = 0;

        for (var score : results) {
            expectedAverage += score;
        }
        expectedAverage /= results.size();  // 2.0

        nStudent.setGrades(results);

//        check that naughty students are indeed students
        assertTrue(this.nStudent instanceof Student);

//        check that the naughty student's avg
//        is indeed 10% more of the actual avg
        assertEquals(
                1.1 * expectedAverage,
                nStudent.getAverageGrade()
        );
    }
}
