package stringprocessing;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 *
 * @author Dmitrii Nikiforov
 */
class HTMLOutputProcessor implements OutputProcessor {
    private FileOutputStream fos;
    public HTMLOutputProcessor(String path) {
        try {
            fos=new FileOutputStream(path);
        } catch (FileNotFoundException ex) {
            System.out.printf("There is a problem with writing to file %s",path);
        }
    }
    
    @Override
    public void processText(List<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            bw.write("<html><body><table border=1 cellpadding=5 cellspacing=0>");
            for (String s: list) {
                bw.write("<tr><td>"+s+"</td></tr>");
            }
            bw.write("</table></body></html>");            
        } catch (IOException ex) {
            System.out.printf("IO exception");
        }
    }    
}