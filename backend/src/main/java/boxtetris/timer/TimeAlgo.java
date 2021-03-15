package boxtetris.timer;

import java.util.Arrays;
import java.util.Scanner;

import boxtetris.App;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Layer;
import boxtetris.entities.Pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

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
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                String[] next = scanner.next().split(",");
                if (next.length == 2) {
                    cuboidsInRow = Integer.parseInt(next[0]);
                    rowsInLayer = Integer.parseInt(next[1]);
                }
                if (next.length == 6) {
                    String name = next[0];
                    Integer length = Integer.parseInt(next[1]);
                    Integer width = Integer.parseInt(next[2]);
                    Integer height = Integer.parseInt(next[3]);
                    Integer weight = Integer.parseInt(next[4]);
                    Integer demand = Integer.parseInt(next[5]);
                    cuboids.add(new Cuboid(name, length, width, height, weight, demand));
                }
                if (next.length == 5) {
                    String name = next[0];
                    Integer length = Integer.parseInt(next[1]);
                    Integer width = Integer.parseInt(next[2]);
                    Integer height = Integer.parseInt(next[3]);
                    Integer maxWeight = Integer.parseInt(next[4]);
                    containers.add(new Container(name, length, width, height, maxWeight));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
        App app = new App(cuboids, containers, cuboidsInRow, rowsInLayer);
        MyList<Pattern> patterns = time(app);
        File output = createOutputFile();
        writePatterns(output, patterns);

    }

    /**
     * Writes information about the patterns on csv
     * 
     * @param patterns
     * @throws IOException
     */
    public static File createOutputFile() {
        try {
            File output = new File("output.txt");
            output.createNewFile();
            return output;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Writes the patterns into the output file
     * 
     * @param output
     * @param patterns
     */
    public static void writePatterns(File output, MyList<Pattern> patterns) {
        try {
            PrintWriter writer = new PrintWriter(output);
            writer.print("");
            for (int i = 0; i < patterns.size(); i++) {
                Pattern pattern = patterns.get(i);
                writer.println(pattern.toString());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Prints out the runtime of the algorithm
     * 
     * @param app
     */
    public static MyList<Pattern> time(App app) {
        long startTime = System.currentTimeMillis();

        MyList<Pattern> patterns = app.getPatterns();

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        return patterns;

    }

}
