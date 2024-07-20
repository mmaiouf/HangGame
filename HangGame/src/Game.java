import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public final ArrayWordToGuess arrayWordToGuess = new ArrayWordToGuess();
    public ArrayAlphabet arrayAlphabet = new ArrayAlphabet();
    private int nbTry;
    private int gameIsOver;

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

    private int gameLogic() {
        Scanner scanner = new Scanner(System.in);
        String input;
        char car;
        boolean containsWord;
        boolean containsAlphabet;
        int indexWord;
        int indexAlphabet;
        int nb = 65;
        String value;

        while (nbTry > 0)
        {
            System.out.println("Guess the word : " + arrayWordToGuess.getCurrentWord());
            System.out.println(nbTry + " tries left!\n");
            arrayAlphabet.displayArrayAlphabet();
            System.out.print("Type your letter : ");
            input = scanner.next();
            car = input.charAt(0);
            // Check if the list contains the target string
            containsAlphabet = arrayAlphabet.getListAlphabet().contains(input);

            if (containsAlphabet) {
                indexAlphabet = (((int) input.charAt(0)) - nb);
                value = arrayAlphabet.getListAlphabet().get(indexAlphabet);
                car = value.charAt(0);
                arrayAlphabet.getListAlphabet().remove(indexAlphabet);
                nb--;
            }
            else
            {
                System.out.println("You already entered this letter");
            }

            //if (input.length() == 1)


            // Convert the character to a string and check if it is present in the string
            containsWord = arrayWordToGuess.getWordToGuess().contains(Character.toString(car));
            if (containsWord)
            {
                indexWord = arrayWordToGuess.getWordToGuess().indexOf(car);
                arrayWordToGuess.putLetter(indexWord, car);
                System.out.println(arrayWordToGuess.getCurrentWord());
            }
            else
            {
                nbTry = nbTry - 1;
            }
        }

        if (nbTry == 0)
            gameIsOver = 1;

        return (0);
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
        System.out.println("Welcome to Hang Game\n");
        arrayWordToGuess.initArray();
        arrayWordToGuess.initCurrentWord();
        nbTry = 6;
        System.out.println(arrayWordToGuess.getWordToGuess());
        arrayAlphabet.initArrayAlphabet();
        gameLoop();
    }
}
