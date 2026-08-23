class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0, product=1;
        int temp =n;
        while(temp!=0)
        {
            int lastDigit = temp%10;
            sum+=lastDigit;
            product*=lastDigit;
            temp/=10;
        }

        return n%(sum+product)==0;
    }
}