import org.junit.*;

public class LinkedBagTest {

    // tests for getCurrentSize() and add()
    @Test
    public void bagSizeShouldBe2AfterAdding2Items() {
        BagInterface<String> bag = new LinkedBag<>();
        // add the two items to the bag
        bag.add("a");
        bag.add("b");
        Assert.assertEquals(2, bag.getCurrentSize());
    }

    @Test
    public void bagSizeShouldBe5AfterAdding5Items() {
        BagInterface<Double> bag = new LinkedBag<>();
        // add the two items to the bag
        bag.add(1.5);
        bag.add(2.2);
        bag.add(3.9);
        bag.add(4.7);
        bag.add(5.0);
        Assert.assertEquals(5, bag.getCurrentSize());
    }

    @Test
    public void bagSizeShouldBe26AfterAdding26Items() { // adding beyond default capacity since bag is resizable
        BagInterface<Integer> bag = new LinkedBag<>();
        // add the 26 items to the bag
        for (int i = 0; i < 26; i++) {
            bag.add(i);
        }
        Assert.assertEquals(26, bag.getCurrentSize());
    }
    // end tests for getCurrentSize() and add()

    // tests for isFull()
    @Test
    public void shouldNotBeFullSinceNoItemsInBag() {
        BagInterface<String> bag = new LinkedBag<>();
        Assert.assertFalse(bag.isFull());
    }
    @Test
    public void shouldNotBeFullSinceNotAtMaxCapacity() {
        BagInterface<String> bag = new LinkedBag<>();
        // add the two items to the bag
        bag.add("a");
        bag.add("b");
        Assert.assertFalse(bag.isFull());
    }
    // end tests for isFull()

    // tests for isEmpty()
    @Test
    public void shouldBeTrueSinceEmpty() {
        // new bag has nothing in it
        BagInterface<String> bag = new LinkedBag<>();
        Assert.assertTrue(bag.isEmpty());
    }

    @Test
    public void shouldBeFalseSinceNotEmpty() {
        BagInterface<Integer> bag = new LinkedBag<>();
        // add an item to the bag so it is not longer empty
        bag.add(1);
        Assert.assertFalse(bag.isEmpty());
    }
    // end tests for isEmpty()

    // tests for remove()
    @Test
    public void bagSizeShouldBe2AfterRemoving1ItemFromBagOf3() {
        BagInterface<String> bag = new LinkedBag<>();
        bag.add("one");
        bag.add("two");
        bag.add("three");
        bag.remove();
        Assert.assertEquals(2, bag.getCurrentSize());
    }

    @Test
    public void bagSizeShouldBe4AfterRemoving9ItemFromBagOf13() {
        BagInterface<Integer> bag = new LinkedBag<>();
        // add 13 items to the bag initially
        for (int i = 0; i < 13; i++) {
            bag.add(i);
        }
        // remove 9 items from bag
        for (int i = 0; i < 9; i++) {
            bag.remove();
        }

        Assert.assertEquals(4, bag.getCurrentSize());
    }
    // end tests for remove()

    // tests for remove(T entry) and contains(T entry) and getFrequencyOf(T entry)
    @Test
    public void bagShouldNotContain2AfterRemoving2() { // assume no duplicates for this scenario
        BagInterface<Integer> bag = new LinkedBag<>();
        // initialize bag with 30 numbers from 0-29
        for (int i = 0; i < 30; i++) {
            bag.add(i);
        }
        bag.remove(2);
        Assert.assertFalse(bag.contains(2));
    }

    @Test
    public void bagShouldContain6IfNotRemoved() {
        BagInterface<Integer> bag = new LinkedBag<>();
        // initialize bag with 30 numbers from 0-29
        for (int i = 0; i < 30; i++) {
            bag.add(i);
        }
        Assert.assertTrue(bag.contains(6));
    }

