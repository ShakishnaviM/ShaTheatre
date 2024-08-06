
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private User user;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User guestUser = new User();
                    guestUser.setUsername("Guest");
                    MainFrame frame = new MainFrame(guestUser);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame(User user) {
        this.user = user;
        setTitle("ShaTheatre - Main");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 725, 386);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername() + "!");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        welcomeLabel.setBounds(278, 32, 157, 25);
        contentPane.add(welcomeLabel);

        JButton viewBookingsButton = new JButton("View Bookings");
        viewBookingsButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        viewBookingsButton.setBounds(100, 150, 200, 29);
        contentPane.add(viewBookingsButton);

        JButton bookSeatButton = new JButton("Book a Seat");
        bookSeatButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        bookSeatButton.setBounds(400, 150, 200, 29);
        contentPane.add(bookSeatButton);

        // Add action listeners for the buttons to implement respective functionalities
        viewBookingsButton.addActionListener(e -> {
            BookingFrame Bframe = new BookingFrame(user);
            Bframe.setVisible(true);
            dispose(); // Close the main window
        });

        bookSeatButton.addActionListener(e -> {
            BookingFrame Bframe = new BookingFrame(user);
            Bframe.setVisible(true);
            dispose(); // Close the main window
        });
    }
}
