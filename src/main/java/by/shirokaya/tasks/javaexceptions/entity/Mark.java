package by.shirokaya.tasks.javaexceptions.entity;

import java.util.Objects;

public class Mark {
    private int value;
    private Subject subject;

    public Mark(int value, Subject subject) {
        this.value = value;
        this.subject = subject;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return value == mark.value &&
                Objects.equals(subject, mark.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, subject);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "value=" + value +
                ", subject=" + subject +
                '}';
    }

}
