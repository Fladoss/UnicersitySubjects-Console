package com.vlados.unisubjects;

import com.vlados.unisubjects.commands.CommandsHandler;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        StudentUtil.init();
        CommandsHandler.execute();
    }
}