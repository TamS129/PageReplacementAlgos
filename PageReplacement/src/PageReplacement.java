import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PageReplacement {

    public static void testAlgorithms(List<Integer> referenceString, int[] pageFrameCounts) {
        for (int pageFrameCount : pageFrameCounts) {
            System.out.println("Page Frames: " + pageFrameCount);

            testAlgorithm("FIFO", referenceString, pageFrameCounts, FIFO::new);
            testAlgorithm("LRU", referenceString, pageFrameCounts, LRU::new);
            testAlgorithm("OPT", referenceString, pageFrameCounts, frames -> new OPT(frames, referenceString));

            System.out.println();
        }
    }

    public static void testAlgorithm(String algorithmName, List<Integer> referenceString, int[] pageFrameCounts, AlgorithmFactory factory) {
        for (int pageFrameCount : pageFrameCounts) {
            ReplacementAlgo algo = factory.create(pageFrameCount);

            for (int pageNumber : referenceString) {
                algo.insert(pageNumber);
            }
            System.out.printf("Our Algorthm %s has %d frames. The number of page faults are %d %n", algorithmName, pageFrameCount, algo.getPageFaultCount());
        }
    }



    static List<Integer> generateRandomRefString(int size, int maxPageNumber){
        Random random = new Random();
        Integer[] randomRef = new Integer[size];
        for(int i = 0; i < size; i++){
            randomRef[i] = random.nextInt(maxPageNumber);
        }
        return Arrays.asList(randomRef);
    }

}
interface AlgorithmFactory {
    ReplacementAlgo create(int pageFrameCount);
}
