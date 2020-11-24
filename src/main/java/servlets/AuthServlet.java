package servlets;

import model.car.User;
import store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession();
        User user = HbmStore.instanceOf().findUser(login, password);
        PrintWriter printWriter = resp.getWriter();
        if (user == null) {
            printWriter.print("invalid");
        } else {
            httpSession.setAttribute("login", login);
            printWriter.print(login);
        }
        printWriter.flush();
        printWriter.close();
    }
}
