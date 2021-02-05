import java.util.*;

public class Register {

    private List<Student> students;

    Register() {}

    Register(List<Student> students) {
        this.students = students;
    }

    public List<String> getRegister() {
        List<String> names = new ArrayList<String>();

        for (var nameable : this.students) {
            names.add(nameable.getName());
        }

        return names;
    }

    public Map<Level, List<Student>> getRegisterByLevel(Level level) {
        var names = new ArrayList<Student>();

        for (var student : this.students) {
            if(((Student) student).getLevel() == level) {
                names.add(student);
            }
        }

        var map = new HashMap<Level, List<Student>>();
        map.put(level, names);

        return map;
    }

    public String printReport() {
        var wrapper = new Object() { String out = ""; };
        var studentsByLevel = new EnumMap<Level, HashSet<Student>>(Level.class);

//        re-arrange students
        for (var student : this.students) {
            var l = ((Student) student).getLevel();
            if (!studentsByLevel.containsKey(l)) {
                studentsByLevel.put(l, new HashSet<>());
            }
            studentsByLevel.get(l).add((Student) student);
        }

//        print students
        studentsByLevel.forEach((level, students) -> {
            wrapper.out += "\n";
            wrapper.out += "===========================\n";
            wrapper.out += "Level " + level + "\n";
            wrapper.out += "\n";

            for(var s : students) {
                wrapper.out += s.getName() + "\n";
            }
        });

        System.out.println(wrapper.out);

        return wrapper.out;
    }

    List<Student> sort(Comparator<Student> c) {
        var x = new ArrayList<>(this.students);

        x.sort(c);

        return x;
    }
}
