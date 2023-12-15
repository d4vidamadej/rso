import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Razred za upravljanje s seznamom oseb
class PersonList {
    private ArrayList<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(int index) {
        if (index >= 0 && index < persons.size()) {
            persons.remove(index);
        }
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    // Metoda za shranjevanje v tekstovno datoteko
    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : persons) {
                writer.write(person.name + "," + person.age);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
