package lab06.Contactos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsStorageCSV implements ContactsStorageInterface {
    private File file;
    private static final String DELIMITER = ",";

    public ContactsStorageCSV(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(file))) {
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] fields = line.split(DELIMITER);
                String name = fields[0];
                String phone = fields[1];
                contacts.add(new Contact(name, phone));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Contact contact : list) {
                fileWriter.write(contact.getName() + DELIMITER + contact.getPhoneNumber() + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

