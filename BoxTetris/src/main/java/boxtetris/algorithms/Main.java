package boxtetris.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import boxtetris.algorithms.PackingPatterns;
import boxtetris.datastructures.MyList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        System.out.println(lista.toString());
        testi(lista);
        System.out.println(lista.toString());
        Comparator.reverseOrder();
    }

    /**
     * @param test
     */
    public static void testi(ArrayList<Integer> test) {
        test.clear();
        test.add(5);
    }
}
