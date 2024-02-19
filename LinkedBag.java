public class LinkedBag<T> implements BagInterface<T> {
    private Node<T> firstNode;
    int numberOfEntries;

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries <= 0);
    }

    @Override
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<T>(newEntry);
        newNode.setNextNode(firstNode);

        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean isFull() {
        // Will never gets full
        return false;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T entry) {
        int frequency = 0;
        int counter = 0;
        Node<T> currentNode = firstNode;
        while ((counter < numberOfEntries) && currentNode != null) {
            if (entry.equals(currentNode.getData())) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while
        return currentNode;
    }

    @Override
    public boolean remove(T entry) {
        boolean result = false;
        Node<T> entryReference = getReferenceTo(entry);
        if (entryReference != null) {
            entryReference.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;

    }

    @Override
    public boolean contains(T entry) {
        Node<T> currentNode = firstNode;
        boolean found = false;
        while (!found && currentNode != null) {
            if (entry.equals(currentNode)) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && currentNode != null) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> inputBag) {
        LinkedBag<T> result = new LinkedBag<T>();

        for (T item : this.toArray()) {
            result.add(item);
        }
        for (T item : inputBag.toArray()) {
            result.add(item);
        }

        // while (!this.isEmpty()) {
        // unionBag.add(this.remove());
        // }
        // while (!inputBag.isEmpty()) {
        // unionBag.add(inputBag.remove());
        // }
        return result;
    }
    // worse/best: O(n+m)

    @Override
    public BagInterface<T> intersection(BagInterface<T> inputBag) {
        LinkedBag<T> intersectionBag = new LinkedBag<T>();
        while (!this.isEmpty()) {
            T entry = this.remove();
            if (inputBag.remove(entry)) {
                intersectionBag.add(entry);
            }
        }
        return intersectionBag;
    }
    // worse: O(nm)
    // best: O(n)

    @Override
    public BagInterface<T> difference(BagInterface<T> inputBag) {
        LinkedBag<T> differenceBag = new LinkedBag<T>();
        while (!this.isEmpty()) {
            T entry = this.remove();
            if (!inputBag.remove(entry)) {
                differenceBag.add(entry);
            }
        }
        return differenceBag;
    }
    // worse: O(nm)
    // best: O(n)
}