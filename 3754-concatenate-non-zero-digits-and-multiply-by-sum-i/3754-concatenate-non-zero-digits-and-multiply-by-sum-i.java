class Solution {
    public long sumAndMultiply(int n) {
        
        int sum=0;
        int res=0;
        String num= String.valueOf(n);
        for(char c : num.toCharArray())
        {
            int digit = c-'0';
            // System.out.println(digit);
            if(digit!=0)
            {       
                sum=sum+digit;
                // System.out.println(sum+ " sum");
                res=res*10+digit;
                // System.out.println(res + "res ");
            }
        }
        long ans= 1L*res*sum;
        return ans;
    }
}