package interfacevariant;


/**
 *
 * @author Joanis Naum
 */
public interface ShapeInterface {
    //data
    final String NAME = "Geometric shape";
    
    
    //methods
    public double area();
    
    default String getShapeName() {
        return this.getClass().getSimpleName();
    }
    
    
}
