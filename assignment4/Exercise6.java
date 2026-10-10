import java.awt.*;
import java.awt.event.*;

public class Exercise6 extends Frame implements ActionListener {
    private TextField nameField;
    private TextField rollField;
    private TextField courseField;
    private Button submitBtn;

    public Exercise6() {
        setTitle("Student Registration Form");
        setLayout(new FlowLayout());
        setSize(320, 220);

        Label nameLabel = new Label("Name:   ");
        nameField = new TextField(20);

        Label rollLabel = new Label("Roll No:");
        rollField = new TextField(20);

        Label courseLabel = new Label("Course: ");
        courseField = new TextField(20);

        submitBtn = new Button("Submit");
        submitBtn.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(rollLabel);
        add(rollField);
        add(courseLabel);
        add(courseField);
        add(submitBtn);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String roll = rollField.getText();
        String course = courseField.getText();

        Dialog dialog = new Dialog(this, "Registration Details", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(280, 140);
        dialog.add(new Label("Registered Successfully!"));
        dialog.add(new Label(name + " (" + roll + ") - " + course));

        Button okBtn = new Button("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        dialog.add(okBtn);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
        System.out.println("Registration: " + name + " | " + roll + " | " + course);
    }

    public static void main(String[] args) {
        new Exercise6();
    }
}
