import java.util.Scanner;

public class MontyRunner {

    static Scanner scan = new Scanner(System.in);

    public static void main(String args[]){

        int doors = 3;

        //Creates a new Monty game of n doors
        Monty game = new Monty(doors);

        //Displays the doors...
        System.out.println(game);

        //...gets the player's first choice of door...
        System.out.print("Pick a door from 0 - " + (doors-1) + ": ");
        int firstChoice = getUserInput();

        //...reveals first round doors using first choice
        //...and returns door to switch...
        int switchDoor = game.revealDoors(firstChoice);

        System.out.println(game);

        //...ask player if want to switch door, and switch if so...
        System.out.println("The other doors except one have been revealed!\nDo you want to switch?");
        System.out.print("0 for No, 1 for Yes: ");
        int switchChoice = getUserInput();
        game.wantSwitch(switchDoor,switchChoice);

        //...reveal the outcome
        game.revealFinalDoor();
        System.out.println(game);
        System.out.println(game.isWin());
        
    }

    /**
     * Gets the player's choice
     * @return player's choice as an integer
     */
    public static int getUserInput(){
        int input = scan.nextInt();
        return input;
    }

}
