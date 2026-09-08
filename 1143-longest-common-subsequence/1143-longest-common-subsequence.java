class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int n=text1.length();
       int m=text2.length();
    //memoization
    //    int dp[][] = new int[n+1][m+1];
    //    for(int rows[]  : dp)
    //     Arrays.fill(rows,-1);

    //printing LCS
       int dp[][]=solve(text1,text2,n,m);
       StringBuilder sb= new StringBuilder();
        int i=n,j=m;
        while(i>0 && j>0)
        {
            if(text1.charAt(i-1) == text2.charAt(j-1))
            {
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i][j]==dp[i-1][j])
                    j--;
                else
                    i--;
            }
        } 
        String lcs= sb.reverse().toString();
        System.out.println(lcs);
       return dp[n][m];
    }

    public int[][] solve(String s, String t, int n,int m)
    {   
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] =1+ dp[i-1][j-1];  // 1+solve(s,t,n-1,m-1,dp);
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // return dp[n][m];
        //print lcs
        return dp;


        // if(n==0 || m==0)
        //     return 0;
        // if(dp[n][m] != -1)
        //     return dp[n][m];
        // if(s.charAt(n-1) == t.charAt(m-1))
        //     return dp[n][m] =1+solve(s,t,n-1,m-1,dp);
        // else{
        //     return dp[n][m] =Math.max(solve(s,t,n-1,m,dp), solve(s,t,n,m-1,dp));
        // }
    }
}