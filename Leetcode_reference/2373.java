class Solution {
    public int[][] largestLocal(int[][] grid) {
        int maxlocal[][] = new int[grid.length - 2][grid.length - 2];
        for(int i = 0; i < maxlocal.length; i++){
            for(int j = 0; j < maxlocal.length; j++){
                // System.out.println(i + " " + j);
                maxlocal[i][j] = maxi(grid, i, j);
            }
        }
        return maxlocal;
    }
    public int maxi(int[][] grid, int k, int l){
        int maxVal = 0;
        for(int i = k; i < k + 3; i++){
            for(int j = l; j< l + 3; j++){
                // System.out.println(i + " " + j);
                maxVal = Math.max(maxVal,grid[i][j]);
            }
        }
        return maxVal;
    }
}