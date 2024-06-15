import java.util.LinkedHashMap;
import java.util.Map;

public class LRU extends ReplacementAlgo{
    private Map<Integer, Integer> pages;
    public LRU(int pageFrameCount) {
        super(pageFrameCount);
        this.pages = new LinkedHashMap<>(pageFrameCount, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > pageFrameCount;
            }
        };
    }

    @Override
    public void insert(int pageNumber) {
        if(!pages.containsKey(pageNumber)){
            pageFaultCount++;

        }

        pages.put(pageNumber, pageNumber);

    }
}
