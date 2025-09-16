import java.util.Scanner;

public class LastBiscuit {
    //submitting this again as it can be improved by adding more constants and string formatting
    // Initial barrel values
    public static final int INITIAL_BISCUITS_BARREL1 = 6;
    public static final int INITIAL_BISCUITS_BARREL2 = 8;

    // Constants for strings
    public static final String BISCUITS_LEFT_BARREL_MESSAGE = "Biscuits Left - Barrel %d: %d";
    public static final String BARREL_CHOICE_MESSAGE = "Choose a barrel: barrel1 (one), "
            +"barrel2 (two), or both (both), or skip turn (skip)? ";
    public static final String ERROR_INTEGER_MESSAGE = "Please input an integer: ";
    public static final String ERROR_NON_LEGAL_INTEGER_MESSAGE = "Sorry, that's not a "
           + "legal number of biscuits for that/those barrel(s)";
    public static final String NUMBER_OF_BISCUITS_MESSAGE = "How many biscuits are you taking? ";
    public static final String SKIP_USED_MESSAGE = "Sorry you've used your skip.";
    public static final String PLAYER_TURN_MESSAGE = "Player Turn: %d";
    public static final String WINNER_MESSAGE = "Winner is player %d";
    public static final String GAME_ERROR_MESSAGE ="Game error";

    public static final String BARREL_ONE_OPTION = "one";
    public static final String BARREL_TWO_OPTION = "two";
    public static final String BARREL_BOTH_OPTION = "both";
    public static final String BARREL_SKIP_OPTION = "skip";

