package ArrayDeque;

import java.util.ArrayDeque;

public class ArrayDequeContracts <E> extends ArrayDeque<E> implements DequeContracts<E> {

    @Override
    public void addFirst(E e){ super.addFirst(e);}

    @Override
    public void addLast(E e){ super.addLast(e);}

    @Override
    public boolean offerFirst(E e){return super.offerFirst(e);}

    @Override
    public boolean offerLast(E e){return super.offerLast(e);}

    @Override
    public E removeFirst(){return super.removeFirst();}

    @Override
    public E removeLast(){return super.removeLast();}

    @Override
    public E getFirst(){return super.getFirst();}

    @Override
    public E getLast(){return super.getLast();}

    @Override
    public E peekFirst(){return super.peekFirst();}

    @Override
    public E peekLast(){return super.peekLast();}

}

