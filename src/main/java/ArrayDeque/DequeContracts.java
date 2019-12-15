package ArrayDeque;


import java.util.Deque;

import ch.usi.si.codelounge.jsicko.Contract;
import static ch.usi.si.codelounge.jsicko.Contract.old;
import static ch.usi.si.codelounge.jsicko.ContractUtils.*;


public interface DequeContracts<E> extends Deque<E>, Contract {

    @Invariant
    @Pure
    default boolean non_null_elements(){ return this.contains(null);}

    //pre-conditions and post-conditions for chosen methods
    @Pure
    @Ensures({"final_size_non_empty","size_increased_by_one","check_first_element"})
    void addFirst(E e);

    @Pure
    @Ensures({"final_size_non_empty","size_increased_by_one","check_last_element"})
    void addLast(E e);

    @Pure
    @Ensures({"final_size_non_empty","size_increased_by_one"})
    boolean offerFirst(E e);

    @Pure
    @Ensures({"final_size_non_empty","size_increased_by_one"})
    boolean offerLast(E e);

    @Pure
    @Requires("initial_size_non_empty")
    @Ensures("size_decreased_by_one")
    E removeFirst();

    @Pure
    @Requires("initial_size_non_empty")
    @Ensures("size_decreased_by_one")
    E removeLast();

    @Pure
    @Requires("initial_size_non_empty")
    @Ensures("size_unchanged")
    E getFirst();

    @Pure
    @Requires("initial_size_non_empty")
    @Ensures("size_unchanged")
    E getLast();

    @Pure
    @Requires("initial_size_non_empty")
    @Ensures("size_unchanged")
    E peekFirst();

    @Pure
    @Requires("initial_size_non_empty")
    @Ensures("size_unchanged")
    E peekLast();


    // implementations of pre- and post-conditions methods

    @Pure
    default boolean final_size_non_empty(){ return size() != 0; }

    @Pure
    default boolean size_increased_by_one(){ return size() == old(this).size()+1; }

    @Pure
    default boolean check_first_element(E e){
        return e == old(this).getFirst();
    }

    @Pure
    default boolean check_last_element(E e){
        return e == old(this).getLast();
    }

    @Pure
    default boolean initial_size_non_empty(){ return size() != 0; }

    @Pure
    default boolean size_decreased_by_one(){
        return size() == old(this).size()-1;
    }

    @Pure
    default boolean size_unchanged(){
        return size() == old(this).size();
    }

}


