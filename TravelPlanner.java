import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TravelPlannerGUI extends JFrame {
    private ArrayList<String> destinations = new ArrayList<>();
    private JTextField destinationField;

    public TravelPlannerGUI() {
        setTitle("Travel Planner");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("Welcome to Travel Planner", SwingConstants.CENTER);
        add(label);

        destinationField = new JTextField();
        destinationField.setHorizontalAlignment(JTextField.CENTER);
        add(destinationField);

        JButton addBtn = new JButton("Add Destination");
        JButton viewBtn = new JButton("View Plan");
        JButton clearBtn = new JButton("Clear Plan");
        JButton exitBtn = new JButton("Exit");

        add(addBtn);
        add(viewBtn);
        add(clearBtn);
        add(exitBtn);

        addBtn.addActionListener(e -> addDestination());
        viewBtn.addActionListener(e -> viewPlan());
        clearBtn.addActionListener(e -> clearPlan());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void addDestination() {
        String destination = destinationField.getText().trim();
        if (!destination.isEmpty()) {
            destinations.add(destination);
            destinationField.setText("");
            showMessage("Added: " + destination);
        } else {
            showMessage("Please enter a destination.");
        }
    }

    private void viewPlan() {
        if (destinations.isEmpty()) {
            showMessage("Your plan is empty.");
        } else {
            StringBuilder plan = new StringBuilder("Your Travel Plan:\n");
            for (int i = 0; i < destinations.size(); i++) {
                plan.append((i + 1)).append(". ").append(destinations.get(i)).append("\n");
            }
            showMessage(plan.toString());
        }
    }

    private void clearPlan() {
        destinations.clear();
        showMessage("Travel plan cleared.");
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public static void main(String[] args) {
        new TravelPlannerGUI();
    }
}
