package ua.com.kopunova;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<H1>Social Network</H1>");

        DaoFactory daoFactory = new PostgreSqlDaoFactory();

        try (Connection con = daoFactory.getConnection()) {
            UserDao userDao = daoFactory.getUserDao(con);

            pw.println("<H1>User with id 1</H1>");
            User u = userDao.getUserById(1);
            pw.println(u.toString());
            pw.println("<br>");

            pw.println("<H1>All users</H1>");
            List<User> uList = userDao.getAllUsers();
            for (User el: uList) {
                pw.println(el.toString());
                pw.println("<br>");
            }

            pw.println("<H1>Friends of user with id 1</H1>");
            uList = userDao.getUserFriends(1);
            for (User el: uList) {
                pw.println(el.toString());
                pw.println("<br>");
            }

            pw.println("<H1>All news of user with id 1</H1>");
            UserNewsDao userNewsDao = daoFactory.getUserNewsDao(con);
            NewsDao newsDao = daoFactory.getNewsDao(con);
            List<UserNews> userNewsList = userNewsDao.getAllUserNews(1);
            for (UserNews el: userNewsList) {
                pw.println(el.toString());
                pw.println("<br>");
                News news = newsDao.getNewsById(el.getNewsId());
                pw.println("news:   " + news.toString());
                pw.println("<br>");
                u = userDao.getUserById(news.getUserId());
                pw.println("user:   " + u.toString());
                pw.println("<br>");

                pw.println("News comments");
                pw.println("<br>");
                NewsCommentDao newsCommentDao = daoFactory.getNewsCommentDao(con);
                List<NewsComment> cList = newsCommentDao.getAllNewsComments(el.getId());
                for (NewsComment e: cList) {
                    pw.println(e.toString());
                    pw.println("<br>");
                }
                pw.println("<br>");
            }
        }
        catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}





















