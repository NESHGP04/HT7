
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssociationTest {

    //Test para Getters
    @Test
    public void testGetValue() {
        Association<String, String, String> association = new Association<>("key", "v1", "v2");

        assertEquals("key", association.getKey());
        assertEquals("v1", association.getValue1());
        assertEquals("v2", association.getValue2());
    }

    //Test para Setters
    @Test
    public void testSetValue() {
        Association<String, String, String> association = new Association<>("key", "value1", "value2");

        association.setKey("newKey");
        association.setValue1("newValue1");
        association.setValue2("newValue2");
        
        assertEquals("newKey", association.getKey());
        assertEquals("newValue1", association.getValue1());
        assertEquals("newValue2", association.getValue2());
    }
}
