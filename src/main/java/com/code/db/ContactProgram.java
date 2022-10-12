package com.code.db;

import java.sql.*;


public class ContactProgram {
    public static void main(String[] args){
        String jdbcURL="jdbc:postgresql://localhost:5432/ProbaDB";
        String username = "postgres";
        String password = "admin";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PosgreSQL server");

            //Запросы
            String sql = "INSERT INTO \"Students\" (\"First_name\", \"Second_name\") VALUES (?, ?)";
            String DELETE = "DELETE FROM \"Students\" WHERE \"id\"=?";

            // Функция удаления
            PreparedStatement statementDel = connection.prepareStatement(DELETE);
            statementDel.setInt(1, 3);
            statementDel.executeUpdate();

            int rowsDel = statementDel.executeUpdate();
            if (rowsDel>0){
                System.out.println("Удалено " + rowsDel + " записей");
            }
            //Функция добавления
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Иван");
            statement.setString(2,"Иванов");

            int rows = statement.executeUpdate();
            if (rows>0) {
                System.out.println("Было изменено " + rows + " записей.");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in connection to PostgreSQL server");
            e.printStackTrace();

        }


    }

}
