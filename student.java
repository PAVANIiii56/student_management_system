import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class student extends JFrame {

    private JTextField nameField, ageField, rollField;
    private JButton addButton, deleteButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    public student() {
        // Set the title of the window
        setTitle("Student Management System");

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(5);

        JLabel rollLabel = new JLabel("Roll No:");
        rollField = new JTextField(5);

        addButton = new JButton("Add Student");
        deleteButton = new JButton("Delete Selected Student");

        // Table setup
        tableModel = new DefaultTableModel(new Object[]{"Name", "Age", "Roll No"}, 0);
        studentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(studentTable);

        // Panel setup for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(rollLabel);
        inputPanel.add(rollField);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        // Window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    // Method to add a student to the table
    private void addStudent() {
        String name = nameField.getText();
        String age = ageField.getText();
        String rollNo = rollField.getText();

        if (name.isEmpty() || age.isEmpty() || rollNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Input Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Object[] studentData = {name, age, rollNo};
            tableModel.addRow(studentData);
            clearInputFields();
        }
    }

    // Method to clear the input fields after adding a student
    private void clearInputFields() {
        nameField.setText("");
        ageField.setText("");
        rollField.setText("");
    }

    // Method to delete a selected student from the table
    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete", "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new student();
            }
        });
    }
}

// import java.awt.BorderLayout;
// import java.awt.Button;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.FlowLayout;
// import java.awt.GridLayout;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTable;
// import javax.swing.JTextField;

// class student{
//     public static void main(String[] args) {
//         JTextField namField,agField,roField;
//         JButton addButton,deletebButton;

//         JFrame frame = new JFrame();
//         frame.setSize(800,500);
//         frame.setTitle("Student Management System");
        

//         JLabel name = new JLabel("Name:");
//         JLabel age = new JLabel("Age:");
//         JLabel roll = new JLabel("Roll:");

//         namField =new JTextField(10);
//         namField.setPreferredSize(new Dimension(100,5));
//         agField = new JTextField(10);
//         agField.setPreferredSize(new Dimension(100,5));
//         roField = new JTextField(10);
//         roField.setPreferredSize(new Dimension(100,5));

//         addButton = new JButton("Add a Record");
//         deletebButton = new JButton("Delete A Record");

//         JPanel inputPanel=new JPanel();
//         inputPanel.setLayout(new GridLayout(4, 2));

//         inputPanel.add(name);
//         inputPanel.add(namField);
//         inputPanel.add(age);
//         inputPanel.add(agField);
//         inputPanel.add(roll);
//         inputPanel.add(roField);

      
//         JPanel buttonpaJPanel = new JPanel();
//         buttonpaJPanel.setLayout(new FlowLayout());
//         buttonpaJPanel.add(addButton);
//         buttonpaJPanel.add(deletebButton);
       
//         frame.add(inputPanel,BorderLayout.NORTH);
//         frame.add(buttonpaJPanel,BorderLayout.SOUTH);
//         frame.setVisible(true);


//     }
// }