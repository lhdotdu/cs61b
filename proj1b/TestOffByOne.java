import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator obo = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(obo.equalChars('a','b'));
        assertTrue(obo.equalChars('c','d'));
        assertTrue(obo.equalChars('d','c'));
        assertFalse(obo.equalChars('c','q'));
        assertFalse(obo.equalChars('c','c'));
        assertFalse(obo.equalChars('z','f'));
    }
}
