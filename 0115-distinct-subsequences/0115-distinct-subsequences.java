class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        //reduce space by using 2 array .
        int prev[] = new int[m + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {

            int [] cur = new int[m + 1];
            cur[0] = 1;

            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = prev[j - 1] + prev[j];
                } else {
                    cur[j] = prev[j];
                }
            }

            prev = cur;
        }

        return prev[m];

        //bottom up
        // return solveDp(s, t, n, m);

        //recursive _+ memoization
        // int[][] dp = new int[n+1][m+1];
        // for(int []a : dp)
        // {
        //     Arrays.fill(a,-1);
        // }
        // solve(s,t,n,m,dp);
        // return dp[n][m];
    }

    //botom up
    public int solveDp(String s, String t, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        //dp[n][m]
        //initilzaition
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    //recursive _+ memoization
    public int solve(String s, String t, int n, int m, int[][] dp) {
        // recursive + memoization
        if (m == 0) {
            return dp[n][m] = 1;
        }
        if (n == 0) {
            return dp[n][m] = 0;
        }
        if (dp[n][m] != -1)
            return dp[n][m];

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            return dp[n][m] = solve(s, t, n - 1, m - 1, dp) + solve(s, t, n - 1, m, dp);
        } else {
            return dp[n][m] = solve(s, t, n - 1, m, dp);
        }
    }
}