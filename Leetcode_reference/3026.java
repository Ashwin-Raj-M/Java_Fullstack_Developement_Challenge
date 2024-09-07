class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = Integer.MIN_VALUE;
        for(int start = 0; start < nums.length; start++){
            for(int end = start; end < nums.length; end++){
                int subarray[] = Arrays.copyOfRange(nums,start,end+1);
                long temp = solve(subarray, k);
                if(temp > sum){
                    // System.out.println(sum);
                    sum = temp;
                    // System.out.println(sum);
                }
            }
        }
        return sum == Integer.MIN_VALUE ? 0 : sum;
    }
    private long solve(int[] sub, int k){
        System.out.println(Math.abs(sub[0] - sub[sub.length - 1]) == k);
        System.out.println(Math.abs(sub[0] - sub[sub.length - 1]));
        System.out.println(sub[0] + " " + sub[sub.length - 1]);
        System.out.println(Arrays.stream(sub).sum());
        return Math.abs(sub[0] - sub[sub.length - 1]) == k ? Arrays.stream(sub).sum() : Integer.MIN_VALUE;
        // if(Math.abs(sub[0] - sub[sub.length - 1]) == k) return Arrays.stream(sub).sum();
        // return Integer.MIN_VALUE;
    }
}