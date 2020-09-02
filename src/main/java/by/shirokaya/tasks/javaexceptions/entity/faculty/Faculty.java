package by.shirokaya.tasks.javaexceptions.entity.faculty;


import by.shirokaya.tasks.javaexceptions.customexception.*;
import by.shirokaya.tasks.javaexceptions.entity.Calculable;
import by.shirokaya.tasks.javaexceptions.entity.Group;
import by.shirokaya.tasks.javaexceptions.entity.Student;
import by.shirokaya.tasks.javaexceptions.entity.Subject;

import java.util.*;

public abstract class Faculty implements Calculable {
    FacultyName name;
    Set<Group> groups;

    public Faculty() {
        this.groups = new HashSet<>();
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
    }

    public FacultyName getName() {
        return name;
    }

    public void setName(FacultyName name) {
        this.name = name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public List<Student> getStudentsForCalculation() throws NoGroupsInFacultyException, NoStudentsInGroupException, NoSubjectsInStudentException {
        List<Student> list = new ArrayList<>();
        if (hasAnyGroups()) {
            for (Group group : groups)
                if (group.hasAnyStudents()) {
                    group.aggregateStudentsByGroup(list);
                }
        }
        return list;
    }

    @Override
    public List<Student> getStudentsForCalculation(Subject subject) throws NoGroupsInFacultyException, NoStudentsInGroupException, NoSubjectsInStudentException {
        List<Student> list = new ArrayList<>();
        if (hasAnyGroups()) {
            for (Group group : groups)
                if (group.hasAnyStudents()) {
                    group.aggregateStudentsByGroup(subject, list);
                }
        }
        return list;
    }

    public boolean hasAnyGroups() throws NoGroupsInFacultyException {
        if (groups.isEmpty()) {
            throw new NoGroupsInFacultyException("CALCULATION ERROR : Faculty " + this.name + " has no groups.");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name == faculty.name &&
                Objects.equals(groups, faculty.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + name +
                ", groups=" + groups +
                '}';
    }
}
