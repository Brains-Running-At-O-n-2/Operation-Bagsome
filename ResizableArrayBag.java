import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T> {
    // private final T[] bag;
    private T[] bag; // bag shouldn't be final for resizable array bag?
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
        if (isFull()) {
            doubleCapacity();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;

        return true;
    }

    /**
     * Removes last entry in the bag
     * 
     * @return either removed entry, if removal was successful, or null
     */
    public T remove() {
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

    /**
     * Clear all entries from bag
     */
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
        
        T[] thisArray = this.toArray();
        T[] inputArray = inputBag.toArray();

        ResizableArrayBag<T> result = new ResizableArrayBag<>();

        for (T item : thisArray) {
            result.add(item);
        }
        for (T item : inputArray) {
            result.add(item);
        }
        return result;
    }

    /**
     * Returns a bag consisting of the items that are shared by both bags
     * 
     * @param bag to determine intersecting items
     * @return bag with shared items
     */
    public BagInterface<T> intersection(BagInterface<T> inputBag) {
        T[] thisArray = this.toArray();

        ResizableArrayBag<T> result = new ResizableArrayBag<>();

        for (T item : thisArray) {
            int lowerFrequency = this.getFrequencyOf(item) < inputBag.getFrequencyOf(item) ? this.getFrequencyOf(item)
                    : inputBag.getFrequencyOf(item);
            int stillNeed = lowerFrequency - result.getFrequencyOf(item); // see if item is already added to the bag or
                                                                          // not

            while (stillNeed > 0) {
                result.add(item);
                stillNeed--;
            }
        }
        return result;
    }

    /**
     * Returns a bag with the contents from the other bag pulled out
     * 
     * @param bag to compare to the called bag
     * @return bag without inputBag items
     */
    public BagInterface<T> difference(BagInterface<T> inputBag) {
        T[] thisArray = this.toArray();

        ResizableArrayBag<T> result = new ResizableArrayBag<>();

        for (T item : thisArray) {
            if (inputBag.contains(item)) {
                int itemDifference = this.getFrequencyOf(item) - inputBag.getFrequencyOf(item);
                if (!result.contains(item)) { // check if item already in bag
                    while (itemDifference > 0) {
                        result.add(item);
                        itemDifference--;
                    }
                }
            } else {
                result.add(item);
            }
        }
        return result;
    }

    // Helper methods
    //
    //
    //
    /**
     * check integrity of the bag
     */
    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("ArrayBag Object is corrupt.");
        }
    }

    /**
     * gets index of an item (only used in implementation)
     * 
     * @param entry whose index is being sought
     * @return index of the entry
     */
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

    /**
     * removes an entry at a given index (only used in implementation)
     * 
     * @param givenIndex where entry should be removed
     * @return null or entry that was removed
     */
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

    /**
     * checks to see if bag needs to become bigger
     * 
     * @param capacity how big bag is
     */
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException(
                    "Attempt to create a bug whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    /**
     * double the capacity to make bag resizable
     */
    private void doubleCapacity() {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
        System.out.println("end");
    }

    // END helper methods

}