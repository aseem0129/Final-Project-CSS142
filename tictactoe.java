import java.util.*;
import java.util.List;
public class tictactoe
{
        //arraylist objects for all methods to use
        ArrayList<Integer> player = new ArrayList<Integer>();
        ArrayList<Integer> cpu = new ArrayList<Integer>();
            
    public void Game () {
           tictactoe game = new tictactoe();  //creates object of tictactoe
           gameBoard();
    }
   
    public void gameBoard () {
           Scanner scn = new Scanner (System.in);
           System.out.println("Gameboard:");
           String [][] gameSlots = {{"1", "|", "2","|", "3"},
                                    {"-", "+", "-","+", "-"},
                                    {"4", "|", "5","|", "6"},
                                    {"-", "+", "-","+", "-"},
                                    {"7", "|", "8","|", "9"}};
            
            //gameplay methods 
            while (true) {
                Scanner scan = new Scanner(System.in);
                printBoard(gameSlots);
                System.out.println("Enter a number to place");
                int slot = scn.nextInt();
                while (player.contains(slot) || (cpu.contains(slot))){
                    System.out.println("Slot taken");
                    slot = scan.nextInt();
                }
                numberPlacer(gameSlots, slot, "Player");
                System.out.println("");
                Random randNum = new Random();
                int cpuSlot = randNum.nextInt(9) + 1;
                while (player.contains(cpuSlot) || (cpu.contains(cpuSlot))){
                    cpuSlot = randNum.nextInt(9) + 1;
                }
                numberPlacer(gameSlots, cpuSlot, "CPU");
                System.out.println("");
                System.out.println("");
                System.out.println(winner());
            }
    }
    
    //methods for the instructions of the gaame
    public void introToGame () {
        System.out.println("Instructions:");
        System.out.println("");
        System.out.println("1. 3 by 3 tic tac toe game");
        System.out.println("");
        System.out.println("2. Enter a number (1-9)");
        System.out.println("");
        System.out.println("3. Player is x, CPU is o");
    }
   
    
    public void numberPlacer (String[][] gameSlots, int slot, String user) {
            
        String letter = " ";
        if (user.equals("Player")) {
                letter = "X";
                player.add(slot);
        }
        else if (user.equals("CPU")) {
                letter = "O";
                cpu.add(slot);
        }
        
        //every possible case for where you can place a  piece
        switch (slot) {
            case 1: gameSlots[0][0] = letter;
                break;
            case 2: gameSlots[0][2] = letter;
                break;
            case 3: gameSlots[0][4] = letter;
                break;
            case 4: gameSlots[2][0] = letter;
                break;
            case 5: gameSlots[2][2] = letter;
                break;
            case 6: gameSlots[2][4] = letter;
                break;
            case 7: gameSlots[4][0] = letter;
                break;
            case 8: gameSlots[4][2] = letter;
                break;
            case 9: gameSlots[4][4] = letter;
            default:
                break;
            }
        printBoard(gameSlots);
    }
    
    //method to display the gameBoard
    public void printBoard (String[][] gameSlots) {
        for (String [] rows: gameSlots) {
            for (String a : rows) {
                    System.out.print(a);
                    }
            System.out.println("");
        }
    }
        
    //method to find every case for a win
        public String winner () {
        
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List across1 = Arrays.asList(1, 5, 9);
        List across2 = Arrays.asList(7, 5, 3);
            
        List<List> winnerCheck = new ArrayList<List>();
            
        winnerCheck.add(topRow);
        winnerCheck.add(midRow);
        winnerCheck.add(botRow);
        winnerCheck.add(leftCol);
        winnerCheck.add(midCol);
        winnerCheck.add(rightCol);
        winnerCheck.add(across1);
        winnerCheck.add(across2);
            
            for (List list: winnerCheck) {
                if (player.containsAll(list)) {
                    return "You win!";
            }
                else if (cpu.containsAll(list)) {
                    return "CPU wins";
            }
        }
        
        return "";
    }
}
