package array;

public class Practice1 {


    // TC- O(n2) SC- O(1)
    private static int largestSumInSubArray(int[] arr) {

        int maxSum=0;
        for (int i = 0; i < arr.length; i++)
        {
            int sum=0;
            for (int j = i; j < arr.length; j++)
            {
                sum+=arr[j];
                if(maxSum<sum)
                    maxSum=sum;
            }
        }
        return maxSum;
    }

    // TC- O(n) SC- O(1) // this sol will not work  if all values are negative, it will return 0
    private static int KadanesLargestSumInSubArray(int[] arr) {

        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < arr.length; i++)
        {
            sum+=arr[i];

            if(sum<0)
                sum=0;

            if(maxSum<sum)
                maxSum=sum;
        }
        return maxSum;
    }

    //Input: nums = [-2,1,-3,4,-1,2,1,-5,4] // this sol work even if all values are negative
    private static int KadanesLargestSumInSubArrayV2(int[] arr) {
        int maxSum = arr[0];  // Start with first element
        int sum = arr[0];      // Initialize sum with first element

        for (int i = 1; i < arr.length; i++) {  // Start from index 1
            sum = Math.max(arr[i], sum + arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }


    public static void main(String[] args) {

        /*

         Given an integer array nums, find the subarray with the largest sum, and return its sum.
         Example:
         Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
         Output: 6
         Explanation: The subarray [4,-1,2,1] has the largest sum 6.
         */

    //        System.out.println(largestSumInSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        //System.out.println(largestSumInSubArray(new int[]{-2,-3,4,-1,-2,1,5,-3}));

        //System.out.println(KadanesLargestSumInSubArray(new int[]{-2,-3,4,-1,-2,1,5,-3}));
        //System.out.println(KadanesLargestSumInSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(KadanesLargestSumInSubArrayV2(new int[]{-2,-1,-3}));


       // System.out.println(KadanesLargestSumInSubArrayV2(new int[]{-2,-3,4,-1,-2,1,5,-3}));
       // System.out.println(KadanesLargestSumInSubArrayV2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));



    }
}
