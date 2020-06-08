package filehandling;

import java.io.IOException;
import java.util.List;
import app.*;
import java.io.File;

/**
 *
 * @author Joanis Naum
 * 
 */
public abstract class Writer {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    
    public abstract void saveResults(String resultFilepath, List<Product> products) throws IOException;
}
