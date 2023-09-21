package lab09.ex3;

import java.util.Collection;

public class RemoveCommand<E> extends CollectionCommand<E> {
    public RemoveCommand(Collection<E> collection) {
        super(collection);
    }

    @Override
    public void execute(E element) throws CommandExecutionException {
        if (collection.remove(element))
            history.push(element);
        else
            throw new CommandExecutionException("Element not found");
    }

    @Override
    public void undo() throws CommandUndoException {
        if (!history.empty() && collection.add(history.peek()))
            history.pop();
        else
            throw new CommandUndoException(
                    "Can't undo because there is no element to add or element can't be added because is already in collection");
    }
}
