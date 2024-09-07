class Solution {
    public int x = 0;
    public int finalValueAfterOperations(String[] operations) {
        solve(operations, 0);
        return x;
    }
    public void solve(String[] ope, int i){
        if(i < ope.length){
            x += ((ope[i].equals("X++") || ope[i].equals("++X")) ? 1 : -1);
            solve(ope, i + 1);
        }
    }
}