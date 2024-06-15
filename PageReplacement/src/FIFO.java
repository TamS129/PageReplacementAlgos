import java.util.LinkedList;
import java.util.Queue;


public class FIFO extends ReplacementAlgo {

    Queue<Integer> pages;


    public FIFO(int pageFrameCount){
        super(pageFrameCount);
        this.pages = new LinkedList<>();

    }

    @Override
    public void insert(int pageNumber){
        if(!pages.contains(pageNumber)){
            if(pages.size() >= pageFrameCount){

                pages.poll();
            }
            pages.add(pageNumber);
            pageFaultCount++;
        }

    }

}
