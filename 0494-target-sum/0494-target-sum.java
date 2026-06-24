class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        target=Math.abs(target); // normalize the input.
        int sum=0;
        for(int i:nums)
            sum+=i;

        if(sum<target || (sum + target)%2 != 0) { // if target > sum its impossible to reach it and if sum + target is odd, it also not possible 
            return 0;
        } 
        sum= (sum+target)/2;

        return subsetSumCount(n , sum , nums);
    }

    public int subsetSumCount(int n, int sum , int a[])
    {
        int dp [][] = new int [n+1][sum+1];

        for(int i=0;i<=n;i++)
            dp[i][0]=1;

        for(int i=1 ; i<=n ; i++)
        {
            for(int j =0; j<=sum ; j++)
            {
                if(a[i-1] <= j)
                    dp[i][j]=dp[i-1][j- a[i-1]] + dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}