class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n==1 ) return 1;
        int min =Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        int maxI=-1, minI=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
                minI=i;
            }
            if(nums[i]>max)
            {
                max=nums[i];
                maxI=i;
            }
        }

        //
        // int a=Math.min(minInd,maxInd); //min of both
        // int b =Math.max(minInd,maxInd); // max of both
        //  int front=b+1; //removing both element from front, max +1
        //  int back=n-a;  //removing both elemetn from back,  n- min
        //  int both=(a+1)+(n-b); // removing min from left + max form right
        //  return Math.min(front,Math.min(back,both)); //return min of all the three

        //sagar
        int minIdx = Math.min(maxI,minI);
        int maxIdx = Math.max(maxI,minI);
        //left
        int leftcount = minIdx;
        //mid/
        int midcount = maxIdx-minIdx-1;
        //right
        int rightcount = n-maxIdx-1;
        int max3 = Math.max(leftcount,Math.max(midcount,rightcount));

        return n-max3;

    }
}