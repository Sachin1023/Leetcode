class Solution {
    public String makeSmallestPalindrome(String s) {
        int l=0,r=s.length()-1;
        char[] word =s.toCharArray();
        while(l<r){
            if( word[l]!=word[r])
            {
                if(word[l]<word[r])
                {
                    word[r]=word[l];
                }
                else
                {
                    word[l]=word[r];
                }
            }
            l++;
            r--;
        }
        return new String(word);
    }
}