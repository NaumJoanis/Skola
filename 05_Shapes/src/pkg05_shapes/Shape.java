package pkg05_shapes;

/**
 *
 * @author Joanis Naum
 */
public abstract class Shape {
    //data
    protected String name = "Geometric shape";
    
    
    //methods
    public abstract double area();
    
    public String getShapeName() {
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString(){
        return name + " " + getShapeName();
    }
    
}
