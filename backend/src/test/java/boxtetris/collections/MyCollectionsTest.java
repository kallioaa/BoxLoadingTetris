package boxtetris.collections;

import static org.junit.Assert.assertArrayEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import boxtetris.algorithms.LayerBuilding;
import boxtetris.comparators.DimensionComparatorOne;
import boxtetris.comparators.DimensionComparatorThree;
import boxtetris.comparators.LayerComparators;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Cuboid;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Layer;
import junit.framework.AssertionFailedError;

public class MyCollectionsTest {

    private MyList<FreeSpace> freeSpaces;
    private MyList<Container> containers;
    private Random random;

    @Before
    public void setUp() {
        this.random = new Random();
        this.freeSpaces = new MyList<>();
        this.containers = new MyList<>();
    }

    @Test
    public void freeSpacesSmall() {
        Coordinates coordinate = new Coordinates(2, 2, 2);
        Object[] all = new Object[] { new FreeSpace(4, 2, 2, coordinate), new FreeSpace(4, 2, 3, coordinate),
                new FreeSpace(4, 2, 8, coordinate) };
        freeSpaces.addAll(all);
        MyCollections.sort(freeSpaces, new DimensionComparatorOne());
        assertArrayEquals(new Object[] { new FreeSpace(4, 2, 8, coordinate), new FreeSpace(4, 2, 3, coordinate),
                new FreeSpace(4, 2, 2, coordinate) }, freeSpaces.toArray());
    }

    @Test
    public void freeSpacesLarge() {
        Coordinates coordinate = new Coordinates(2, 2, 2);
        FreeSpace[] all = new FreeSpace[100];
        for (int i = 0; i < all.length; i++) {
            all[i] = new FreeSpace(3, 4, random.nextInt(100), coordinate);
        }
        freeSpaces.addAll(all);
        MyCollections.sort(freeSpaces, new DimensionComparatorOne());
        Integer prev = Integer.MAX_VALUE;
        for (int i = 0; i < freeSpaces.size(); i++) {
            if (freeSpaces.get(i).getHeight() > prev) {
                throw new AssertionFailedError();
            }
            prev = freeSpaces.get(i).getHeight();
        }
    }

    @Test
    public void containersLarge() {
        Container[] all = new Container[100];
        for (int i = 0; i < all.length; i++) {
            all[i] = new Container("a", 3, 4, random.nextInt(100), 1000);
        }
        containers.addAll(all);
        MyCollections.sort(containers, new DimensionComparatorThree());
        Long prev = Long.MAX_VALUE;
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).getVolume() > prev) {
                throw new AssertionFailedError();
            }
            prev = containers.get(i).getVolume();
        }
    }

    @Test
    public void freeSpacesAllVariables() {
        Coordinates coordinate = new Coordinates(2, 2, 2);
        FreeSpace[] all = new FreeSpace[100];
        for (int i = 0; i < all.length; i++) {
            all[i] = new FreeSpace(random.nextInt(100), random.nextInt(100), random.nextInt(100), coordinate);
        }
        freeSpaces.addAll(all);
        MyCollections.sort(freeSpaces, new DimensionComparatorOne());
        Integer prevHeight = Integer.MAX_VALUE;
        Integer prevWidth = Integer.MAX_VALUE;
        for (int i = 0; i < freeSpaces.size(); i++) {
            if (freeSpaces.get(i).getHeight() == prevHeight) {
                if (freeSpaces.get(i).getWidth() > prevWidth) {
                    throw new AssertionFailedError();
                }
            }
            prevHeight = freeSpaces.get(i).getHeight();
            prevWidth = freeSpaces.get(i).getWidth();
        }
    }

    @Test
    public void sortLayersVolume() {
        MyList<Cuboid> cuboids = generateCuboidsOne();
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 5, 5);
        MyCollections.sort(layers, new LayerComparators.Volume());
        Long volume = layers.get(0).getVolume();
        for (int i = 1; i > layers.size(); i++) {
            if (layers.get(i).getVolume() > volume) {
                throw new AssertionFailedError();
            }
            volume = layers.get(i).getVolume();
        }
    }

    @Test
    public void sortLayersHeightWeightAndArea() {
        MyList<Cuboid> cuboids = generateCuboidsOne();
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 5, 5);
        MyCollections.sort(layers, new LayerComparators.HeightWeightAndArea());
        double heightWeightAndArea = layers.get(0).getHeightAndWeightDivArea();
        for (int i = 1; i > layers.size(); i++) {
            if (layers.get(i).getHeightAndWeightDivArea() > heightWeightAndArea) {
                throw new AssertionFailedError();
            }
            heightWeightAndArea = layers.get(i).getVolume();
        }
    }

    public MyList<Cuboid> generateCuboidsOne() {
        MyList<Cuboid> cuboids = new MyList<>();
        Cuboid first = new Cuboid("first", 10, 10, 10, 10, 10);
        Cuboid third = new Cuboid("third", 20, 20, 20, 20, 20);
        Cuboid second = new Cuboid("second", 5, 5, 5, 5, 5);
        cuboids.add(first);
        cuboids.add(second);
        cuboids.add(third);
        return cuboids;
    }
}
