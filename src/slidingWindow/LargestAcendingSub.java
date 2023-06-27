package slidingWindow;

public class LargestAcendingSub {
    int[] bestEndingAtMemo;

    public int solution(int[] A){
        int maxSize = 1;
        int maxSizeBegin = 0;
        this.bestEndingAtMemo = new int[A.length];
        for (int k=0; k<A.length; k++){
            if (k==0) {
                bestEndingAtMemo[0] = 1;
                continue;
            }
            if(A[k] > A[k-1]) {
                bestEndingAtMemo[k] = bestEndingAtMemo[k-1] + 1;
                if (bestEndingAtMemo[k] > maxSize){
                    maxSize = bestEndingAtMemo[k];
                    maxSizeBegin = k - maxSize + 1;
                }
            }
            else{
                bestEndingAtMemo[k] = 1;
            }
        }
        System.out.println("MaxSize is " + maxSize);
        return maxSizeBegin;
    }
}