    @Test
    public void bagShouldContain3CopiesOfFiveAfterRemovingFive3Times() {
        BagInterface<String> bag = new LinkedBag<>();
        // add "Five" to bag 6 times
        for (int i = 0; i < 6; i++) {
            bag.add("Five");
        }
        // add copies of other items to bag
        for (int i = 0; i < 10; i++) {
            bag.add("NotFive");
        }
        // remove "Five" from bag 3 times
        for (int i = 0; i < 3; i++) {
            bag.remove("Five");
        }
        Assert.assertEquals(3, bag.getFrequencyOf("Five"));
    }
    // end tests for remove(T entry) and contains(T entry) and getFrequencyOf(T entry)

    // tests for clear()
    @Test
    public void bagSizeShouldBe0AfterClear() {
        BagInterface<String> bag = new LinkedBag<>();
        // initialize bag
        for(int i = 0; i < 5; i++) {
            bag.add("Something " + i);
        }
        bag.clear();
        Assert.assertEquals(0, bag.getCurrentSize());
    }

    @Test
    public void bagSizeShouldBe5AfterClearingThenAdding5Items() {
        BagInterface<Integer> bag = new LinkedBag<>();
        // initialize bag with items 
        for (int i = 0; i < 20; i++) {
            bag.add(i);
        }
        bag.clear();
        // add 5 items back to bag
        for (int i = 0; i < 5; i++) {
            bag.add(i);
        }
        Assert.assertEquals(5, bag.getCurrentSize());
    }
    // end tests for clear()

    // tests for toArray()
    @Test
    public void integerArraysShouldBeEqual() {
        BagInterface<Integer> bag = new LinkedBag<>();
        Integer[] expected = {3, 2, 1};
        // initialize bag with 1, 2, 3
        for(int i = 1; i <= 3; i++) {
            bag.add(i);
        }
        Assert.assertArrayEquals(expected, bag.toArray());
    }

    @Test
    public void doubleArraysShouldBeEqual() {
        BagInterface<Double> bag = new LinkedBag<>();
        Double[] expected = {2.0, 2.0, 3.5, 4.7};
        // initialize bag with 4.7, 3.5, 2.0, 2.0 (after toArray items will be reversed since adding new item to linkedBag adds to start)
        bag.add(4.7);
        bag.add(3.5);
        bag.add(2.0);
        bag.add(2.0);
        Assert.assertArrayEquals(expected, bag.toArray());
    }
    // end tests for toArray()

    // tests for union()
    @Test
    public void shouldBeBagWithAllItemsFromBag1AndBag2Combined() {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bagExpected = new LinkedBag<>();
        // initialize bags
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        bagExpected.add("c");
        bagExpected.add("b");
        bagExpected.add("a");
        bagExpected.add("e");
        bagExpected.add("d");
        bagExpected.add("b");
        bagExpected.add("b");
        
        Assert.assertArrayEquals(bagExpected.toArray(), bag1.union(bag2).toArray());
    }
    // end tests for union()

    // tests for intersection()
    @Test
    public void shouldBeBagWithCommonItemB() {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bagExpected = new LinkedBag<>();
        // initialize bags
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        bagExpected.add("b");
        Assert.assertArrayEquals(bagExpected.toArray(), bag1.intersection(bag2).toArray());
    }
    // end tests for intersection()

    // tests for intersection()
    @Test
    public void bag1DifferenceBag2() {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bagExpected = new LinkedBag<>();
        // initialize bags
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        bagExpected.add("c");
        bagExpected.add("a");
        Assert.assertArrayEquals(bagExpected.toArray(), bag1.difference(bag2).toArray());
    }

    @Test
    public void bag2DifferenceBag1() {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bagExpected = new LinkedBag<>();
        // initialize bags
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        bagExpected.add("e");
        bagExpected.add("d");
        bagExpected.add("b");
        Assert.assertArrayEquals(bagExpected.toArray(), bag2.difference(bag1).toArray());
    }
    // end tests for intersection()
    
}
