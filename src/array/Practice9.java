package array;

import java.util.*;

public class Practice9 {

    static int[][] mergeIntervals(int[][] arr)
    {

        List<int[]> list=new ArrayList<>();
        int[] currentInterval=new int[2];
        currentInterval[0]=arr[0][0];
        currentInterval[1]=arr[0][1];
        for(int i=1;i<arr.length;i++)
        {
               if(currentInterval[1]>=arr[i][0])
               {
                   currentInterval[1]=arr[i][1];
               }else{
                   list.add(currentInterval);
                   currentInterval=new int[2];
                   currentInterval[0]=arr[i][0];
                   currentInterval[1]=arr[i][1];
               }

        }
        list.add(currentInterval);
        int[][] ansArr=new int[list.size()][];
        for(int i=0;i<list.size();i++)
        {
            ansArr[i]=list.get(i);
        }
        return ansArr;
    }

    static int[][] mergeIntervalsOptimal(int[][] arr)
    {

        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        List<int[]> list=new LinkedList<>();
        for(int[] interval:arr)
        {
                if(list.isEmpty() || list.getLast()[1]<interval[0])
                {
                    list.add(interval);
                }
                else
                {
                    list.getLast()[1]=Math.max(list.getLast()[1],interval[1]);
                }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

        /*

        Given a collection of shift timing , merge all overlapping shifts .

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]

 Test Case 1: Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are merged into [1,5].
 Test Case 2: Input: [[1,4],[0,2],[3,5]] Output: [[0,5]] Explanation: Intervals [1,4], [0,2], and [3,5] are all merged into [0,5].
 Test Case 3: Input: [[1,4],[2,3]] Output: [[1,4]] Explanation: Interval [2,3] is completely within [1,4], so they are merged into [1,4].
 Test Case 4: Input: [[1,4],[5,6]] Output: [[1,4],[5,6]] Explanation: Intervals [1,4] and [5,6] do not overlap, so they remain separate.
 Test Case 5: Input: [[1,10],[2,6],[8,10],[15,18]] Output: [[1,10],[15,18]] Explanation: Intervals [1,10], [2,6], and [8,10] are merged into [1,10], while [15,18] remains separate.
 Test Case 6: Input: [[1,3],[2,6],[8,10],[15,18],[17,20]] Output: [[1,6],[8,10],[15,20]] Explanation: Intervals [1,3] and [2,6] are merged into [1,6], and intervals [15,18] and [17,20] are merged into [15,20].
         */

        //int[][] arr=mergeIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        //int[][] arr=mergeIntervals(new int[][]{{1,4},{4,5}});


        int[][] arr=mergeIntervalsOptimal(new int[][]{{1,3},{8,10},{15,18},{2,6}});
        //int[][] arr=mergeIntervalsOptimal(new int[][]{{1,4},{4,5}});

        for(int[] a:arr)
            System.out.println(a[0]+" "+a[1]);

    }
}
