class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int n=text1.length();
       int m=text2.length();
       int dp[][] = new int[n+1][m+1];
       for(int rows[]  : dp)
        Arrays.fill(rows,-1);
       return solve(text1,text2,n,m,dp); 
    }

    public int solve(String s, String t, int n,int m, int dp[][])
    {
        if(n==0 || m==0)
            return 0;
        if(dp[n][m] != -1)
            return dp[n][m];
        if(s.charAt(n-1) == t.charAt(m-1))
            return dp[n][m] =1+solve(s,t,n-1,m-1,dp);
        else{
            return dp[n][m] =Math.max(solve(s,t,n-1,m,dp), solve(s,t,n,m-1,dp));
        }
    }
}