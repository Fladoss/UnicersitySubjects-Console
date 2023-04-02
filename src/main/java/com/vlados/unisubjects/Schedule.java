package com.vlados.unisubjects;

import java.util.*;

public class Schedule {
    private static List<String> monday = new ArrayList<>();

    private static List<String> tuesday = new ArrayList<>();

    private static List<String> wednesday = new ArrayList<>();

    private static List<String> thursday = new ArrayList<>();

    private static List<String> friday = new ArrayList<>();

    private static List<String> saturday = new ArrayList<>();

    private static Map<String, List<String>> schedule = new LinkedHashMap<>();

    public static Map<String, List<String>> getSchedule() {
        return schedule;
    }

    public static void addToSchedule(String day, List<String> schedule) {
        Schedule.schedule.put(day, schedule);
    }

    public static int deleteFromSchedule(String day, String subject) {
        if (monday.contains(subject)) {
            monday.remove(subject);
            return 1;
        }

        else {
            return -1;
        }
    }

    /**
     * Clears the schedule and all day schedules: monday, tuesday and on.
     */
    public static void clear() {
        schedule.clear();
        monday.clear();
        tuesday.clear();
        wednesday.clear();
        thursday.clear();
        friday.clear();
        saturday.clear();
    }

    public static List<String> getMonday() {
        return monday;
    }

    public static void addToMonday(String subject) {
        monday.add(subject);
    }

    public static List<String> getTuesday() {
        return tuesday;
    }

    public static void addToTuesday(String subject) {
        tuesday.add(subject);
    }

    public static List<String> getWednesday() {
        return wednesday;
    }

    public static void addToWednesday(String subject) {
        wednesday.add(subject);
    }

    public static List<String> getThursday() {
        return thursday;
    }

    public static void addToThursday(String subject) {
        thursday.add(subject);
    }

    public static List<String> getFriday() {
        return friday;
    }

    public static void addToFriday(String subject) {
        friday.add(subject);
    }

    public static List<String> getSaturday() {
        return saturday;
    }

    public static void addToSaturday(String subject) {
        saturday.add(subject);
    }
}
