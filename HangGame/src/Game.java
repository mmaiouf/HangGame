import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public final ArrayWordToGuess arrayWordToGuess = new ArrayWordToGuess();
    public ArrayAlphabet arrayAlphabet = new ArrayAlphabet();
    private int nbTry;
    private int gameIsOver;
    public static int nbLettersFound = 0;

    private static final String[] HANGMAN_STAGES = {
            // Stage 0
                    " +---+\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "=========\n",

            // Stage 1
                    " +---+\n" +
                    " O   |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "=========\n",

            // Stage 2
                    " +---+\n" +
                    " O   |\n" +
                    " |   |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "=========\n",

            // Stage 3
                    " +---+\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "=========\n",

            // Stage 4
                    " +---+\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "=========\n",

            // Stage 5
                    " +---+\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    "     |\n" +
                    "=========\n",

            // Stage 6
                    " +---+\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    "     |\n" +
                    "=========\n"
    };

    private void gameLogic() {
        Scanner scanner = new Scanner(System.in);
        String input;
        char car;
        boolean containsWord;
        boolean containsAlphabet;

        while (nbTry > 0 && nbLettersFound != arrayWordToGuess.getCurrentWord().length())
        {
            System.out.println("Guess the word : " + arrayWordToGuess.getCurrentWord());
            System.out.println(nbTry + " tries left!\n");
            arrayAlphabet.displayArrayAlphabet();
            System.out.print("Type your letter : ");
            input = scanner.next();

            // check if String
            if (input.length() != 1)
            {
                System.out.println("You have entered a String instead of a character");
                break;
            }


            // check Alphabet
            car = input.charAt(0);
            containsAlphabet = arrayAlphabet.getListAlphabet().contains(input);
            if (containsAlphabet) {
                System.out.println("\n\nYou typed : " + car);
                arrayAlphabet.getListAlphabet().remove(input);
            }
            else
            {
                System.out.println("You already entered this letter");
            }

            // check contains Word
            containsWord = arrayWordToGuess.getWordToGuess().contains(Character.toString(car));
            if (containsWord)
            {
                arrayWordToGuess.putLetter(car);
                System.out.println(arrayWordToGuess.getCurrentWord());
            }
            else
                nbTry--;
        }

        if (nbTry == 0)
        {
            System.out.println("Loss !");
            System.out.println("The word was " + arrayWordToGuess.getWordToGuess());
            gameIsOver = 1;
        }

        if (nbLettersFound == arrayWordToGuess.getCurrentWord().length())
        {
            System.out.println("You have won the game !");
            gameIsOver = 1;
        }
    }

    private void gameLoop()
    {
        gameIsOver = 0;
        while (gameIsOver == 0)
        {
            gameLogic();
        }
    }
    public void runGame()
    {
        System.out.println("Welcome to Hangg Game\n");
        arrayWordToGuess.initArray();
        arrayWordToGuess.initCurrentWord();
        nbTry = 6;
        System.out.println(arrayWordToGuess.getWordToGuess());
        arrayAlphabet.initArrayAlphabet();
        gameLoop();
    }
}
