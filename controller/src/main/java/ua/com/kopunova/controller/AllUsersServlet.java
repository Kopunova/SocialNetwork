package ua.com.kopunova.controller;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.model.User;
import ua.com.kopunova.service.UserService;
import ua.com.kopunova.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllUsersServlet", urlPatterns={"/all-users"})
public class AllUsersServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();
        List<User> allUsers = new ArrayList<>();
        try {
            allUsers = userService.getAllUsers();
        } catch (DBException e) {
        }

        req.setAttribute("allUsers", allUsers);

        getServletContext().getRequestDispatcher("/AllUsers.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
