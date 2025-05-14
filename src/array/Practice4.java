package array;

public class Practice4 {

    // TC- O(N) SC- O(1)
    static int searchInsert(int[] nums, int target) {

            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>=target)
                    return i;
            }
            return nums.length;
    }

    // TC- O(log n) SC- O(1)
    static int searchInsertOptimal(int[] nums, int target) {

        int low=0,high=nums.length-1,ans=nums.length;
        while (low<=high)
        {
            int mid= (low+high)/2;
            if(nums[mid]>=target)
            {
                high=mid-1;
                ans=mid;
            }
            else
                low=mid+1;
        }

        return ans;
    }


    public static void main(String[] args) {

        /*

            Find the index where the target value can be inserted in an sorted array
            int nums[] = {1,5,7,12,15,20};
            int target=14;
            output : 4
         */

        System.out.println(searchInsert(new int[]{1,5,7,12,15,20},14));
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsert(new int[]{1,3,5,6},7));


        System.out.println("----------------------");

        System.out.println(searchInsertOptimal(new int[]{1,5,7,12,15,20},14));
        System.out.println(searchInsertOptimal(new int[]{1,3,5,6},5));
        System.out.println(searchInsertOptimal(new int[]{1,3,5,6},2));
        System.out.println(searchInsertOptimal(new int[]{1,3,5,6},7));

    }
}
