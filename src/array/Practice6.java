package array;

public class Practice6 {

    // TC- O(log N) , SC- O(1)
    static char[] reverseString(char[] arr)
    {

        for(int i=0;i<arr.length/2;i++)
        {
            char temp=arr[i];
            arr[i]=arr[arr.length-(i+1)];
            arr[arr.length-(i+1)]=temp;
        }
        return arr;
    }

    public static void main(String[] args) {

        // String array reversal using O(1) space
        System.out.println(new String(reverseString(new char[]{'a','b','h','i'})));
        System.out.println(new String(reverseString(new char[]{'m','a','d','a','m'})));
    }
}
