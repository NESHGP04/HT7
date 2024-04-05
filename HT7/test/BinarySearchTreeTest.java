
//package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

//import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

public class BinarySearchTreeTest {

    private Comparator<String> comparator = Comparator.naturalOrder();
    private BinarySearchTree<String, String> tree = new BinarySearchTree<>(comparator);
    

    @Test
    public void testCount() {
        assertEquals(0, tree.count());
        tree.insert("key1", "value1");
        assertEquals(1, tree.count());

    }

    @Test
    public void testFind() {
        tree.insert("key1", "value1");
        assertEquals("value1", tree.find("key1"));
        assertNull(tree.find("key2"));
    }

    @Test
    public void testInsert() {
        tree.insert("key1", "value1");
        assertEquals(1, tree.count());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.insert("key1", "value1");
        assertFalse(tree.isEmpty());
        
    }

    @Test
    public void testInOrderWalk() {
        String[] keys = {"key1", "key2", "key3"};
        for (String key : keys) {
            tree.insert(key, "value");
        }
        
        StringBuilder result = new StringBuilder();
        tree.InOrderWalk(value -> result.append(value).append(";"));
        
        assertEquals("value;value;value;", result.toString());
    }
}