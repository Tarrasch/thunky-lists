

public class LazyList {
    public int head;
    public Thunk<LazyList> tail;

    public LazyList(int head, Thunk<LazyList> tail) {
        this.head = head;
        this.tail = tail;
    }
}
