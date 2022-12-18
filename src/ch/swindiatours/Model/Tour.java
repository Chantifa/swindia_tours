package ch.swindiatours.Model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;


@Table(name = "Tours")
@NamedQueries({
        @NamedQuery(name = "tour.findAll", query = "SELECT t FROM Tour t"),
        @NamedQuery(name = "tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id"),
        @NamedQuery(name = "tour.findByTitle", query = "SELECT t FROM Tour t WHERE t.name = :name"),
        @NamedQuery(name = "tour.findByDescription", query = "SELECT t FROM Tour t WHERE t.description = :description"),
        @NamedQuery(name = "tour.findByPrice", query = "SELECT t FROM Tour t WHERE t.price = :price")})
@Entity
public class Tour {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "description", nullable = false)
    private String description;

    @Basic
    @Column(name = "price", nullable = false)
    private Double price;
    @Basic
    @Column(name = "image", nullable = false)
    private String image;

    public Tour() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setTourId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String category) {
        this.description = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Tour [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", image="
                + image + "]";
    }
}
