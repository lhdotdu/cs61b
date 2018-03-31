public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int front;

    public ArrayDeque() {
        items = (T[]) new Object[2];
        size = 0;
        front = items.length-1;
    }

    public void addFirst(T item) {
        if (size==items.length) {
            resize(size*2);
        }
        front = offset_index(front, -1);
        items[front] = item;
        size ++;
    }

    public void addLast(T item) {
        if (size==items.length) {
            resize(size*2);
        }
        items[offset_index(front, size)] = item;
        size ++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i=0; i<size; i++) {
            System.out.print(items[offset_index(front,i)] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = items[front];
        items[front] = null;
        front = offset_index(front, 1);
        size --;
        if (size >= 4 && size <= items.length/2) {
            resize(items.length/2);
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = items[offset_index(front,size-1)];
        items[offset_index(front,size-1)] = null;
        size --;
        if (size >= 4 && size <= items.length/2) {
            resize(items.length/2);
        }
        return res;
    }

    public T get(int index) {
        if (index >= items.length) {
            return null;
        }
        return items[offset_index(front,index)];
    }

    private int offset_index(int index, int offset) {
        int res = index + offset;
        if (res < 0) {
            res += items.length;
        }
        if (res >= items.length) {
            res -=items.length;
        }
        return res;
    }

    private void resize(int new_capacity) {
        T[] a = (T[]) new Object[new_capacity];
        if (front + size <= items.length) {
            System.arraycopy(items,front,a,0,size);
        } else {
            // Length of the first section.
            int len_sec1 = items.length-front;
            System.arraycopy(items,front,a,0,len_sec1);
            System.arraycopy(items,0,a,len_sec1,items.length-len_sec1);
        }
        front = 0;
        items = a;
    }

}
