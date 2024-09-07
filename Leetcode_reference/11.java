class Solution {
    public int maxArea(int[] height) {
        int volume = 0, temp = 0;
        // O(n^2) solution:
        // for(int i = 0; i < height.length; i++){
        //     for(int j = 0; j < height.length; j++){
        //         if(i == j) continue;
        //         int gap = Math.abs(i - j);
        //         // System.out.println(gap);
        //         volume = gap * Math.min(height[i], height[j]);
        //         // System.out.println(volume);
        //         temp = Math.max(volume,temp);
        //         // System.out.println(temp);
        //         // System.out.println("\n");
        //     }
        // } 
        // O(n) solution:
        int l = 0, r = height.length - 1;
        while (l < r){
            volume = (r - l) * Math.min(height[l], height[r]);
            temp = Math.max(volume,temp);

            if(height[l] < height[r]) l++;
            else r--;
        }
        return temp;
    }
}