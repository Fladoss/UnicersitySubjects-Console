package com.vlados.unisubjects;

import java.io.*;

public class StudentUtil {
    private static Student student;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Initial set-up of the Student object. Must be called once.
     * We set the 'name', 'age' and 'course'.
     */
    public static void init() throws IOException {
        if (student == null) {
            student = Student.getStudent();
        }

        System.out.println("Welcome!");
        setName();
        System.out.println("Good! Now let's set your age.");
        setAge();
        System.out.println("And now let's set your course!");
        setCourse();
        System.out.println("Wonderful! You are all set up.");
        System.out.println("For now, you will see this thing \">\", it means that you have to enter some command.");
        System.out.println("To see all commands you can use \"-help\". Good luck!");

        Subjects.addSubject("Math");
        Subjects.addSubject("Arts");
        Subjects.addSubject("Physics");
        Subjects.addSubject("Physicals");
    }

    /**
     * Method returns the Student instance. It comes in handy when we want to declare the same Student object in many classes.
     *
     * @return Student instance.
     */
    public static Student getStudent() {
        return student;
    }

    /**
     * Method sets the entered value as 'name' to the Student.
     */
    public static void setName() throws IOException {

        // starting the cycle of setting name, checking the right input
        while (true) {

            System.out.println("Please enter your name: ");
            System.out.print("> ");

            String enteredName = reader.readLine();

            if (enteredName.matches("[a-zA-Z]+")) {
                student.setName(enteredName);

                System.out.println("Name has been successfully set! You are now " + enteredName + "!");
                break;
            } else {
                System.out.println("[!] The name must be only latin characters! Try again");
            }

        }

    }

    public static void setAge() throws IOException {

        while (true) {

            System.out.println("Please enter your age: ");
            System.out.print("> ");

            String enteredAge = reader.readLine();

            if (enteredAge.matches("[0-9]+")) {

                int age = Integer.parseInt(enteredAge);

                if (age >= 16 && age <= 150) {
                    student.setAge(age);
                    System.out.println("Age has been successfully set! You are now " + age + " years old!");

                    break;
                } else {
                    System.out.println("[!] The age must be between 16 and 150! Try again.");
                }

            } else {
                System.out.println("[!] The age must contain only digits! Try again");
            }
        }

    }

    public static void setCourse() throws IOException {

        while (true) {

            System.out.println("Please enter your course (1-5): ");
            System.out.print("> ");

            String enteredCourse = reader.readLine();

            if (enteredCourse.matches("[0-9]+")) {

                int course = Integer.parseInt(enteredCourse);

                if (course >= 1 && course <= 5) {
                    student.setCourse(course);
                    System.out.println("Course has been successfully set! You are at " + course + " course!");

                    break;
                } else {
                    System.out.println("[!] The course must be between 1 and 5! Try again.");
                }

            } else {
                System.out.println("[!] The course must contain only digits! Try again");
            }
        }

    }

}
