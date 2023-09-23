package lab06.Contactos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        Contact c1 = new Contact("João", "111111111");
        Contact c2 = new Contact("José", "222222222");
        Contact c3 = new Contact("Maria", "333333333");
        Contact c4 = new Contact("António", "444444444");
        Contact c5 = new Contact("Manuel", "555555555");
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(c4);
        contacts.add(c5);
        
        ContactsInterface contactsManager = new ContactsManager();
        ContactsStorageInterface textStorage = new ContactsStorageTXT("lab06/Contactos/contacts.txt");
        contactsManager.openAndLoad(textStorage);
        for (Contact contact : contacts) {
            contactsManager.add(contact);
        }
        contactsManager.saveAndClose();
        contactsManager.openAndLoad(textStorage);
        System.out.println("\nLoaded from text:\n" + contactsManager);

        Contact c6 = new Contact("David", "666666666");
        contacts.add(c6);
        contactsManager.add(c6);
        contactsManager.remove(c2);
        ContactsStorageInterface binaryStorage = new ContactsStorageBinary("lab06/Contactos/contacts.bin");
        contactsManager.saveAndClose(binaryStorage);
        contactsManager.openAndLoad(binaryStorage);
        System.out.println("Loaded from binary:\n" + contactsManager);

        ContactsStorageInterface csvStorage = new ContactsStorageCSV("lab06/Contactos/contacts.csv");
        contactsManager.remove(c1);
        contactsManager.remove(c3);
        contactsManager.remove(c4);
        
        contactsManager.saveAndClose(csvStorage);
        contactsManager.openAndLoad(csvStorage);
        System.out.println("Loaded from CSV:");
        // test exits() e getByName()
        for (Contact contact : contacts) {
            if (contactsManager.exist(contact))
                System.out.println(contactsManager.getByName(contact.getName()).toString());
        }
    }
}
