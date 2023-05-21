class Solution {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;
        int sumAB = (brown / 2) - 2;
        int N = 0;
        for(int i = 1 ; i < brown/2 ; i++) {
            if(i * i + yellow == sumAB * i) {
                N = i + 2;
                break;
            }
        }
        if(N > totalSize/ N)
            return new int[] {N, totalSize / N};
        
        return new int[] {totalSize / N , N};
    }
}