
import java.util.*;
public class Level1 {
    public static void main(String[] args) {

        Scanner readKeyboard = new Scanner(System.in);

        int numBiscuitsBarrel1 = 6;
        int numBiscuitsBarrel2 = 8;
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
            System.out.println("Choose a barrel: barrel (one), barrel (two), or both (both), or skip turn(skip)? ");
            String barrelSelection = readKeyboard.nextLine();
            switch(barrelSelection){
                case "one":
                    System.out.println("How many biscuits are you taking?");
                    int takenBiscuits1 = readKeyboard.nextInt();
                    numBiscuitsBarrel1 -= takenBiscuits1;
                    readKeyboard.nextLine();
                    break;
                case "two":
                    System.out.println("How many biscuits are you taking?");
                    int takenBiscuits2 = readKeyboard.nextInt();
                    numBiscuitsBarrel2 -= takenBiscuits2;
                    readKeyboard.nextLine();
                    break;
                case "both":
                    System.out.println("How many biscuits are you taking?");
                    int takenBiscuitsBoth = readKeyboard.nextInt();
                    numBiscuitsBarrel1 -= takenBiscuitsBoth;
                    numBiscuitsBarrel2 -= takenBiscuitsBoth;
                    readKeyboard.nextLine();
                    break;
                default:
                    System.out.println("Invalid barrel selection");
            }

        }while(numBiscuitsBarrel1 >0 ||  numBiscuitsBarrel2 >0 );


        System.out.println("Player " + playerNum + " won!");
    }
}