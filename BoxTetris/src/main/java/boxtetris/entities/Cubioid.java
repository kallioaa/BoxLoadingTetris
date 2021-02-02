package boxtetris.entities;

public class Cubioid {

    private Integer length;
        private Integer width;
        private Integer height;
        private Integer weight;
        private Double priority;
    
    
        public Cubioid(Integer length, Integer width, Integer height, Integer weight, Double priority) {
            this.length = length;
            this.width = width;
            this.height = height;
            this.weight = weight;
            this.priority = priority;
        }
    
        public Integer getLength() {
            return this.length;
        }
    
        public Integer getWidth() {
            return this.width;
        }
    
        public Integer getHeight() {
            return this.height;
        }
    
        public Integer getWeight() {
            return this.weight;
        }
            
        public Double getPriority() {
            return this.priority;
        } 
    }