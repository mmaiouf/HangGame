public class Game
{
    public final ArrayWordToGuess arrayWordToGuess = new ArrayWordToGuess();

    void runGame()
    {
        System.out.println("Welcome to Hang Game");
        arrayWordToGuess.initArray();
        System.out.println("here is the word to guess : " + arrayWordToGuess.getRandomWord());
    }
}
