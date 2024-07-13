package com.itacademy.courses;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException {

        InsertApp application = new InsertApp();
        application.start();

        UpdateApp app = new UpdateApp();
        app.start();

        SelectApp selectApp = new SelectApp();
        selectApp.start();
    }
}
