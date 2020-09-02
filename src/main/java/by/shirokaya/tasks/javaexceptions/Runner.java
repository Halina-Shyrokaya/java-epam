package by.shirokaya.tasks.javaexceptions;

import by.shirokaya.tasks.javaexceptions.customexception.*;
import by.shirokaya.tasks.javaexceptions.entity.Group;
import by.shirokaya.tasks.javaexceptions.entity.Student;
import by.shirokaya.tasks.javaexceptions.entity.Subject;
import by.shirokaya.tasks.javaexceptions.entity.University;
import by.shirokaya.tasks.javaexceptions.entity.faculty.Faculty;
import by.shirokaya.tasks.javaexceptions.entity.faculty.FinanceAndEconomyFaculty;
import by.shirokaya.tasks.javaexceptions.entity.faculty.InformationTechnologyFaculty;
import by.shirokaya.tasks.javaexceptions.entity.faculty.LawFaculty;
import by.shirokaya.tasks.javaexceptions.service.RateService;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Faculty fef = new FinanceAndEconomyFaculty();
        Faculty fit = new InformationTechnologyFaculty();

        Set<Faculty> faculties = new HashSet<>();
        faculties.add(fef);
        faculties.add(fit);

        University university = new University(faculties);

        Group groupFef = new Group("16-LG");
        fef.addGroup(groupFef);

        Group groupFit = new Group("17-BN");
        fit.addGroup(groupFit);

        Student mike = new Student("mike", "sparrow");
        mike.addSubject(Subject.ACCOUNTING);
        mike.addSubject(Subject.ECONOMICS);

        Student ricky = new Student("ricky", "martin");
        ricky.addSubject(Subject.ACCOUNTING);
        ricky.addSubject(Subject.FINANCE);

        Student lily = new Student("lily", "gale");
        lily.addSubject(Subject.APPLIED_IMMERSIVE_GAME_DESIGN);
        lily.addSubject(Subject.COMPUTER_ENGINEERING);

        try {
            RateService.rate(mike, 10, Subject.ACCOUNTING);
            RateService.rate(mike, 8, Subject.ACCOUNTING);
            RateService.rate(mike, 7, Subject.ACCOUNTING);
            RateService.rate(mike, 9, Subject.ECONOMICS);
            RateService.rate(mike, 9, Subject.ECONOMICS);
            RateService.rate(ricky, 8, Subject.ACCOUNTING);
            RateService.rate(ricky, 8, Subject.ACCOUNTING);
            RateService.rate(ricky, 7, Subject.ACCOUNTING);
            RateService.rate(ricky, 9, Subject.FINANCE);
            RateService.rate(ricky, 6, Subject.FINANCE);
            RateService.rate(lily, 8, Subject.COMPUTER_ENGINEERING);
            RateService.rate(lily, 9, Subject.COMPUTER_ENGINEERING);
            RateService.rate(lily, 7, Subject.COMPUTER_ENGINEERING);
            RateService.rate(lily, 9, Subject.APPLIED_IMMERSIVE_GAME_DESIGN);
            RateService.rate(lily, 6, Subject.APPLIED_IMMERSIVE_GAME_DESIGN);
        } catch (InvalidSubjectException | InvalidMarkException e) {
            e.printStackTrace();
        }

        try {
            RateService.rate(ricky, -10, Subject.FINANCE);
        } catch (InvalidSubjectException | InvalidMarkException e) {
            e.printStackTrace();
        }

        try {
            RateService.rate(mike, 11, Subject.ECONOMICS);
        } catch (InvalidSubjectException | InvalidMarkException e) {
            e.printStackTrace();
        }

        try {
            RateService.rate(lily, 9, Subject.WATER_AND_ENVIRONMENTAL_SYSTEMS_ENGINEERING);
        } catch (InvalidSubjectException | InvalidMarkException e) {
            e.printStackTrace();
        }

        groupFef.includeStudent(mike);
        groupFef.includeStudent(ricky);
        groupFit.includeStudent(lily);

        System.out.print("Average mark of student Mike: ");
        try {
            System.out.println(mike.getAverageMark());
        } catch (NoSubjectsInStudentException | NoMarksInStudentException | NoGroupsInFacultyException | NoStudentsInGroupException | NoFacultiesInUniversityException e) {
            e.printStackTrace();
        }

        System.out.print("Average mark of students of the one group of Financial faculty by subject ACCOUNTING: ");
        try {
            System.out.println(groupFef.getAverageMark(Subject.ACCOUNTING));
        } catch (NoStudentsInGroupException | NoSubjectsInStudentException | NoFacultiesInUniversityException | NoMarksInStudentException | InvalidSubjectException | NoGroupsInFacultyException e) {
            e.printStackTrace();
        }

        System.out.print("Average mark of students of the Financial faculty: ");
        try {
            System.out.println(fef.getAverageMark());
        } catch (NoGroupsInFacultyException | NoStudentsInGroupException | NoSubjectsInStudentException | NoFacultiesInUniversityException | NoMarksInStudentException e) {
            e.printStackTrace();
        }

        System.out.print("Average mark of students of the whole university by subject APPLIED_IMMERSIVE_GAME_DESIGN: ");
        try {
            System.out.println(university.getAverageMark(Subject.APPLIED_IMMERSIVE_GAME_DESIGN));
        } catch (NoFacultiesInUniversityException | NoGroupsInFacultyException | NoStudentsInGroupException | NoSubjectsInStudentException | NoMarksInStudentException | InvalidSubjectException e) {
            e.printStackTrace();
        }

        Student nobody = new Student("test", "test");
        groupFit.includeStudent(nobody); //студент без предметов

        System.out.println("Demo of case of student without marks and subjects: ");
        try {
            System.out.println(university.getAverageMark(Subject.APPLIED_IMMERSIVE_GAME_DESIGN));
        } catch (NoFacultiesInUniversityException | NoGroupsInFacultyException | NoStudentsInGroupException | NoSubjectsInStudentException | NoMarksInStudentException | InvalidSubjectException e) {
            e.printStackTrace();
        }

        groupFit.excludeStudent(nobody);
        Group groupVv = new Group("20-ВВ");
        fef.addGroup(groupVv); //группа без студентов

        System.out.println("Demo of case of group without students: ");
        try {
            System.out.println(university.getAverageMark(Subject.APPLIED_IMMERSIVE_GAME_DESIGN));
        } catch (NoFacultiesInUniversityException | NoGroupsInFacultyException | NoStudentsInGroupException | NoSubjectsInStudentException | NoMarksInStudentException | InvalidSubjectException e) {
            e.printStackTrace();
        }

        University uni = new University(); // университет без факультетов

        System.out.println("Demo of case of university without faculties: ");
        try {
            System.out.println(uni.getAverageMark(Subject.APPLIED_IMMERSIVE_GAME_DESIGN));
        } catch (NoFacultiesInUniversityException | NoGroupsInFacultyException | NoStudentsInGroupException | NoSubjectsInStudentException | NoMarksInStudentException | InvalidSubjectException e) {
            e.printStackTrace();
        }

        Set<Faculty> faculties2 = new HashSet<>();
        faculties2.add(new LawFaculty());
        University uni2 = new University(faculties2); //университет с факультетом без групп

        System.out.println("Demo of case of university with faculty without groups: ");
        try {
            System.out.println(uni2.getAverageMark(Subject.APPLIED_IMMERSIVE_GAME_DESIGN));
        } catch (NoFacultiesInUniversityException | NoGroupsInFacultyException | NoStudentsInGroupException | NoSubjectsInStudentException | NoMarksInStudentException | InvalidSubjectException e) {
            e.printStackTrace();
        }


    }
}
