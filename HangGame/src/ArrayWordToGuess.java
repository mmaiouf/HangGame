import java.util.Random;

public class ArrayWordToGuess
{
    private final String[] arrayWordToGuess = new String[99];

    private final String[] frenchWords = {
            "bonjour", "amour", "chat", "chien", "maison", "ecole", "voiture", "soleil",
            "pomme", "livre", "plage", "neige", "fleur", "reve", "famille", "musique",
            "montagne", "riviere", "ciel", "etoile", "arbre", "chocolat", "hiver", "ete",
            "printemps", "automne", "vacances", "mer", "ocean", "foret", "ville", "village",
            "jardin", "parc", "route", "pont", "bateau", "avion", "train", "bus",
            "camion", "velo", "moto", "gare", "aeroport", "hopital", "police", "pompiers",
            "eglise", "mosquee", "temple", "universite", "bibliotheque", "cinema",
            "theatre", "restaurant", "cafe", "hotel", "banque", "magasin", "supermarche",
            "marche", "boulangerie", "boucherie", "pharmacie", "poste", "bureau",
            "usine", "ferme", "chateau", "musee", "zoo", "parc d'attractions",
            "stade", "piscine", "plaine", "colline", "desert", "ile", "peninsule",
            "continent", "pays", "region", "departement", "province", "capitale",
            "centre-ville", "quartier", "rue", "avenue", "boulevard", "place",
            "carrefour", "rond-point", "feu", "trottinette", "poussette", "skateboard",
            "roller"
    };

    public void initArray()
    {
        for (int i = 0; i < arrayWordToGuess.length; i++)
        {
            arrayWordToGuess[i] = frenchWords[i];
        }
    }

    public String getRandomWord()
    {
        int randomNb;
        Random rand = new Random();

        randomNb = rand.nextInt(arrayWordToGuess.length);
        return arrayWordToGuess[randomNb];
    }
}
