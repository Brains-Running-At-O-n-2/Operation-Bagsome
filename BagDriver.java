public class BagDriver {
    public static void main(String[] args) {
        // Creation of a LinkedBag and ResizableArrayBag and their contents to be added
        BagInterface<String> rArrayBag = new ResizableArrayBag<>();
        BagInterface<String> lBag = new LinkedBag<>();
        String[] rArrayBagContents = {"a", "b", "c"};
        String[] lBagContents = {"b", "b", "d", "e"};
    }
}