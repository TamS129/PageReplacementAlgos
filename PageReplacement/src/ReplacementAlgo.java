public abstract class ReplacementAlgo {
    protected int pageFaultCount;
    protected int pageFrameCount;

    public ReplacementAlgo(int pageFrameCount){

        if(pageFrameCount < 0){
            throw new IllegalArgumentException();

        }
        this.pageFrameCount = pageFrameCount;
        this.pageFaultCount = 0;
    }

    public int getPageFaultCount() {
        return pageFaultCount;
    }

    public abstract void insert(int pageNumber);
}
