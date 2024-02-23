// package oldTests;
// import java.util.Arrays;

// import BagInterface;
// import LinkedBag;

// public class OldLinkedBagTest {
//     public static void main(String[] args) {
//         // test creating one bag
//         BagInterface<String> bag1 = new LinkedBag<>();
//         BagInterface<String> bag2 = new LinkedBag<>(); 

//         // tests before adding to bag
//         //
//         // getCurrentSize()
//         System.out.println("\n\nTESTS BEFORE ADDING TO BAGS:\n");
//         System.out.println("bag1.getCurrentSize(); = " + bag1.getCurrentSize());
//         System.out.println("bag2.getCurrentSize(); = " + bag2.getCurrentSize());

//         // isFull()
//         System.out.println();
//         System.out.println("bag1.isFull(); = " + bag1.isFull());
//         System.out.println("bag2.isFull(); = " + bag2.isFull());

//         // isEmpty()
//         System.out.println();
//         System.out.println("bag1.isEmpty(); = " + bag1.isEmpty());
//         System.out.println("bag2.isEmpty(); = " + bag2.isEmpty());

//         // add items to bags
//         bag1.add("a");
//         bag1.add("b");
//         bag1.add("c");

//         bag2.add("b");
//         bag2.add("b");
//         bag2.add("d");
//         bag2.add("e");

//         // tests after adding to bag
//         //
//         // getCurrentSize()
//         System.out.println("\n\nTESTS AFTER ADDING TO BAGS:\n");
//         System.out.println("bag1.getCurrentSize(); = " + bag1.getCurrentSize());
//         System.out.println("bag2.getCurrentSize(); = " + bag2.getCurrentSize());

//         // isFull()
//         System.out.println();
//         System.out.println("bag1.isFull(); = " + bag1.isFull());
//         System.out.println("bag2.isFull(); = " + bag2.isFull());

//         // isEmpty()
//         System.out.println();
//         System.out.println("bag1.isEmpty(); = " + bag1.isEmpty());
//         System.out.println("bag2.isEmpty(); = " + bag2.isEmpty());

//         // remove()
//         System.out.println();
//         System.out.println("bag1.remove(); = " + bag1.remove());
//         System.out.println("bag2.remove(); = " + bag2.remove());

//         // remove(T entry)
//         System.out.println();
//         System.out.println("bag1.remove(\"a\"); = " + bag1.remove("a"));
//         System.out.println("bag2.remove(\"b\"); = " + bag2.remove("b"));

//         // recheck current size
//         System.out.println();
//         System.out.println("bag1.getCurrentSize(); = " + bag1.getCurrentSize());
//         System.out.println("bag2.getCurrentSize(); = " + bag2.getCurrentSize());

//         // clear()
//         System.out.println();
//         System.out.println("bag1.clear();");
//         System.out.println("bag2.clear();");
//         bag1.clear();
//         bag2.clear();

//         // rechcked size after clearing
//         System.out.println();
//         System.out.println("bag1.getCurrentSize(); = " + bag1.getCurrentSize());
//         System.out.println("bag2.getCurrentSize(); = " + bag2.getCurrentSize());

//         // re-add items to bags
//         System.out.println("\n\nRE-ADDING ITEMS TO BAGS\n");
//         bag1.add("a");
//         bag1.add("b");
//         bag1.add("c");

//         bag2.add("b");
//         bag2.add("b");
//         bag2.add("d");
//         bag2.add("e");

//         // getFrequencyOf(T entry)
//         System.out.println();
//         System.out.println("bag1.getFrequencyOf(\"a\"); = " + bag1.getFrequencyOf("a"));
//         System.out.println("bag2.getFrequencyOf(\"b\"); = " + bag2.getFrequencyOf("b"));

//         // contains(T entry)
//         System.out.println();
//         System.out.println("bag1.contains(\"a\"); = " + bag1.contains("a"));
//         System.out.println("bag2.contains(\"z\"); = " + bag2.contains("z"));

//         // toArray() then print
//         System.out.println();
//         // System.out.println("bag1.toArray(); = " + bag1.toArray());
//         // System.out.println("bag2.toArray(); = " + bag2.toArray());
//         System.out.println("bag1.toArray(); = " + Arrays.toString(bag1.toArray()));
//         System.out.println("bag2.toArray(); = " + Arrays.toString(bag2.toArray()));
//         // NOTE: original bags are unaffected by toArray()

//         // TESTING union, intersection, difference
//         System.out.println("\n\nTESTING UNION, INTERSECTION, DIFFERENCE\n");

//         // union(BagInterface<T> inputBag)
//         BagInterface<String> unionBag = bag1.union(bag2);
//         System.out.println();
//         System.out.println("bag1.union(bag2); = " + Arrays.toString(unionBag.toArray()));

//         // intersection(BagInterface<T> inputBag)
//         BagInterface<String> intersectionBag = bag1.intersection(bag2);
//         System.out.println();
//         System.out.println("bag1.intersection(bag2); = " + Arrays.toString(intersectionBag.toArray()));

//         // difference(BagInterface<T> inputBag)
//         BagInterface<String> differenceBag1 = bag1.difference(bag2);
//         BagInterface<String> differenceBag2 = bag2.difference(bag1);
//         System.out.println();
//         System.out.println("bag1.difference(bag2); = " + Arrays.toString(differenceBag1.toArray()));
//         System.out.println("bag2.difference(bag1); = " + Arrays.toString(differenceBag2.toArray()));
//         System.out.println();

//     }
// }

