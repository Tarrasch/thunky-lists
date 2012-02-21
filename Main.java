

public class Main {
    public static void main(String[] args) {
        LazyList primes = CommonLazyLists.primes();

        // Doing the extractions manually
        LazyList ll = primes;
        System.out.println(ll.head);
        LazyList ll2 = ll.tail.eval();
        System.out.println(ll2.head);
        LazyList ll3 = ll2.tail.eval();
        System.out.println(ll3.head);

        // But it's also possible to use a loop
        LazyList rest = primes;
        for (int i = 0; i < 20; i++) {
            System.out.print(rest.head + " ");
            rest = rest.tail.eval();
        }
        System.out.println("");
    }

}
