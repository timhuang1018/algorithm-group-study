package leetcode._881_boats_to_save_people;

import java.util.Arrays;

public class Solution {


    //time O(nlogn)
    //space O(1)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length -1, count = 0;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            count++;
            right--;
        }


        return count;
    }

}
