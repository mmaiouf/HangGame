import java.util.ArrayList;
import java.util.List;

public class ArrayAlphabet
{
    private List<String> listAlphabet = new ArrayList<String>();

    public void initArrayAlphabet()
    {
        listAlphabet.add("A");
        listAlphabet.add("B");
        listAlphabet.add("C");
        listAlphabet.add("D");
        listAlphabet.add("E");
        listAlphabet.add("F");
        listAlphabet.add("G");
        listAlphabet.add("H");
        listAlphabet.add("I");
        listAlphabet.add("J");
        listAlphabet.add("K");
        listAlphabet.add("L");
        listAlphabet.add("M");
        listAlphabet.add("N");
        listAlphabet.add("O");
        listAlphabet.add("P");
        listAlphabet.add("Q");
        listAlphabet.add("R");
        listAlphabet.add("S");
        listAlphabet.add("T");
        listAlphabet.add("U");
        listAlphabet.add("V");
        listAlphabet.add("W");
        listAlphabet.add("X");
        listAlphabet.add("Y");
        listAlphabet.add("Z");
    }

    // Getter method for listAlphabet
    public List<String> getListAlphabet() {
        return listAlphabet;
    }

    public void displayArrayAlphabet() {
        for (int i = 0; i < listAlphabet.size(); i++) {
            System.out.print(listAlphabet.get(i));
            if (i < listAlphabet.size() - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println(); // To move to the next line after printing all items
    }
}
