package boxtetris.timer;

import java.util.Arrays;
import java.util.Scanner;

import boxtetris.App;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Cuboid;

import java.io.File;
import java.io.FileNotFoundException;

public class TimeAlgo {

    /**
     * Reads the input.csv file and prints the run time for the algortithm in
     * milliseconds.
     * 
     * @param args
     */
    public static void main(String[] args) {
        MyList<Cuboid> cuboids = new MyList<>();
        MyList<Container> containers = new MyList<>();
        Integer cuboidsInRow = 5;
        Integer rowsInLayer = 5;
        try {
            Scanner scanner = new Scanner(new File("input.csv"));
            while (scanner.hasNext()) {
                String[] next = scanner.next().split(",");

                if (next.length == 2) {
                    cuboidsInRow = Integer.parseInt(next[0]);
                    rowsInLayer = Integer.parseInt(next[1]);
                }
                if (next.length == 5) {
                    Integer length = Integer.parseInt(next[0]);
                    Integer width = Integer.parseInt(next[1]);
                    Integer height = Integer.parseInt(next[2]);
                    Integer weight = Integer.parseInt(next[3]);
                    Integer demand = Integer.parseInt(next[4]);
                    cuboids.add(new Cuboid("", length, width, height, weight, demand));
                }
                if (next.length == 4) {
                    Integer length = Integer.parseInt(next[0]);
                    Integer width = Integer.parseInt(next[1]);
                    Integer height = Integer.parseInt(next[2]);
                    Integer weight = Integer.parseInt(next[3]);
                    containers.add(new Container("", length, width, height, weight));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
        App app = new App(cuboids, containers, cuboidsInRow, rowsInLayer);
        time(app);
    }

    /**
     * @param app
     */
    public static void time(App app) {
        long startTime = System.currentTimeMillis();

        app.getPatterns();

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");

    }
}
