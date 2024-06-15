import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> refStr1 = Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1);
        List<Integer> refStr2 = Arrays.asList(8, 1, 0, 7, 3, 0, 3, 4, 5, 3, 5, 2, 0, 6, 8, 4, 8, 1, 5, 3);
        List<Integer> refStr3 = Arrays.asList(4, 6, 4, 8, 6, 3, 6, 0, 5, 9, 2, 1, 0, 4, 6, 3, 0, 6, 8, 4);

        int[] pageFrameCounts = {3, 5, 7};

        System.out.println("Testing with Reference String 1:");
        PageReplacement.testAlgorithms(refStr1, pageFrameCounts);

        System.out.println("\nTesting with Reference String 2:");
        PageReplacement.testAlgorithms(refStr2, pageFrameCounts);

        System.out.println("\nTesting with Reference String 3:");
        PageReplacement.testAlgorithms(refStr3, pageFrameCounts);

        for (int pageFrameCount : pageFrameCounts) {
            List<Integer> randomRefStr = PageReplacement.generateRandomRefString(15, 10);
            System.out.println("\nTesting with Random Reference String (Page Frames: " + pageFrameCount + "):");
            
            PageReplacement.testAlgorithm("FIFO", randomRefStr, new int[]{pageFrameCount}, FIFO::new);
            PageReplacement.testAlgorithm("LRU", randomRefStr, new int[]{pageFrameCount}, LRU::new);
            PageReplacement.testAlgorithm("OPT", randomRefStr, new int[]{pageFrameCount}, frames -> new OPT(frames, randomRefStr));
        }
    }
}