public class LinkedBag<T> implements BagInterface<T> {
    private Node<T> firstNode;
    int numberOfEntries; 

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries<=0);
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
        if (firstNode != null){
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
        while ((counter < numberOfEntries) && currentNode != null){
            if (entry.equals(currentNode.getData())){
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    @Override
    public boolean remove(T entry) {
        
        return false;
    }

    @Override
    public boolean contains(T entry) {
        Node currentNode = firstNode;
        boolean found = false;
        while (!found && currentNode != null){
            if (entry.equals(currentNode)){
                found = true;
            }
            else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found; 
    }
    
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && currentNode != null){
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> inputBag) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> inputBag) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> inputBag) {
        // TODO Auto-generated method stub
        return null;
    }
}