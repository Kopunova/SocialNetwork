package ua.com.kopunova;

import ua.com.kopunova.impl.NewsCommentServiceImpl;
import ua.com.kopunova.impl.NewsServiceImpl;
import ua.com.kopunova.impl.UserNewsServiceImpl;
import ua.com.kopunova.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //getServletContext().getRequestDispatcher("/Main.jsp").forward(req, resp);

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<H1>Social Network</H1>");

        UserService userService = new UserServiceImpl();
        pw.println("<H1>User with id 1</H1>");
        try {
            User user = userService.getUserById(1);
            pw.println(user.toString());
        } catch (DBException e) {
            pw.println(e.getMessage());
        }
        /*try {
            User user = new User();
            user.setName("Test");
            user.setEmail("");
            user.setPassword("");
            user.setMediaFile("");

            userService.insertUser(user);
        } catch (DBException e) {
            pw.println(e.getMessage());
        }*/

        pw.println("<H1>All users</H1>");
        try {
            List<User> uList = userService.getAllUsers();
            for (User el: uList) {
                pw.println(el.toString());
                pw.println("<br>");
            }
        } catch (DBException e) {
            pw.println(e.getMessage());
        }

        pw.println("<H1>Friends of user with id 1</H1>");
        try {
            List<User> uList = userService.getUserFriends(1);
            for (User el: uList) {
                pw.println(el.toString());
                pw.println("<br>");
            }
        } catch (DBException e) {
            pw.println(e.getMessage());
        }

        pw.println("<H1>All news of user with id 1</H1>");
        UserNewsService userNewsService = new UserNewsServiceImpl();
        /*try {
            News news = new News();
            news.setUserId(1);
            news.setContent("test");
            news.setMediaFile("MediaFile4");

            UserNews userNews = new UserNews();
            userNews.setUserId(1);
            userNews.setLikes(24);
            userNews.setNews(news);

            userNewsService.insertUserNews(userNews);
        } catch (DBException e) {
            pw.println(e.getMessage());
        }*/
        /*try {
            UserNews userNews = new UserNews();
            userNews.setId(15);
            userNewsService.deleteUserNews(userNews);
        } catch (DBException e) {
            pw.println(e.getMessage());
        }*/

        NewsService newsService = new NewsServiceImpl();
        List<UserNews> userNewsList = null;
        try {
            userNewsList = userNewsService.getAllUserNews(1);
        } catch (DBException e) {
            pw.println(e.getMessage());
        }

        for (UserNews el: userNewsList) {
            pw.println(el.toString());
            pw.println("<br>");
            News news = null;
            try {
                news = newsService.getNewsById(el.getNewsId());
            } catch (DBException e) {
                pw.println(e.getMessage());
            }
            pw.println("news:   " + news.toString());
            pw.println("<br>");
            User u = null;
            try {
                u = userService.getUserById(news.getUserId());
            } catch (DBException e) {
                pw.println(e.getMessage());
            }
            pw.println("user:   " + u.toString());
            pw.println("<br>");

            pw.println("News comments");
            pw.println("<br>");
            NewsCommentService newsCommentService = new NewsCommentServiceImpl();
            List<NewsComment> cList = null;
            try {
                cList = newsCommentService.getAllNewsComments(el.getId());
            } catch (DBException e) {
                pw.println(e.getMessage());
            }
            for (NewsComment e: cList) {
                pw.println(e.toString());
                pw.println("<br>");
            }
            pw.println("<br>");
        }
    }
}





















