package contract;

import ch.usi.si.codelounge.jsicko.Contract;
import contract.HashMapContracts;
import contract.MapContracts;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class HashMapContractsTest {

    @Test
    public void testSize() {
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
        mc.put(1, "foo");
        assertEquals(mc.containsKey(1), true);
        assertEquals(mc.containsValue("foo"), true);
    }

    @Test
    public void testPutIfAbsent() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.putIfAbsent(1, "foo");
        mc.putIfAbsent(1, "foo2");
        assertEquals(mc.containsKey(1), true);
        assertEquals(mc.containsValue("foo"), true);
        assertEquals(mc.containsValue("foo2"), false);
        assertEquals(mc.size(), 1);
    }

    @Test
    public void testRemove() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "foo");
        mc.put(2, "foo2");
        mc.remove(1);
        assertEquals(mc.containsKey(1), false);
        assertEquals(mc.containsKey(2), true);
        assertEquals(mc.size(), 1);
    }

    @Test
    public void testClear() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "foo");
        mc.put(2, "foo2");
        mc.clear();
        assertEquals(mc.containsKey(1), false);
        assertEquals(mc.containsKey(2), false);
        assertEquals(mc.size(), 0);
    }

    @Test
    public void testReplaceAll() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "foo");
        mc.put(2, "foo2");
        mc.replaceAll((k, v) -> {
            return v = v + "replace";
        });
        assertEquals(mc.containsValue("foo"), false);
        assertEquals(mc.containsValue("fooreplace"), true);
        assertEquals(mc.containsValue("foo2"), false);
        assertEquals(mc.containsValue("foo2replace"), true);
        assertEquals(mc.size(), 2);
    }

    @Test
    public void testKeySet() {
        MapContracts<Integer, String> mc = new HashMapContracts<>();
        mc.put(1, "foo");
        mc.put(2, "foo2");
        Set<Integer> keyset = mc.keySet();
        assertEquals(keyset.contains(1), true);
        assertEquals(keyset.contains(2), true);
        assertEquals(keyset.size(), 2);
    }

}