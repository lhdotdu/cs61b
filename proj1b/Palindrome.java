/**
 * A class for palindrome operations.
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i=0; i<word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return dequeIsPalindrome(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i=0; i<word.length()/2; i++) {
            if (!cc.equalChars(word.charAt(word.length()-i-1), word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean dequeIsPalindrome(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }

        if (d.removeFirst() == d.removeLast()) {
            return dequeIsPalindrome(d);
        }
        return false;
    }
}
