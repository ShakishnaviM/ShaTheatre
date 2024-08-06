
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField userNameField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DemoFrame frame = new DemoFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DemoFrame() {
        setTitle("ShaTheatre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 725, 386);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        userNameField = new JTextField();
        userNameField.setBounds(341, 92, 124, 25);
        contentPane.add(userNameField);
        userNameField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Enter username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(150, 94, 124, 19);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter password");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(150, 150, 113, 19);
        contentPane.add(lblNewLabel_1);

        JLabel lblWelcomeToShatheatre = new JLabel("WELCOME TO ShaTheatre");
        lblWelcomeToShatheatre.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblWelcomeToShatheatre.setBounds(228, 33, 202, 25);
        contentPane.add(lblWelcomeToShatheatre);

        passwordField = new JPasswordField();
        passwordField.setBounds(341, 151, 124, 25);
        contentPane.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        loginButton.setBounds(228, 241, 113, 29);
        contentPane.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        registerButton.setBounds(378, 241, 113, 29);
        contentPane.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userNameField.getText();
                String password = new String(passwordField.getPassword());
                User user = User.login(username, password);
                if (user != null) {
                    MainFrame mainFrame = new MainFrame(user);
                    mainFrame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userNameField.getText();
                String password = new String(passwordField.getPassword());
                boolean registered = User.register(username, password);
                if (registered) {
                    JOptionPane.showMessageDialog(contentPane, "User registered successfully!");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Username already exists!");
                }
            }
        });
    }
}
