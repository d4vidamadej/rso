import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Razred za urejanje podrobnosti osebe
class PersonDetailsFrame extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JButton saveButton;

    private Person person;

    public PersonDetailsFrame(Person person) {
        this.person = person;

        nameField = new JTextField(person.name);
        ageField = new JTextField(String.valueOf(person.age));
        saveButton = new JButton("Shrani");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Posodobi podatke osebe
                person.name = nameField.getText();
                person.age = Integer.parseInt(ageField.getText());
                dispose();  // Zapri okno po shranjevanju
            }
        });

        setLayout(new GridLayout(3, 2));
        add(new JLabel("Ime:"));
        add(nameField);
        add(new JLabel("Starost:"));
        add(ageField);
        add(new JLabel());  // prazen prostor za boljši videz
        add(saveButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
