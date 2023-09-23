package lab06.Contactos;

import java.util.List;

public class ContactsManager implements ContactsInterface {

    private List<Contact> contacts;
    private ContactsStorageInterface storage;

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        this.storage = store;
        this.contacts = storage.loadContacts();
    }

    @Override
    public void saveAndClose() {
        if (storage != null) {
            storage.saveContacts(contacts);
            this.storage = null;
            this.contacts = null;
        }
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        this.storage = store;
        storage.saveContacts(contacts);
        this.storage = null;
        this.contacts = null;
    }

    @Override
    public boolean exist(Contact contact) {
        try {
            return contacts.contains(contact);            
        } catch (NullPointerException e) {
            System.err.println("ContactsManager is closed.");
            return false;
        }
    }

    @Override
    public Contact getByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact) {
        if (contacts == null) {
            System.err.println("ContactsManager is closed.");
            return false;
        }
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Contact contact) {
        if (contacts == null) {
            System.err.println("ContactsManager is closed.");
            return false;
        }
        return contacts.remove(contact);
    }

    @Override
    public String toString() {
        if (contacts == null) {
            System.err.println("ContactsManager is closed.");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contacts) {
            sb.append(contact.toString());
            sb.append("\n");
        }
        return sb.toString(); 
    }
}
