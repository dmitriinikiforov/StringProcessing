package stringprocessing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dmitrii Nikiforov
 */
public class FileDataSource implements DataSource {
    private FileInputStream fis;
    public FileDataSource(String path) {
        try {
            fis=new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            System.out.printf("file %s wasn't found.",path);
        }
    }
    
    @Override
    public List<String> getData() {
        LinkedList<String> list = new LinkedList<>();
        String line;
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            while ((line=br.readLine())!=null) {            
                list.add(line);
            }
        } catch (IOException ex) {
            System.out.printf("IO exception");
        }
        return list;
    }
}