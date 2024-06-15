
import org.junit.Test;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;


public class TestAlgos {

    @Test
    public void testFIFO() {
        FIFO testFIFO = new FIFO(3);
        int[] refStr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        for (int pageNums : refStr) {

            testFIFO.insert(pageNums);
        }
        assertEquals(15, testFIFO.getPageFaultCount());
    }

    @Test
    public void testLRU() {
        LRU testLRU = new LRU(3);
        int[] refStr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        for (int pageNums : refStr) {

            testLRU.insert(pageNums);
        }
        assertEquals(12, testLRU.getPageFaultCount());
    }

    @Test
    public void testOPT() {
        List<Integer> refStr = Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1);
        OPT opt = new OPT(3, refStr);
        for (int pageNumber : refStr) {
            opt.insert(pageNumber);
        }
        assertEquals(9, opt.getPageFaultCount());
    }
}


