package ua.com.kopunova.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.model.User;
import ua.com.kopunova.service.UserService;
import ua.com.kopunova.service.impl.UserServiceImpl;

@WebServlet(name = "MainServlet", urlPatterns={"/"})
public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User registeredUser = null;

        if (req.getParameter("LogIn") != null) {

            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setEmail(req.getParameter("email").trim());

            try {
                registeredUser = userService.checkUser(user);
            } catch (DBException e) {
            }
        }

        getServletContext().getRequestDispatcher("/Main.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}



















