package controller.servlets;

import model.car.Car;
import model.car.Engine;
import model.car.User;
import store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet
@MultipartConfig
public class SaveCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Engine engine = new Engine(Integer.parseInt(req.getParameter("powerengine")),
                Float.parseFloat(req.getParameter("capacityEngine")), req.getParameter("engine"));
        HttpSession httpSession = req.getSession();
        User user = PsqlStore.instanceOf().findUserByName((String) httpSession.getAttribute("login"));
        Car car = new Car(req.getParameter("model"), req.getParameter("color"),
                Integer.parseInt(req.getParameter("price")), Integer.parseInt(req.getParameter("yearRelease")),
                Integer.parseInt(req.getParameter("mileage")), req.getParameter("body"),
                req.getParameter("transmission"), req.getParameter("gear"), req.getParameter("desc"),
                engine, user);
        Part file = req.getPart("file");
        String imagePath = Paths.get(file.getSubmittedFileName()).getFileName().toString();
        car.addPathImage(imagePath);
        UploadPhoto.saveImage(imagePath, file);
        PsqlStore.instanceOf().saveCar(car, engine);
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
