package model.car;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "engines")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int power;
    private float capacity;
    private String type;

    public Engine() {
    }

    public Engine(int power, float capacity, String type) {
        this.power = power;
        this.capacity = capacity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return id == engine.id &&
                power == engine.power &&
                capacity == engine.capacity &&
                Objects.equals(type, engine.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, power, capacity, type);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", power=" + power +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}
