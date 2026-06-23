class Solution {
    public int maxNumberOfBalloons(String text) {
        //will count frequency of ballon
        int freq[] = new int[26];
        for(char x : text.toCharArray())
        {
            freq[x-'a']++;
        }
        String ballon = "balon";
        int min=Integer.MAX_VALUE;
        for(char x :ballon.toCharArray())
        {   
            int temp=freq[x-'a'];
            if(x == 'l' || x== 'o')
            {
                temp=temp/2;
            }
            // System.out.println(x+"  then temp"+temp);
            min= Math.min(min,temp);
            // System.out.println(x+"  then min"+min);
        } 
        // System.out.println(Arrays.toString(freq));
        return min;
    }
}