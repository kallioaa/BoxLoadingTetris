package boxtetris.restservice.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Cuboid;

@Service
public class Services {

    private final MyList<Cuboid> cuboids;
    private final MyList<Container> containers;

    public Services() {
        this.cuboids = new MyList<>();
        this.containers = new MyList<>();
    }

    public Cuboid createCuboid(Cuboid cuboid) {
        cuboids.add(cuboid);
        System.out.print(cuboid);
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

    public ArrayList<Container> getContainers() {
        ArrayList<Container> arrayContainer = new ArrayList<>();
        for (int i = 0; i < containers.size(); i++) {
            arrayContainer.add(containers.get(i));
        }
        return arrayContainer;
    }

    public ArrayList<Cuboid> getCuboids() {
        ArrayList<Cuboid> arrayCuboid = new ArrayList<>();
        for (int i = 0; i < cuboids.size(); i++) {
            arrayCuboid.add(cuboids.get(i));
        }
        return arrayCuboid;
    }
}
