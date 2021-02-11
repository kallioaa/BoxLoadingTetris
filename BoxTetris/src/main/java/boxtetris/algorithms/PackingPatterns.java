package boxtetris.algorithms;

import boxtetris.entities.Container;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Pattern;
import boxtetris.entities.Layer;

import boxtetris.datastructures.MyList;

public class PackingPatterns {

    /**
     * @param containers
     * @param layers
     * @param demands
     * @return MyList<Pattern>
     */
    static MyList<Pattern> generatePatterns(Container[] containers, Layer[] layers, Integer[] demands) {
        /*
         * MyList<Pattern> patterns = new MyList<>(); Integer min = findMin(demands);
         * while (min > 0) { Double volUtil = Double.MIN_VALUE; Pattern pattern = null;
         * for (int i = 0; i < containers.length; i++) { for (int i = 0, i <) }
         * 
         * } return patterns; }
         * 
         * private static void packingPatternOne() {
         * 
         * }
         * 
         * private static void packingPatternTwo() {
         * 
         * }
         * 
         * 
         * /**
         * 
         * @return MyList<FreeSpace>
         */

        /**
         * @param demands
         * @return Integer
         */
        return null;
    }

    private static Integer findMin(Integer[] demands) {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < demands.length; i++) {
            Integer value = demands[i];
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
