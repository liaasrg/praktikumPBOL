import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginRegister {

    private static Map<String, String> userDatabase = new HashMap<>();

    private static Map<String, String> userFullName = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginRegister().showLoginScreen());
    }

    private void showLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeLoginComponents(panel, frame);

        frame.setVisible(true);
    }

    private void placeLoginComponents(JPanel panel, JFrame frame) {
        panel.setLayout(new GridLayout(4, 2));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        panel.add(new JLabel());
        panel.add(registerButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (userDatabase.containsKey(email) && userDatabase.get(email).equals(password)) {
                JOptionPane.showMessageDialog(frame, "selamat datang, " + userFullName.get(email) + "!", "Login berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "email atau password salah", "Login gagal", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> {
            frame.dispose();
            showRegisterScreen();
        });
    }

    private void showRegisterScreen() {
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeRegisterComponents(panel, frame);

        frame.setVisible(true);
    }

    private void placeRegisterComponents(JPanel panel, JFrame frame) {
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Full Name:");
        JTextField nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(registerButton);
        panel.add(new JLabel());
        panel.add(backButton);

        registerButton.addActionListener(e -> {
            String fullName = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Isi terlebih dahulu", "Registrasi gagal", JOptionPane.ERROR_MESSAGE);
            } else if (userDatabase.containsKey(email)) {
                JOptionPane.showMessageDialog(frame, "Email telah terdaftar", "Registrasi gagal", JOptionPane.ERROR_MESSAGE);
            } else {
                userDatabase.put(email, password);
                userFullName.put(email, fullName);
                JOptionPane.showMessageDialog(frame, "Registrasi berhasil! silakan login.", "Registrasi berhasil", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                showLoginScreen();
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showLoginScreen();
        });
    }
}

