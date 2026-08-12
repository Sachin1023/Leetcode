class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxlen=0;
        int l=0,r=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<nums.length)
        {   
            int x= nums[r];
            if(!map.containsKey(x))
            {
                map.put(x,1);
            }
            else{
                map.put(x, map.get(x)+1);
                while(map.get(x) > k)  
                {   
                    int y= nums[l];
                    map.put(y,map.get(y)-1);
                    l++;
                }
            }
            maxlen=Math.max(maxlen ,r-l+1);
            r++;
        }
        return maxlen;
    }
}