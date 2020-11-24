package model.car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String color;

    @Temporal(TemporalType.DATE)
    private Date created;

    private int price;
    private int yearRelease;
    private int mileage;
    private String body;
    private String transmission;
    private String gear;
    private String pathImage;
    private String description;

    @OneToOne
    private Engine engine;

    @ManyToOne
    private User user;

    public Car(String model, String color, int price, int yearRelease, int mileage,
               String body, String transmission, String gear, String description, Engine engine, User user) {
        this.model = model;
        this.color = color;
        this.created = new Date();
        this.price = price;
        this.yearRelease = yearRelease;
        this.mileage = mileage;
        this.body = body;
        this.transmission = transmission;
        this.gear = gear;
        this.description = description;
        this.engine = engine;
        this.user = user;
    }

    public Car() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void addPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                price == car.price &&
                yearRelease == car.yearRelease &&
                mileage == car.mileage &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(created, car.created) &&
                Objects.equals(body, car.body) &&
                Objects.equals(transmission, car.transmission) &&
                Objects.equals(gear, car.gear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, color, created, price, yearRelease, mileage, body, transmission, gear);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", created=" + created +
                ", price=" + price +
                ", yearRelease=" + yearRelease +
                ", mileage=" + mileage +
                ", body='" + body + '\'' +
                ", transmission='" + transmission + '\'' +
                ", gear='" + gear + '\'' +
                ", pathImage='" + pathImage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
