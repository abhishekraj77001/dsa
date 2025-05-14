package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice3 {

    // TC- O(N2) , SC- O(1)
    static int[] getIndicesOfTargetSum(int[] nums,int target)
    {
        int[] indices=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return indices;
    }

    // TC- O(N) , SC- O(N)
    static int[] getIndicesOfTargetSumOptimal(int[] nums,int target)
    {
        Map<Integer,Integer> indicesMap=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int compliment= target - nums[i];
            if(indicesMap.containsKey(compliment))
                return new int[]{indicesMap.get(compliment),i};

            indicesMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }



    public static void main(String[] args) {

        /*
         Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 You can return the answer in any order.

 Example 1:
 Input: nums = [2,7,11,15], target = 9 Output: [0,1]Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 Example 2:
 Input: nums = [3,2,4], target = 6Output: [1,2]
 Example 3:
 Input: nums = [3,3], target = 6Output: [0,1]
         */


        System.out.println(Arrays.toString(getIndicesOfTargetSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(getIndicesOfTargetSum(new int[]{3,2,4},6)));
        System.out.println(Arrays.toString(getIndicesOfTargetSum(new int[]{3,3},6)));

        System.out.println("---------------");

        System.out.println(Arrays.toString(getIndicesOfTargetSumOptimal(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(getIndicesOfTargetSumOptimal(new int[]{3,2,4},6)));
        System.out.println(Arrays.toString(getIndicesOfTargetSumOptimal(new int[]{3,3},6)));




    }
}
