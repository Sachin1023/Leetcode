class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount+1;

        // Initialize
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0;  // base case

        // Fill DP
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}