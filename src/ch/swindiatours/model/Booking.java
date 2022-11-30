package ch.swindiatours.model;

public class Booking extends Tour {
    private int bookingId;
    private int uid;
    private int qunatity;
    private String date;

    public Booking() {
    }

    public Booking(int bookingId, int uid, int qunatity, String date) {
        super();
        this.bookingId = bookingId;
        this.uid = uid;
        this.qunatity = qunatity;
        this.date = date;
    }

    public Booking(int uid, int qunatity, String date) {
        super();
        this.uid = uid;
        this.qunatity = qunatity;
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int orderId) {
        this.bookingId = bookingId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
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
