package com.vlados.unisubjects.commands;

public enum Commands {

    HELP("-help"),

    STUDENT_INFO("-st info"),

    CHANGE_NAME("-ch name"),

    CHANGE_AGE("-ch age"),

    CHANGE_COURSE("-ch course"),

    ADD_SUBJECT("-add subject"),

    SUBJECTS("-subjects"),

    DELETE_SUBJECT("-del subject"),

    HELP2("-help 2"),

    CREATE_SCHEDULE("-cr schedule"),

    SCHEDULE_DAY("-schedule"),

    FULL_SCHEDULE("-full schedule"),

    CHANGE_SCHEDULE("-ch schedule");

    public final String name;

    Commands(String name) {
        this.name = name;
    }
}
