package lab06.Contactos;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsStorageTXT implements ContactsStorageInterface {
    private File file;

    public ContactsStorageTXT(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (Scanner sc = new Scanner(this.file)) {
            String line;
            while (sc.hasNext()) {
                line = sc.nextLine();
                String[] fields = line.split("\t");
                for (String field : fields) {
                    String[] new_fields = field.split(", ");
                    Contact contact = new Contact(new_fields[0], new_fields[1]);
                    contacts.add(contact);
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (FileWriter fileWriter = new FileWriter(this.file)) { 
            for (Contact contact : list) {
                fileWriter.write(contact.getName() + ", " + contact.getPhoneNumber() + '\t');
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error writing file: " + e.getMessage());
            return false;
        }
    }
}
