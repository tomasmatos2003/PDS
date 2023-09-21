package lab09.ex3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CommandDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        CollectionCommand<String> command;

        System.out.println("Using ArrayList:");
        for (int i = 0; i <= 1; i++) {
            if (i == 1) {
                System.out.println("\nUsing HashSet:");
                collection = new HashSet<>();
            }

            command = new AddCommand<>(collection);

            try {
                command.execute("foo");
                System.out.println("Collection after adding foo: " + collection);
            } catch (CommandExecutionException e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
    
            try {
                command.undo();
                System.out.println("Collection after undoing add of foo: " + collection);
            } catch (CommandUndoException e) {
                System.out.println("Error undoing add of foo: " + e.getMessage());
            }
    
            try {
                command.undo();
                System.out.println("Collection after undoing nothing: " + collection);
            } catch (CommandUndoException e) {
                System.out.println("Error undoing command: " + e.getMessage());
            }
    
            try {
                command.execute("bar");
                System.out.println("Collection after adding bar: " + collection);
            } catch (CommandExecutionException e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
    
            try {
                command.execute("bar");
                System.out.println("Collection after adding bar again: " + collection);
            } catch (CommandExecutionException e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
    
            try {
                command.undo();
                System.out.println("Collection after undoing add of bar: " + collection);
            } catch (CommandUndoException e) {
                System.out.println("Error undoing command: " + e.getMessage());
            }
    
            command = new RemoveCommand<>(collection);
            try {
                command.execute("bar");
                System.out.println("Collection after removing bar: " + collection);
            } catch (CommandExecutionException e) {
                System.out.println("Error executing remove of bar: " + e.getMessage());
            }
    
            try {
                command.execute("bar");
                System.out.println("Collection after removing bar again: " + collection);
            } catch (CommandExecutionException e) {
                System.out.println("Error executing remove of bar again: " + e.getMessage());
            }
    
            try {
                command.undo();
                System.out.println("Collection after undoing remove of bar: " + collection);
            } catch (CommandUndoException e) {
                System.out.println("Error undoing command: " + e.getMessage());
            }
        }
    }
}
