class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        boolean test = true; 
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length; j++){
                if (j == i) continue;
                for(int k = 2; k < nums.length; k++){
                    if (k == j || k == i) continue;
                    List<Integer> temp = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k]));
                    System.out.println(temp.stream().mapToInt(Integer::intValue).sum());
                    // test = check(arr, temp);
                    if(temp.stream().mapToInt(Integer::intValue).sum() == 0 && i < j && j < k && test){
                        System.out.println("inside");
                        arr.add(temp);
                        System.out.println("added");
                    }
                    test = check(arr, temp);
                } 
            }
        }
        // if(test == false) arr.remove(arr.size() - 1);
        // return new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(-1,0,1),Arrays.asList(-1,2,-1)));
        return arr;
    }
    private boolean check(List<List<Integer>> arrs, List<Integer> temp){
        if(arrs.size() == 0) return true;
        int flag = 0;
        for(List<Integer> arr : arrs){
            for(int i = 0; i < arr.size(); i++){
                if(temp.contains(arr.get(i))){
                    flag++;
                }
            }
        }
        if(flag == 3) return false;
        else return true;
    }
}