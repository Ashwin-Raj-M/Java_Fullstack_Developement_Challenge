class Solution {
    public int maximumWealth(int[][] acc) {
        int wel = 0;
        for(int[] arr : acc){
            wel = Math.max(wel, Arrays.stream(arr).sum());
        }
        return wel;
    }
}