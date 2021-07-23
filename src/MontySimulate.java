public class MontySimulate {

    public static void main(String args[]){

        int numWins = 0;
        int numTrials = 0;

        for (int i = 0; i < 100; i++) {

            numTrials++;

            String log = "";

            int doors = 4;
            //Creates a new Monty game of n doors
            Monty game = new Monty(doors);

            //...gets the player's first choice of door...
            int firstChoice = (int) (Math.random() * doors);
            //...and returns door to switch...
            int switchDoor = game.revealDoors(firstChoice);

            //...ask player if want to switch door, and switch if so...
           /* int switchChoice = (int) (Math.random() * 2);
            log += ", Switch Choice: " + switchChoice;*/

            game.wantSwitch(switchDoor, 1);

            boolean win = game.isBotWin();

            if(win)
                numWins++;

        }

        System.out.println("Win Ratio: " + numWins/(double)numTrials);

    }
}

