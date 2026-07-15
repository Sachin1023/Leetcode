class Solution {
    public int gcdOfOddEvenSums(int n) {
        int a=n*n;
        int b=n*(n+1);
        return gcd(a,b);
    }
    // public int gcd(int a,int b)
    // {
    //     while (b != 0) {
    //         int temp = b;
    //         b = a % b;
    //         a = temp;
    //     }
    //     return a;
    // }
    //recursive
     public int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}