package leetcode._239_sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        //create a deque for sliding window
        //add number from end into a deque
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int start = 0, end = 0;


        for (; end<nums.length; end++){
            //kickout all value not bigger than this value
            while(!deque.isEmpty() && deque.peekLast() < nums[end]){
                deque.pollLast();
            }
            deque.addLast(nums[end]);

            //compare if distance between end and start is equal to result.length
            //remove word from start, if remove tempMax, compare with number at end
            if(end - start == k - 1){
                result[start] = deque.peekFirst();
                if (nums[start] == deque.peekFirst()){
                    deque.pollFirst();
                }
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);

        //expected 3,3,1,5
        solution.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);

        //expected 7,4
        solution.maxSlidingWindow(new int[]{7,2,4}, 2);
    }
}
