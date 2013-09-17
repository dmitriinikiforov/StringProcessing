package stringprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dmitrii Nikiforov
 */
public class LongestWordStringSorter implements Sorter<String> {
    private DataSource ds;
    private OutputProcessor op;
    private List<String> data;
    
    @Override
    public void setDataSource(DataSource ds) {
        this.ds=ds;
        getData();
    }
    
    @Override
    public void setOutputProcessor(OutputProcessor op) {
        this.op=op;
    }

    @Override
    public void getData() {
        data=ds.getData();
    }
    
    @Override
    public void sort() {
        int dataSize=data.size();
        ArrayList<String> sorted=new ArrayList<>(dataSize);
        int[] order=new int[dataSize];
        int k=0;
        int curMetrics;
        for (String s: data) {
            curMetrics=getIntMetrics(s);
            for (int i=0; i<dataSize; i++) {
                if (curMetrics>order[i]) {
                    for (int j=k; j>i; j--) {
                        order[j]=order[j-1];
                    }
                    order[i]=curMetrics;
                    sorted.add(i, s);
                    k++;
                    break;
                }
            }            
        }
        data=sorted.subList(0, 5);
    }

    @Override
    public void processSortedData() {
        op.processText(data);
    }

    public int getIntMetrics(String s) {
        return (int)getMetrics(s);
    }
    
    @Override
    public Number getMetrics(String s) {
        int maxWordLength=0;
        int spaceNum=s.indexOf(" ");
        String word;
        int wordLength;
        while (spaceNum!=-1) {
            word=s.substring(0, spaceNum);
            wordLength=word.length();
            s=s.substring(spaceNum+1);
            if (wordLength>maxWordLength) maxWordLength=wordLength;
            spaceNum=s.indexOf(" ");
        }
        int lastWordLength=s.length();
        return lastWordLength>maxWordLength?lastWordLength:maxWordLength;        
    }
}