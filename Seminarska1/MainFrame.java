import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Glavni vmesnik
class MainFrame extends JFrame {
    private PersonList personList;
    private JList<String> personJList;
    private PersonListModel personListModel;

    public MainFrame() {
        personList = new PersonList();
        loadDataFromFile();  // Naloži podatke ob zagonu programa
        personListModel = new PersonListModel(personList);
        personJList = new JList<>(personListModel);

        JButton addButton = new JButton("Dodaj osebo");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Vnesi ime:");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Vnesi starost:"));
                personList.addPerson(new Person(name, age));
                personListModel.fireContentsChanged(0, personListModel.getSize() - 1);
            }
        });

        JButton removeButton = new JButton("Odstrani osebo");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = personJList.getSelectedIndex();
                personList.removePerson(selectedIndex);
                personListModel.fireContentsChanged(0, personListModel.getSize() - 1);
            }
        });

        JButton editButton = new JButton("Uredi osebo");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = personJList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Person selectedPerson = personList.getPersons().get(selectedIndex);
                    new PersonDetailsFrame(selectedPerson);
                    personListModel.fireContentsChanged(selectedIndex, selectedIndex);
                }
            }
        });

        JButton saveButton = new JButton("Shrani v datoteko");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataToFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(personJList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Metoda za shranjevanje v datoteko
    private void saveDataToFile() {
        personList.saveToFile("persons.txt");
        JOptionPane.showMessageDialog(this, "Podatki uspešno shranjeni v datoteko.");
    }

    // Metoda za nalaganje podatkov iz datoteke
    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("persons.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    personList.addPerson(new Person(name, age));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
