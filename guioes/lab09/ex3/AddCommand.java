package lab09.ex3;

import java.util.Collection;

public class AddCommand<E> extends CollectionCommand<E> {
    public AddCommand(Collection<E> collection) {
        super(collection);
    }

    @Override
    public void execute(E element) throws CommandExecutionException {
        if (collection.add(element))
            history.push(element);
        else
            throw new CommandExecutionException("Element can't be added because it already exists in collection");
    }

    @Override
    public void undo() throws CommandUndoException {
        if (!history.empty() && collection.remove(history.peek()))
            history.pop();
        else
            throw new CommandUndoException(
                    "Can't undo because there is no element to remove or element is no longer in collection");
    }
}
