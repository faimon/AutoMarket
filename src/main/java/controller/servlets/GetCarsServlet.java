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

public class GetCarsServlet extends HttpServlet {
    private static final String WITH_PHOTO = "withPhoto";
    private static final String ONLY_LAST_DAY = "onlyLastDay";

    @Override
    public void init() throws ServletException {
        PsqlStore.instanceOf();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = new PrintWriter(resp.getOutputStream(), true, StandardCharsets.UTF_8);
        String type = req.getParameter("type");
        if (WITH_PHOTO.equals(type)) {
            pw.write(new Gson().toJson(PsqlStore.instanceOf().findCarsWithPhoto()));
        } else if (ONLY_LAST_DAY.equals(type)) {
            pw.write(new Gson().toJson(PsqlStore.instanceOf().findCarsOnlyLastDay()));
        } else {
            pw.write(new Gson().toJson(PsqlStore.instanceOf().findCarsByModel(type)));
        }
        pw.flush();
        pw.close();
    }
}
