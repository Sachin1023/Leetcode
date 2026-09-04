class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int largestTillNow=-1;
        int[] smallestno= new int[n];
        smallestno[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            smallestno[i]=Math.min(smallestno[i+1],nums[i]);
        }

        for(int i=0;i<n;i++)
        {
            largestTillNow=Math.max(largestTillNow,nums[i]);
            // int stableno=largestTillNow -smallestno[i];/
            if(largestTillNow -smallestno[i] <=k)
                return i;
        }

        return -1;
    }
}