package tqsua.lab1stack;

public interface ITqsStack<A> {
    boolean isEmpty();
    A peek();
    int size();
    A push(A a);
    A pop();
}
