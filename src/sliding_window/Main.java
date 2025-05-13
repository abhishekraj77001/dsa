package sliding_window;

import java.util.Arrays;

public class Main {

    //Best Time to Buy and Sell Stock
       public static int maxProfit(int[] prices) {

            int i=0,j=1;
            int buyPrice=Integer.MAX_VALUE,sellPrice=Integer.MIN_VALUE;
            int maxProfit=0;
            while(j<prices.length)
            {
                buyPrice=Math.min(buyPrice,prices[i]);
                sellPrice=prices[j];
                maxProfit=Math.max(maxProfit,sellPrice-buyPrice);
                i++;
                j++;
            }

            return maxProfit;
        }


    //

    // TC- O(n), SC-O(1)
    public static int[] searchRange(int[] nums, int target) {
        int l=0,h=nums.length-1;

        int[] res=new int[]{-1,-1};
        while(l<=h)
        {
            if(res[0]==-1)
            {
                if (nums[l]==target)
                    res[0]=l;
                else
                    l++;
            }
            if(res[1]==-1)
            {
                if (nums[h]==target){
                    res[1]=h;
                }else
                    h--;
            }

            if(res[0]!=-1 && res[1]!=-1)
                return res;
        }

        return res;
    }

    public static void main(String[] args) {


        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        //System.out.println(maxProfit(new int[]{7,6,4,3,1}));


    }
}
