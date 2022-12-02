package ch.swindiatours.Entities;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Booking extends Tour {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "b_id", nullable = false)
    private int bookingId;

    @Column(name = "t_id")
    @ManyToOne
    @JoinColumn(name = "id")
    private Tour tid;

    @Column(name ="u_id")
    @ManyToOne
    @JoinColumn(name = "id")
    private  User uid;

    @Column(name="b_qantity")
    @Basic
    private int qunatity;

    @Column(name="b_date")
    @Basic
    private String date;

    public Booking() {
    }

    public Booking(int bookingId, User uid, int qunatity, String date) {
        super();
        this.bookingId = bookingId;
        this.uid = uid;
        this.qunatity = qunatity;
        this.date = date;
    }

    public Booking(User uid, int qunatity, String date) {
        super();
        this.uid = uid;
        this.qunatity = qunatity;
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUid() {
        return Integer.parseInt(uid.toString());
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public int getQunatity() {
        return qunatity;
    }
    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

}
