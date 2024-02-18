public interface BagInterface<T> {
    /**
     * Gets the current number of entries in this bag.
     *
     * @return The number of entries.
     */
    int getCurrentSize();

    /**
     * Checks whether this bag is full.
     *
     * @return True if the bag is full, false otherwise.
     */
    boolean isFull();

    /**
     * Checks whether this bag is empty.
     *
     * @return True if the bag is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The entry to be added.
     * @return True if the addition was successful, false otherwise.
     */
    boolean add(T newEntry);

    /**
     * Removes an unspecified entry from this bag.
     *
     * @return The removed entry or null if the bag is empty.
     */
    T remove();

    /**
     * Removes a specific entry from this bag.
     *
     * @param entry The entry to be removed.
     * @return True if the removal was successful, false otherwise.
     */
   boolean remove(T entry);


    /**
     * Removes all entries from this bag.
     */
    void clear();

    /**
     * Gets the frequency of a specific entry in this bag.
     *
     * @param entry The entry to find the frequency of.
     * @return The number of occurrences of the entry.
     */
    int getFrequencyOf(T entry);

    /**
     * Checks whether a specific entry is in this bag.
     *
     * @param entry The entry to check.
     * @return True if the entry is in the bag, false otherwise.
     */
    boolean contains(T entry);

    /**
     * Retrieves all entries in this bag as an array.
     *
     * @return An array containing all entries in the bag.
     */
    T[] toArray();

    // union, intersection, difference
    //
    /**
     * Performs the union of this bag and another bag.
     *
     * @param inputBag The other bag for the union.
     * @return A new bag representing the union of the two bags.
     */
    BagInterface<T> union(BagInterface<T> inputBag);

    /**
     * Performs the intersection of this bag and another bag.
     *
     * @param inputBag The other bag for the intersection.
     * @return A new bag representing the intersection of the two bags.
     */
    BagInterface<T> intersection(BagInterface<T> inputBag);

    /**
     * Performs the difference of this bag and another bag.
     *
     * @param inputBag The other bag for the difference.
     * @return A new bag representing the difference of the two bags.
     */
    BagInterface<T> difference(BagInterface<T> inputBag);
}