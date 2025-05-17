import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingAppGUI extends JFrame {
    private double balance = 0.0;
    private JLabel balanceLabel;

    public BankingAppGUI() {
        setTitle("Simple Banking App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        balanceLabel = new JLabel("Current Balance: ₹0.0", SwingConstants.CENTER);
        add(balanceLabel);

        JButton depositBtn = new JButton("Deposit Money");
        JButton withdrawBtn = new JButton("Withdraw Money");
        JButton checkBtn = new JButton("Check Balance");
        JButton exitBtn = new JButton("Exit");

        add(depositBtn);
        add(withdrawBtn);
        add(checkBtn);
        add(exitBtn);

        depositBtn.addActionListener(e -> depositMoney());
        withdrawBtn.addActionListener(e -> withdrawMoney());
        checkBtn.addActionListener(e -> showMessage("Your Balance is ₹" + balance));
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void depositMoney() {
        String input = JOptionPane.showInputDialog("Enter amount to deposit:");
        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            balance += amount;
            updateBalance();
            showMessage("₹" + amount + " deposited successfully.");
        }
    }

    private void withdrawMoney() {
        String input = JOptionPane.showInputDialog("Enter amount to withdraw:");
        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            if (amount <= balance) {
                balance -= amount;
                updateBalance();
                showMessage("₹" + amount + " withdrawn successfully.");
            } else {
                showMessage("Insufficient balance.");
            }
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Current Balance: ₹" + balance);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        new BankingAppGUI();
    }
}
