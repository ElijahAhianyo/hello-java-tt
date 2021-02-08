import java.util.HashSet;
import java.util.Set;

public class Lecture {

    private final HashSet<Student> students;

    Lecture() {

        this.students = new HashSet<Student>();
    }

    public Boolean enter(Student s) {
        return this.students.add(s);
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public double getHighestAverageGrade() {
        double highestAvg = 0.0;

        for(var student : this.students) {
            double grade = student.getAverageGrade();
            if(grade > highestAvg) {
                highestAvg = grade;
            }
        }

        return highestAvg;
    }
}
