import java.util.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class guessingGame {
    
    /*
     * method to implement all
     * methods in this  class
     */
    public void gameTime() throws IOException {
        guessingGame gg = new guessingGame();
        gg.gameIntro();
        gg.Guess();
    }
    
    /*
     * Method that provides instructions
     * for the number guessing game
     */
    public void gameIntro() {
        System.out.println("NUMBER GUESSING GAME");
        System.out.println("");
        System.out.println("Instructions:");
        System.out.println("1. Computer will generate a number between");
        System.out.println("   0 and 40");
        System.out.println("");
        System.out.println("2. Keep guessing until you get the right number");
        System.out.println("");
        System.out.println("3. Program will tell you if your number is greater than");
        System.out.println("   or less than the correct number");
        System.out.println("");
        System.out.println("You have 7 attempts");
        System.out.println("");
        
    }
    
    /*
     * Method for the gameplay. Asks
     * user for a number and compares
     * to computer generated number
     */
    public void Guess () throws IOException{
        
        int x = 'y';
        while(x == 'y') {
            
            Scanner scn = new Scanner (System.in);
            Random randNum = new Random();  //declares new object of class Random
            int randomNum = randNum.nextInt(40);  //generates number between 0 and 40
            File file = new File ("Results.txt");  //makes new file
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            
            System.out.println("Begin by entering your first guess");
            Scanner scan = new Scanner (System.in);
            int guessNum = scan.nextInt();
            pw.println(guessNum);
            
            //compares the two numbers and prints message based
            //on comparison. Loop to run 7 times (7 attempts to guess 
            //right number)
            for (int i = 7; i > 0; i--) {
                if (guessNum > randomNum) {
                    System.out.println("Number is less than " + guessNum);
                    System.out.println(i + " attempts left");
                    guessNum = scan.nextInt();
                    pw.println(guessNum);
                }
                    else if (guessNum < randomNum) {
                    System.out.println("Number is greater than " + guessNum);
                    System.out.println(i + " attempts left");
                    guessNum = scan.nextInt();
                    pw.println(guessNum);
                }
                else if (guessNum == randomNum) {
                    System.out.println("");
                    System.out.println("CONGRATS! YOU GUESSED THE RIGHT NUMBER");
                    System.out.println("");
                    break;  //exits loop before 7 runs if number is guessed correctly
                }
        
            }
            pw.close();
            System.out.println("The number was " + randomNum);
            Scanner keyboard = new Scanner(System.in);
            System.out.println("");
            System.out.println("Your results have been written to Results.txt");
            System.out.println("Would you like to play again? (y/n)"); //runs method again if y
            x = keyboard.next().charAt(0);
            
            if (x == 'n') {
                System.out.println("Thanks for playing!!");  //if n, thanks the user
            }
    
            scn.close();
        }
    }
}