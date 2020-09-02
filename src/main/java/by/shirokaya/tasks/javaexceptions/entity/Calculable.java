package by.shirokaya.tasks.javaexceptions.entity;



import by.shirokaya.tasks.javaexceptions.customexception.*;

import java.util.List;

public interface Calculable {

    List<Student> getStudentsForCalculation() throws NoSubjectsInStudentException, NoMarksInStudentException, NoGroupsInFacultyException, NoStudentsInGroupException, NoFacultiesInUniversityException;
    List<Student> getStudentsForCalculation(Subject subject) throws NoSubjectsInStudentException, NoMarksInStudentException, InvalidSubjectException, NoGroupsInFacultyException, NoStudentsInGroupException, NoFacultiesInUniversityException;

    default double getAverageMark(List<Student> allStudents) throws NoSubjectsInStudentException {
        int count = 0;
        double sum = 0.0;
        for (Student student : allStudents) {
            try {
                sum += student.getSumOfMarks();
                count += student.getMarks().size();
            } catch (NoMarksInStudentException e) {
                System.err.println(e.getMessage());
            }
        }
        return sum / count;
    }
    default double getAverageMark(List<Student> allStudents, Subject subject) throws NoSubjectsInStudentException {
        int count = 0;
        double sum = 0.0;
        for (Student student : allStudents) {
            try {
                sum += student.getSumOfMarks(subject);
                count += student.getMarks(subject).size();
            } catch (NoMarksInStudentException | InvalidSubjectException e) {
                System.err.println(e.getMessage());
            }
        }
        return sum / count;

    }
    default double getAverageMark() throws NoSubjectsInStudentException, NoMarksInStudentException, NoGroupsInFacultyException, NoStudentsInGroupException, NoFacultiesInUniversityException {
        return getAverageMark(getStudentsForCalculation());
    }

    default double getAverageMark(Subject subject) throws NoSubjectsInStudentException, NoMarksInStudentException, InvalidSubjectException, NoGroupsInFacultyException, NoStudentsInGroupException, NoFacultiesInUniversityException {
        return getAverageMark(getStudentsForCalculation(subject), subject);
    }
}
