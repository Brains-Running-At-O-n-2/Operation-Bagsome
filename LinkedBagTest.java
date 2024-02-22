
import java.util.*;

public class LinkedBagTest {
    public static void main(String[] args) {
        LinkedBag<String> bag1 = new LinkedBag<>();
        bag1.add("Apple");
        bag1.add("Apple");
        bag1.add("Orange");
        bag1.add("Banana");
        bag1.add("Banana");
        bag1.add("Banana");
        bag1.add("Grapes");
        bag1.add("Grapes");
        bag1.add("Grapes");

        LinkedBag<String> bag2 = new LinkedBag<>();
        bag2.add("Apple");
        bag2.add("Apple");
        bag2.add("Orange");
        bag2.add("Orange");
        bag2.add("Grapes");

        BagInterface<String> unionResult = bag1.union(bag2);
        System.out.println("Union Result: " + Arrays.toString(unionResult.toArray()));

        BagInterface<String> intersectionResult = bag1.intersection(bag2);
        System.out.println("Intersection Result: " + Arrays.toString(intersectionResult.toArray()));

        BagInterface<String> differenceResult = bag1.difference(bag2);
        System.out.println("Difference Result: " + Arrays.toString(differenceResult.toArray()));
    }
}