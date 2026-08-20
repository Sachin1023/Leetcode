class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        //try using 1 array.
        int a [] = new int [n];
        int i=0, j=n-1;
        a[i++]=nums[0];
        a[j--]=nums[1]; // for second array . adding data in reverse for it.
        for(int k=2 ;k<n;k++)
        {
            if( a[i-1] > a[j+1])
            {
                a[i++]=nums[k];
            }
            else{
                a[j--]=nums[k];
            }
        }   

        //now we need to reverse the data of a[0---i,j----n] for the j portion .
        // after last increment i will be in correct place to iterate.
        // System.out.println(i); 
        j=n-1;
        while(i<j)
        {
            int temp = a[j];
            a[j]=a[i];
            a[i]=temp;
            i++;
            j--;
        }

        //using two array.
        // int a[] = new int[n];
        // int b[]= new int[n];
        // int i=0, j=0;
        // a[i++]=nums[0];
        // b[j++]=nums[1];

        // //iteration of nums 
        // for(int k=2; k<n;k++)
        // {
        //     if(a[i-1]>b[j-1])
        //     {   
        //         a[i++]=nums[k];
        //     }
        //     else{
        //         b[j++]=nums[k];
        //     }
        // }
        // j=0; // not using a new array for result using the first array and adding array 2 data into it
        // while( b[j]!=0)
        // {
        //     a[i++]=b[j++];
        // }

        return a;

    }
}