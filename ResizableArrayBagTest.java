import org.junit.*;

public class ResizableArrayBagTest {
    @Test
    public void ResizArrTest() {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();

        // tests before adding to bag
        //
        // getCurrentSize()
        Assert.assertEquals(0, bag1.getCurrentSize()); // default bag size is 0
        Assert.assertEquals(0, bag2.getCurrentSize()); // default bag size is 0

        // isFull()
        Assert.assertFalse(bag1.isFull());
        Assert.assertFalse(bag1.isFull());
    }
}
