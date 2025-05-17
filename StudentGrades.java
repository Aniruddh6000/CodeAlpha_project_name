import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculatorGUI extends JFrame {
    private JTextField[] subjectFields = new JTextField[5];

    public GradeCalculatorGUI() {
        setTitle("Grade Calculator");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        JLabel titleLabel = new JLabel("Enter Marks for 5 Subjects", SwingConstants.CENTER);
        add(titleLabel);

        for (int i = 0; i < 5; i++) {
            subjectFields[i] = new JTextField();
            subjectFields[i].setHorizontalAlignment(JTextField.CENTER);
            subjectFields[i].setToolTipText("Subject " + (i + 1));
            add(subjectFields[i]);
        }

        JButton calcBtn = new JButton("Calculate Grade");
        JButton clearBtn = new JButton("Clear");
        JButton exitBtn = new JButton("Exit");

        add(calcBtn);
        add(clearBtn);
        add(exitBtn);

        calcBtn.addActionListener(e -> calculateGrade());
        clearBtn.addActionListener(e -> clearFields());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void calculateGrade() {
        try {
            int total = 0;
            for (JTextField field : subjectFields) {
                int mark = Integer.parseInt(field.getText().trim());
                if (mark < 0 || mark > 100) {
                    showMessage("Marks must be between 0 and 100.");
                    return;
                }
                total += mark;
            }

            int average = total / subjectFields.length;
            String grade;

            if (average >= 90) grade = "A";
            else if (average >= 75) grade = "B";
            else if (average >= 60) grade = "C";
            else if (average >= 40) grade = "D";
            else grade = "F";

            showMessage("Average: " + average + "\nGrade: " + grade);

        } catch (NumberFormatException e) {
            showMessage("Please enter valid numeric marks in all fields.");
        }
    }

    private void clearFields() {
        for (JTextField field : subjectFields) {
            field.setText("");
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        new GradeCalculatorGUI();
    }
}
