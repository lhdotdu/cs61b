//import org.junit.Test;
//import static org.junit.Assert.*;

public class testArrayDeque {

    public static void teststh() {
        ArrayDeque<String> A = new ArrayDeque<>();
        A.addFirst("001");
        A.addFirst("003");
        A.addFirst("005");
        A.addLast("999");
        A.addFirst("006");
        A.addLast("888");
        A.addFirst("051");
        A.addFirst("053");
        A.addFirst("055");
        A.addLast("959");
        A.addFirst("056");
        A.addLast("858");
        A.printDeque();
        System.out.println(A.size());
        System.out.println(A.get(4));
        System.out.println(A.get(7));
        System.out.println(A.get(999));
        System.out.println(A.removeFirst());
        System.out.println(A.removeLast());
        System.out.println(A.removeFirst());
        System.out.println(A.removeFirst());
        A.printDeque();
        System.out.println(A.get(4));
        System.out.println(A.get(7));
        System.out.println(A.get(999));
        System.out.println(A.removeLast());
        System.out.println(A.removeFirst());
        System.out.println(A.removeLast());
        A.printDeque();
        System.out.println(A.removeFirst());
        System.out.println(A.removeLast());
        A.printDeque();
        System.out.println(A.removeFirst());
        System.out.println(A.removeFirst());
        System.out.println(A.removeLast());
        System.out.println(A.removeFirst());
        System.out.println(A.removeFirst());
        A.printDeque();
    }

    public static void main(String[] args) {
        teststh();
    }

}
