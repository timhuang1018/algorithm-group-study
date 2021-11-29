package leetcode._1011_capacity_to_ship_packages_within_d_days;

public class Solution {

    //find avg weight for each day
    //There is a min and max between all options we are searching -> binary search
    //use middle value of weight to check if it satisfy the days
    //not satisfy -> need to carry more weight -> make left bigger
    //satisfy -> try carry less weight -> try to make right smaller
    public int shipWithinDays(int[] weights, int days) {
        //init left and right as max weight, and total weight
        //if only one day, answer is total weight
        //if multiple days, minimum weight is the max one
        int left = 0, right = 0;
        for(int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }

        while(left <= right){
            int mid = left + (right - left)/2, needDays = 1, current = 0;
            for(int weight : weights){
                if(current + weight > mid){
                    current = 0;
                    needDays++;
                }
                current += weight;
            }

            if(needDays > days){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
