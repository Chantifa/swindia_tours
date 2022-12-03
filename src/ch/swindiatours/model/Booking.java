package ch.swindiatours.model;

public class Booking extends Tour {
    private int bookingId;
    private int uid;
    private int quantity;
    private String date;

    public Booking() {
    }

    public Booking(int bookingId, int uid, int quantity, String date) {
        super();
        this.bookingId = bookingId;
        this.uid = uid;
        this.quantity = quantity;
        this.date = date;
    }

    public Booking(int uid, int quantity, String date) {
        super();
        this.uid = uid;
        this.quantity = quantity;
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

}
