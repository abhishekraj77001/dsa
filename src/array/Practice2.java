package array;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Practice2 {



    // TC- O(N)+O(N)=2O(N)= O(N) , SC- O(N)
    static int majorityElementFormAnArray(int[] arr)
    {
        Map<Integer,Integer> countMap=new HashMap<>();

        for(Integer i:arr)
        {
//            if(countMap.containsKey(i))
//            {
//                countMap.put(i, countMap.get(i) +1);
//            }else
//                countMap.put(i,1);
            countMap.put(i,countMap.getOrDefault(i,0)+1);
        }

        Map.Entry<Integer,Integer> maxEntry=new AbstractMap.SimpleEntry<>(0,0);
        for(Map.Entry<Integer,Integer> entry:countMap.entrySet())
        {
            if(entry.getValue()>maxEntry.getValue())
                maxEntry=entry;
        }

        return maxEntry.getKey();
    }

    // TC- O(N) , SC- O(1)
    static int majorityElementFormAnArrayByMooreVotingAlgo(int[] arr)
    {
        int currentVotingElement=0;
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(count==0)
                currentVotingElement=arr[i];

            if(arr[i]==currentVotingElement)
                count++;
            else
                count--;
        }

        // check if the current element is actually majority element
        // in case if array doesn't contain the majority element
        int c=0;
        for(int i:arr)
        {
            if(currentVotingElement==i)
                c++;
        }

        return c>arr.length/2?currentVotingElement:-1;
    }

    public static void main(String[] args) {

        /*

 Given an array nums of size n, return the majority element.
 The majority element is the element that appears more than ⌊n / 2⌋ times.
 You may assume that the majority element always exists in the array.

 Example 1:
 Input: nums = [3,2,3]Output: 3
 Example 2:
 Input: nums = [2,2,1,1,1,2,2]Output: 2

         */

        System.out.println(majorityElementFormAnArray(new int[]{3,2,3}));
        System.out.println(majorityElementFormAnArray(new int[]{2,2,1,1,1,2,2}));

        System.out.println(majorityElementFormAnArrayByMooreVotingAlgo(new int[]{3,2,3}));
        System.out.println(majorityElementFormAnArrayByMooreVotingAlgo(new int[]{2,1,1,1,1,2,2}));

    }
}
