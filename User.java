
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User extends Person {
    private static Map<String, User> userStore = new HashMap<>();
    private static Map<Integer, Seat> seats;
    private List<Seat> bookedSeats;

    static {
        seats = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            seats.put(i, new RegularSeat(i));
        }
        for (int i = 11; i <= 20; i++) {
            seats.put(i, new AcSeat(i));
        }
    }

    public User() {
        bookedSeats = new ArrayList<>();
    }

    public static boolean register(String username, String password) {
        if (userStore.containsKey(username)) {
            return false;
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userStore.put(username, newUser);
        return true;
    }

    public static User login(String username, String password) {
        User user = userStore.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void bookSeat(int seatNo) {
        Seat seat = seats.get(seatNo);
        if (seat != null && seat.isAvailable()) {
            seat.setAvailable(false);
            bookedSeats.add(seat);
        }
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public static Map<Integer, Seat> getSeats() {
        return seats;
    }
}
