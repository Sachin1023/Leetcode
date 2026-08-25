class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int presum[] = new int [n];
        presum[0]=stones[0];
        for(int i=1;i<n;i++)
        {
            presum[i]=presum[i-1]+stones[i];
        }

        //o(1) 
        // int ans=presum[n-1];
        // for(int i=n-2;i>=1;i--)
        // {
        //     ans=Math.max(ans,presum[i]-ans);
        // }
        // return ans;

        //
        //dp -bottom up 
        //base case dp[n-1]=presum[n-1];
        int dp[]= new int[n];
        dp[n-1] =presum[n-1];
        for(int i=n-2 ; i>=1 ;i--)
        {   
           int take = presum[i] - dp[i+1];
           int skip = dp[i+1];
           dp[i]=Math.max(take,skip);
        }
        return dp[1];

        // // recursion 
        // // int dp[]= new int[n];
        // Integer [] dp = new Integer[n];
        // // Arrays.fill(dp, -1);
        // return solve(1,presum,n,dp); // as we can take more than 1, 0 base index


        // //dp -bottom up 
        // int dp[]= new int[n];
        // dp[n-1] =presum[n-1];
        // for(int i=n-2 ; i>=1 ;i--)
        // {
        //     dp[i]= Math.max(dp[i+1],presum[i]-dp[i+1]);
        // }
        // return dp[1];

    }

    // //recursion give TLE in 1 TC, use bottom up
    // int solve(int i, int presum[],int n, Integer []dp)
    // {
    //     if(i==n-1) 
    //         return presum[n-1];
    //     if(dp[i]!=null) return dp[i];

    //     int take = presum[i] - solve(i+1,presum,n,dp);
    //     int skip = solve(i+1,presum,n,dp);

    //     return dp[i]=Math.max(take,skip);
        
    // }
}