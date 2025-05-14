package array;

import java.util.Arrays;
import java.util.Stack;

public class Practice7 {


    // TC- O(N2) SC- O(N)
    static boolean[] getTempFlagArray(int[] arr)
    {
        boolean[] ans=new boolean[arr.length];
        int answerIndex=0;
        for(int i=0;i<arr.length;i++)
        {
            boolean flag=false;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]<arr[j])
                {
                    flag=true;
                    break;
                }
            }
            ans[answerIndex++]=flag;
        }
        return ans;
    }

    // TC- O(N+X) SC- O(N)
    static boolean[] getTempFlagArrayOptimal(int[] arr)
    {
        boolean[] ans=new boolean[arr.length];
        Stack<Integer> integerStack=new Stack<>();

        for(int i=arr.length-1;i>=0;i--)
        {
          int val=arr[i];
          if(integerStack.isEmpty())
              ans[i]=false;
          else {
              int peekValue=integerStack.peek();
              if(peekValue>val)
                  ans[i]=true;
              else {
                  while (!integerStack.isEmpty())
                  {
                      int popValue=integerStack.pop();
                      if(popValue>val){
                          ans[i]=true;
                          integerStack.push(popValue);
                          break;
                      }
                  }
              }
          }
          integerStack.push(arr[i]);
        }
        return ans;
    }

    /*
    How Many Times Does pop() Run?
    Each element is pushed onto the stack at most once.
    Each element is popped from the stack at most once.
    Since every element is pushed once and popped once,
    the total number of pop() operations across the entire loop is at most N.
    TC- O(N) + O(N) for and one for pop while, SC- O(N) + O(N) one is for stack another is for ans
     */
    static boolean[] getTempFlagArrayOptimalV2(int[] arr){

        boolean[] ans=new boolean[arr.length];
        Stack<Integer> integerStack=new Stack<>();

        for(int i=arr.length-1;i>=0;i--)
        {
            while (!integerStack.isEmpty() && integerStack.peek()<=arr[i])
                integerStack.pop();

            ans[i]= !integerStack.isEmpty();
            integerStack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {


        /*

        Given an array of integers temperatures represents the daily temperatures,
        return an array answer such that answer[i] array is true if there is any day warmer after ith day
        Example 1:
        Input: temperatures = [73,74,75,71,69,72,76,73]
 Output: [true,true,true,true,true,true,false,false]
 Example 2:
 Input: temperatures = [30,40,50,60]
 Output: [true,true,true,false]
 Example 3:
 Input: temperatures = [30,60,90]
 Output: [true,true,false]
         */

        System.out.println(Arrays.toString(getTempFlagArray(new int[]{4,12,5,3,1,2,5,3,1,2,4,6})));
        System.out.println(Arrays.toString(getTempFlagArray(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(getTempFlagArray(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(getTempFlagArray(new int[]{30,60,90})));

        System.out.println("---------------------");

        System.out.println(Arrays.toString(getTempFlagArrayOptimalV2(new int[]{4,12,5,3,1,2,5,3,1,2,4,6})));
        System.out.println(Arrays.toString(getTempFlagArrayOptimalV2(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(getTempFlagArrayOptimalV2(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(getTempFlagArrayOptimalV2(new int[]{30,60,90})));
    }
}
