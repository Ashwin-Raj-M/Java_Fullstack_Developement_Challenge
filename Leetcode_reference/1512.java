class Solution {
    // public int temp = 0;
    public int numIdenticalPairs(int[] nums) {
        
        return solve(nums, 0);
        // int flag = 0;
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = 0; j < nums.length; j++){
        //         if(i < j && nums[i] == nums[j]){
        //             flag++;
        //         }
        //     }
        // }
        // return flag;
    }
    public int solve(int[] nums, int i){
        int flag, temp = 0;
        if(i < nums.length){
            flag = solve1(nums, i, 0);
            temp += flag;
            solve(nums, i + 1);
        }
        return temp;
    }
    public int solve1(int[] nums, int i, int j){
        int temp = 0;
        if(j < nums.length){
            if(i < j && nums[i] == nums[j]){
                temp++;
                solve1(nums, i, j + 1);
            }
        }
        return temp;
    }
}