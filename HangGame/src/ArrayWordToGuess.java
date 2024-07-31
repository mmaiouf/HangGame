import java.util.Random;

public class ArrayWordToGuess
{
    private final String[] arrayWordToGuess = new String[99];
    private String wordToGuess;
    private String currentWord;
    private final String[] frenchWords = {
            "POMPIER", "AMIS", "VOYAGE", "TRAVAIL", "LUMIERE", "JOUR", "NUIT",
            "HEURE", "MINUTE", "SECONDE", "CLASSE", "PROFESSEUR", "ELEVE",
            "EQUIPE", "SPORT", "FOOTBALL", "BASKETBALL", "NATATION", "TENNIS",
            "VELO", "MOTO", "VOITURE", "CAMION", "BUS", "TRAIN", "TRAMWAY",
            "AVION", "BATEAU", "PORT", "AEROPORT", "GARE", "METRO", "QUAI",
            "BOUTIQUE", "CENTRE COMMERCIAL", "LIBRAIRIE", "PHARMACIE", "HOPITAL",
            "CLINIQUE", "CABINET", "DOCTEUR", "MEDECIN", "INFIRMIERE", "ORDONNANCE",
            "MEDICAMENT", "CHIRURGIE", "URGENTISTE", "AMBULANCE", "POLICIER",
            "GENDARME", "SECURITE", "CRIMINALITE", "VOL", "AGRESSION", "VICTIME",
            "TEMOIN", "SUSPECT", "ENQUETE", "PROCES", "TRIBUNAL", "AVOCAT", "JUGE",
            "COUR", "PRISON", "DETENU", "LIBERATION", "JUSTICE", "PEINE", "VERDICT",
            "ACCUSATION", "DEFENSE", "EVIDENCE", "TEMOIGNAGE", "PREUVE", "ALIBI",
            "MOBILE", "MOTIF", "DELINQUANCE", "CRIMINALITE", "FRAUDE", "ESCROQUERIE",
            "CYBERCRIMINALITE", "HACKER", "CYBERSECURITE", "ENQUETEUR", "AGENT",
            "OFFICIER", "COMMISSIONNAIRE", "DIRECTEUR", "PREFET", "MINISTRE",
            "PRESIDENT", "GOUVERNEMENT", "ASSEMBLEE", "SENAT", "PARLEMENT", "DEPUTE",
            "SENATEUR", "LEGISLATION", "REGLEMENT", "LOI", "CONSTITUTION", "DECRET",
            "ARRETE", "ORDONNANCE", "JURIDICTION", "COUR SUPREME", "CONSEIL D'ETAT",
            "TRIBUNAL ADMINISTRATIF", "JURISTE", "AVOCAT", "NOTAIRE", "HUISSIER",
            "MAGISTRAT", "PROCUREUR", "ENQUETEUR", "EXPERT", "TEMOIN"
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
