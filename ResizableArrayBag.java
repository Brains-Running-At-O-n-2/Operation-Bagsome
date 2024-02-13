import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T> {
    // private final T[] bag;
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    public ResizableArrayBag(int capcacity) {
        if (capcacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capcacity];
            bag = tempBag;
            this.numberOfEntries = 0;
            this.integrityOK = true;
        } else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    public boolean isFull() {
        return this.numberOfEntries == bag.length;
    }

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

    public boolean remove(T entry) {
        checkIntegrity();
        int index = getIndexOf(entry);
        T result = removeEntry(index);
        return entry.equals(result);
    }

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

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

    public boolean contains(T entry) {
        checkIntegrity();
        return getIndexOf(entry) > -1;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    // Bagsome methods (union, intersection, difference)
    


    // Helper methods
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
        if(capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bug whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    private void doubleCapacity() {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }
    // END helper methods

}