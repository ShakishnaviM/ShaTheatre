
public class RegularSeat implements Seat {
    private int seatNo;
    private boolean available;
    private double price;

    public RegularSeat(int seatNo) {
        this.seatNo = seatNo;
        this.available = true;
        this.price = 450.00;
    }

    @Override
    public int getSeatNo() {
        return seatNo;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
