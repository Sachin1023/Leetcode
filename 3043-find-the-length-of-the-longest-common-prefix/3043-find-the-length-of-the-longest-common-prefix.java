class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int x:arr1)
        {
            while(x!=0)
            {
                set.add(x);
                x=x/10;
            }
        }
        // for (int element : set) {
        //     System.out.println(element);
        // }
        int maxLen=0;
        for(int x: arr2)
        {
            while(x!=0)
            {
                if(set.contains(x))
                {
                    maxLen=Math.max(maxLen,String.valueOf(x).length());
                }
                x=x/10;
            }
        }


    return maxLen;
    }

}