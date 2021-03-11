package boxtetris.comparators;

import java.util.Comparator;

import boxtetris.entities.Dimensions;

public class DimensionComparatorThree implements Comparator<Dimensions> {

    @Override
    public int compare(Dimensions first, Dimensions second) {
        if (first.getVolume() > second.getVolume()) {
            return 1;
        }
        return -1;
    }

}
