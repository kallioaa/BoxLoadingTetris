package boxtetris.entities;

public class Cubioid extends Dimensions{


        private Integer weight;
        private Double priority;
    
    
        public Cubioid(Integer length, Integer width, Integer height, Integer weight, Double priority) {
            super(length,width,height)
;           this.weight = weight;
            this.priority = priority;
        }
    
        public Integer getWeight() {
            return this.weight;
        }
            
        public Double getPriority() {
            return this.priority;
        } 
    }