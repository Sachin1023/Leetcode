class Solution {
    public int change(int amount, int[] coins) {
        return unboundedknapsack(coins,coins.length,amount);
    }

    public int unboundedknapsack(int wt[], int n, int w)
    {
        int t[][]= new int[n+1][w+1];
        //initialization
        for(int i=0;i<=n;i++)
        {
            t[i][0]=1;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=w;j++)
            {   
                if(wt[i-1]<=j)
                    t[i][j]=t[i-1][j]+t[i][j-wt[i-1]];
                else
                    t[i][j]=t[i-1][j];
            }
        }
        return t[n][w];
    }
}