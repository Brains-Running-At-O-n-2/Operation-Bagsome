public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T dataPortion){
        this.data = dataPortion;
        this.next = null; 
    }

    public Node(T dataPortion, Node<T> nextNode){
        this.data = dataPortion;
        this.next = nextNode; 
    }

    public T getData(){
        return data;
    }

    public void setData(T newData){
        this.data = newData;
    }

    public Node<T> getNextNode(){
        return this.next;
    }

    public void setNextNode(Node<T> nextNode){
        this.next = nextNode; 
    }
}
