public interface BagInterface<T> {

    int getCurrentSize();

    boolean isFull();

    boolean isEmpty();

    boolean add(T newEntry);

    T remove();

    // boolean remove(T entry);

    void clear();

    int getFrequencyOf(T entry);

    boolean contains(T entry);

    T[] toArray();

    // added via BagSome project requirements
    BagInterface<T> union(BagInterface<T> inputBag);

    BagInterface<T> intersection(BagInterface<T> inputBag);   

    BagInterface<T> difference(BagInterface<T> inputBag);


}