package boxtetris.collections;

import java.util.Comparator;

import boxtetris.entities.Dimensions;

public class DimensionComparerOne implements Comparator<Dimensions> {

    /**
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