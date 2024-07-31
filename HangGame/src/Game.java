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
            // Stage 6
            " +---+\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
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

            // Stage 4
            " +---+\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
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

            // Stage 2
            " +---+\n" +
                    " O   |\n" +
                    " |   |\n" +
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

            // Stage 0
            " +---+\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
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
            System.out.println("\n\nGuess the word : " + arrayWordToGuess.getCurrentWord());
            if (nbTry == 1)
                System.out.println(nbTry + " try left!\n");
            else
                System.out.println(nbTry + " tries left!\n");
            System.out.println(HANGMAN_STAGES[nbTry]);
            arrayAlphabet.displayArrayAlphabet();
            System.out.print("Type your letter : ");
            input = scanner.next();

        // check if String
            if (input.length() != 1)
            {
                System.out.println("\n\nYou have entered a String instead of a character");
                break;
            }

        // check Alphabet
            car = input.charAt(0);
            if (Character.isLowerCase(car))
                car = Character.toUpperCase(car);
            containsAlphabet = arrayAlphabet.getListAlphabet().contains(Character.toString(car));
            if (containsAlphabet)
                arrayAlphabet.getListAlphabet().remove(Character.toString(car));
            else
                System.out.println("\n\nThere is no " + car + " from the available car");

        // check contains Word
            if (containsAlphabet)
            {
                containsWord = arrayWordToGuess.getWordToGuess().contains(Character.toString(car));
                if (containsWord)
                {
                    System.out.println("\n\nThere is " + car + " in the word to guess !");
                    arrayWordToGuess.putLetter(car);
                }
                else
                {
                    System.out.println("\n\nThere is no " + car + " in the word to guess !");
                    nbTry--;
                }
            }

        }

        if (nbTry == 0)
        {
            System.out.println(HANGMAN_STAGES[nbTry]);
            System.out.println("\nLoss !");
            System.out.println("The word was " + arrayWordToGuess.getWordToGuess());
            gameIsOver = 1;
        }
        if (nbLettersFound == arrayWordToGuess.getCurrentWord().length())
        {
            System.out.println("You have won the game !");
            System.out.println("The word was " + arrayWordToGuess.getWordToGuess());
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
        System.out.println("\nWelcome to Hang Man !\n");
        arrayWordToGuess.initArray();
        arrayWordToGuess.initCurrentWord();
        nbTry = 6;
        arrayAlphabet.initArrayAlphabet();
        gameLoop();
    }
}
