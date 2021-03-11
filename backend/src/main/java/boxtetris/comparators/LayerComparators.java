package boxtetris.comparators;

import java.util.Comparator;

import boxtetris.entities.Layer;

/**
 * Nine different comparators for sorting layer with different rules.
 */
public class LayerComparators {

    private LayerComparators() {
    }

    public static class WeightAndArea implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getWeightDivArea() > o2.getWeightDivArea()) {
                return 1;
            }
            return -1;
        }
    }

    public static class WeightAndVolume implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getWeightDivVolume() > o2.getWeightDivVolume()) {
                return 1;
            }
            return -1;
        }
    }

    public static class WeightAndHeight implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getWeightDivHeight() > o2.getWeightDivHeight()) {
                return 1;
            }
            return -1;
        }
    }

    public static class HeightWeightAndArea implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getHeightAndWeightDivArea() > o2.getHeightAndWeightDivArea()) {
                return 1;
            }
            return -1;
        }
    }

    public static class Area implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getArea() > o2.getArea()) {
                return 1;
            }
            return -1;
        }
    }

    public static class Volume implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getVolume() > o2.getVolume()) {
                return 1;
            }
            return -1;
        }
    }

    public static class Weight implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getWeight() > o2.getWeight()) {
                return 1;
            }
            return -1;
        }
    }

    public static class Width implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getWidth() > o2.getWidth()) {
                return 1;
            }
            return -1;
        }
    }

    public static class Length implements Comparator<Layer> {

        @Override
        public int compare(Layer o1, Layer o2) {
            if (o1.getLength() > o2.getLength()) {
                return 1;
            }
            return -1;
        }
    }

}
