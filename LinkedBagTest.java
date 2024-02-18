import org.junit.jupiter.api.BeforeAll;

public class LinkedBagTest {
    @BeforeAll
        public static <T> void AddContents (BagInterface<T> bag, T[] contents){
            //bag/contents null check
            if (bag == null || contents == null){
                System.out.println("There's no bag/contents");
                return;
            } //End if
            //Check if the bag is already filled
            if (!bag.isEmpty()){
                System.out.println("Bag already filled");
                return;    
            } //End if
            //Adding all content of array to bag
            for (T item: contents){
                if (!bag.add(item)){
                    System.out.println("Unable to add" + item.toString() + "to bag");
                } //End if
            } //End for
            //Print out contents of bag
            System.out.println("Contents of LinkedBag: " + bag.toArray().toString());
    } //End AddContents
    
} //End of LinkedBagTest