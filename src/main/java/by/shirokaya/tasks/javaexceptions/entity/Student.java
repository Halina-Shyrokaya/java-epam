package by.shirokaya.tasks.javaexceptions.entity;

import by.shirokaya.tasks.javaexceptions.customexception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student implements Calculable {
    private String name;
    private String lastName;
    private List<Subject> subjects;
    private List<Mark> marks;

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.subjects = new ArrayList<>();
        this.marks = new ArrayList<>();
    }

    public Student(String name, String lastName, List<Subject> subjects) {
        this.name = name;
        this.lastName = lastName;
        this.subjects = subjects;
        this.marks = new ArrayList<>();
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }


    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void deleteSubject(Subject subject) {
        subjects.remove(subject);
    }

    public int getSumOfMarks() throws NoSubjectsInStudentException, NoMarksInStudentException {

        int sum = 0;
        if (canBeCalculated()) {
            for (Mark mark : marks) {
                sum += mark.getValue();
            }
        }
        return sum;
    }

    public int getSumOfMarks(Subject subject) throws NoSubjectsInStudentException, InvalidSubjectException, NoMarksInStudentException {
        int sum = 0;
        if (canBeCalculated(subject)) {
            for (Mark mark : marks) {
                if (mark.getSubject().equals(subject)) {
                    sum += mark.getValue();
                }
            }
        }
        return sum;
    }

    public List<Mark> getMarks(Subject subject) {
        return marks.stream()
                .filter(m -> m.getSubject().equals(subject))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsForCalculation() throws NoSubjectsInStudentException, NoMarksInStudentException {
        List<Student> list = new ArrayList<>();
        if (canBeCalculated()) {
            list.add(this);
        }
        return list;
    }

    @Override
    public List<Student> getStudentsForCalculation(Subject subject) throws NoSubjectsInStudentException, NoMarksInStudentException, InvalidSubjectException {
        List<Student> list = new ArrayList<>();
        if (canBeCalculated(subject)) {
            list.add(this);
        }
        return list;
    }

    private boolean hasAnySubjects() throws NoSubjectsInStudentException {
        if (subjects.isEmpty()) {
            throw new NoSubjectsInStudentException("CALCULATION ERROR : No one subject is related to the student with name: " + this.getName());
        }
        return true;
    }

    private boolean hasAnyMarks() throws NoMarksInStudentException {
        if (marks.isEmpty()) {
            throw new NoMarksInStudentException("No one mark is related to the student with name: " + this.getName());
        }
        return true;
    }

    private boolean hasSubject(Subject subject) throws InvalidSubjectException {
        if (!subjects.contains(subject)) {
            throw new InvalidSubjectException("The student with name: " + this.getName() + " does not study subject: " + subject);
        }
        return true;
    }

    public boolean canBeCalculated(Subject subject) throws NoSubjectsInStudentException, InvalidSubjectException, NoMarksInStudentException {
        return hasAnySubjects() &&
                hasAnyMarks() &&
                hasSubject(subject);
    }

    public boolean canBeCalculated() throws NoSubjectsInStudentException, NoMarksInStudentException {
        return hasAnySubjects() &&
                hasAnyMarks();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(subjects, student.subjects) &&
                Objects.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, subjects, marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjects=" + subjects +
                ", marks=" + marks +
                '}';
    }
}
