import java.util.Random;

public class ArrayWordToGuess
{
    private final String[] arrayWordToGuess = new String[99];
    private String wordToGuess;
    private String currentWord;


    private final String[] frenchWords = {
            "BONJOUR", "AMOUR", "CHAT", "CHIEN", "MAISON", "ECOLE", "VOITURE", "SOLEIL",
            "POMME", "LIVRE", "PLAGE", "NEIGE", "FLEUR", "REVE", "FAMILLE", "MUSIQUE",
            "MONTAGNE", "RIVIERE", "CIEL", "ETOILE", "ARBRE", "CHOCOLAT", "HIVER", "ETE",
            "PRINTEMPS", "AUTOMNE", "VACANCES", "MER", "OCEAN", "FORET", "VILLE", "VILLAGE",
            "JARDIN", "PARC", "ROUTE", "PONT", "BATEAU", "AVION", "TRAIN", "BUS",
            "CAMION", "VELO", "MOTO", "GARE", "AEROPORT", "HOPITAL", "POLICE", "POMPIERS",
            "EGLISE", "MOSQUEE", "TEMPLE", "UNIVERSITE", "BIBLIOTHEQUE", "CINEMA",
            "THEATRE", "RESTAURANT", "CAFE", "HOTEL", "BANQUE", "MAGASIN", "SUPERMARCHE",
            "MARCHE", "BOULANGERIE", "BOUCHERIE", "PHARMACIE", "POSTE", "BUREAU",
            "USINE", "FERME", "CHATEAU", "MUSEE", "ZOO", "PARC D'ATTRACTIONS",
            "STADE", "PISCINE", "PLAINE", "COLLINE", "DESERT", "ILE", "PENINSULE",
            "CONTINENT", "PAYS", "REGION", "DEPARTEMENT", "PROVINCE", "CAPITALE",
            "CENTRE-VILLE", "QUARTIER", "RUE", "AVENUE", "BOULEVARD", "PLACE",
            "CARREFOUR", "ROND-POINT", "FEU", "TROTTINETTE", "POUSSETTE", "SKATEBOARD",
            "ROLLER"
    };

    public String getWordToGuess()
    {
        return wordToGuess;
    }
    public String getCurrentWord()
    {
        return currentWord;
    }

    public String getRandomWord()
    {
        int randomNb;
        Random rand = new Random();

        randomNb = rand.nextInt(arrayWordToGuess.length);
        return arrayWordToGuess[randomNb];
    }


    public void initArray()
    {
        for (int i = 0; i < arrayWordToGuess.length; i++)
        {
            arrayWordToGuess[i] = frenchWords[i];
        }
    }

    public void initCurrentWord()
    {
        wordToGuess = getRandomWord();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++)
            sb.append("_");
        currentWord = sb.toString();
    }

    public void putLetter(char myCar)
    {
        StringBuilder sb = new StringBuilder(getCurrentWord());
        for (int i = 0; i < getCurrentWord().length(); i++)
        {
            if (getWordToGuess().charAt(i) == myCar)
            {
                sb.setCharAt(i, myCar);
                Game.nbLettersFound++;
            }
        }
        currentWord = sb.toString();
    }
}
