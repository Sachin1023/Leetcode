class Solution {
    //recursive with memoizaiton
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        if(n==1) return 0;
        int presum[]= new int[n];
        presum[0]= stoneValue[0];
        for(int i=1;i<n;i++)
        {
            presum[i]=presum[i-1]+stoneValue[i];
        }

        int dp[][] = new int[n+1][n+1];
        for(int a[] : dp)
        {
            Arrays.fill(a,-1);
        }
        return solve(0,n-1,presum,dp);
    }

    public int solve(int l , int r , int [] presum, int[][] dp)
    {   
        if(l>=r)
        {
            return 0; // no division can be done 
        }
        if(dp[l][r] != -1)
            return dp[l][r];

        int score=0;
        for(int mid=l; mid<=r-1;mid++)
        {
            int leftsum = presum[mid] - ( l-1>=0? presum[l-1]:0); // [l--mid]
            int rightsum= presum[r] - presum[mid]; //[mid+1 --- r];

            if(leftsum < rightsum)
            {
                score = Math.max(score,leftsum+solve(l,mid,presum,dp));
            }
            else if(leftsum > rightsum)
            {
                score = Math.max(score,rightsum+solve(mid+1,r,presum,dp));
            }
            else{ //leftsum==rightsum
                score = Math.max(rightsum+solve(mid+1,r,presum,dp),leftsum+solve(l,mid,presum,dp));
            }
        }
        return dp[l][r]=score;

    }
}