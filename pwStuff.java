import java.util.Scanner;
import java.io.*;
import java.io.IOException;

/*
 * File io
 * Multiple classes
 * Functional decompostion
 * 1d arrays
 * 2d arrays
 * branching
 * loops
 */
public class pwStuff {
    public static void main (String[] args) {
        pwStuff practice = new pwStuff();  //makes a new object of class pwStuff
        tictactoe game = new tictactoe();
        
        //try catch statement for method pwAsker
        try
        {
            practice.pwAsker();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        
    }
    
    /*
     * This method is used for the user to create 
     * a password if they don't already have one or
     * create a new one if they forgot their password
     */
    public String Password () throws IOException {
        
        System.out.println("Please create a password");
        
        Scanner sc = new Scanner (System.in);
        String password = sc.nextLine();
        
        File file = new File ("Passwordkeeper.txt");  //makes new file
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        
        pw.print(password);  //stores password in file for future use
        
        pw.close();  //closes the file to be able to write to it
        
        System.out.println("This is the password you");
        System.out.println("will use to access the games");
        System.out.println("");
        System.out.println("Please close the program and"); 
        System.out.println("enter this password");
        System.out.println("to continue");
        
        return password;
        
    }
    
    /*
     * This method creates objects of every class that
     * will be used. A general overview of this method
     * is that it asks for the password as input
     * and checks if it is right or wrong. 
     */
    public String pwAsker () throws IOException {
        pwStuff asker = new pwStuff();
        tictactoe game1 = new tictactoe();
        Scanner sc = new Scanner(System.in);
        asker.instructions();
        String ask = sc.nextLine();
        String pwInput;
        
        File file = new File("Passwordkeeper.txt");
        if (ask.equalsIgnoreCase("yes")) {
            System.out.println("What is the password you created?");
            
            pwInput = sc.nextLine();
            sc = new Scanner(file);
            
            String [] pwChecker = {pwInput, sc.nextLine()};  //array to store user input and file password
            
            //compares both elements in array pwChecker
            if (pwChecker[0].equals(pwChecker[1])) {
                asker.options();
                }
                else {
                Scanner scan = new Scanner (System.in);
                
                //if the password is not correct this
                //for loop will initiate. Gives the
                //user 3 tries to type the correct
                //password before closing the program
                for (int i = 3; i > 0;) {
                    System.out.println("Password is not correct");
                    System.out.println(i + " more tries");
                    pwInput = scan.nextLine();
                    if (pwInput.equals(pwChecker[1])) {
                        asker.options(); //displays game options if user types correct password
                        break;
                    }
                    else {
                        i--;
                    }
                    if (pwInput != pwChecker[1]) { 
                        System.out.println("Please try again");
                        
                    }
                }
        
            }
        }
        else {
            asker.Password();
        }
        return ask;
    }
    
    /*
     * This method is simply to 
     * give instructions to the user 
     * about the program
     */
    public void instructions () {
        Scanner scn = new Scanner(System.in);
        System.out.println("This program has two game options");
        System.out.println("");
        System.out.println("To access these options, you");
        System.out.println("need to create a password if");
        System.out.println("you haven't already");
        System.out.println("");
        System.out.println("Have you created a password? (yes/no)");
        System.out.println("(if this is your first time using");
        System.out.println("the program type no)");
    }
    
    /*
    * Method to have the user choose
    * from to game options and pick
    * which game they would like to play
    * after they have accessed them by 
    * giving the correct password
    */
    public void options () throws IOException {
        Scanner scn = new Scanner (System.in);
        
        //creates an object of the games to use
        tictactoe game1 = new tictactoe();
        guessingGame game2 = new guessingGame();
        
        System.out.println("Game options: ");
        System.out.println("");
        System.out.println("Enter 1 for tic tac toe");
        System.out.println("Enter 2 for number guesser");
        
        String x = "1";
        String y = "2";
        String pickOption = scn.nextLine();
        String [] arrayOption = {x, y};
        
        if (pickOption.equals(arrayOption[0])) {
            game1.Game(); //to play the first game
        }
        else if (pickOption.equals(arrayOption[1])) {
            game2.gameTime();  //to play the second game
        }
        else {
            //if input is invalid
            System.out.println("Invalid input");
            System.out.println("Please enter 1 or 2");
            pickOption = scn.nextLine();
            
            if (pickOption.equals(arrayOption[0])) {
                game1.Game();
            }
            else if (pickOption.equals(arrayOption[1])) {
                game2.gameTime();
            }
        }
        
    }
}
        
        
    
    

    




