class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x : nums)
        {
            sum+=x;
        }
        if(sum%2!=0) return false;

        // as Sum == even, it can be divided into 2 equal sums. 
        //will run subset sum for sum/2 and if that possible return true or false

        //subset sum for sum/2 
        sum=sum/2;
        boolean t[][] = new boolean[n+1][sum+1];
        //initialization
        for(int i=0;i<=n;i++)
        {
            t[i][0]=true;
        }


        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(nums[i-1]<=j)
                {
                    t[i][j]=  t[i-1][j-nums[i-1]] || t[i-1][j];
                }
                else
                    t[i][j]=t[i-1][j];
            }
        }
        return t[n][sum];
    }
}