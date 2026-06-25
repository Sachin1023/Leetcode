class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        return unboundedKnapsack(coins,amount,n);
    }

    public int unboundedKnapsack(int []coins, int amount ,int n)
    {
        int [][]t = new int[n+1][amount+1];
        for(int a[]: t)//initialization
        {
            a[0]=1;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                if(coins[i-1]<=j)
                {
                    t[i][j]=t[i-1][j]+t[i][j-coins[i-1]];
                }
                else
                {
                    t[i][j]=t[i-1][j]; //processed, not take
                }
            }
        }
        return t[n][amount];
    }
}