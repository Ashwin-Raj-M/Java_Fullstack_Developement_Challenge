class Solution {
    public int[] buildArray(int[] nums) {
        int ans[] = new int[nums.length];
        return solve(nums, ans, 0);
    }
    public int[] solve(int[] nums, int[] ans, int i){
        if(i < nums.length){
            ans[i] = nums[nums[i]];
            solve(nums, ans, i+1);
        }
        return ans;
    }
}