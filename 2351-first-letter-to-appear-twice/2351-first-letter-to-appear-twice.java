class Solution {
    public char repeatedCharacter(String s) {
        int [] feq = new int[26];
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            int x= c-'a';
            feq[x]++;
            if(feq[x]==2)
                return c;
        } 
        return 'a';
    }
}