package contract;

import contract.HashMapContracts;
import contract.MapContracts;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class HashMapContractsTest {

    @Test
    void testSize() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        assertEquals(mc.size(), 0);
        mc.put(null, null);
        assertEquals(mc.size(), 1);
    }

    @Test
    public void testIsEmpty() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        assertEquals(mc.isEmpty(), true);
    }

    @Test
    public void testContainsKey() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(null, null);
        assertEquals(mc.containsKey(null), true);
        assertEquals(mc.containsKey(1), false);
    }

    @Test
    public void testContainsValue() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(null, null);
        assertEquals(mc.containsValue(null), true);
        assertEquals(mc.containsValue(1), false);
    }

    @Test
    public void testPut() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "prova");
        assertEquals(mc.containsKey(1), true);
        assertEquals(mc.containsValue("prova"), true);
    }

    @Test
    public void testPutIfAbsent() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.putIfAbsent(1, "prova");
        mc.putIfAbsent(1, "hey");
        assertEquals(mc.containsKey(1), true);
        assertEquals(mc.containsValue("prova"), true);
        assertEquals(mc.containsValue("hey"), false);
        assertEquals(mc.size(), 1);
    }

    @Test
    public void testRemove() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "prova");
        mc.put(2, "hey");
        mc.remove(1);
        assertEquals(mc.containsKey(1), false);
        assertEquals(mc.containsKey(2), true);
        assertEquals(mc.size(), 1);
    }

    @Test
    public void testClear() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "prova");
        mc.put(2, "hey");
        mc.clear();
        assertEquals(mc.containsKey(1), false);
        assertEquals(mc.containsKey(2), false);
        assertEquals(mc.size(), 0);
    }

    @Test
    public void testReplaceAll() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "prova");
        mc.put(2, "hey");
        mc.replaceAll((k, v) -> {
            return v = v + "replace";
        });
        assertEquals(mc.containsValue("prova"), false);
        assertEquals(mc.containsValue("provareplace"), true);
        assertEquals(mc.containsValue("hey"), false);
        assertEquals(mc.containsValue("heyreplace"), true);
        assertEquals(mc.size(), 2);
    }

    @Test
    public void testKeySet() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "prova");
        mc.put(2, "hey");
        Set<Integer> keyset = mc.keySet();
        assertEquals(keyset.contains(1), true);
        assertEquals(keyset.contains(2), true);
        assertEquals(keyset.size(), 2);
    }

}