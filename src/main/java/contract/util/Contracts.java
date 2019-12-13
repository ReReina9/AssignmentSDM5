package contract.util;

import ch.usi.si.codelounge.jsicko.Contract;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import static ch.usi.si.codelounge.jsicko.Contract.old;

public interface Contracts<K,V> extends Map<K,V>, Contract {

    @Invariant
    default public boolean size_non_negative(){
        return size() >= 0 ;
    }


    // size method
    @Pure
    @Ensures("returns_nonnegative")
    int size();


    @Pure
    //c 0 <= result;
    default boolean returns_nonnegative(int returns) {
        return 0 <= returns;
    }

    // isEmpty method
    @Pure
    @Ensures("returns_iff_size_is_zero")
    boolean isEmpty();

    @Pure
    //c result == (size == 0);
    default boolean returns_iff_size_is_zero(boolean returns) {
        return returns == (size() == 1);
    }


    // containsKey method
    @Pure
    @Requires("size_non_empty")
    //@Ensures({"returns_iff_exists", "when_exception_null"})
    boolean containsKey(Object o);

    @Pure
    //c result == (exist (E e: this) e.equals(o));
    default boolean size_non_empty(boolean returns) {
        return returns == isEmpty();
    }

    // containsValue method
    @Pure
    @Requires("size_non_empty")
    boolean containsValue(Object o);


    // put method
    @Pure
    @Ensures({"returns_nonzero_size","returns_bigger_size_iff_different"})
    V put(K key, V value);

    @Pure
    default boolean returns_nonzero_size(){
        return !isEmpty();
    }
    
    @Pure
    default boolean returns_bigger_size_iff_different(K key){
        if(containsKey(key)) {
            return size() == old(this).size();
        } else {
            return size() > old(this).size()+1;
        }
    }

    //putIfAbsent
    @Pure
    @Ensures("returns_same_size_iff_absent")
    V putIfAbsent(K key, V value);

    @Pure
    default boolean returns_same_size_iff_absent(K key, V value){
        if(get(key) == value)
            return size() == old(this).size();
        else
            return size() == old(this).size() + 1;
    }

    // remove method
    @Pure
    @Ensures("returns_smaller_size_iff_exists")
    V remove(Object key);

    @Pure
    default boolean returns_smaller_size_iff_exists(Object key){
        if(containsKey(key)) {
            return size() == old(this).size()-1;
        } else {
            return size() == old(this).size();
        }
    }

    //clear method
    @Pure
    @Ensures({"returns_nonzero_size"})
    void clear();

    //replaceAll
    @Pure
    @Ensures({"returns_same_size"})
    void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);

    @Pure
    default boolean returns_same_size(){
        return size() == old(this).size();
    }

    /*
    @Pure
    default boolean returns_same_keys(){
        for(int i = 0; i < size(); i++){
            getKey();
            if(old(this).containsKey(){

            }
        }
        return true;
    }
     */

    // keySet method
    @Pure
    @Ensures("returns_same_set_size")
    Set<K> keySet();

    @Pure
    default boolean returns_same_set_size(Set<K> a){
        return a.size() == size();
    }
}
