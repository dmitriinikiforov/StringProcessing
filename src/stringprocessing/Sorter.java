package stringprocessing;

/**
 *
 * @author Dmitrii Nikiforov
 */
interface Sorter<T> {
    public void setDataSource(DataSource ds);
    public void setOutputProcessor(OutputProcessor op);
    public void getData();
    public void sort();
    public void processSortedData();
    public Number getMetrics(T t);
}