package other;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while(i < firstList.length && j < secondList.length){
            int maxStart = Math.max(firstList[i][0], secondList[j][0]);
            int minEnd = Math.min(firstList[i][1], secondList[j][1]);

            if(maxStart <= minEnd) result.add(new int[]{maxStart, minEnd});

            if(minEnd == firstList[i][1]){
                i++;
            }else{
                j++;
            }
        }

        int[][] finalResult = new int[result.size()][2];

        for(int k=0; k<result.size(); k++){
            finalResult[k] = result.get(k);
        }

        return finalResult;
    }
}
