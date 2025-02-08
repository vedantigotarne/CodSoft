import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(10, 1, 10, 10));

        // Labels and text fields for 5 subjects
        JLabel[] subjectLabels = new JLabel[5];
        JTextField[] subjectFields = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            subjectLabels[i] = new JLabel("Subject " + (i + 1) + " Marks:");
            subjectFields[i] = new JTextField();
            frame.add(subjectLabels[i]);
            frame.add(subjectFields[i]);
        }

        // Labels to display total, percentage, and grade
        JLabel totalLabel = new JLabel("Total Marks:");
        JLabel totalValue = new JLabel("0");
        JLabel percentageLabel = new JLabel("Percentage:");
        JLabel percentageValue = new JLabel("0%");
        JLabel gradeLabel = new JLabel("Grade:");
        JLabel gradeValue = new JLabel("N/A");

        // Button to calculate
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int total = 0;
                    for (JTextField field : subjectFields) {
                        total += Integer.parseInt(field.getText());
                    }
                    totalValue.setText(String.valueOf(total));

                    double percentage = (total / 500.0) * 100;
                    percentageValue.setText(String.format("%.2f%%", percentage));

                    String grade;
                    if (percentage >= 90) {
                        grade = "A";
                    } else if (percentage >= 80) {
                        grade = "B";
                    } else if (percentage >= 70) {
                        grade = "C";
                    } else if (percentage >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }
                    gradeValue.setText(grade);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for all subjects.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add total, percentage, and grade labels to the frame
        
        frame.add(totalLabel);
        frame.add(totalValue);
        frame.add(percentageLabel);
        frame.add(percentageValue);
        frame.add(gradeLabel);
        frame.add(gradeValue);
        frame.add(new JLabel()); // Empty space
        frame.add(calculateButton);

        // Display the frame
        frame.setVisible(true);
    }
}