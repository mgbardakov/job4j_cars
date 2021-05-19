package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private boolean onPurchase;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @ManyToOne
    @JoinColumn(name = "car_body_id")
    private CarBody carBody;
    @ManyToOne
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    public Advertisement() {
        created = Calendar.getInstance().getTime();
        onPurchase = true;
    }

    public Advertisement(String description, CarBody carBody, CarBrand carBrand, Image image) {
        this();
        this.description = description;
        this.carBody = carBody;
        this.carBrand = carBrand;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnPurchase() {
        return onPurchase;
    }

    public void setOnPurchase(boolean onPurchase) {
        this.onPurchase = onPurchase;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", onPurchase=" + onPurchase +
                ", created=" + created +
                ", carBody=" + carBody +
                ", carBrand=" + carBrand +
                ", image=" + image +
                '}';
    }
}
