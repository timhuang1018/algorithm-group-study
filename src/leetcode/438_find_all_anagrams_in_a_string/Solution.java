package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    //compare all letters in p with each index in s
    //from range i til i+ p.length
    //keep index for results if valid

    //time complexity O(N * M) space complexity O(M)

    //one character in, and one character out to remove duplicate move
    //time complexity O(N)
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, matchCount =0;

        while(right < s.length()){

            //join
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);

                if(map.get(rightChar) == 0){
                    matchCount++;
                }
            }
            right++;

            //determine
            if(matchCount == map.size()){
                result.add(left);
            }

            //leave
            if(right - left == p.length()){

                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar) == 0){
                        matchCount--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }

                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //expected [0, 6]
        System.out.println(solution.findAnagrams("cbaebabacd","abc"));
    }
}
