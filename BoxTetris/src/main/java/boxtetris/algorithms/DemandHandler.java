package boxtetris.algorithms;

import java.util.HashMap;

import boxtetris.datastructures.MyList;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Layer;
import boxtetris.entities.Pattern;

public class DemandHandler {

    private HashMap<Cuboid, Integer> demands;
    private Integer minDemand;

    public DemandHandler(MyList<Cuboid> cuboids, MyList<Integer> demands) {
        this.demands = intializeDemands(cuboids, demands);
        this.minDemand = findMin();
    }

    public void addPatternsDemands(Pattern pattern) {
        MyList<Layer> layers = pattern.getLayers();
        for (int i = 0; i < layers.size(); i++) {
            Layer layer = layers.get(i);
            Cuboid cuboid = layer.getCuboid();
            Integer amount = layer.getNumberOfCuboid();
            updateDemand(cuboid, amount);
        }
    }

    public Integer getMinDemand() {
        return minDemand;
    }

    private void updateDemand(Cuboid cuboid, Integer amount) {
        Integer prevDemand = demands.get(cuboid);
        Integer newDemand = prevDemand - amount;
        demands.replace(cuboid, newDemand);
        if (newDemand < minDemand) {
            newDemand = minDemand;
        }
    }

    private Integer findMin() {
        Integer minDemand = Integer.MAX_VALUE;
        for (Cuboid key : demands.keySet()) {
            Integer demand = demands.get(key);
            if (demand < minDemand) {
                minDemand = demand;
            }
        }
        return minDemand;
    }

    private HashMap<Cuboid, Integer> intializeDemands(MyList<Cuboid> cuboids, MyList<Integer> demands) {
        if (cuboids.size() != demands.size()) {
            throw new Error("List must have the same lengths");
        }
        HashMap<Cuboid, Integer> demandHash = new HashMap<>();
        for (int i = 0; i < cuboids.size(); i++) {
            Cuboid cuboid = cuboids.get(i);
            Integer demand = demands.get(i);
            demandHash.put(cuboid, demand);
        }
        return demandHash;
    }

}
