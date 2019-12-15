package contract;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import ch.usi.si.codelounge.jsicko.Contract;
import static ch.usi.si.codelounge.jsicko.Contract.old;
import static ch.usi.si.codelounge.jsicko.ContractUtils.*;

public interface MapContracts<K,V> extends Map<K,V>, Contract {

    @Invariant
    default public boolean size_non_negative(){
        return size() >= 0 ;
    }

    @Pure
    @Ensures("returns_non_negative")
    int size();

    @Pure
    default boolean returns_non_negative(int returns) {
        return 0 <= returns;
    }

    @Pure
    @Ensures("returns_iff_size_is_zero")
    boolean isEmpty();

    @Pure
    default boolean returns_iff_size_is_zero(boolean returns) {
        return returns == (size() == 0);
    }

    @Pure
    @Ensures("size_non_empty")
    boolean containsKey(Object o);

    @Pure
    default boolean size_non_empty() {
        return !isEmpty();
    }

    @Pure
    @Ensures("size_non_empty")
    boolean containsValue(Object o);

    @Pure
    @Ensures({"size_non_empty","returns_bigger_or_same_size"})
    V put(K key, V value);

    @Pure
    default boolean returns_bigger_or_same_size(){
        return size() >= old(this).size();
    }

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

    @Pure
    @Ensures({"returns_zero_size"})
    void clear();

    default boolean returns_zero_size(){
        return size() == 0;
    }

    @Pure
    @Ensures({"returns_same_size","returns_same_keys"})
    void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);

    @Pure
    default boolean returns_same_size(){
        return size() == old(this).size();
    }

    @Pure
    default boolean returns_same_keys(){
        Set<K> oldKeySet = old(this).keySet();
        Set<K> newKeySet = keySet();
        return oldKeySet.equals(newKeySet) ? true : false;
    }

    @Pure
    @Ensures("returns_same_set_size")
    Set<K> keySet();

    @Pure
    default boolean returns_same_set_size(Set<K> returns){
        return returns.size() == size();
    }
}