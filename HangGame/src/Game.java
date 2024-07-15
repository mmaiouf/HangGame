import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public final ArrayWordToGuess arrayWordToGuess = new ArrayWordToGuess();
    public ArrayAlphabet arrayAlphabet = new ArrayAlphabet();
    public int nbTry;

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

    private void gameLogic()
    {
        nbTry = 6;
        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.println("Guess the word : " + arrayWordToGuess.getCurrentWord());
        System.out.println(nbTry + " tries left!\n");
        arrayAlphabet.initArrayAlphabet();
        arrayAlphabet.displayArrayAlphabet();
        System.out.print("Type your letter : ");
        input = scanner.nextInt();

    }

    private void gameLoop()
    {
        //int gameIsOver = 0;

        //while (gameIsOver == 0)
        //{
            gameLogic();
        //}
    }
    public void runGame()
    {
        System.out.println("Welcome to Hang Game\n");
        arrayWordToGuess.initArray();
        arrayWordToGuess.initCurrentWord();
        gameLoop();
    }
}
