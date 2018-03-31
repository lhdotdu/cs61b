/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
//        printPalindromeOffByZero();
//        printPalindromeOffByOne();
//        printPalindromeOffByN(5, true);
        findNForMostPalindromes();
    }

    private static class resultForFun {
        private int numP;
        private String longestP;
        private int lenLongestP;

        private resultForFun(int n, String l1, int l2) {
            numP = n;
            longestP = l1;
            lenLongestP = l2;
        }
    }

    public static void printPalindromeOffByZero() {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
    }

    public static void printPalindromeOffByOne() {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        CharacterComparator obo = new OffByOne();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, obo)) {
                System.out.println(word);
            }
        }
    }

    public static resultForFun printPalindromeOffByN(int N, boolean doPrint) {
        int numP = 0;
        String longestPalindromesOffByN = "";

        int maxLength = 0;

        int minLength = 4;
        int wordLength;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        CharacterComparator obo = new OffByN(N);

        while (!in.isEmpty()) {
            String word = in.readString();
            wordLength = word.length();
            if (palindrome.isPalindrome(word, obo)) {
                if (wordLength >= minLength && doPrint) {
                    System.out.println(word);
                }
                if (wordLength > maxLength) {
                    maxLength = wordLength;
                    longestPalindromesOffByN = word;
                }
                numP ++;
            }
        }
        return new resultForFun(
                numP,
                longestPalindromesOffByN,
                maxLength);
    }

    public static void findNForMostPalindromes() {
        int maxN = -1;
        int maxLength = -1;
        int longestPalindromeN = -1;
        String longestPalindrome = "";

        resultForFun tempRes;
        int maxAmount = 0;
        for (int N=0; N<=26; N++) {
            tempRes = printPalindromeOffByN(N, false);
            if (tempRes.numP > maxAmount) {
                maxAmount = tempRes.numP;
                maxN = N;
            }
            if (tempRes.lenLongestP > maxLength) {
                maxLength = tempRes.lenLongestP;
                longestPalindrome = tempRes.longestP;
                longestPalindromeN = N;
            }
        }
        System.out.println("At N="+maxN+
                " we have most palindromes, amount="+maxAmount);
        System.out.println("At N="+longestPalindromeN+
                " we have the longest palindrome: "+longestPalindrome);
    }
}
