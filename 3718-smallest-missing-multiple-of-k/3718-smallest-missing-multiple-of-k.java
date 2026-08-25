class Solution {
    public int missingMultiple(int[] nums, int k) {
     Set<Integer> set = new HashSet<>();
     for(int i : nums)
     {  
        if(i%k==0)
          set.add(i);
     }   
     int res=k;
     for(int i=1 ; i<= set.size()+1;i++)
     {
        if(!set.contains(i*k))
            return res=i*k;
     }
     return k;
    }
}