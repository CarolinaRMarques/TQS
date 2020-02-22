package tqsua.lab1stack;
import java.util.NoSuchElementException;

public class TqsSimpleStack<T> implements ITqsStack<T> {
    private T[] data;
    private int size = 0;

    public TqsSimpleStack(int max) {
        data =  (T[]) new Object[max] ;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if (size != 0) { return data[size-1]; }
        else { throw new NoSuchElementException(); }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T push(T t) {
        if (data.length != size) {
            data[size] = t;
            size++;
            return t;
        }
        else {throw new IllegalStateException(); }
    }

    @Override
    public T pop() {
        if (size > 0) {
            data[size-1] = null;
            return data[size--];
        }
        else {
            System.out.println("EmptyStack");
            throw new NoSuchElementException();
        }
    }


}


