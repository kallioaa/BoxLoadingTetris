package boxtetris.comparators;

import java.util.Comparator;

import boxtetris.entities.Dimensions;

/**
 * Comparator for comparing two different Dimensions objects.
 */
public class DimensionComparatorOne implements Comparator<Dimensions> {

    /**
     * 
     * @param first
     * @param second
     * @return int
     */
    @Override
    public int compare(Dimensions first, Dimensions second) {
        if (first.getHeight() > second.getHeight()) {
            return 1;
        }
        if (first.getHeight() == second.getHeight()) {
            if (first.getWidth() > second.getWidth()) {
                return 1;
            }
            if (first.getWidth() == second.getWidth()) {
                if (first.getLength() < second.getLength()) {
                    return 1;
                }
            }
        }
        return -1;
    }
}