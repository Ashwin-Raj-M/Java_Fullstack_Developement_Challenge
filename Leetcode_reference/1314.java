class Solution {
    public int i;
    public int j;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // System.out.print(mat[1][1]);
        int[][] ans = new int[mat.length][mat[1].length];
        for(i = 0; i < mat.length; i++){
            for(j = 0; j < mat[i].length ; j++){
                ans[i][j] = solve(mat, k);
            }
        }
        return ans;
    }
    public int solve(int[][] mat, int k){
        int temp = 0;
        for(int r = i - k; r <= i + k; r++){
            for(int c = j - k; c <= j + k; c++){
                if(r >= 0 && r < mat.length && c >= 0 && c < mat[1].length){
                    temp += mat[r][c];
                }
            }
        }
        return temp;
    }
}