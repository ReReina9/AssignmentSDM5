package contract.util;

import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;


public class HashMapContractTest {

    @Test
    public void testSizeEmpty() {
        HashMap<String, Integer> empty;
        empty = new HashMapContracts<>();
        empty.put(null, 1);
        empty.put("ciao", 2);
        empty.putIfAbsent(null, 2);
        Contracts<String, Integer> copy;
        empty.remove("hey");
        empty.replaceAll((key, oldValue)
                -> oldValue * oldValue);
        System.out.println(empty.toString());
        System.out.println(empty.keySet().size());
        assertEquals(empty.size(), 2);
    }
}