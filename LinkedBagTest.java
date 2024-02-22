
import java.util.*;

public class LinkedBagTest {
    public static void main(String[] args) {
        LinkedBag<Integer> bag = new LinkedBag<>();
        System.out.println("Bag: " + bag);

        // Add elements
        bag.add("Apple");
        bag.add("Orange");
        bag.add("Grape");

        // Get current size
        System.out.println("Current Size: " + bag.getCurrentSize());

        // Check if empty
        System.out.println("Is Empty: " + bag.isEmpty());

        // Check if full (always false for LinkedBag)
        System.out.println("Is Full: " + bag.isFull());

        // Remove element
        System.out.println("Remove: " + bag.remove());
        System.out.println("After Removing: " + bag);

        // Check frequency
        System.out.println("Frequency of Apple: " + bag.getFrequencyOf("Apple"));

        // Check if contains
        System.out.println("Contains Orange: " + bag.contains("Orange"));

        // Union with another bag
        LinkedBag<Integer> anotherBag = new LinkedBag<>();
        anotherBag.add("Banana");
        anotherBag.add("Orange");
        anotherBag.add("Apple");
        System.out.println("Union with Another Bag: " + bag.union(anotherBag));

        // Intersection with another bag
        System.out.println("Intersection with Another Bag: " + bag.intersection(anotherBag));

        // Difference with another bag
        System.out.println("Difference with Another Bag: " + bag.difference(anotherBag));
    }
}