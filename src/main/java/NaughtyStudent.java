import java.util.List;

public class NaughtyStudent extends Student {
    NaughtyStudent() {
        super();
    }

    NaughtyStudent(List<Double> grades) {
        super();
        this.grades = grades;
    }

    @Override
    public Double getAverageGrade() {
        double result = 0.0;

        for (Double grade : grades) {
            result += grade;
        }
        result = result / grades.size();

        return 1.1 * result;
    }

}
