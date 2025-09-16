import java.util.*;
public class Level2 {
    public static void main(String[] args) {

        Scanner readKeyboard = new Scanner(System.in);

        final int INITIAL_BISCUITS_BARREL1 = 6;
        final int INITIAL_BISCUITS_BARREL2= 8;

        int numBiscuitsBarrel1 = INITIAL_BISCUITS_BARREL1;
        int numBiscuitsBarrel2 = INITIAL_BISCUITS_BARREL2;

        int playerCount=0;
        int playerNum=0;
        do{
            System.out.println("Biscuits Left - Barrel 1: " + numBiscuitsBarrel1);
            System.out.println("Biscuits Left - Barrel 2: " + numBiscuitsBarrel2);
            playerCount++;

            if((playerCount % 2 == 0 )){
                playerNum = 2;

            }else if((playerCount % 2 == 1 )){
                playerNum = 1;
            }

            System.out.println("Player Turn: " + playerNum);
            System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), or both (both), or skip turn (skip)? ");
            String barrelSelection = readKeyboard.nextLine();
            while(!barrelSelection.equalsIgnoreCase("one") && !barrelSelection.equalsIgnoreCase("two")
                    && !barrelSelection.equalsIgnoreCase("both")){
                System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), or both (both), or skip turn (skip)? ");
                barrelSelection = readKeyboard.nextLine();
            }


            switch(barrelSelection){
                case "one":
                    System.out.print("How many biscuits are you taking? ");
                    while(!readKeyboard.hasNextInt()){
                        System.out.print("Please input an integer: ");
                        readKeyboard.nextLine();
                    }
                    int takenBiscuits1 = readKeyboard.nextInt();

                    numBiscuitsBarrel1 -= takenBiscuits1;
                    readKeyboard.nextLine();
                    break;
                case "two":
                    System.out.print("How many biscuits are you taking? ");
                    while(!readKeyboard.hasNextInt()){
                        System.out.print("Please input an integer: ");
                        readKeyboard.nextLine();
                    }
                    int takenBiscuits2 = readKeyboard.nextInt();
                    numBiscuitsBarrel2 -= takenBiscuits2;
                    readKeyboard.nextLine();
                    break;
                case "both":
                    System.out.print("How many biscuits are you taking? ");
                    while(!readKeyboard.hasNextInt()){
                        System.out.print("Please input an integer: ");
                        readKeyboard.nextLine();
                    }
                    int takenBiscuitsBoth = readKeyboard.nextInt();
                    numBiscuitsBarrel1 -= takenBiscuitsBoth;
                    numBiscuitsBarrel2 -= takenBiscuitsBoth;
                    readKeyboard.nextLine();
                    break;
            }


        }while(numBiscuitsBarrel1 >0 ||  numBiscuitsBarrel2 >0 );

        System.out.println("Biscuits Left - Barrel 1: " + numBiscuitsBarrel1);
        System.out.println("Biscuits Left - Barrel 2: " + numBiscuitsBarrel2);

        System.out.println("Winner is player " + playerNum);
    }
}
