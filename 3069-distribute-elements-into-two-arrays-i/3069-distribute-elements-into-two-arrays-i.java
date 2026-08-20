class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int a[] = new int[n];
        int b[]= new int[n];
        int i=0, j=0;
        a[i++]=nums[0];
        b[j++]=nums[1];

        //iteration of nums 
        for(int k=2; k<n;k++)
        {
            if(a[i-1]>b[j-1])
            {   
                a[i++]=nums[k];
            }
            else{
                b[j++]=nums[k];
            }
        }
        j=0; // not using a new array for result using the first array and adding array 2 data into it
        while( b[j]!=0)
        {
            a[i++]=b[j++];
        }
        return a;

    }
}