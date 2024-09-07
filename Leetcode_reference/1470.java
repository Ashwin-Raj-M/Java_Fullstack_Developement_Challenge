class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[n * 2];
        return solve(nums, ans, n, 0);
    }
    public int[] solve(int[] nums, int[] ans, int n, int i){
        if(i < n){
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[i + n];
            solve(nums, ans, n, i + 1);
        }
        return ans;
    }
}