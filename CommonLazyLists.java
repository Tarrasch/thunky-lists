
public class CommonLazyLists {
    static public LazyList enumFrom(final int start){
        Thunk<LazyList> delayedTail = new Thunk<LazyList>() {
            public LazyList eval() {
                return enumFrom(start+1);
            }
        };
        return new LazyList(start, delayedTail);
    }

    static public LazyList sieve(final LazyList ll){
        int h = ll.head;
        final LazyList filtered = filterDivisibleBy(h, ll.tail.eval());
        return new LazyList(h, new Thunk<LazyList>() {
            public LazyList eval() {
                return sieve(filtered);
            }
        });
    }

    static public LazyList filterDivisibleBy(final int n, final LazyList ll) {
        int elem = ll.head;
        Thunk<LazyList> rest = new Thunk<LazyList>() {
            public LazyList eval() {
                return filterDivisibleBy(n, ll.tail.eval());
            }
        };
        if( elem % n == 0){ // Do not include element
            return rest.eval();
        }
        else{ // Do include the element
            return new LazyList(elem, rest); // Note the resemblance to cons
        }
    }

    static public LazyList primes(){
        return sieve(enumFrom(2));
    }
}
