package boxtetris.restservice.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import boxtetris.App;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Layer;
import boxtetris.entities.Pattern;
import boxtetris.restservice.models.PatternJSON;

@Service
public class Services {
    private final MyList<Cuboid> cuboids;
    private final MyList<Container> containers;
    private ArrayList<PatternJSON> patterns;

    public Services() {
        this.cuboids = new MyList<>();
        this.containers = new MyList<>();
        this.patterns = new ArrayList<>();
    }

    public void generatePatterns(Integer cuboidsInRow, Integer rowsInLayer) {
        patterns = new ArrayList<>();
        MyList<Cuboid> clonedCuboids = cloneCuboids(cuboids);
        App app = new App(clonedCuboids, containers, cuboidsInRow, rowsInLayer);
        MyList<Pattern> patterns = app.getPatterns();
        this.patterns = patternsToJSON(patterns);
    }

    public ArrayList<PatternJSON> getPatterns() {
        return patterns;
    }

    public void createCuboid(Cuboid cuboid) {
        cuboids.add(cuboid);
    }

    public void createContainer(Container container) {
        containers.add(container);
    }

    public void clearContainers() {
        containers.clear();
    }

    public void clearCuboids() {
        cuboids.clear();
    }

    public ArrayList<Cuboid> getCuboids() {
        return myListToArrayList(cuboids);
    }

    private MyList<Cuboid> cloneCuboids(MyList<Cuboid> cuboids) {
        MyList<Cuboid> clonedCuboids = new MyList<>();
        for (int i = 0; i < cuboids.size(); i++) {
            Cuboid cuboid = cuboids.get(i);
            String name = cuboid.getName();
            Integer lenght = cuboid.getLength();
            Integer width = cuboid.getWidth();
            Integer height = cuboid.getHeight();
            Integer weight = cuboid.getWeight();
            Integer demand = cuboid.getDemand();
            Cuboid clonedCuboid = new Cuboid(name, lenght, width, height, weight, demand);
            clonedCuboids.add(clonedCuboid);
        }
        return clonedCuboids;

    }

    public ArrayList<Container> getContainers() {
        ;
        return myListToArrayList(containers);
    }

    private ArrayList<PatternJSON> patternsToJSON(MyList<Pattern> patterns) {
        ArrayList<PatternJSON> returnList = new ArrayList<>();
        for (int i = 0; i < patterns.size(); i++) {
            Pattern pattern = patterns.get(i);
            ArrayList<Layer> layers = myListToArrayList(pattern.getLayers());
            ArrayList<Coordinates> coordinates = myListToArrayList(pattern.getCoordinates());
            Container container = pattern.getContainer();
            returnList.add(new PatternJSON(container, layers, coordinates, pattern.volumeUtilization(),
                    pattern.weightUtilization()));
        }
        return returnList;

    }

    static private <T> ArrayList<T> myListToArrayList(MyList<T> myList) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            arrayList.add(myList.get(i));
        }
        return arrayList;
    }
}
