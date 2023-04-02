package com.vlados.unisubjects;

import java.util.HashMap;
import java.util.Map;

public class Subject {
    private String subjectName;

    private Map<String, Subject> subjects = new HashMap<>();

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
