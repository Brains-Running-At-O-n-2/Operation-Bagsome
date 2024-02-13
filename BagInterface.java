public interface BagInterface<T> {

    int getCurrentSize();

    boolean isFull();

    boolean isEmpty();

    boolean add(T newEntry);

    T remove();

    boolean remove(T entry);

    void clear();

    int getFrequencyOf(T entry);

    boolean contains(T entry);

    T[] toArray();

    // added via BagSome project requirements
    T[] union(T[] inputBag);

    T[] intersection(T[] inputBag);   

    T[] difference(T[] inputBag);


}