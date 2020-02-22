package tqsua.lab1stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class TqsSimpleStackTest {

    TqsSimpleStack <String> emptystack;
    TqsSimpleStack <String> stack ;
    TqsSimpleStack <String> fullStack;

    @BeforeEach
    void setUp() {
        // a) mostly tested here, size = 0 on constrution and therefore empty
        emptystack = new TqsSimpleStack<>(0);
        Assertions.assertEquals(0,emptystack.size());
        Assertions.assertTrue(emptystack.isEmpty());

        stack = new TqsSimpleStack<>(3);
        Assertions.assertEquals(0,stack.size());
        Assertions.assertTrue(stack.isEmpty());
        stack.push("Hey");
        stack.push("Dummy");

        fullStack = new TqsSimpleStack<>(2);
        Assertions.assertEquals(0,fullStack.size());
        Assertions.assertTrue(fullStack.isEmpty());
        fullStack.push("Dummy2");
        fullStack.push("Dummy3");

    }

    //After n pushes to an empty stack, n > 0, the stack is not empty and its size is n
    @Test
    void push() {
        //stack has 2 elements -> it is not empty || size = 2
        Assertions.assertTrue(!stack.isEmpty()||stack.size()==2);
    }


    @Test
    void pop() {
        //If one pushes x then pops, the value popped is x.

        //If the size is n, then after n pops, the stack is empty and has a size 0
        for (int i = 0 ;i <= stack.size() ; i++) {
            stack.pop();
        }
        Assertions.assertTrue(stack.isEmpty() || stack.size() == 0);
    }

    @Test
    void peek() {
        Assertions.assertTrue(stack.size() > 0);
        //if one pushes x then peeks, the value returned is x, but the size stays the same
        Assertions.assertTrue(stack.peek() == "Dummy" || stack.size() == 2);
    }

    @Test
    void size() {
        Assertions.assertTrue(emptystack.size() >= 0 );
        Assertions.assertTrue(stack.size() >= 0 );
        Assertions.assertTrue(fullStack.size() >= 0 );

    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(emptystack.size()== 0);
        Assertions.assertFalse(stack.size() == 0);
        Assertions.assertFalse(fullStack.size() == 0);

    }

    @Test
    void testPopEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
         emptystack.pop();
        });
    }

    @Test
    void testPeekEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            emptystack.peek();
        });
    }

    @Test
    void testPushBoundedStack() {
        Assertions.assertThrows( IllegalStateException.class, () -> {
            fullStack.push("ImpossiblePush");
        });
    }
}