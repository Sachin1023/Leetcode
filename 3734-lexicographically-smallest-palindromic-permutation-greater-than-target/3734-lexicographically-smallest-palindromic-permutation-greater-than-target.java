class Solution {
    String res="";
    String mid = "";
    int halflen=0;

    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();
        halflen=n/2;
        int cnt[]=new int [26];
        for(char ch : s.toCharArray())
            cnt[ch-'a']++;

        int oddFreq=0;

        for(int i=0;i<26;i++)
        {
            if(cnt[i]%2==1) 
            {   
                oddFreq++;
                mid= String.valueOf((char)('a'+i));
            }
            cnt[i]/=2;
        }
        if(oddFreq>1) return "";

        StringBuilder curr= new StringBuilder();

        solve(curr,cnt,target,0,false);
        return res;
    }

    boolean solve(StringBuilder curr, int[] cnt, String target,int i, boolean greater)
    {   
        if(i==halflen )
        {
            
            StringBuilder rev = new StringBuilder(curr).reverse(); 
            String candidate = curr.toString() +mid+rev.toString();
            if(candidate.compareTo(target)>0)
            {   
                res=candidate;
                return true;
            }
        

            return false;
        }

        for(char ch='a'; ch<='z';ch++)
        {
            if(cnt[ch-'a'] == 0) continue; //skip;
            if(!greater && ch < target.charAt(i)) continue; //skip

            //do
            cnt[ch-'a']--;
            curr.append(ch);

            boolean isGreater = greater || ch> target.charAt(i);

           if( solve(curr,cnt,target,i+1,isGreater) )
            return true;

            //undo
            cnt[ch-'a']++;
            curr.setLength(curr.length()-1);
        }
        return false;
    }

}