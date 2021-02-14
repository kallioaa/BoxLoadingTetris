package boxtetris.entities;

import boxtetris.datastructures.MyList;

public class Pattern extends Dimensions {

    private Container container;
    private MyList<Layer> layers;

    public Pattern(Container container) {
        super(container.getLength(), container.getWidth(), container.getHeight());
        this.layers = new MyList<>();
        this.container = container;
    }

    
    /** 
     * @param layer
     */
    public void addLayer(Layer layer) {
        this.addLayer(layer);
    }

}
