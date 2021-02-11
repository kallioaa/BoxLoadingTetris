package boxtetris.entities;

import boxtetris.datastructures.MyList;

public class Stack {

    private MyList<Layer> layers;

    public Stack(MyList<Layer> layers) {
        this.layers = layers;
    }

    public Integer getLength() {
        return layers.get(0).getLength();
    }

    public Integer getWidth() {
        return layers.get(0).getLength();
    }

    public Integer getHeight() {
        return layers.get(0).getLength();
    }
}
