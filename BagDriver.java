import java.util.Arrays;

public class BagDriver {
    public static void main(String[] args) {
        // Creations of bags containing names of basketball players and football players & List of names of each categories
        BagInterface<String> bBallPlayers = new ResizableArrayBag<>();
        BagInterface<String> fBallPlayers = new LinkedBag<>();
        String[] bBallPlayerList = {"Erick", "Alice", "John", "John", "John", "Alex", "Alex", "Denis", "Sadi"};
        String[] fBallPlayerList = {"Alice", "John", "Alex", "Alex", "Alex", "Denis", "Denis", "Tara", "Daria", "Mori"};
        //Adding contents to their respective bags
        for (String sb: bBallPlayerList){
            if (!bBallPlayers.add(sb)){
                System.out.println ("Unable to add " + sb + " to ResizableArrayBag");
            } //end if
        } //end for
        for (String sf: fBallPlayerList){
            if (!fBallPlayers.add(sf)){
                System.out.println ("Unable to add " + sf + " to LinkedBag");
            } //end if
        } //end for
        //Verifying contents of bag:
        System.out.println("Players that plays basketball: " + Arrays.toString(bBallPlayers.toArray()));
        System.out.println("Players that plays football: " + Arrays.toString(fBallPlayers.toArray()));
        //Check for union between two bags
        System.out.println ("Players that plays either basketball or football: " + Arrays.toString(bBallPlayers.union(fBallPlayers).toArray()));
        //Check for intersection between two bags
        System.out.println ("Players that plays both basketball and football: " + Arrays.toString(bBallPlayers.intersection(fBallPlayers).toArray()));
        //Check for difference between two bags, both ways
        System.out.println ("Players who plays basketball but not football: " + Arrays.toString(bBallPlayers.difference(fBallPlayers).toArray()));
        System.out.println ("Players who plays football but not basketball: " + Arrays.toString(fBallPlayers.difference(bBallPlayers).toArray()));
    } //end main
}