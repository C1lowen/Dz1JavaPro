package com.google.test_group.dao;

import com.google.test_group.controller.Ticket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestDAO {

    @Value("${base.jdbcURL}")
    private String jdbcURL;

    @Value("${base.username}")
    private String username;

    @Value("${base.password}")
    private String password;


    public List<Ticket> executeTicketsAll() {
        List<Ticket> ticketsAll = null;
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {

                ticketsAll = new ArrayList<>();

                String sql = "SELECT * FROM tickets";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String src = resultSet.getString("src");
                    String dest = resultSet.getString("dest");
                    boolean isBooked = resultSet.getBoolean("isBooked");
                    ticketsAll.add(new Ticket(id, src, dest, isBooked));
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных PostgreSQL: " + e.getMessage());
        }

        return ticketsAll;
    }

    public void executeNewTickets(Ticket newTicket) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {

                String src = newTicket.getSrc();
                String dest = newTicket.getDest();
                boolean isBooked = newTicket.isIsBooked();

                String sql = "INSERT INTO tickets (src, dest, isBooked) VALUES (?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, src);
                preparedStatement.setString(2, dest);
                preparedStatement.setBoolean(3, isBooked);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Запись успешно добавлена в базу данных.");
                } else {
                    System.out.println("Ошибка при добавлении записи в базу данных.");
                }

                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных PostgreSQL: " + e.getMessage());
        }
    }
}
