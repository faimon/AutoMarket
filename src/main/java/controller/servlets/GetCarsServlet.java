package controller.servlets;

import com.google.gson.Gson;
import store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class GetCarsServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        PsqlStore.instanceOf();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true, StandardCharsets.UTF_8);
        pw.write(new Gson().toJson(PsqlStore.instanceOf().findAllCars()));
        pw.flush();
        pw.close();
    }
}
