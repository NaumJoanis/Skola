
package filehandling;
import app.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
 *
 * @author Joanis Naum
 */
public class TextWriter extends Writer{
    
    @Override
    public void saveResults(String resultFilepath, List<Product> products) throws IOException{
        File resultFile = new File(dataDirectory, resultFilepath);
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, true)))) {
            
            for (Product product : products) {
                pw.println(product.getName() + " " + product.getPieces());
            }
        }
        }
    }

    
    

