package by.shirokaya.tasks.javaexceptions.service;

import by.shirokaya.tasks.javaexceptions.customexception.*;
import by.shirokaya.tasks.javaexceptions.entity.Mark;
import by.shirokaya.tasks.javaexceptions.entity.Student;
import by.shirokaya.tasks.javaexceptions.entity.Subject;

public class RateService {

    public static void rate(Student student, int value, Subject subject) throws InvalidSubjectException, InvalidMarkException {
        if (!student.getSubjects().contains(subject)) {
            throw new InvalidSubjectException("RATE ERROR : The student with name: " + student.getName() + " cannot be rated in the subject: " + subject);
        } else if (value < 0 || value > 10) {
            throw new InvalidMarkException("RATE ERROR : The mark must be from 0 to 10. Invalid mark: " + value);
        } else {
            student.getMarks().add(new Mark(value, subject));
        }
    }
}
