/**
 * A class for off-by-N comparators.
 */
public class OffByN implements CharacterComparator {

    private int offset;

    public OffByN(int N) {
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return ((y-x) == offset || (y-x) == -offset);
    }
}
