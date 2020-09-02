package by.shirokaya.tasks.javaexceptions.entity;

import by.shirokaya.tasks.javaexceptions.customexception.*;
import by.shirokaya.tasks.javaexceptions.entity.faculty.Faculty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class University implements Calculable {

    private Set<Faculty> faculties;

    public University(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public University() {
        this.faculties = new HashSet<>();
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public List<Student> getStudentsForCalculation() throws NoGroupsInFacultyException, NoStudentsInGroupException, NoFacultiesInUniversityException, NoSubjectsInStudentException {
        List<Student> list = new ArrayList<>();
        if (hasAnyFaculties()) {
            for (Faculty faculty : faculties) {
                if (faculty.hasAnyGroups()) {
                    for (Group group : faculty.getGroups())
                        if (group.hasAnyStudents()) {
                            group.aggregateStudentsByGroup(list);
                        }
                }
            }
        }
        return list;
    }

    @Override
    public List<Student> getStudentsForCalculation(Subject subject) throws NoGroupsInFacultyException, NoStudentsInGroupException, NoFacultiesInUniversityException, NoSubjectsInStudentException {
        List<Student> list = new ArrayList<>();
        if (hasAnyFaculties()) {
            for (Faculty faculty : faculties) {
                if (faculty.hasAnyGroups()) {
                    for (Group group : faculty.getGroups())
                        if (group.hasAnyStudents()) {
                            group.aggregateStudentsByGroup(subject, list);
                        }
                }
            }
        }
        return list;
    }

    public boolean hasAnyFaculties() throws NoFacultiesInUniversityException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesInUniversityException("CALCULATION ERROR : University has no faculties");
        }
        return true;
    }


}
