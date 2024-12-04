import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Student {
    private String surname;
    private String name;
    private int schoolNumber;
    private int score;

    public Student(String surname, String name, int schoolNumber, int score) {
        this.surname = surname;
        this.name = name;
        this.schoolNumber = schoolNumber;
        this.score = score;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + schoolNumber + " " + score;
    }
}

class School {
    private int schoolNumber;
    private List<Integer> scores;

    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
        this.scores = new ArrayList<>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public double getAverageScore() {
        return scores.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    @Override
    public String toString() {
        return "Школа " + schoolNumber + ": Средний балл = " + getAverageScore();
    }
}

class District {
    private List<Student> students;

    public District(List<Student> students) {
        this.students = students;
    }

    public double getAverageScore() {
        int totalScore = students.stream().mapToInt(Student::getScore).sum();
        return (double) totalScore / students.size();
    }

    public HashMap<Integer, School> getSchoolsAboveAverage() {
        HashMap<Integer, School> schoolMap = new HashMap<>();
        double districtAverage = getAverageScore();

        for (Student student : students) {
            schoolMap.putIfAbsent(student.getSchoolNumber(), new School(student.getSchoolNumber()));
            schoolMap.get(student.getSchoolNumber()).addScore(student.getScore());
        }

        // Удалим школы, у которых средний балл ниже среднего по району
        schoolMap.values().removeIf(school -> school.getAverageScore() <= districtAverage);
        return schoolMap;
    }
}
