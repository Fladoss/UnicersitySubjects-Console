package com.vlados.unisubjects.commands;

import com.vlados.unisubjects.Schedule;
import com.vlados.unisubjects.Student;
import com.vlados.unisubjects.StudentUtil;
import com.vlados.unisubjects.Subjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandsHandler {
    private static Student student = StudentUtil.getStudent();

    private static String userCommand;

    private static int crScheduleCount = 0;

    public static void execute() throws IOException {

        while (true) {
            BufferedReader readerCommand = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("> ");
            userCommand = readerCommand.readLine();

            // -help
            if (userCommand.equals(Commands.HELP.name)) {
                System.out.println("[=== All commands ===]");
                System.out.println("[-help : prints all commands]");
                System.out.println("[-st info : prints student's information]");
                System.out.println("[-ch name : allows you yo change your name]");
                System.out.println("[-ch age : allows you yo change your age]");
                System.out.println("[-ch course : allows you yo change your course]");
                System.out.println("[-subjects : prints all the subjects out here]");
                System.out.println("[-add subject ... : adds the subject; example: '-add subject English']");
                System.out.println("[-del subject ... : deletes the subject; example: '-del subject English']");
                System.out.println("[=== Type '-help 2' to see the page 2 of the commands list ===]");
            }

            // -help 2
            else if (userCommand.equals(Commands.HELP2.name)) {
                System.out.println("[=== All commands, page 2 ===]");
                System.out.println("[-cr schedule : allows you to create a schedule]");
                System.out.println("[-full schedule : allows you to see the full schedule]");
                System.out.println("[-schedule ... : allows you to see the schedule on a particular day. Example: '-schedule monday']");
                System.out.println("[-del schedule : deletes the schedule]");
            }

            // -st info
            else if (userCommand.equals(Commands.STUDENT_INFO.name)) {
                System.out.println(student.toString());
            }

            // -ch name
            else if (userCommand.equals(Commands.CHANGE_NAME.name)) {
                StudentUtil.setName();

                // student.setName();
                // student.setName("sample_text");
                // make 2 methods in Student class
            }

            // -ch age
            else if (userCommand.equals(Commands.CHANGE_AGE.name)) {
                StudentUtil.setAge();
            }

            // -ch course
            else if (userCommand.equals(Commands.CHANGE_COURSE.name)) {
                StudentUtil.setCourse();
            }

            // -subjects
            else if (userCommand.equals(Commands.SUBJECTS.name)) {
                for (String subject : Subjects.getAllSubjects().values()) {
                    System.out.println(subject);
                }
            }

            // -add subject
            else if (userCommand.startsWith(Commands.ADD_SUBJECT.name)) {

                    if (userCommand.equals(Commands.ADD_SUBJECT.name)) {
                        System.out.println("[!] Value after command is required! For example: '-add subject English'.");
                    }

                    else {
                        String[] args = userCommand.split("-add subject ");
                        Subjects.addSubject(args[1]);
                        System.out.println("Subject " + args[1] + " has been added to all Subjects!");
                    }

            }

            // -del subject
            else if (userCommand.equals(Commands.DELETE_SUBJECT.name)) {
                System.out.println("Deleting Subject");
            }

            // -cr schedule
            else if (userCommand.equals(Commands.CREATE_SCHEDULE.name)) {
                System.out.println("Type '-done' when you are done.");

                createScheduleLoop("Monday", readerCommand);
                createScheduleLoop("Tuesday", readerCommand);
                createScheduleLoop("Wednesday", readerCommand);
                createScheduleLoop("Thursday", readerCommand);
                createScheduleLoop("Friday", readerCommand);
                createScheduleLoop("Saturday", readerCommand);

                System.out.println("Your schedule is done! Type '" + Commands.FULL_SCHEDULE.name + "' to see it!");
            }

            // -full schedule
            else if (userCommand.equals(Commands.FULL_SCHEDULE.name)) {
                for (String day : Schedule.getSchedule().keySet()) {
                    List<String> subjects = Schedule.getSchedule().get(day);

                    if (subjects.size() > 0) {
                        System.out.println(day + ", subjects: " + subjects + ".");
                    }

                    else {
                        System.out.println(day + ", no subjects. Yahoo!");
                    }
                }
            }

            // -schedule ...
            else if (userCommand.startsWith(Commands.SCHEDULE_DAY.name)) {
                printScheduleDay();
            }

            // -ch schedule
            else if (userCommand.startsWith(Commands.CHANGE_SCHEDULE.name)) {
                String[] args = userCommand.split("-ch schedule ");

                try {
                    changeSchedule(args[1].toUpperCase());
                } catch (Exception e) {
                    System.out.println("[!] Value after command is required! For example: '-ch schedule monday'.");
                }
            }

            // check if command starts with '-'
            else if (userCommand.startsWith("-")) {
                System.out.println("[!] Unknown command: '" + userCommand.replace("-", "") + "'! Try again.");
            }

            // command must start with '-', warning
            else {
                System.out.println("[!] Command must start with '-'!");
            }

        }
    }

    /**
     * Internal method to create a schedule from scratch. Before each call, the schedule will be cleared.
     * @param day the day to be scheduled. It is good to call this method 6 times: monday, tuesday...
     * @param readerSchedule the BufferedReader needed for method to work with IO.
     * @throws IOException as it uses System.in.
     */
    private static void createScheduleLoop(String day, BufferedReader readerSchedule) throws IOException {

        if (crScheduleCount == 6) {
            System.out.println("Also, you have already created the schedule so it will be cleared.");

            Schedule.clear();

            crScheduleCount = 0;
        }

        String userScheduleEnter;

        ArrayList<String> currentDaySubjectsArray = new ArrayList<>();

        boolean isDone = false;
        boolean isCancelled = false;

        System.out.println("Add subjects to " + day + ".");
        while (!isDone) {
            System.out.print("> ");

            userScheduleEnter = readerSchedule.readLine();

            if (userScheduleEnter.equals("-done")) {
                isDone = true;
            }

            else if (userScheduleEnter.matches("[a-zA-Z0-9 ]+")) {
                currentDaySubjectsArray.add(userScheduleEnter);
                System.out.println("Added!");
                System.out.println(currentDaySubjectsArray);
            }

            else {
                System.out.println("[!] Only latin characters, spaces and digits are allowed! Try again.");
            }

            if (userScheduleEnter.equals("-cancel")) {
                isCancelled = true;
                currentDaySubjectsArray.clear();
                Schedule.clear();
                break;
            }

        }

        if (!isCancelled) {
            if (day.equalsIgnoreCase("Monday")) {
                for (String subject : currentDaySubjectsArray) {
                    Schedule.addToMonday(subject);
                }

                Schedule.addToSchedule(day.toUpperCase(), Schedule.getMonday());
            }

            else if (day.equalsIgnoreCase("Tuesday")) {
                for (String subject : currentDaySubjectsArray) {
                    Schedule.addToTuesday(subject);
                }

                Schedule.addToSchedule(day.toUpperCase(), Schedule.getTuesday());
            }

            else if (day.equalsIgnoreCase("Wednesday")) {
                for (String subject : currentDaySubjectsArray) {
                    Schedule.addToWednesday(subject);
                }

                Schedule.addToSchedule(day.toUpperCase(), Schedule.getWednesday());
            }

            else if (day.equalsIgnoreCase("Thursday")) {
                for (String subject : currentDaySubjectsArray) {
                    Schedule.addToThursday(subject);
                }

                Schedule.addToSchedule(day.toUpperCase(), Schedule.getThursday());
            }

            else if (day.equalsIgnoreCase("Friday")) {
                for (String subject : currentDaySubjectsArray) {
                    Schedule.addToFriday(subject);
                }

                Schedule.addToSchedule(day.toUpperCase(), Schedule.getFriday());
            }

            else if (day.equalsIgnoreCase("Saturday")) {
                for (String subject : currentDaySubjectsArray) {
                    Schedule.addToSaturday(subject);
                }

                Schedule.addToSchedule(day.toUpperCase(), Schedule.getSaturday());
            }

            crScheduleCount++;
        }
    }

    private static void changeSchedule(String day) {
        printScheduleDay(day);

    }

    private static void printScheduleDay() {
        if (userCommand.equals(Commands.SCHEDULE_DAY.name)) {
            System.out.println("[!] Value after command is required! For example: '-schedule monday'.");
        }

        else {
            String[] command = userCommand.split("-schedule ");
            String day = command[1].toUpperCase();

            try {

                List<String> subjects = Schedule.getSchedule().get(day);

                if (subjects.size() > 0) {
                    System.out.println(day + ", subjects: " + subjects + ".");
                }

                else {
                    System.out.println(day + ", no subjects. Yahoo!");
                }

            } catch (Exception e) {
                System.out.println("[!] Check your input!");
            }

        }
    }

    private static void printScheduleDay(String day) {

        List<String> subjects;

        if (Schedule.getSchedule().containsKey(day.toUpperCase())) {

            subjects = Schedule.getSchedule().get(day);

            if (subjects == null) {
                System.out.println("[!] There was no schedule for that day, and probably not for the other days either! Use '-cr schedule' first.");
            }

            else {
                System.out.println("Your current schedule on " + day + " is: ");

                if (subjects.size() > 0) {
                    System.out.println(day + ", subjects: " + subjects + ".");
                } else {
                    System.out.println(day + ", no subjects. Yahoo!");
                }

                System.out.println("To change the schedule on this day, we have to clear it.");
                System.out.println("Are you sure you want to clear the schedule and add other subjects? 'y' or 'n'");

            }

        }

        else {
            System.out.println("[!] Unknown day or there is no schedule at all. Check your input or create a new schedule with '-cr schedule'!");
        }

    }
}
