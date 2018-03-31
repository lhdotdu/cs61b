public class LinkedListDeque<T> {
//    private static class TList

    private class node {
        private T item;
        private node last;
        private node next;

        private node(node l, T i, node n) {
            last = l;
            item = i;
            next = n;
        }
    }

    private node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new node(null,null,null);
        sentinel.last = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        node new_node = new node(sentinel,item,sentinel.next);
        sentinel.next.last = new_node;
        sentinel.next = new_node;
        size ++;
    }

    public void addLast(T item) {
        node new_node = new node(sentinel.last,item,sentinel);
        sentinel.last.next = new_node;
        sentinel.last = new_node;
        size ++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        node node_ptr = sentinel.next;
        for (int i=0; i<size; i++) {
            System.out.print(node_ptr.item + " ");
            node_ptr = node_ptr.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;

        // Clean up the pointers of the first item.
        sentinel.next.last.next = null;
        sentinel.next.last.last = null;

        sentinel.next.last = sentinel;
        size --;
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T res = sentinel.last.item;
        sentinel.last = sentinel.last.last;

        // Clean up the pointers of the last item.
        sentinel.last.next.next = null;
        sentinel.last.next.last = null;

        sentinel.last.next = sentinel;
        size --;
        return res;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        node node_ptr = sentinel.next;
        for (int i=0; i<index; i++) {
            node_ptr = node_ptr.next;
        }
        return node_ptr.item;
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRHelper(sentinel.next, 0, index);
    }

    private T getRHelper(node subList, int pos, int index) {
        if (index == pos) {
            return subList.item;
        }
        return getRHelper(subList.next, pos+1, index);
    }
}
