package controller.servlets;

import com.google.gson.Gson;
import service.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class GetCarsByUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("login", req.getSession().getAttribute("login"));
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true, StandardCharsets.UTF_8);
        String login = (String) req.getSession().getAttribute("login");
        pw.write(new Gson().toJson(PsqlStore.instanceOf().findCarsByUser(login)));
        pw.flush();
        pw.close();
    }
}
