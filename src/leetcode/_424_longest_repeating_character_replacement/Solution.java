package leetcode._424_longest_repeating_character_replacement;

public class Solution {

    //check max count inside window (start ~ end)
    //end - start + 1 - maxCount == 0 means there are all same char in window
    //if end - start + 1 - maxCount > 0 means there are different char
    //max length are count as valid string where end - start + 1 - maxCount <= k
    public int characterReplacement(String s, int k) {

        int[] charsCount = new int[26];
        int maxCount = 0, start=0, end=0, maxLen = 0;

        while(end < s.length()){

            maxCount = Math.max(maxCount, ++charsCount[s.charAt(end) - 'A']);
            if(end - start + 1 - maxCount <= k){
                maxLen = Math.max(maxLen, end - start + 1);
            }

            if(end - start + 1 - maxCount > k){
                --charsCount[s.charAt(start) - 'A'];
                start++;
            }
            end++;
        }

        return maxLen;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        //expected 4
        System.out.println(solution.characterReplacement("AABABBA",1));

        //expected 4
        System.out.println(solution.characterReplacement("AAAA",2));
    }
}
