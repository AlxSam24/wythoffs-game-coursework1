import java.util.Scanner;

public class Level3 {

    public static final int INITIAL_BISCUITS_BARREL1 = 6;
    public static final int INITIAL_BISCUITS_BARREL2 = 8;


    @SuppressWarnings({"checkstyle:LocalFinalVariableName", "checkstyle:ParenPad"})
    public static void main(String[] args) {

        Scanner readKeyboard = new Scanner(System.in);

        int numBiscuitsBarrel1 = INITIAL_BISCUITS_BARREL1;
        int numBiscuitsBarrel2 = INITIAL_BISCUITS_BARREL2;

        int playerCount = 0;
        int playerNum = 0;

        do {
            System.out.println("Biscuits Left - Barrel 1: " + numBiscuitsBarrel1);
            System.out.println("Biscuits Left - Barrel 2: " + numBiscuitsBarrel2);
            playerCount++;

            if ((playerCount % 2 == 0)) {
                playerNum = 2;
            } else if ((playerCount % 2 == 1)) {
                playerNum = 1;
            }

            System.out.println("Player Turn: " + playerNum);

            boolean validNum = true;

            do {
                System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), ");
                System.out.print("or both (both), or skip turn (skip)? ");
                String barrelSelection = readKeyboard.nextLine();
                while (!barrelSelection.equalsIgnoreCase("one") && !barrelSelection.equalsIgnoreCase("two")
                        && !barrelSelection.equalsIgnoreCase("both")) {
                    System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), ");
                    System.out.print("or both (both), or skip turn (skip)? ");
                    barrelSelection = readKeyboard.nextLine();
                }

                switch (barrelSelection) {
                    case "one":
                        System.out.print("How many biscuits are you taking? ");
                        while (!readKeyboard.hasNextInt()) {
                            System.out.print("Please input an integer: ");
                            readKeyboard.nextLine();
                        }
                        int takenBiscuits1 = readKeyboard.nextInt();

                        if (takenBiscuits1 > 0 && takenBiscuits1 <= numBiscuitsBarrel1) {
                            validNum = true;
                            numBiscuitsBarrel1 -= takenBiscuits1;
                        } else {
                            validNum = false;
                            System.out.println("Sorry, that's not a legal number of biscuits for that/those barrel(s)");
                        }

                        readKeyboard.nextLine();
                        break;

                    case "two":
                        System.out.print("How many biscuits are you taking? ");
                        while (!readKeyboard.hasNextInt()) {
                            System.out.print("Please input an integer: ");
                            readKeyboard.nextLine();
                        }
                        int takenBiscuits2 = readKeyboard.nextInt();

                        if (takenBiscuits2 > 0 && takenBiscuits2 <= numBiscuitsBarrel2) {
                            validNum = true;
                            numBiscuitsBarrel2 -= takenBiscuits2;
                        } else {
                            validNum = false;
                            System.out.println("Sorry, that's not a legal number of biscuits for that/those barrel(s)");
                        }

                        readKeyboard.nextLine();
                        break;

                    case "both":
                        System.out.print("How many biscuits are you taking? ");
                        while (!readKeyboard.hasNextInt()) {
                            System.out.print("Please input an integer: ");
                            readKeyboard.nextLine();
                        }
                        int takenBiscuitsBoth = readKeyboard.nextInt();

                        if (takenBiscuitsBoth > 0 && takenBiscuitsBoth <= numBiscuitsBarrel1
                                && takenBiscuitsBoth <= numBiscuitsBarrel2) {
                            validNum = true;
                            numBiscuitsBarrel1 -= takenBiscuitsBoth;
                            numBiscuitsBarrel2 -= takenBiscuitsBoth;
                        } else {
                            validNum = false;
                            System.out.println("Sorry, that's not a legal number of biscuits for that/those barrel(s)");
                        }

                        readKeyboard.nextLine();
                        break;

                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } while (!validNum);

        } while (numBiscuitsBarrel1 > 0 || numBiscuitsBarrel2 > 0);

        System.out.println("Biscuits Left - Barrel 1: " + numBiscuitsBarrel1);
        System.out.println("Biscuits Left - Barrel 2: " + numBiscuitsBarrel2);

        System.out.println("Winner is player " + playerNum);
    }
}
