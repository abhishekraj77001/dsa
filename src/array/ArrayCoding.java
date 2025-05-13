package array;

import java.util.*;

public class ArrayCoding {

    // TC - O(n) , SC- O(1)
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int nSum= n*(n+1)/2;

        int currentSum=0;
        for(int num:nums)
            currentSum+=num;

        return nSum-currentSum;
    }

    // TC - O(n) , SC- O(n)
    public int findDuplicate(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for(int num:nums)
        {
            if(set.contains(num))
                return num;

            set.add(num);
        }

        return -1;
    }

    // TC- O(n) , SC- O(1)
    public int findDuplicateOptimal(int[] nums){
        int slow=nums[0];
        int fast=nums[0];

        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);

        slow=nums[0];
        while (slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] resArr=new int[temperatures.length];
        Stack<Integer> stack=new Stack();
        for(int i=temperatures.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i])
            {
              stack.pop();
            }

            resArr[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }

        return resArr;
    }

    // TC- O(n2) , SC- O(1)
    public int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(j!=i && nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }

    // TC - O(n) , SC- O(n)
    public int[] twoSumOptimal(int[] nums, int target) {

        Map<Integer,Integer> integerMap=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(integerMap.containsKey(target-nums[i]))
            {
                return new int[]{integerMap.get(target-nums[i]),i};
            }

            integerMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> uniqueSet=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        uniqueSet.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(uniqueSet);
    }

    // TC- O(n), SC-O(1)
    public static void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length)
        {
            if(nums[j]!=0)
            {
                nums[i++]=nums[j++];
            }else
            {
                j++;
            }
        }
        while(i<nums.length)
            nums[i++]=0;
    }


    // TC- O(n)+ O(n log n) +  O(2n) = O(n log n) , SC - O(2n)
    public static boolean carPooling(int[][] trips, int capacity) {

        if(capacity<trips.length)
            return false;

        int[][] splitArr=new int[trips.length*2][];
        int splitArrIndex=0;
        for (int[] trip : trips) {
            int[] enter = new int[]{trip[1], 1, trip[0]};
            int[] exit = new int[]{trip[2], 0, trip[0]};
            splitArr[splitArrIndex++] = enter;
            splitArr[splitArrIndex++] = exit;
        }

        //Arrays.sort(splitArr,Comparator.comparingInt(x->x[0]));
        Arrays.sort(splitArr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]); // exit(0) before enter(1)
        });

        int currentCap=0;
        for (int[] ints : splitArr) {
            if (ints[1] == 1)
                currentCap = currentCap + ints[2];
            else
                currentCap = currentCap - ints[2];

            if (currentCap > capacity)
                return false;
        }

        return true;
    }


    // TC- ?? , O(n) ??, SC- O(1)
    public static boolean carPoolingOptimal(int[][] trips, int capacity){

        int[] timestamp=new int[1001]; // as max trip can be 1000
        for(int[] trip: trips)
        {
            timestamp[trip[1]]+=trip[0];
            timestamp[trip[2]]-=trip[0];
        }

        int usedCapacity=0;
        for(int t:timestamp)
        {
            usedCapacity+=t;

            if(usedCapacity>capacity)
                return false;
        }
        return true;
    }

    // second largest element
    static int secondLargestElement(int[] arr)
    {
        int max=Integer.MIN_VALUE,secondMax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                secondMax=max;
                max=arr[i];
            }else if(secondMax<arr[i]) {
                secondMax=arr[i];
            }
        }
        return secondMax==Integer.MIN_VALUE?-1:secondMax;
    }


    public static void main(String[] args) {
//        int[] arr=new int[]{0,1,0,3,12};
//        moveZeroes(arr);
//        System.out.println(Arrays.toString(arr));

        int trips=2;
        int[][] splitArr=new int[trips][];
        splitArr[0]=new int[]{2,1,5};
        splitArr[1]=new int[]{3,3,7};


        //System.out.println(carPooling(splitArr,4));

        System.out.println(secondLargestElement(new int[]{12, 1, 35, 10, 34, 1}));


    }
}