    //ignore this line as it's for showing checkstyle errors
    @SuppressWarnings({"checkstyle:LocalFinalVariableName", "checkstyle:ParenPad"})
    public static void main(String[] args) {
        Scanner readKeyboard = new Scanner(System.in);

        int numBiscuitsBarrel1 = INITIAL_BISCUITS_BARREL1;
        int numBiscuitsBarrel2 = INITIAL_BISCUITS_BARREL2;

        // declaring variables so they are in the scope
        int playerCount = 0;
        int playerNum = 0;

        //boolean variables to track whether the player has used there skip
        boolean playerOneSkipped = false;
        boolean playerTwoSkipped = false;

        do {

            //checks whether the loop counter is even to track player number
            if ((playerCount % 2 == 0)) {
                playerNum = 1;
            } else if ((playerCount % 2 == 1)) {
                playerNum = 2;
            }
            //adds 1 each time the loop is run to keep track of the player
            playerCount++;
            //format the player message
            String playerMessage = String.format(PLAYER_TURN_MESSAGE, playerNum);

            //format string for the barrel message
            String barrelMessageOne = String.format(BISCUITS_LEFT_BARREL_MESSAGE,
                    1,  numBiscuitsBarrel1);
            String barrelMessageTwo = String.format(BISCUITS_LEFT_BARREL_MESSAGE,
                    2, numBiscuitsBarrel2);

            System.out.println(barrelMessageOne);
            System.out.println(barrelMessageTwo);
            System.out.println(playerMessage);
            /*
            boolean variables which are declared before the loop
            to keep track of invalid inputs and whether the player is trying to
            skip more than once
             */
            boolean validNum;
            boolean invalidSkip;
            do {
                //resets when it's the next players turn
                validNum = true;
                invalidSkip = false;

                System.out.print(BARREL_CHOICE_MESSAGE);
                String barrelSelection = readKeyboard.nextLine();

                //checks whether the user has entered a valid barrel type
                while (!barrelSelection.equalsIgnoreCase(BARREL_ONE_OPTION)
                        && !barrelSelection.equalsIgnoreCase(BARREL_TWO_OPTION)
                        && !barrelSelection.equalsIgnoreCase(BARREL_BOTH_OPTION)
                        && !barrelSelection.equalsIgnoreCase(BARREL_SKIP_OPTION)) {
                    System.out.print(BARREL_CHOICE_MESSAGE);
                    barrelSelection = readKeyboard.nextLine();
                }
                //switch statement to determine the users choice
                switch (barrelSelection) {
                    case BARREL_ONE_OPTION:
                        System.out.print(NUMBER_OF_BISCUITS_MESSAGE);
                        //checks whether the user has entered an integer
                        while (!readKeyboard.hasNextInt()) {
                            System.out.print(ERROR_INTEGER_MESSAGE);
                            readKeyboard.nextLine(); //discards invalid input
                        }
                        int takenBiscuits1 = readKeyboard.nextInt();
                        //checks whether the number entered is legal
                        if (takenBiscuits1 > 0 && takenBiscuits1 <= numBiscuitsBarrel1) {
                            numBiscuitsBarrel1 -= takenBiscuits1;
                        } else {
                            //if the number entered isn't valid set
                            // this too false to run this block of code again
                            validNum = false;
                            System.out.println(ERROR_NON_LEGAL_INTEGER_MESSAGE);
                        }
                        readKeyboard.nextLine();
                        break;
                    case BARREL_TWO_OPTION:
                        System.out.print(NUMBER_OF_BISCUITS_MESSAGE);
                        while (!readKeyboard.hasNextInt()) {
                            System.out.print(ERROR_INTEGER_MESSAGE);
                            readKeyboard.nextLine();
                        }
                        int takenBiscuits2 = readKeyboard.nextInt();

                        if (takenBiscuits2 > 0 && takenBiscuits2 <= numBiscuitsBarrel2) {
                            numBiscuitsBarrel2 -= takenBiscuits2;
                        } else {
                            validNum = false;
                            System.out.println(ERROR_NON_LEGAL_INTEGER_MESSAGE);
                        }

                        readKeyboard.nextLine();
                        break;

                    case BARREL_BOTH_OPTION:
                        System.out.print(NUMBER_OF_BISCUITS_MESSAGE);
                        while (!readKeyboard.hasNextInt()) {
                            System.out.print(ERROR_INTEGER_MESSAGE);
                            readKeyboard.nextLine();
                        }
                        int takenBiscuitsBoth = readKeyboard.nextInt();

                        if (takenBiscuitsBoth > 0 && takenBiscuitsBoth <= numBiscuitsBarrel1
                                && takenBiscuitsBoth <= numBiscuitsBarrel2) {
                            numBiscuitsBarrel1 -= takenBiscuitsBoth;
                            numBiscuitsBarrel2 -= takenBiscuitsBoth;
                        } else {
                            validNum = false;
                            System.out.println(ERROR_NON_LEGAL_INTEGER_MESSAGE);
                        }

                        readKeyboard.nextLine();
                        break;
                    case BARREL_SKIP_OPTION:
                        //checking whether the player has used their skip
                        if (playerNum == 1 && !playerOneSkipped) {
                            playerOneSkipped = true;
                        } else if (playerNum == 2 && !playerTwoSkipped) {
                            playerTwoSkipped = true;
                        //repeat from line 52 if player has used there skip
                        } else {
                            System.out.println(SKIP_USED_MESSAGE);
                            invalidSkip = true;
                        }

                        break;
                    //game error messages displays if anything goes wrong with the program
                    default:
                        System.out.println(GAME_ERROR_MESSAGE);
                        break;
                }
                //while conditions to repeat do loops for validation and end of the game
            } while (!validNum || invalidSkip);
        } while (numBiscuitsBarrel1 > 0 || numBiscuitsBarrel2 > 0);

        //format string for the (new) barrel message & the won player message/print the messages
        String barrelMessageOne = String.format(BISCUITS_LEFT_BARREL_MESSAGE,
                1,  numBiscuitsBarrel1);
        String barrelMessageTwo = String.format(BISCUITS_LEFT_BARREL_MESSAGE,
                2, numBiscuitsBarrel2);
        System.out.println(barrelMessageOne);
        System.out.println(barrelMessageTwo);
        //print the won player
        String wonPlayerMessage = String.format(WINNER_MESSAGE, playerNum);
        System.out.println(wonPlayerMessage);
    }
}
