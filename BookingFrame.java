
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class BookingFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel seatPanel;
    private User user;

    public BookingFrame(User user) {
        this.user = user;

        setTitle("ShaTheatre - Book a Seat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Welcome Label at the top
        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername() + "! Book your seat:");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(welcomeLabel, BorderLayout.NORTH);

        // Seat panel in the center
        seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(4, 5, 10, 10)); // 4 rows, 5 columns
        contentPane.add(seatPanel, BorderLayout.CENTER);

        // Right column panel
        JPanel rightColumnPanel = new JPanel();
        rightColumnPanel.setLayout(new GridLayout(2, 1, 5, 5)); // 2 rows, 1 column with gaps
        contentPane.add(rightColumnPanel, BorderLayout.EAST);

        // Left column panel
        JPanel leftColumnPanel = new JPanel();
        leftColumnPanel.setLayout(new GridLayout(3, 1, 5, 5)); // 3 rows, 1 column with gaps
        contentPane.add(leftColumnPanel, BorderLayout.WEST);

        // Add buttons to seat panel
        Map<Integer, Seat> seats = User.getSeats();
        for (Map.Entry<Integer, Seat> entry : seats.entrySet()) {
            Seat seat = entry.getValue();
            JButton seatButton = new JButton("Seat " + seat.getSeatNo() + " (" + seat.getPrice() + " Rs)");
            seatButton.setPreferredSize(new Dimension(60, 60)); // Adjust button size
            seatButton.setBackground(seat.isAvailable() ? Color.GREEN : Color.RED);

            seatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (seat.isAvailable()) {
                        user.bookSeat(seat.getSeatNo());
                        seatButton.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(contentPane, "Seat " + seat.getSeatNo() + " booked successfully!");
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Seat " + seat.getSeatNo() + " is already booked!");
                    }
                }
            });

            seatPanel.add(seatButton);
        }

        // Add "View My Bookings" button
        JButton viewBookingsButton = new JButton("View My Bookings");
        viewBookingsButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        viewBookingsButton.setPreferredSize(new Dimension(150, 50));
        viewBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder bookings = new StringBuilder("Your booked seats:\n");
                for (Seat seat : user.getBookedSeats()) {
                    bookings.append("Seat ").append(seat.getSeatNo()).append(" (").append(seat.getPrice()).append(" Rs)\n");
                }
                JOptionPane.showMessageDialog(contentPane, bookings.toString());
            }
        });
        rightColumnPanel.add(viewBookingsButton);

        // Add "Logout" button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        logoutButton.setPreferredSize(new Dimension(150, 50));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DemoFrame demoFrame = new DemoFrame();
                demoFrame.setVisible(true);
                dispose();
            }
        });
        rightColumnPanel.add(logoutButton);

        // Add labels to left column panel
        for (int i = 0; i < 3; i++) {
            JLabel leftLabel = new JLabel("Left " + (i + 1));
            leftLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
            leftColumnPanel.add(leftLabel);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User user = new User();
                    user.setUsername("Guest");
                    BookingFrame frame = new BookingFrame(user);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
