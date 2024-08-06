
import java.util.*;

public class Show {
	
	private Movie Mname;
	private Date showDate;
	private ArrayList<Seat> seats;
	
	public Show(Movie movie, Date showdate, ArrayList<Seat> seats) {
		this.Mname = movie;
		this.seats = seats;
		this.showDate = showdate;
	}
	
	public ArrayList<Seat> getAvailableSeats() {
		ArrayList<Seat> availableSeats = new ArrayList<>();
		for(Seat s:seats) {
			if(s.isAvailable()) {
				availableSeats.add(s);
			}
		}
		return availableSeats;
		
	}
	
	public void bookSeat( Seat seat) {
		
	}
	
	
}
