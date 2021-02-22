package boxtetris.restservice.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import boxtetris.App;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Pattern;

@Service
public class Services {

    private final MyList<Cuboid> cuboids;
    private final MyList<Container> containers;

    public Services() {
        this.cuboids = new MyList<>();
        this.containers = new MyList<>();
    }

    public ArrayList<Pattern> generatePatterns(Integer itemsInRow, Integer rowsInLayer) {
        App app = new App(cuboids, containers, itemsInRow, rowsInLayer);
        MyList<Pattern> patterns = app.getPatterns();
        return myListToArrayList(patterns);

    }

    public Cuboid createCuboid(Cuboid cuboid) {
        cuboids.add(cuboid);
        return cuboid;
    }

    public Container createContainer(Container container) {
        containers.add(container);
        return container;
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

    public ArrayList<Container> getContainers() {
        return myListToArrayList(containers);
    }

    static private <T> ArrayList<T> myListToArrayList(MyList<T> myList) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            arrayList.add(myList.get(i));
        }
        return arrayList;
    }
}
