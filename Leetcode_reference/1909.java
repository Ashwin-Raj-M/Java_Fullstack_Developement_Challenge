class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int max = 0;
        int clone[] = new int[nums.length - 1];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0, k = 0; j< nums.length; j++){
                if(i == j){
                    continue;
                }else{
                    clone[k++] = nums[j];
                }
            }
            if(solve(clone) == 1){
                System.out.println(nums[i]);
                return true;
            } 
        }
        return false;    
    }
    public int solve(int[] clone){
        for(int i = 0; i < clone.length - 1; i++){
            if(clone[i] >= clone[i + 1]) return 0;
        }
        return 1;
    }
}