package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private Integer series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(String model, Integer series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ID = ").append(getId()).append("\n" )
                .append("Model = ").append(getModel()).append("\n" )
                .append("Series = ").append(getSeries());
        return res.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(series, car.series) && Objects.equals(user, car.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, series, user);
    }
}
