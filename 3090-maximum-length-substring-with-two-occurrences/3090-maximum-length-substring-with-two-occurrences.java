class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen=0;
        int[] freq= new int[26];
        int l=0,r=0;
        for(;r< s.length();r++)
        {
            int c=s.charAt(r)-'a';
            freq[c]++;
            while(freq[c]>2)
            {
                int a=s.charAt(l)-'a';
                freq[a]--;
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}