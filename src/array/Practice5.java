package array;

public class Practice5 {


    static boolean isStringPalindrome(String string)
    {
        // TC- O(log N) SC- O(1)
        for(int i=0;i<string.length()/2;i++)
        {
            if(string.charAt(i)!=string.charAt(string.length()-(i+1)))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        // String array reversal using O(1) space
        // isStringPalindrome

        System.out.println(isStringPalindrome("madam"));
        System.out.println(isStringPalindrome("madama"));
        System.out.println(isStringPalindrome("aabb"));
        System.out.println(isStringPalindrome("abba"));
    }
}
