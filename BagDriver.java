public class BagDriver {
    public static void main(String[] args) {
        // Creations of bags containing names of basketball players and football players & List of names of each categories
        BagInterface<String> bBallPlayers = new ResizableArrayBag<>();
        BagInterface<String> fBallPlayers = new LinkedBag<>();
        String[] bBallPlayerList = {"Erick, Alice, John, John, John, Alex, Alex, Denis, Sadi"};
        String[] fBallPlayerList = {"Alice, John, Alex, Alex, Alex, Denis, Denis, Tara, Daria, Mori"};
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
        //Check for union between two bags
        System.out.println ("Players that plays either basketball or football: " + bBallPlayers.union(fBallPlayers).toArray().toString());
        //Check for intersection between two bags
        System.out.println ("Players that plays both basketball and football: " + bBallPlayers.intersection(fBallPlayers).toArray().toString());
        //Check for difference between two bags, both ways
        System.out.println ("Players who plays basketball but not football: " + bBallPlayers.difference(fBallPlayers).toArray().toString());
        System.out.println ("Players who plays football but not basketball: " + fBallPlayers.difference(bBallPlayers).toArray().toString());
    } //end main
}