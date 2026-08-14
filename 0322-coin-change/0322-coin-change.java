class Solution {
    public int coinChange(int[] coins, int amount) {
       int n=coins.length;
       int res= unboundedKnapsack(coins,amount,n);
        return  res== Integer.MAX_VALUE-1 ? -1 : res;
    }

    public int unboundedKnapsack(int []coins, int amount ,int n)
    {
       int t[][]= new int[n+1][amount+1];
       //initilizaition;
       int inf = Integer.MAX_VALUE-1;

       for(int j=0;j<=amount ;j++)
       {
            t[0][j]=inf;
       }
       //for 2nd row
       for(int j=1;j<=amount;j++)
       {
            if( j%coins[0]==0)
            {
                t[1][j]=j/coins[0];
            }
            else
                t[1][j]=inf;
       }

       for(int i=2;i<=n;i++)
       {
        for(int j=1;j<=amount;j++)
        {
            if(coins[i-1]<=j)
            {
                t[i][j]=Math.min(t[i-1][j] ,1+t[i][j-coins[i-1]]);
            }else
                t[i][j]=t[i-1][j];
        }
       }
       return t[n][amount];
    }
    
}