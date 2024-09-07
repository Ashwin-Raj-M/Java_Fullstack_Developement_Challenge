class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ind = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++){
            if(words[i].indexOf(x) != -1){
                // System.out.println(str.contains(Character.toString(x)));
                // System.out.println(words.indexOf(str));
                // ind.add(words.indexOf(str));
                ind.add(i);
            } 
        }
        return ind;
    }
}
// class Solution {
//     public List<Integer> findWordsContaining(String[] words, char x) {
//         List<Integer> ind = new ArrayList<Integer>();
//         for (int i = 0; i < words.length; i++) {
//             if (words[i].contains(Character.toString(x))) {
//                 ind.add(i);
//             }
//         }
//         return ind;
//     }
// }