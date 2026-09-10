class Solution {
    int mod = (int)1e9+7;
    public int distinctSubseqII(String s) {
        int n=s.length();
        int [] lastseen = new int[26];
        int [] prev = new int[n+1]; //1 base, last time we saw nth index

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

        for(int i=1; i<=n;i++)
        {
            int idx = s.charAt(i-1) -'a';
            prev[i]=lastseen[idx];
            lastseen[idx]=i;
        }   

        dp[0]=1;
        for(int i=1;i<=n;i++)
        {
            int total = (2*dp[i-1])%mod;
            if(prev[i]!=0)
            {
                int duplicate = dp[prev[i]-1];
                total= (total - duplicate + mod)%mod;
            }
            dp[i]=total;
        }
        return (dp[n]-1+mod)%mod;
        // return (solve(n,dp,prev)-1 +mod)%mod;
    }
    

    //recursion
    // int solve(int n,int dp[],int []prev)
    // {
    //     if(n==0)
    //      return 1;
        
    //     if(dp[n]!=-1)
    //         return dp[n];
        
    //     int total = (2* solve(n-1,dp,prev))%mod;

    //     if(prev[n]!=0)
    //     {
    //         int duplicate = solve(prev[n]-1,dp,prev);
    //         total= (total - duplicate + mod)%mod;
    //     }    

    //     return dp[n]=total;
    // }
}