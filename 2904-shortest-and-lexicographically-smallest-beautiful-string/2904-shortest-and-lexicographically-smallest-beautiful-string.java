class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int totalones = 0;
        for (int i = 0; i < s.length(); i++) totalones += s.charAt(i) - '0';
        if(totalones < k) return ""; // s does not have minimum no of ones.
        int l=0, cnt=0;
        String ans=s;
        for(int r=0;r<n;r++)
        {
            int a=s.charAt(r)-'0';
            cnt+=a;
            while (cnt > k || s.charAt(l) == '0') { // second || condition for removing the substrings starting from 0, removing trailing zeros
                cnt -= s.charAt(l++) - '0';
            }
            if(cnt==k)
            {
                String temp = s.substring(l,r+1);
                if(temp.length()< ans.length() || (temp.length()== ans.length() && temp.compareTo(ans) <0))
                {
                    //second || condition for the lexicographically smallest 
                    ans=temp;
                }
            }
        }
        return ans;
    }
}