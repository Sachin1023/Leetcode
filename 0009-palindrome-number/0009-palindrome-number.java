class Solution {
    public boolean isPalindrome(int x) {
        if(x <0)
            return false;
        // String s = String.valueOf(x);
        // int j=s.length()-1;
        // for(int i=0;i < s.length()/2; i++)
        // {
        //     int a = s.charAt(i)- '0';
        //     int b = s.charAt(j)-'0';
        //     if(a!=b)
        //         return false;
        //     j--;
        // }
        // return true;

        int rev=0;
        int n=x;
        while(n!=0)
        {
            int lastdigit= n%10;
            rev= (rev*10)+ lastdigit;
            n=n/10;
        }

        return rev==x;

    }
}