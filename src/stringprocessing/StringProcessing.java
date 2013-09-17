package stringprocessing;
/**
 *
 * @author Dmitrii Nikiforov
 */
public class StringProcessing {    
    public static void main(String[] args) {
        LongestWordStringSorter ss=new LongestWordStringSorter();
        ss.setDataSource(new FileDataSource("C:\\Users\\Dima\\Documents\\task2.txt"));
        ss.setOutputProcessor(new HTMLOutputProcessor("C:\\Users\\Dima\\Documents\\task2.html"));
        ss.sort();
        ss.processSortedData();
    }
}