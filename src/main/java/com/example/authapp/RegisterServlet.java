package com.example.authapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.authapp.util.DatabaseUtil;
import com.example.authapp.util.GenerateCardNumber;

public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        int a = Integer.parseInt(age);
        if(a < 18){
            response.sendRedirect("register.jsp?error=1");
        }

        if (registerUser(username, password, email)) {
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }


    private boolean registerUser(String username, String password, String email) {
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT INTO users(username, password, email, balance, card) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, "0");
            String card = GenerateCardNumber.generateRandomNumber(20);
            preparedStatement.setString(5, card);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
