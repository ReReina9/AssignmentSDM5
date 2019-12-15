package ArrayDeque;


import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayDequeContractsTest {


    @Test
    public void addFirstTest(){
        DequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        array_deque.addFirst("elem");
        assertThrows(Contract.PostconditionViolation.class, () -> array_deque.addFirst("elem2"));
    }

    @Test
    public void addLastTest(){
        DequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        array_deque.addLast("elem");
        assertThrows(Contract.PostconditionViolation.class, () -> array_deque.addLast("elem2"));
    }

    @Test
    public void offerFirstTest(){
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        array_deque.addFirst("elem");
        assertThrows(Contract.PostconditionViolation.class, () -> array_deque.addFirst("elem2"));
    }

    @Test
    public void offerLastTest(){
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        array_deque.addLast("elem");
        assertThrows(Contract.PostconditionViolation.class, () -> array_deque.addLast("elem2"));
    }

    @Test
    public void removeFirstOnEmptyArrayDeque() throws Throwable {
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        assertThrows(Contract.PreconditionViolation.class,array_deque::removeFirst);
    }

    @Test
    public void removeLastOnEmptyArrayDeque() throws Throwable {
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        assertThrows(Contract.PreconditionViolation.class,array_deque::removeLast);
    }

    @Test
    public void getFirstOnEmptyArrayDeque() throws Throwable {
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        assertThrows(Contract.PreconditionViolation.class,array_deque::getFirst);
    }

    @Test
    public void getLastOnEmptyArrayDeque() throws Throwable {
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        assertThrows(Contract.PreconditionViolation.class,array_deque::getLast);
    }

    @Test
    public void peekFirstOnEmptyArrayDeque() throws Throwable {
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        assertThrows(Contract.PreconditionViolation.class,array_deque::peekFirst);
    }

    @Test
    public void peekLastOnEmptyArrayDeque() throws Throwable {
        ArrayDequeContracts<String> array_deque = new ArrayDequeContracts<String>();
        assertThrows(Contract.PreconditionViolation.class,array_deque::peekLast);
    }



}