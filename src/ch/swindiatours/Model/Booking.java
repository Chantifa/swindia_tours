package ch.swindiatours.Model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "Bookings")
@NamedQueries({
        @NamedQuery(name = "booking.getAll", query = "SELECT booking FROM Booking booking"),
        @NamedQuery(name = "booking.findByUserId", query = "SELECT booking FROM Booking booking WHERE booking.uid = :userId"),
        @NamedQuery(name = "booking.findByBookingId", query = "SELECT booking FROM Booking booking WHERE booking.bookingId = :bookingId"),
        @NamedQuery(name = "booking.getQuantityByBookingId", query = "SELECT booking FROM Booking booking WHERE booking.bookingId = :bookingId"),
        @NamedQuery(name = "booking.getBookingDate", query = "SELECT booking FROM Booking booking WHERE booking.bookingId = (:booking) AND booking.date= :date"),
        @NamedQuery(name = "booking.findOpenBooking", query = "SELECT booking FROM Booking booking where booking.uid=(:userId) AND booking.bookingId= :bookingId")
})

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
    private int uid;

    @Column(name="b_qantity")
    @Basic
    private int qunatity;

    @Column(name="b_date")
    @Basic
    private String date;


    public Booking() {
        super();
    }

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUid(){
        return Integer.parseInt(String.valueOf(uid));
    }
    public void setUid(int uid) {
        this.uid = Integer.parseInt(String.valueOf(uid));
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

