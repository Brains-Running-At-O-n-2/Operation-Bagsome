public class ResizableArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    // Constructors
    //
    //
    //
    /** Default constructor */
    public ResizableArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[DEFAULT_CAPACITY]; // default capacity is 25
        bag = tempBag;
        this.numberOfEntries = 0;
        this.integrityOK = true;
    }

    /** Constructor with user given capacity */
    public ResizableArrayBag(int capcacity) {
        if (capcacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capcacity]; // user provided capacity
            bag = tempBag;
            this.numberOfEntries = 0;
            this.integrityOK = true;
        } else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    // Methods according to BagInterface
    //
    //
    //
    /**
     * Gives current number of items in bag
     * 
     * @return Integer number of entries in the bag
     */
    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    /**
     * Determines if bag is empty
     * 
     * @return True if bag has no items, false if bag has items
     */
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    /**
     * Determines if bag is at max capacity
     * 
     * @return True if bag has no more space for entries, false if bag has space to
     *         add entries
     */
    public boolean isFull() {
        return this.numberOfEntries == bag.length;
    }

    /**
     * Adds a new entry to the bag
     * 
     * @param newEntry object to be added to bag
     * @return True if entry was successfully added, false if not
     */
    public boolean add(T newEntry) {
        checkIntegrity();
        boolean result = true;
        if (isFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    /**
     * Removes last entry in the bag
     * 
     * @return either removed entry, if removal was successful, or null
     */
    public T remove() {
        // checkIntegrity();
        // T result = null;
        // if(!isEmpty()){
        // result = bag[numberOfEntries-1];
        // bag[numberOfEntries-1] = null;
        // numberOfEntries--;
        // }
        // return result;

        // OR //

        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    /**
     * Removes specific entry from bag
     * 
     * @param entry to be removed
     * @return True if removal was successful, false if not
     */
    public boolean remove(T entry) {
        checkIntegrity();
        int index = getIndexOf(entry);
        T result = removeEntry(index);
        return entry.equals(result);
    }

    /** Clear all entries from bag */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    /**
     * Gets how often a specific entry appears in bag
     * 
     * @param entry to find frequency of
     * @return Integer of how often entry appears
     */
    public int getFrequencyOf(T entry) {
        checkIntegrity();
        int counter = 0;

        for (int i = 0; i < numberOfEntries; i++) {
            if (entry.equals(bag[i])) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Determine if a bag contains a specific entry
     * 
     * @param entry that is being determined if it is in the bag
     * @return True if entry is in the bag, false if entry is not found in bag
     */
    public boolean contains(T entry) {
        checkIntegrity();
        return getIndexOf(entry) > -1;
    }

    /**
     * Makes the bag into an array for the user to use
     * 
     * @return Array of the bag that is made for the user to use
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    // Bagsome methods (union, intersection, difference)
    //
    //
    //
    /**
     * Joins two bags into one
     * 
     * @param bag to combine with the other that the method is being called on
     * @return bag with combined items
     */
    public BagInterface<T> union(BagInterface<T> inputBag) {
        ResizableArrayBag<T> result = new ResizableArrayBag<>(numberOfEntries + inputBag.getCurrentSize());
        for (T item : this.toArray()) {
            result.add(item);
        }
        for (T item : inputBag.toArray()) {
            result.add(item);
        }
        return result;
    }

    /** Returns a bag consisting of the items that are shared by both bags
     * 
     * @param bag to determine intersecting items
     * @return bag with shared items
     */
    public BagInterface<T> intersection(BagInterface<T> inputBag) {
        int minSize = bag.length < inputBag.getCurrentSize() ? bag.length : inputBag.getCurrentSize();
        ResizableArrayBag<T> result = new ResizableArrayBag<>(minSize);

        T[] bag1Copy = this.toArray();
        for(T item : bag1Copy) {
            int needed = this.getFrequencyOf(item) < inputBag.getFrequencyOf(item) ? this.getFrequencyOf(item) : inputBag.getFrequencyOf(item);
            int lacking = needed - result.getFrequencyOf(item);
            while (lacking > 0) {
                result.add(item);
                lacking--;
            }
        }
        return result;
    }

    public BagInterface<T> difference(BagInterface<T> inputBag) {
        ResizableArrayBag<T> bag1Copy = new ResizableArrayBag<>(this.getCurrentSize());
        ResizableArrayBag<T> bag2Copy = new ResizableArrayBag<>(inputBag.getCurrentSize());
        for (T item : this.toArray()) {
            bag1Copy.add(item);
        }
        for (T item : inputBag.toArray()) {
            bag2Copy.add(item);
        }

        for (T item : bag1Copy.toArray()) {
            if (bag2Copy.contains(item)) {
                bag1Copy.remove(item);
                bag2Copy.remove(item);
            }
        }
        return bag1Copy;
    }

    // Helper methods
    //
    //
    //
    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("ArrayBag Object is corrupt.");
        }
    }

    private int getIndexOf(T entry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && index < numberOfEntries) {
            if (entry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    private T removeEntry(int givenIndex) {
        T result = null;

        if (!isEmpty() && givenIndex >= 0) {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException(
                    "Attempt to create a bug whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    // private void doubleCapacity() {
    // int newLength = 2 * bag.length;
    // checkCapacity(newLength);
    // bag = Arrays.copyOf(bag, newLength);
    // }
    // END helper methods

}