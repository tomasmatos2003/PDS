package lab09.ex3;

import java.util.Collection;
import java.util.Stack;

public abstract class CollectionCommand<E> {
    protected Collection<E> collection;
    protected Stack<E> history;

    public CollectionCommand(Collection<E> collection) {
        this.collection = collection;
        this.history = new Stack<E>();
    }

    public abstract void execute(E element) throws CommandExecutionException;

    public abstract void undo() throws CommandUndoException;
}
