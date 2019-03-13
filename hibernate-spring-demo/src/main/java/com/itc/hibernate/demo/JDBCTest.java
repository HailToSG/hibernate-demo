package com.itc.hibernate.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
