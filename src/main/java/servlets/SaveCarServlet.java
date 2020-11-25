package servlets;

import model.car.Car;
import model.car.Engine;
import model.car.User;
import store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Engine engine = new Engine(Integer.parseInt(req.getParameter("powerEngine")),
                Float.parseFloat(req.getParameter("capacityEngine")), req.getParameter("engine"));
        User user = HbmStore.instanceOf().findUserByName(req.getParameter("login"));
        Car car = new Car(req.getParameter("model"), req.getParameter("color"),
                Integer.parseInt(req.getParameter("price")), Integer.parseInt(req.getParameter("yearRelease")),
                Integer.parseInt(req.getParameter("mileage")), req.getParameter("body"),
                req.getParameter("transmission"), req.getParameter("gear"), req.getParameter("desc"),
                engine, user);
        HbmStore.instanceOf().saveCar(car, engine);

    }
}
