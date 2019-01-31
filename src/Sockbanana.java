import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sockbanana {
    public static void main(String[] args) {
        //Values
        int points = 0;
        String guess;
        int guessesLeft = 3;
        String guessedLetters = "";
        Scanner inputFile = null;
        //Scanning the files
        try {
            inputFile = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("filen finns int, använd tangentborde iställe..");
            inputFile = new Scanner(System.in);
        }
        //Creating the word list
        ArrayList<String> wordList = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            wordList.add(inputFile.nextLine());
        }
        //Word randomizer
        Random R = new Random();
        String word = wordList.get(R.nextInt(wordList.size()));
        String star = "*";
        char[] myWord = new char[word.length()];
        for(int i = 0; i<word.length(); i++){

            myWord[i] += star.charAt(0);
        }
        //Printing the Word
        for(int s = 0; s < 1; s++){
            System.out.print(myWord);
            System.out.println();
        }
        //Guessing
        Scanner in = new Scanner(System.in);
        while (guessesLeft > 0) {
            char guessAsChar = in.nextLine().charAt(0);
            guess = Character.toString(guessAsChar);
            while (guessedLetters.contains("" + guessAsChar)) {
                System.out.println("Du ha redan gissa på han!");
                guessAsChar = in.nextLine().charAt(0);
            }
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(0)) {
                    myWord[i] = guess.charAt(0);
                    points ++;
                }
            }
            //Win
            System.out.print(myWord);
            System.out.println();
            if(points == word.length()){
                System.out.println("Congrats my dude!");
                break;
            }
            //Is word true?
            boolean found = false;
            guessedLetters += guessAsChar;
            char[] wordAsChar = word.toCharArray();
            for(int u = 0; u < wordAsChar.length; u++){
                    if (wordAsChar[u] == guessAsChar){
                        myWord[u] = guessAsChar;
                        found = true;
                    }
                }

                //Hanging the man
            if(!found){
                guessesLeft--;
                System.out.println("Du har " + guessesLeft + " kvar!");
                if(guessesLeft == 2){
                    System.out.println(" ___________________ \n"
                                + "|/                 | \n"
                                + "|                  0 \n"
                                + "|                  \n"
                                + "|                  \n"
                                + "| \n"
                                + "| \n"
                                + "/ \\");
                }
                if(guessesLeft == 1){
                    System.out.println(" ___________________ \n"
                                + "|/                 | \n"
                                + "|                  0 \n"
                                + "|                 -|- \n"
                                + "|                  \n"
                                + "| \n"
                                + "| \n"
                                + "/ \\");
                    }
                    if(guessesLeft == 0){
                        System.out.println(" ___________________ \n"
                                + "|/                 | \n"
                                + "|                  0 \n"
                                + "|                 -|- \n"
                                + "|                 / \\ \n"
                                + "| \n"
                                + "| \n"
                                + "/ \\");
                        System.out.println("The word was " + word);
                    }
                }
        }

    }
}
