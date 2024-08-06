
public class AcSeat implements Seat {
    private int seatNo;
    private boolean available;
    private double price;

    public AcSeat(int seatNo) {
        this.seatNo = seatNo;
        this.available = true;
        this.price = 790.00;
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

    

