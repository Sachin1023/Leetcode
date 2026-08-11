class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l=0,r=0,start=0;
        int max=0;
        while(r<s.length())
        {
            char c= s.charAt(r);
            if(map.containsKey(c))
            {
                if(map.get(c)>=l)
                    l=map.get(c)+1;
                
            }
            map.put(c,r);
            int len=r-l+1;
            if(len>max){
                max=len;
                start=l;
            }
            r++;
        }
        // System.out.println(s.substring(start,start+max));
    return max;
    }
}