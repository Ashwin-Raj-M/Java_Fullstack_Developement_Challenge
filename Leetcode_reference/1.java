class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int temp[] = new int[2];
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                // System.out.println(i + " " + j);
                // System.out.println(nums[i] + nums[j]);
                if(nums[j] + nums[j-i] == target){
                    // temp[0] = i;
                    // temp[1] = j;
                    return new int[]{j, j - i};
                }
                else continue;
            }
        }
        return new int[]{0,0};
    }
}