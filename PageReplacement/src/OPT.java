import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OPT extends ReplacementAlgo{

    private List<Integer> pages;
    private List<Integer> ref;
    public OPT(int pageFrameCount, List<Integer> ref) {
        super(pageFrameCount);
        this.pages = new LinkedList<>();
        this.ref = new ArrayList<>(ref);
    }

    @Override
    public void insert(int pageNumber) {
        if(!pages.contains(pageNumber)){
            if(pages.size() >= pageFrameCount){
                int farIndex = -1;
                int pageReplace = -1;

                for(int page : pages){
                    int index = ref.indexOf(page);

                    if(index == -1){
                        pageReplace = page;
                        break;
                    } else if(index > farIndex){
                        farIndex = index;
                        pageReplace = page;
                    }
                }

                pages.remove(Integer.valueOf(pageReplace));

            }
            pages.add(pageNumber);
            pageFaultCount++;

        }

        ref.remove(Integer.valueOf(pageNumber));

    }
}
