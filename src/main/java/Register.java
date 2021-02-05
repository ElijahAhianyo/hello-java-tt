import java.util.*;

public class Register {

    private List<Nameable> nameables;

    Register() {}

    Register(List<Nameable> nameables) {
        this.nameables = nameables;
    }

    public List<Nameable> getNameables() {
        return nameables;
    }

    public void setNameables(List<Nameable> nameables) {
        this.nameables = nameables;
    }

    public List<String> getRegister() {
        List<String> names = new ArrayList<String>();

        for (var nameable : this.nameables) {
            names.add(nameable.getName());
        }

        return names;
    }

    public List<String> getRegisterByLevel(Level level) {
        var names = new ArrayList<String>();

        for (var student : this.nameables) {
//            Make sure object is student and not any Nameable
//            because NaughtyStudent does not have a Level property
            if(((Student) student).getLevel() == level) {
                names.add(student.getName());
            }
        }

        return names;
    }

    public String printReport() {
        var wrapper = new Object() { String out = ""; };
        var studentsByLevel = new EnumMap<Level, HashSet<Student>>(Level.class);

//        re-arrange students
        for (var student : this.nameables) {
            var l = ((Student) student).getLevel();
            if (!studentsByLevel.containsKey(l)) {
                studentsByLevel.put(l, new HashSet<Student>());
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
}
