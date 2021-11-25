package leetcode;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 */
//roomCount
//  +1    +1      -1     +1
//s1:0  s2:5   e2:10   s3:15  e3:20   e1:30
//0 ->

public class Solution {

    //time complexity O(nlogn)
    //space complexity O(n)
    public static int minMeetingRooms(int[][] intervals){
        int max = 0,temp = 0;
        List<Pointer> pointers = new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            pointers.add(new Pointer(intervals[i][0],Boundary.START));
            pointers.add(new Pointer(intervals[i][1],Boundary.END));
        }
        Collections.sort(pointers, (o1, o2) -> o1.location - o2.location);


        for (int j = 0; j<pointers.size();j++){
            Pointer p = pointers.get(j);
            if (p.boundary==Boundary.START){
                temp++;
            }else{
                temp--;
            }
            max = Math.max(max,temp);
        }

        return max;
    }

    public static class Pointer{
        int location;
        Boundary boundary;
        public Pointer(int location,Boundary boundary){
            this.location = location;
            this.boundary = boundary;
        }
    }

    enum Boundary{
        START,END
    }

}
