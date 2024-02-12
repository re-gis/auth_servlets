package com.example.authapp;

import com.example.authapp.util.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("withdraw.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // we have to get the account a decrement the balance
        String accountNumber = req.getParameter("account_number");
        String amountStr = req.getParameter("amount");
        double amount = Double.parseDouble(amountStr);

        double currentBalance = getCurrentBalance(accountNumber);

        double newBalance = currentBalance - amount;

        String ba = Double.toString(newBalance);

        updateBalance(accountNumber, ba);

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>Deposit Successful</h1>");
        out.println("<p>Withdrawn " + amount + " from account number " + accountNumber + "</p>");
        out.println("<p>New balance: " + newBalance + "</p>");
        out.println("</body></html>");
    }

    private double getCurrentBalance(String accountNumber){
        double balance = 0;
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT balance FROM users WHERE card = ?")) {
            preparedStatement.setString(1, accountNumber);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String ba = rs.getString("balance");
                    balance = Double.parseDouble(ba);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

    private void updateBalance(String accountNumber, String newBalance) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement("UPDATE users SET balance = ? WHERE card = ?")) {
            preparedStatement.setString(1, newBalance);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
