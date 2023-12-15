import javax.swing.AbstractListModel;

// Razred za logični prikaz podatkov
class PersonListModel extends AbstractListModel<String> {
    private PersonList personList;

    public PersonListModel(PersonList personList) {
        this.personList = personList;
    }

    @Override
    public int getSize() {
        return personList.getPersons().size();
    }

    @Override
    public String getElementAt(int index) {
        Person person = personList.getPersons().get(index);
        return person.toString();
    }

    // Dodaj to metodo za posredovanje sprememb
    public void fireContentsChanged(int index0, int index1) {
        fireContentsChanged(this, index0, index1);
    }
}
