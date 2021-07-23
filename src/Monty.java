import java.util.Scanner;

public class Monty{

    /**
     * Number of doors
     */
    private int numDoors;

    /**
     * Backend of doors, contains booleans to denote winning or not
     */
    private boolean[] backDoors;

    /**
     * Frontend of doors, contains Strings showing players the contents of the doors
     */
    private String[] frontDoors;

    /**
     * Winning door
     */
    private int winningDoor;

    /**
     * Door the player chooses
     **/
    private int playerChoice;

    Scanner scan = new Scanner(System.in);

    /**
     * Initializes values of the game, generates doors and picks winning doors
     * @param numDoors number of doors to play
     */
    public Monty(int numDoors){
        this.numDoors = numDoors;
        backDoors = new boolean[numDoors];
        frontDoors = new String[numDoors];
        winningDoor = generateRandNum(-1);
    }

    /**
     * Gets player's first door choice
     * @return
     */
//    public int getFirstChoice(){
//        System.out.print("Pick a door from 0 - " + (numDoors-1) + ": ");
//        int choice = getUserInput();
//        return choice;
//    }

    /**
     * Generates random door index, excluding specified doors
     * Used for choosing winning door and if needed, random door to be reveal
     * @param notIncludeNum door not to reveal
     * @return door index
     */
    public int generateRandNum(int notIncludeNum){
        int randNum = (int)(Math.random()*numDoors);
        while (randNum == notIncludeNum){
            randNum = generateRandNum(randNum);
        }
        return randNum;
    }

    /**
     * Reveals doors depending on player's choice
     * If the player chose the winning door, then a random door has to be chosen
     * else the winning door is the one not to be revealed.
     * @param playerDoor
     */
    public int revealDoors(int playerDoor){

        //If player did not choose winning door...
        if (playerDoor != winningDoor) {
            for (int i = 0; i < numDoors; i++) {
                //...set chosen door to " X "...
                if (i == playerDoor) {
                    frontDoors[i] = " X ";
                //...and all other doors except the winning door to "Goat"...
                } else if (i != winningDoor) {
                    frontDoors[i] = "Goat";
                }
            }
            //...return the winning door to be switched
            return winningDoor;

        //If player did pick winning door...
        }else{
            //...generate random door to not be reveal, as long as it's not the winning door...
            int randomDoor = generateRandNum(winningDoor);
            for (int i = 0; i < numDoors; i++) {
                if (i == winningDoor) {
                    frontDoors[i] = " X ";
                } else if (i != randomDoor) {
                    frontDoors[i] = "Goat";
                }
            }
            //...return random door to be switched
            return randomDoor;
        }
    }

    /**
     * Asks player if they want to switch doors
     * If yes, then player's choice will change to switch-door
     * @param ifSwitchNum switch-door index
     */
    public void wantSwitch(int ifSwitchNum, int choice) {
        if (choice == 1){
            playerChoice = ifSwitchNum;
            //System.out.println("[You switch to Door " + playerChoice + "]");
        }
    }

    /**
     * Returns if player's final choice is the winning door
     * @return true if equal, false if not
     */
    public void revealFinalDoor(){
        for (int i = 0; i < numDoors; i++) {
            if (i == winningDoor){
                frontDoors[i] = "Money";
            }else{
                frontDoors[i] = "Goat";
            }
        }
    }

    /**
     * Determines if player won
     * @return true if player's choice is the winning door, false if not
     */
    public String isWin(){
        boolean win = playerChoice == winningDoor;
        if (win)
            return "You won the money!";
        else
            return "At least you got a goat?";
    }

    public boolean isBotWin(){
        return playerChoice == winningDoor;
    }

    public String toString(){

        String output = "\n Doors \n";
        for (String door: frontDoors){
            output += "[" + door + "] ";
        }
        output += "\n";

        return output;
    }

    /**
     * Gets the player's choice
     * @return player's choice as an integer
     */
    public int getUserInput(){
        int input = scan.nextInt();
        return input;
    }

}