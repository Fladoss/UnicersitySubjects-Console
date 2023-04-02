package com.vlados.unisubjects;

import java.util.HashMap;
import java.util.Map;

public class Subjects {

    private static Map<String, String> allSubjects = new HashMap<>();

    public static void addSubject(String subjectName) {
        allSubjects.put(subjectName, subjectName);
    }

    public static Map<String, String> getAllSubjects() {
        return allSubjects;
    }

    public static void setAllSubjects(Map<String, String> allSubjects) {
        Subjects.allSubjects = allSubjects;
    }
}
