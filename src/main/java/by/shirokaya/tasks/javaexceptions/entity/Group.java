package by.shirokaya.tasks.javaexceptions.entity;

import by.shirokaya.tasks.javaexceptions.customexception.*;

import java.util.*;

public class Group implements Calculable {
    private String number;
    private Set<Student> students;

    public Group(String number) {
        this.number = number;
        this.students = new HashSet<>();
    }

    public Group() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


    public void includeStudent(Student student) {
        students.add(student);
    }

    public void excludeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public List<Student> getStudentsForCalculation() throws NoStudentsInGroupException, NoSubjectsInStudentException {
        List<Student> list = new ArrayList<>();
        if (hasAnyStudents()) {
            aggregateStudentsByGroup(list);
        }
        return list;
    }

    @Override
    public List<Student> getStudentsForCalculation(Subject subject) throws NoStudentsInGroupException, NoSubjectsInStudentException {
        List<Student> list = new ArrayList<>();
        if (hasAnyStudents()) {
            aggregateStudentsByGroup(subject, list);
        }
        return list;
    }

    public void aggregateStudentsByGroup(List<Student> toList) throws NoSubjectsInStudentException {
        for (Student student : students){
            try {
                if (student.canBeCalculated()){
                    toList.add(student);
                }
            } catch (NoMarksInStudentException e) {
                System.err.println("WARNING: " + e.getMessage());
            }
        }
    }

    public void aggregateStudentsByGroup(Subject subject, List<Student> toList) throws NoSubjectsInStudentException {
        for (Student student : students){
            try {
                if (student.canBeCalculated(subject)){
                    toList.add(student);
                }
            } catch (InvalidSubjectException | NoMarksInStudentException e) {
                System.err.println("WARNING: " + e.getMessage() + ". This student will not be counted.");
            }
        }
    }

    public boolean hasAnyStudents() throws NoStudentsInGroupException {
        if (students.isEmpty()) {
            throw new NoStudentsInGroupException("CALCULATION ERROR : Group " + this.number + " has no students.");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(number, group.number) &&
                Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "number='" + number + '\'' +
                ", students=" + students +
                '}';
    }
}
