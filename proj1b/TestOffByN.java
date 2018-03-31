import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator obo = new OffByN(5);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(obo.equalChars('a','f'));
        assertTrue(obo.equalChars('f','a'));
        assertTrue(obo.equalChars('b','g'));
        assertFalse(obo.equalChars('c','q'));
        assertFalse(obo.equalChars('c','c'));
        assertFalse(obo.equalChars('z','f'));
    }
}
