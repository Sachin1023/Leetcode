class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int diffsum=0;
        int leftQ = 0;
        int rightQ = 0;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                if(i<n/2) leftQ++;
                else  rightQ++;
            }
            else{
                int a = num.charAt(i)-'0';
                diffsum = (i<n/2 ) ?  diffsum+a : diffsum-a;             
            }
        }
        // Odd number of ? => Alice wins
        if ((leftQ + rightQ) % 2 == 1) return true;
        return diffsum != (rightQ - leftQ) * 9 / 2;
    }
}